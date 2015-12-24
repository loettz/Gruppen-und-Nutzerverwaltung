package diesisteinprojekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DBHandler {
	
	private static final DateFormat MYSQL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public void saveUser(User user) {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost/groupstuffs", "root", "");
			Statement myStmt = myConn.createStatement();
			String sql = "insert into person (firstname, lastname, birthdate"
					+ ") values ('" + user.getGivenName() + "', '" + user.getName() + "', '" + MYSQL_DATE_FORMAT.format(user.getAge())  + "')"; 
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

}
