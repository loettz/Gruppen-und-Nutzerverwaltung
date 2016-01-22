package diesisteinprojekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class DBHandler {
	
	private static final DateFormat MYSQL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public Connection connect() {
		Connection con = null;
	    String url = "jdbc:mysql://localhost/";
	    String db = "groupstuffs";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String pass = "";
	    try {
	        Class.forName(driver);
	        con = DriverManager.getConnection(url + db, user, pass);
	        if (con == null) {
	            System.out.println("Connection cannot be established");
	        }
	        return con;
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}

	
	public void saveUser(User user) {
		Connection myConn = null;
		try {
			myConn = connect();
			Statement myStmt = myConn.createStatement();
			String sql = "insert into person (firstname, lastname, birthdate, groupName"
					+ ") values ('" + user.getGivenName() + "', '" + user.getName() + "', '" + MYSQL_DATE_FORMAT.format(user.getAge())  +  "', '"+ "" +"')"; 
			myStmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	
	public ArrayList<String> getGroupNameList() {
		// creates List of Groupnames
		ArrayList<String> groups = new ArrayList<String>();
		Connection myConn = null;
		PreparedStatement stmtGetGroups = null;
		ResultSet rs = null;

		try {
			myConn = connect();
			String getGroups = "SELECT * FROM groups";
			stmtGetGroups = myConn.prepareStatement(getGroups);
			rs = stmtGetGroups.executeQuery();
			while (rs.next()) { 
				groups.add(rs.getString("name"));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return groups;
	}
	
	public void saveGroup(Group group) {
		Connection myConn = null;
		PreparedStatement stmtSaveGroup = null;
		//PreparedStatement stmtUserHasGroup = null;
		PreparedStatement stmtGetUsers = null;
		ResultSet rs = null;
		
		ArrayList<User> members = new ArrayList<User>();
		try {
			myConn = connect();
			String saveGroupInDB = "insert into groups (name, groupSize"
	                   +") values ('" + group.getName() + "', '" + group.getSize() + "')";
			stmtSaveGroup = myConn.prepareStatement(saveGroupInDB);
			String getUsers = "SELECT * FROM person where groupName =  ''";
			stmtGetUsers = myConn.prepareStatement(getUsers);
			rs = stmtGetUsers.executeQuery();
			rs.first();
			if (group.getGroupList() == null) {
				addUserFromRsToGroup(members, group);
				
			}
				while (group.getSize() > group.getGroupList().size() && rs.next()) {
					addUserFromRsToGroup(members, group);

				}
			
				//group.setGroupList(members);
			stmtSaveGroup.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmtSaveGroup.close();
				//stmtUserHasGroup.close();
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
		
	public ResultSet getUsersWithNoGroup() {
		Connection myConn = null;
		PreparedStatement stmtGetUsers = null;
		ResultSet rs = null;		
		try {
			myConn = connect();
			String getUsers = "SELECT * FROM person where groupName =  ''";
			stmtGetUsers = myConn.prepareStatement(getUsers);
			rs = stmtGetUsers.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
		return rs;
	
	}
	
	public ArrayList<String> getUserNameList() {
		ArrayList<String> users = new ArrayList<String>();
		PreparedStatement stmtGetUsers = null;
		Connection myConn = null;
		ResultSet rs = null;
		String user;
		try {
			myConn = connect();
			String getUsers = "SELECT * FROM person where groupName =  ''";
			stmtGetUsers = myConn.prepareStatement(getUsers);
			rs = stmtGetUsers.executeQuery();
			while (rs.next()) {
				user = rs.getString("firstname") + " " + rs.getString("lastname");
				users.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public void addUserToGroup(String username, String groupname) {
		// adds selected user to selected group, set groupname in person, count up groupsize in groups
		Connection myConn = null;
		PreparedStatement stmtSetGroupName = null;
		PreparedStatement stmtGroupSize = null;
		PreparedStatement stmtSetGroupSize = null;
		String[] parts = username.split(" ");
		ResultSet rs = null;
		
		try {
			myConn = connect();
			String setGroupName = "UPDATE person SET groupName = '" + groupname + "' WHERE firstname = '" + parts[0].toString() + "' AND lastname = '" + parts[1].toString() + "'";
			String groupSize = "SELECT * from groups WHERE name = '" + groupname + "'";
			stmtGroupSize = myConn.prepareStatement(groupSize);
			rs = stmtGroupSize.executeQuery();
			rs.first();
			int size = rs.getInt("groupSize");
			size = size +1;
			String setGroupSize = "UPDATE groups SET groupSize = '" + size + "' WHERE name = '" + groupname + "'";
			stmtSetGroupName = myConn.prepareStatement(setGroupName);
			stmtSetGroupSize = myConn.prepareStatement(setGroupSize);
			stmtSetGroupName.executeUpdate();
			stmtSetGroupSize.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void addUserFromRsToGroup(ArrayList<User> members, Group group) {
		// creates user obj from rs and sets groupName in person in db
		Connection myConn = null;
		PreparedStatement stmtUserHasGroup = null;
		PreparedStatement stmtGetUsers = null;
		ResultSet rs = null;
		
		try {
			myConn = connect();
			User user = new User();
			String getUsers = "SELECT * FROM person where groupName =  ''";
			stmtGetUsers = myConn.prepareStatement(getUsers);
			rs = stmtGetUsers.executeQuery();
			rs.first();
			user.setGivenName(rs.getString("firstname"));
			user.setName(rs.getString("lastname"));
			user.setAge(rs.getDate("birthdate"));
			members.add(user);
			String userHasGroup = "UPDATE person SET groupName = '" + group.getName() +"' WHERE firstname = '" + user.getGivenName() +"'";
			stmtUserHasGroup = myConn.prepareStatement(userHasGroup);
			stmtUserHasGroup.execute();
			group.setGroupList(members);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteGroup(String groupname) {
		//delete group in db and reset groupname of the affected users
		Connection myConn = null;
		PreparedStatement stmtDeleteGroup = null;
		PreparedStatement stmtResetGroupnameInPerson = null;
		String deleteGroup = "DELETE FROM groups WHERE name = '" + groupname + "'";
		String ResetGroupnameInPerson = "UPDATE person SET groupName = '' WHERE groupName = '" + groupname + "'";
		
		try {
			myConn = connect();
			stmtDeleteGroup = myConn.prepareStatement(deleteGroup);
			stmtDeleteGroup.execute();
			stmtResetGroupnameInPerson = myConn.prepareStatement(ResetGroupnameInPerson);
			stmtResetGroupnameInPerson.executeUpdate();
			
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteUserFromGroup(String username, String groupname) {
		//reset groupName of user in db and cut the groupsize -1
		Connection myConn = null;
		PreparedStatement stmtUserFromGroup = null;
		PreparedStatement stmtGroupSize = null;
		PreparedStatement stmtResetGroupSize = null;
		ResultSet rs = null;
		String[] parts = username.split(" ");
		String userFromGroup = "UPDATE person SET groupName = '' WHERE firstname =  '" + parts[0].toString() + "' AND lastname = '" + parts[1].toString() + "' AND groupName = '" + groupname + "'";
		String groupSize = "SELECT * from groups WHERE name = '" + groupname + "'";
		
		try {
			myConn = connect();
			stmtUserFromGroup = myConn.prepareStatement(userFromGroup);
			stmtUserFromGroup.executeUpdate();
			stmtGroupSize = myConn.prepareStatement(groupSize);
			rs = stmtGroupSize.executeQuery();
			rs.first();
			int size = rs.getInt("groupSize");
			size = size -1;
			String resetGroupSize = "UPDATE groups SET groupSize = '" + size + "' WHERE name = '" + groupname + "'";
			stmtResetGroupSize = myConn.prepareStatement(resetGroupSize);
			stmtResetGroupSize.executeUpdate();
			
			
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	
	public void getGroupsAndCreateTreeNodes(DefaultMutableTreeNode top) {
		// gets all Groups from DB and creates nodes and child nodes for JTree
		Connection myConn = null;
		PreparedStatement stmtGetGroups = null;
		ResultSet rs = null;

		try {
			myConn = connect();
			String getGroups = "SELECT * FROM groups";
			stmtGetGroups = myConn.prepareStatement(getGroups);
			rs = stmtGetGroups.executeQuery();
			//rs.first();
			while (rs.next()) { 
				createNode(rs, top);	
			}
			

					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getUsersFromGroup(String groupName, DefaultMutableTreeNode groupNode) {
		Connection myConn = null;
		PreparedStatement stmtGetUsersFromGroup = null;
		ResultSet rs = null;
		
		try {
			myConn = connect();
			String getUsers = "SELECT * FROM person WHERE groupName =" + "'" + groupName + "'";
			stmtGetUsersFromGroup = myConn.prepareStatement(getUsers);
			rs = stmtGetUsersFromGroup.executeQuery();
			
			while (rs.next()) {
				createUserNode(rs, groupNode);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void createNode(ResultSet rs, DefaultMutableTreeNode top) {
		// creates All Nodes for JTree 
		Group group = new Group();
		try {
			group.setName(rs.getString("name"));
			group.setSize(rs.getInt("groupSize"));
			DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group.getName());
			top.add(groupNode);
			getUsersFromGroup(group.getName(), groupNode);
			//tree.expandPath(new TreePath(groupNode.getPath()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void createUserNode(ResultSet rs, DefaultMutableTreeNode groupNode) {
		//creates child nodes from group nodes
		User user = new User();
		try {
			user.setGivenName(rs.getString("firstname"));
			user.setName(rs.getString("lastname"));
			DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user.getGivenName() +  " " + user.getName());
			groupNode.add(userNode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
