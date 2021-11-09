package finalProject3311;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class finalLogin {

	private JFrame frame;
	private JTextField cLogin;
	private JTextField cPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalLogin window = new finalLogin();
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
	public finalLogin() {
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
		
		JLabel userLogin = new JLabel("User Name:");
		userLogin.setBounds(42, 89, 84, 13);
		frame.getContentPane().add(userLogin);
		
		JLabel userPassword = new JLabel("Password:");
		userPassword.setBounds(42, 130, 84, 13);
		frame.getContentPane().add(userPassword);
		
		cLogin = new JTextField();
		cLogin.setBounds(136, 86, 96, 19);
		frame.getContentPane().add(cLogin);
		cLogin.setColumns(10);
		
		cPassword = new JTextField();
		cPassword.setBackground(Color.WHITE);
		cPassword.setBounds(136, 127, 96, 19);
		frame.getContentPane().add(cPassword);
		cPassword.setColumns(10);
		
		JButton loginBut = new JButton("LOGIN");
		loginBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader eq=new FileReader("loginInfo.txt");
					BufferedReader po=new BufferedReader(eq);
					String yu=po.readLine();
					String m=cLogin.getText();
					String m1=cPassword.getText();
					while(yu!=null){
						String[] prts = yu.split(" ");
					
						if(prts[2].equals(m1)){
							
							if(prts[0].equals(m)){
							   customerHome.main(null);
							   frame.setVisible(false);
							break;
							}
							else{
								JOptionPane.showMessageDialog(loginBut,"Wrong Password");
								break;
							}
					}
						yu=po.readLine();
						if(yu==null){
								JOptionPane.showMessageDialog(loginBut,"Create Acccount First");
						}
						
						if (identifyType(m, m1).equalsIgnoreCase("customer")) {
							customerHome.main(null);
						} else if(identifyType(m, m1).equalsIgnoreCase("pO")) {
							pEOPortal.main(null);
						} else if(identifyType(m, m1).equalsIgnoreCase("administration")) {
							systemAdminPortal.main(null);
						}
					}
						po.close();
					}
					catch(FileNotFoundException e1){
						e1.printStackTrace();
					}
					catch(IOException e1){
						System.out.println(e1.getMessage());
					}
					catch(NumberFormatException e1){
						System.out.println(e1.getMessage());
					}
				frame.setVisible(false);
					

				
				
			}
		});
		loginBut.setBackground(Color.MAGENTA);
		loginBut.setBounds(97, 190, 96, 21);
		frame.getContentPane().add(loginBut);
		
		JButton newAccountBtn = new JButton("Create New Account");
		newAccountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newAccount.main(null);
			}
		});
		newAccountBtn.setBackground(Color.MAGENTA);
		newAccountBtn.setBounds(234, 190, 174, 21);
		frame.getContentPane().add(newAccountBtn);
		
		JLabel lblNewLabel = new JLabel("Don't have a account?");
		lblNewLabel.setBounds(277, 167, 121, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toronto Parking App");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(42, 28, 173, 33);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	public String identifyType(String clogin, String cPassword) {
		String yLine = "";
		String[] yVal = null;
		String yUserType= "";
		
		try {
			FileReader fr=new FileReader("loginInfo.txt");
			BufferedReader bfr = new BufferedReader(fr);
			while ((yLine = bfr.readLine()) !=  null) {
				yVal = yLine.split(",");				

				List<String> lst = Arrays.asList(yVal);
				if (lst.get(0).contains(clogin) && lst.get(3).contains(cPassword)) {
					yUserType = lst.get(2);
					break;
				} else {
					yUserType = null;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return yUserType;
	}
	
}
