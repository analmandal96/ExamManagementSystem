import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author Anal, Arpan, Ankita, Anamika.
 */

@SuppressWarnings({ "serial", "unused" })
public class ExamPortal extends JFrame {

	private JPanel contentPane;
	ResultSet rs;
	
	static int miliseconds=1000;
	static int seconds=60;
	static int minutes=19;
	static int hours=0;
	
	static boolean state=true;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamPortal frame = new ExamPortal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Login UN=new Login();

	/**
	 * Create the frame.
	 */
	Connection sqlconnDB=null;
	Connection QuesconnDB=null;
	
	private ButtonGroup group;
	
	static String UserAnswer;
	
	static double Marks=0;
	
	private JTextField textField;
	public ExamPortal() {
		setTitle("Examination Portal");
		
		sqlconnDB=sqlconn.dbconnector();
		QuesconnDB=QDBconn.dbconnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 186, 430, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
				
		JRadioButton rdbtnOption1 = new JRadioButton("Option1");
		rdbtnOption1.setBounds(21, 95, 195, 23);
		panel.add(rdbtnOption1);
		
		JRadioButton rdbtnOption3 = new JRadioButton("Option3");
		rdbtnOption3.setBounds(21, 130, 195, 23);
		panel.add(rdbtnOption3);
		
		JRadioButton rdbtnOption2 = new JRadioButton("Option2");
		rdbtnOption2.setBounds(229, 95, 195, 23);
		panel.add(rdbtnOption2);
		
		JRadioButton rdbtnOption4 = new JRadioButton("Option4");
		rdbtnOption4.setBounds(229, 130, 195, 23);
		panel.add(rdbtnOption4);
		
		group = new ButtonGroup();
		group.add(rdbtnOption1);
		group.add(rdbtnOption2);
		group.add(rdbtnOption3);
		group.add(rdbtnOption4);
		
		JLabel lblQuestion = new JLabel("Question");
		/*lblQuestion.setLineWrap(true);
		lblQuestion.setWrapStyleWord(true);*/
		lblQuestion.setBounds(21, 34, 403, 49);
		panel.add(lblQuestion);
		
		JLabel lblQuestionNo = new JLabel("Question No");
		lblQuestionNo.setBounds(21, 6, 79, 16);
		panel.add(lblQuestionNo);
				
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setBounds(10, 16, 250, 16);
		contentPane.add(lblWelcome);
		
		JLabel lblSid = new JLabel("SID");
		lblSid.setBounds(10, 44, 61, 16);
		contentPane.add(lblSid);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setBounds(10, 72, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblSubject = new JLabel("SUBJECT");
		lblSubject.setBounds(10, 100, 61, 16);
		contentPane.add(lblSubject);
		
		JLabel Subject_BlankSpace = new JLabel("");
		Subject_BlankSpace.setBounds(83, 100, 202, 16);
		contentPane.add(Subject_BlankSpace);
		

		JLabel lblTimeLeft = new JLabel("Time Left =");
		lblTimeLeft.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblTimeLeft.setBounds(10, 128, 136, 52);
		contentPane.add(lblTimeLeft);
		
		JLabel lblMin = new JLabel("20");
		lblMin.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblMin.setBounds(185, 128, 26, 52);
		contentPane.add(lblMin);
		
		JLabel lblMinIndc = new JLabel(":");
		lblMinIndc.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblMinIndc.setBounds(220, 128, 5, 52);
		contentPane.add(lblMinIndc);
		
		JLabel lblSec = new JLabel("00");
		lblSec.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblSec.setBounds(234, 128, 26, 52);
		contentPane.add(lblSec);
		
		JLabel lblSecIndc = new JLabel("");
		lblSecIndc.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblSecIndc.setBounds(271, 128, 5, 52);
		contentPane.add(lblSecIndc);
		
		JLabel lblMSec = new JLabel("");
		lblMSec.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblMSec.setBounds(285, 128, 61, 52);
		contentPane.add(lblMSec);
		
		JLabel lblPiclogo = new JLabel("");
		lblPiclogo.setBounds(299, 6, 141, 128);
		Image img1 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblPiclogo.setIcon(new ImageIcon(img1));
		contentPane.add(lblPiclogo);
		
		JLabel lbl_istoSID = new JLabel(":");
		lbl_istoSID.setBounds(75, 44, 5, 16);
		contentPane.add(lbl_istoSID);
		
		JLabel lbl_istoName = new JLabel(":");
		lbl_istoName.setBounds(75, 72, 5, 16);
		contentPane.add(lbl_istoName);
		
		JLabel lbl_istoSubject = new JLabel(":");
		lbl_istoSubject.setBounds(75, 100, 5, 16);
		contentPane.add(lbl_istoSubject);
		
		JLabel SID_BlankSpace = new JLabel("");
		SID_BlankSpace.setBounds(85, 44, 200, 16);
		contentPane.add(SID_BlankSpace);
		
		JLabel Name_BlankSpace = new JLabel("");
		Name_BlankSpace.setBounds(83, 72, 202, 16);
		contentPane.add(Name_BlankSpace);
		
		JLabel lblHourIndc = new JLabel(":");
		lblHourIndc.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblHourIndc.setBounds(169, 128, 5, 52);
		contentPane.add(lblHourIndc);
		
		JLabel lblHour = new JLabel("00");
		lblHour.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblHour.setBounds(137, 128, 26, 52);
		contentPane.add(lblHour);
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
										
						group.clearSelection();
					
					}catch(Exception exp) {
					
				}
			}
		});
		btnReset.setBounds(10, 377, 126, 30);
		contentPane.add(btnReset);
		btnReset.setVisible(false);
		
		
		
		JButton btnNext = new JButton("Submit & Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// User Answer
					if(rdbtnOption1.isSelected()) {
						UserAnswer = rdbtnOption1.getText();
					}
					else if(rdbtnOption2.isSelected()) {
						UserAnswer = rdbtnOption2.getText();
					}
					else if(rdbtnOption3.isSelected()) {
						UserAnswer = rdbtnOption3.getText();
					}
					else if(rdbtnOption4.isSelected()) {
						UserAnswer = rdbtnOption4.getText();
					}
					else {
						UserAnswer=null;
						//JOptionPane.showMessageDialog(null, "No option selected. Marks = "+Marks);
					}
					
					//Checking user answer
					
					if(Objects.equals(UserAnswer, rs.getString(9))) {
						Marks++;
						JOptionPane.showMessageDialog(null, "Correct Answer. Marks = "+Marks);
						
					}
					else if(UserAnswer==null){
						JOptionPane.showMessageDialog(null, "No option selected. Marks = "+Marks);
						
					
					}
					else {
						//if(Marks>0) {
							Marks=Marks-0.5;
						//}
						//else {
							//Marks=0;
						//}
						JOptionPane.showMessageDialog(null, "Wrong Answer. 0.5 marks deducted. Marks = "+Marks);
					}
					
					group.clearSelection();
					
					if(rs.next()) {
						Subject_BlankSpace.setText(rs.getString(2));
						lblQuestionNo.setText("Question "+rs.getString(3));
						lblQuestion.setText("<html>"+rs.getString(4)+"</html>");
						rdbtnOption1.setText(rs.getString(5));
						rdbtnOption2.setText(rs.getString(6));
						rdbtnOption3.setText(rs.getString(7));
						rdbtnOption4.setText(rs.getString(8));
						
					}
				}catch(Exception exp) {
					
				}
			}
		});
		btnNext.setBounds(149, 377, 136, 30);
		contentPane.add(btnNext);
		btnNext.setVisible(false);
		
		JButton btnFinish = new JButton("Finish Exam");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// User Answer
				
				if(rdbtnOption1.isSelected()) {
					UserAnswer = rdbtnOption1.getText();
				}
				else if(rdbtnOption2.isSelected()) {
					UserAnswer = rdbtnOption2.getText();
				}
				else if(rdbtnOption3.isSelected()) {
					UserAnswer = rdbtnOption3.getText();
				}
				else if(rdbtnOption4.isSelected()) {
					UserAnswer = rdbtnOption4.getText();
				}
				else {
					UserAnswer=null;
					//JOptionPane.showMessageDialog(null, "No option selected. Marks = "+Marks);
				}
				
				//Checking user answer
				
				if(Objects.equals(UserAnswer, rs.getString(9))) {
					Marks++;
					JOptionPane.showMessageDialog(null, "Correct Answer. Marks = "+Marks+"\nThanks for giving the examination.");
					//dispose();
					System.exit(0);
				}
				else if(UserAnswer==null){
					JOptionPane.showMessageDialog(null, "No option selected. Marks = "+Marks+"\nThanks for giving the examination.");
					//dispose();
					System.exit(0);
				
				}else {
					//if(Marks>0) {
						Marks=Marks-0.5;
					//}
					//else {
						//Marks=0;
					//}
					JOptionPane.showMessageDialog(null, "Wrong Answer. 0.5 marks deducted. Marks = "+Marks+"\nThanks for giving the examination.");
					//dispose();
					//close();
					System.exit(0);
					
				}
				}catch(Exception exp) {
					
				}
				
			}
		});
		btnFinish.setBounds(299, 377, 141, 30);
		contentPane.add(btnFinish);
		btnFinish.setVisible(false);
				
		
		JButton btnStartExam = new JButton("Start Exam");
		btnStartExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QuesDB","root","");
					String sql = "select * from QuesTB";
					PreparedStatement ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					if(rs.next()) {
						Subject_BlankSpace.setText(rs.getString(2));
						lblQuestionNo.setText("Question "+rs.getString(3));
						lblQuestion.setText("<html>"+rs.getString(4)+"</html>");
						rdbtnOption1.setText(rs.getString(5));
						rdbtnOption2.setText(rs.getString(6));
						rdbtnOption3.setText(rs.getString(7));
						rdbtnOption4.setText(rs.getString(8));
						btnStartExam.setVisible(false);
						btnReset.setVisible(true);
						btnNext.setVisible(true);
						btnFinish.setVisible(true);
						
						group.clearSelection();
						
						state=true;
						Thread t=new Thread() {
							public void run() {
								for(;;) {
									if(state==true) {
										try {
											sleep(1);
											
											if(miliseconds==0) {
												miliseconds=1000;
												seconds--;
											}
											if(seconds==0) {
												miliseconds=1000;
												seconds=60;
												minutes--;
											}
											if(minutes==0) {
												miliseconds=1000;
												seconds=60;
												minutes=60;
												hours--;
											}
											if(hours==0 && minutes==0 && seconds==0 && miliseconds==0) {
												//End of exam
												try {
													// User Answer
												
												if(rdbtnOption1.isSelected()) {
													UserAnswer = rdbtnOption1.getText();
												}
												else if(rdbtnOption2.isSelected()) {
													UserAnswer = rdbtnOption2.getText();
												}
												else if(rdbtnOption3.isSelected()) {
													UserAnswer = rdbtnOption3.getText();
												}
												else if(rdbtnOption4.isSelected()) {
													UserAnswer = rdbtnOption4.getText();
												}
												else {
													UserAnswer=null;
													//JOptionPane.showMessageDialog(null, "No option selected. Marks = "+Marks);
												}
												
												//Checking user answer
												
												if(Objects.equals(UserAnswer, rs.getString(9))) {
													Marks++;
													JOptionPane.showMessageDialog(null, "Correct Answer. Marks = "+Marks+"\nThanks for giving the examination.");
													//dispose();
													System.exit(0);
												}
												else if(UserAnswer==null){
													JOptionPane.showMessageDialog(null, "No option selected. Marks = "+Marks+"\nThanks for giving the examination.");
													//dispose();
													System.exit(0);
												
												}else {
													//if(Marks>0) {
													Marks=Marks-0.5;
												//}
												//else {
													//Marks=0;
												//}
													JOptionPane.showMessageDialog(null, "Wrong Answer. 0.5 marks deducted. Marks = "+Marks+"\nThanks for giving the examination.");
													//dispose();
													System.exit(0);
													
												}
												}catch(Exception exp) {
													
												}
											}
											
											lblSecIndc.setText(":");
											lblMSec.setText(""+miliseconds);
											miliseconds--;
											
											lblSec.setText(""+seconds);
											lblMin.setText(""+minutes);
											lblHour.setText(""+hours);
											
										}catch(Exception e11) {
											
										}
									}
									else {
										break;
									}
								}
							}
						}; 
						t.start();
					}
				}catch(Exception exp) {
					
				}
			}
		});
		btnStartExam.setBounds(299, 134, 141, 40);
		btnStartExam.setBackground(Color.green);
		contentPane.add(btnStartExam);
		
		
		
		try {
			String query1="select * from SignUpTB where Username='"+Login.Username+"' ";
			PreparedStatement pst1=sqlconnDB.prepareStatement(query1);
						
			ResultSet rs1=pst1.executeQuery();
			if(rs1.next()) {
				lblWelcome.setText("Welcome "+rs1.getString(2));
				SID_BlankSpace.setText(rs1.getString(1));
				Name_BlankSpace.setText(rs1.getString(2));
			}
			rs1.close();
			pst1.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
			
		}

	}
}
