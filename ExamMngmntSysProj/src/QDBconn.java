import java.sql.*;
import javax.swing.*;


/**
 * Author Anal, Arpan, Ankita, Anamika.
 */

public class QDBconn {
	Connection conn=null;
	public static Connection dbconnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QuesDB","root","");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	/*void std_details(String Uname){
		String db="jdbc:mysql://localhost:3306/SignUpDB";
		String user="root";
		String pass=""; 
		try {
			Connection conn=DriverManager.getConnection(db, user, pass);
			Statement stmt =conn.createStatement();
			String query="SELECT SignUpTB.SID, SignUpTB.Name FROM SignUpTB WHERE SignUpTB.Username ="+Uname+"";
			ResultSet rs=stmt.executeQuery(query);
			//practice.table.setModel(DbUtils.resultSetToTableModel(rs));
			if(rs.next()){
			ExamPortal.lblWelcome.setText("Welcome "+rs.getString("SignUpTB.Name"));
			ExamPortal.SID_BlankSpace.setText(rs.getString("SignUpTB.SID"));
			ExamPortal.Name_BlankSpace.setText(rs.getString("SignUpTB.Name"));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Record Not Found!!", "Not found", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			
			e.getMessage();
			JOptionPane.showMessageDialog(null,"An unexpected error has occurred:\n" + e.getMessage().toString() +"Warning ", e.getStackTrace().toString(), JOptionPane.ERROR_MESSAGE, null);
		}
	}*/
	void Ques_details(String Uname){
		String db="jdbc:mysql://localhost:3306/QuesDB";
		String user="root";
		String pass=""; 
		try {
			Connection conn=DriverManager.getConnection(db, user, pass);
			Statement stmt =conn.createStatement();
			String query="SELECT QuesTB.SID, SignUpTB.Name FROM SignUpTB WHERE SignUpTB.Username ="+Uname+"";
			ResultSet rs=stmt.executeQuery(query);
			//practice.table.setModel(DbUtils.resultSetToTableModel(rs));
			if(rs.next()){
		/*	ExamPortal.lblWelcome.setText("Welcome "+rs.getString("SignUpTB.Name"));
			ExamPortal.SID_BlankSpace.setText(rs.getString("SignUpTB.SID"));
			ExamPortal.Name_BlankSpace.setText(rs.getString("SignUpTB.Name"));
			*/
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Record Not Found!!", "Not found", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			
			e.getMessage();
			JOptionPane.showMessageDialog(null,"An unexpected error has occurred:\n" + e.getMessage().toString() +"Warning ", e.getStackTrace().toString(), JOptionPane.ERROR_MESSAGE, null);
		}
	}

}
