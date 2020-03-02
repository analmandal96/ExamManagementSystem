import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
public class Login {
	
	/**
	 * Author Anal, Arpan, Ankita, Anamika.
	 */
	
	public JFrame frmLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setLocationRelativeTo(null);
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connDB=null;
	private JTextField textFieldUname;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connDB=sqlconn.dbconnector();
	}
	
	static String Username;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Exam System Login");
		frmLogin.setBounds(100, 100, 450, 281);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setBounds(138, 6, 161, 43);
		frmLogin.getContentPane().add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(210, 48, 68, 27);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(210, 117, 68, 27);
		frmLogin.getContentPane().add(lblPassword);
		
		textFieldUname = new JTextField();
		textFieldUname.setBounds(205, 76, 228, 26);
		frmLogin.getContentPane().add(textFieldUname);
		textFieldUname.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 144, 228, 26);
		frmLogin.getContentPane().add(passwordField);
		/*
		 * Login Button
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Image img0 = new ImageIcon(this.getClass().getResource("/key.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img0));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from SignUpTB where Username=? and Password=? ";
					PreparedStatement pst=connDB.prepareStatement(query);
					pst.setString(1, textFieldUname.getText().trim());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					
					int count=0;
					while(rs.next()) {
						Username = textFieldUname.getText().toString().trim();
						count++;	
					}
					if(count==1) {
						JOptionPane.showMessageDialog(null, "Username and password is correct.");
						frmLogin.dispose();
						ExamPortal exm=new ExamPortal();
						exm.setLocationRelativeTo(null);
						exm.setVisible(true);
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null, "Duplicate Username and password.");
					}
					else {
						JOptionPane.showMessageDialog(null, "Username and password is not correct. Please try again");
					}
					//Username=rs.getString(1);
					rs.close();
					pst.close();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
			}
		});
		btnLogin.setBounds(260, 180, 125, 43);
		frmLogin.getContentPane().add(btnLogin);
		/* 
		 * SignUp Button
		 */
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				SignUp signup=new SignUp();
				signup.setLocationRelativeTo(null);
				signup.setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/signup0.png")).getImage();
		btnSignup.setIcon(new ImageIcon(img2));
		btnSignup.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnSignup.setBounds(53, 180, 125, 43);
		frmLogin.getContentPane().add(btnSignup);
		
		JLabel lblLoginPic = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblLoginPic.setIcon(new ImageIcon(img1));
		lblLoginPic.setBounds(43, 48, 134, 145);
		frmLogin.getContentPane().add(lblLoginPic);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldUname.setText("");
				passwordField.setText("");
			}
		});
		btnReset.setBounds(179, 226, 78, 27);
		frmLogin.getContentPane().add(btnReset);
	}

	/*@SuppressWarnings("deprecation")
	public void setVisibleF(boolean b) {
		
		frmLogin.show();
	}*/
}
