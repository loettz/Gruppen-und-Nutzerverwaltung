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
	
	public void saveGroup(Group group) {
		Connection myConn = null;
		try {
			myConn = connect();
			Statement myStmt = myConn.createStatement();
			String saveGroupInDB = "insert into groups (name, groupSize"
	                   +") values ('" + group.getName() + "," + group.getSize() + "')";
			myStmt.execute(saveGroupInDB);
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
	
	public void checkUsers(Group group) {
		Connection myConn = null;
		PreparedStatement stmtSaveGroup = null;
		PreparedStatement stmtGetUsers = null;
		//PreparedStatement stmtUserHasGroup = null;
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
				addUserToGroup(members, rs, group);
				
			}
				while (group.getSize() > group.getGroupList().size() && rs.next()) {
					addUserToGroup(members, rs, group);

				}
			
				
				//group.setGroupList(members);
			stmtSaveGroup.executeUpdate();
			
			//myStmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmtSaveGroup.close();
				stmtGetUsers.close();
				//stmtUserHasGroup.close();
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	}
	public void addUserToGroup(ArrayList<User> members, ResultSet rs, Group group) {
		Connection myConn = null;
		PreparedStatement stmtUserHasGroup = null;
		
		
		try {
			myConn = connect();
			User user = new User();
			user.setGivenName(rs.getString("firstname"));
			user.setName(rs.getString("lastname"));
			user.setAge(rs.getDate("birthdate"));
			//ArrayList<User> members = new ArrayList<User>();
			members.add(user);
			String userHasGroup = "UPDATE person SET groupName = '" + group.getName() +"' WHERE firstname = '" + user.getGivenName() +"'";
			stmtUserHasGroup = myConn.prepareStatement(userHasGroup);
			stmtUserHasGroup.execute();
			group.setGroupList(members);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
