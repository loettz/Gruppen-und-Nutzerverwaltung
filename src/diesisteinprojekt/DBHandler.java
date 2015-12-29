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
	
	public void saveUser(User user) {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost/groupstuffs", "root", "");
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
			myConn = DriverManager.getConnection("jdbc:mysql://localhost/groupstuffs", "root", "");
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
		PreparedStatement stmtUserHasGroup = null;
		ResultSet rs = null;
		ArrayList<User> members = new ArrayList<User>();
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost/groupstuffs", "root", "");
			String saveGroupInDB = "insert into groups (name, groupSize"
	                   +") values ('" + group.getName() + "', '" + group.getSize() + "')";
			stmtSaveGroup = myConn.prepareStatement(saveGroupInDB);
			String getUsers = "SELECT * FROM person where groupName =  ''";
			stmtGetUsers = myConn.prepareStatement(getUsers);
			rs = stmtGetUsers.executeQuery();
			
			while (group.getGroupList() == null || group.getSize() > group.getGroupList().size()) {
				rs.next();	
				User user = new User();
				user.setGivenName(rs.getString("firstname"));
				user.setName(rs.getString("lastname"));
				user.setAge(rs.getDate("birthdate"));
				//ArrayList<User> members = new ArrayList<User>();
				members.add(user);
				String userHasGroup = "UPDATE person SET groupName = '" + group.getName() +"' WHERE firstname = '" + user.getGivenName() +"'";
				stmtUserHasGroup = myConn.prepareStatement(userHasGroup);
				stmtUserHasGroup.execute();	
						

						

						//rs.next();
			}
			group.setGroupList(members);
			stmtSaveGroup.execute();
			
			//myStmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmtSaveGroup.close();
				stmtGetUsers.close();
				stmtUserHasGroup.close();
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	}

}
