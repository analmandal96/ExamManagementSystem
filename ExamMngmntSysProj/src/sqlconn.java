import java.sql.*;
import javax.swing.*;


/**
 * Author Anal, Arpan, Ankita, Anamika.
 */

public class sqlconn {
	Connection conn=null;
	public static Connection dbconnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			//Connection conn=DriverManager.getConnection("jdbc:sqlite:/Users/analmandal/eclipse-workspace/ExamMngProject/SignUpDB.sql");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/SignUpDB","root","");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
