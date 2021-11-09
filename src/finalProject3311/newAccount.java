package finalProject3311;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class newAccount {

	private JFrame frame;
	private JTextField username;
	private JTextField email;
	private JTextField type;
	private JTextField password;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newAccount window = new newAccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(20, 42, 73, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setBounds(20, 83, 84, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User-Type:");
		lblNewLabel_2.setBounds(20, 120, 84, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(114, 39, 96, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		email = new JTextField();
		email.setBounds(114, 80, 96, 19);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		type = new JTextField();
		type.setBounds(114, 117, 96, 19);
		frame.getContentPane().add(type);
		type.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
				    FileWriter hg=new FileWriter("loginInfo.txt",true);
					BufferedWriter sd=new BufferedWriter(hg);
					String d=username.getText();	
					String f=email.getText();
					String g=type.getText();
					String h= password.getText();
	
						sd.write(d+" "+f+" "+g+" "+h);
						sd.newLine();
				        sd.close();
					}
					catch(Exception e1){
						System.out.print("Exception");
					}				
				
				finalLogin.main(null);
				frame.setVisible(false);
			}
			
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setBounds(238, 176, 119, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalLogin.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setBounds(50, 176, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(20, 153, 84, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		password = new JTextField();
		password.setBounds(114, 146, 96, 19);
		frame.getContentPane().add(password);
		password.setColumns(10);
	}
}
