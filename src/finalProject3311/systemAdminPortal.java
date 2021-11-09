package finalProject3311;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class systemAdminPortal {

	private JFrame frame;
	private JTextField type;
	private JTextField pass;
	private JTextField emailAdd;
	private JTextField username;
	private static Scanner m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					systemAdminPortal window = new systemAdminPortal();
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
	public systemAdminPortal() {
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
		
		JLabel lblNewLabel = new JLabel("username:");
		lblNewLabel.setBounds(10, 49, 71, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel a = new JLabel("Email Address:");
		a.setBounds(10, 78, 71, 13);
		frame.getContentPane().add(a);
		
		JLabel c = new JLabel("Password:");
		c.setBounds(10, 107, 71, 13);
		frame.getContentPane().add(c);
		
		JLabel d = new JLabel("User-Type:");
		d.setBounds(10, 130, 85, 13);
		frame.getContentPane().add(d);
		
		JButton addP = new JButton("Add Parking Officer");
		addP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mName = username.getText();
				String mEmail = emailAdd.getText();
				String mpassword = pass.getText();
				String mType = type.getText();
				
				if (mName==null || mEmail == null || mpassword.isEmpty() || mType == null) {
					JOptionPane.showMessageDialog(addP,"No Entry");
					throw new RuntimeException();
				} else {
					try {
						addOfficer(mName,mEmail,mpassword);
						JOptionPane.showMessageDialog(addP,"PEO Added To Data");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		addP.setBackground(Color.MAGENTA);
		addP.setBounds(31, 186, 169, 21);
		frame.getContentPane().add(addP);
		
		type = new JTextField();
		type.setBounds(104, 127, 96, 19);
		frame.getContentPane().add(type);
		type.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(104, 104, 96, 19);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		emailAdd = new JTextField();
		emailAdd.setBounds(104, 75, 96, 19);
		frame.getContentPane().add(emailAdd);
		emailAdd.setColumns(10);
		
		username = new JTextField();
		username.setBounds(104, 46, 96, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JButton deleteP = new JButton("Delete Parking Officer");
		deleteP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mName = username.getText();
				String mEmail = emailAdd.getText();
				String mpassword = pass.getText();
				String mType = type.getText();
				
				if (mName==null || mEmail == null || mpassword.isEmpty() || mType == null) {
					JOptionPane.showMessageDialog(addP,"No Entry");
					throw new RuntimeException();
				} else {
						deleteOfficer(mName,mEmail,mpassword);
						JOptionPane.showMessageDialog(addP,"PEO Removed From Data");
				}
			
			}
		});
		deleteP.setBackground(Color.MAGENTA);
		deleteP.setBounds(266, 186, 146, 21);
		frame.getContentPane().add(deleteP);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalLogin.main(null);
				
			}
		});
		btnNewButton_2.setBackground(Color.MAGENTA);
		btnNewButton_2.setBounds(169, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modify Payment");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(Color.MAGENTA);
		btnNewButton_3.setBounds(10, 232, 133, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("Admin Portal");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(287, 38, 125, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("<-------Insert \"pO\"");
		lblNewLabel_1.setBounds(210, 130, 177, 13);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	
	public void addOfficer(String username,String email,String password) throws IOException {
		
		File hg = new File("loginInfo.txt");						
		FileWriter ui = new FileWriter(hg, true);
		BufferedWriter dsd = new BufferedWriter(ui);
		PrintWriter cb = new PrintWriter(dsd);				
		m = new Scanner(new File("loginInfo.txt"));
		m.useDelimiter("[,\n]");
		
		if (!hg.exists()) {
			hg.createNewFile();
			System.out.println("File is Available");
		} else {
			System.out.println("File is not Available");
		}
		cb.flush();		
		cb.close();		
	}
	
	
	public void deleteOfficer(String username,String email,String password) {
	
		String com1 = "";
		String com3 = "";
		String com2 = "";
		File firstFile = new File("loginInfo.txt");
		File secondFile = new File("odd.csv");
		try {
			FileWriter hg = new FileWriter("odd.csv", true);
			BufferedWriter uio = new BufferedWriter(hg);
			PrintWriter cb = new PrintWriter(uio);
			m = new Scanner(new File("loginInfo.txt"));			
			m.useDelimiter("[,\n]");						
			
	         while (m.hasNext()) {
				com1 = m.next();
				com2 = m.next();
				com3 = m.next();		
				
				
				if (!com1.equals(username)  && !com2.equals(email) && !com3.equals(password)) {
					cb.println(com1 + ","+ com2 + "," + com3);
				}		
			}
			m.close();
			cb.flush();
			cb.close();
			firstFile.delete();		
			File hgj = new File("loginInfo.txt");
			secondFile.renameTo(hgj);								
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
