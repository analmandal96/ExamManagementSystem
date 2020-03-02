import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.*;


/**
 * Author Anal, Arpan, Ankita, Anamika.
 */


@SuppressWarnings({ "unused", "serial" })

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldYear;
	private JTextField textFieldStream;
	private JTextField textFieldRoll;
	private JTextField textFieldUname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connDB=null;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setTitle("Exam System Login SignUp");
		connDB=sqlconn.dbconnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewStudentRegistration = new JLabel("New Student Registration");
		lblNewStudentRegistration.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewStudentRegistration.setBounds(89, 6, 268, 27);
		contentPane.add(lblNewStudentRegistration);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(33, 45, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(33, 73, 61, 16);
		contentPane.add(lblYear);
		
		JLabel lblStream = new JLabel("Stream");
		lblStream.setBounds(33, 101, 61, 16);
		contentPane.add(lblStream);
		
		JLabel lblRoll = new JLabel("Roll");
		lblRoll.setBounds(33, 129, 61, 16);
		contentPane.add(lblRoll);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(33, 157, 71, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(33, 185, 71, 16);
		contentPane.add(lblPassword);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(153, 40, 291, 26);
		contentPane.add(textFieldName);
		
		textFieldYear = new JTextField();
		textFieldYear.setColumns(10);
		textFieldYear.setBounds(153, 68, 291, 26);
		contentPane.add(textFieldYear);
		
		textFieldStream = new JTextField();
		textFieldStream.setColumns(10);
		textFieldStream.setBounds(153, 96, 291, 26);
		contentPane.add(textFieldStream);
		
		textFieldRoll = new JTextField();
		textFieldRoll.setColumns(10);
		textFieldRoll.setBounds(153, 124, 291, 26);
		contentPane.add(textFieldRoll);
		
		textFieldUname = new JTextField();
		textFieldUname.setColumns(10);
		textFieldUname.setBounds(153, 152, 291, 26);
		contentPane.add(textFieldUname);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String query1="select * from SignUpTB where Username=? and Password=? ";
					PreparedStatement pst1=connDB.prepareStatement(query1);
					pst1.setString(1, textFieldUname.getText().trim());
					pst1.setString(2, passwordField.getText());
					ResultSet rs=pst1.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Username & Password is already registered.\nPlease login now or try creating new account with different Username & Password.");
					}
					else {
					String query="INSERT INTO `SignUpTB`(`Name`, `Year`, `Stream`, `Roll`, `Username`, `Password`) VALUES (?,?,?,?,?,?) ";
					PreparedStatement pst=connDB.prepareStatement(query);
					pst.setString(1, textFieldName.getText());
					pst.setString(2, textFieldYear.getText());
					pst.setString(3, textFieldStream.getText());
					pst.setString(4, textFieldRoll.getText());
					pst.setString(5, textFieldUname.getText().trim());
					pst.setString(6, passwordField.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Registered Successfully, Please login now.");
					
					pst.close();
					
					dispose();
					
					Login login=new Login();
					login.frmLogin.setLocationRelativeTo(null);
					login.frmLogin.setVisible(true);
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/signup0.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img2));
		btnSubmit.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnSubmit.setBounds(229, 218, 145, 41);
		contentPane.add(btnSubmit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 180, 291, 26);
		contentPane.add(passwordField);
		
		JButton button = new JButton("Reset");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
				textFieldYear.setText("");
				textFieldStream.setText("");
				textFieldRoll.setText("");
				textFieldUname.setText("");
				passwordField.setText("");
			}
		});
		button.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(43, 219, 145, 41);
		contentPane.add(button);
	}
}
