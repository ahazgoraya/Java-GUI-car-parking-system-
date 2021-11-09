package finalProject3311;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pEOPortal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static Scanner m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pEOPortal window = new pEOPortal();
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
	public pEOPortal() {
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
		
		JLabel lblNewLabel = new JLabel("Parking Space ID:");
		lblNewLabel.setBounds(10, 44, 118, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Parking Space ID:");
		lblNewLabel_1.setBounds(10, 95, 118, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(138, 41, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 92, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Parking Space");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parkingId = textField.getText();
				if (parkingId == null) {
					JOptionPane.showMessageDialog(btnNewButton,"No entry");
					throw new RuntimeException();
					}
				try {
					addParkingSpace(parkingId);
					JOptionPane.showMessageDialog(btnNewButton,"Added Parking Space in Data");		
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setBounds(268, 40, 147, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Parking Space");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parkingId = textField_1.getText();
				if (parkingId == null) {
					JOptionPane.showMessageDialog(btnNewButton_1,"No Entry");
						throw new RuntimeException();
					}
				try {
					deleteParking(parkingId);
					JOptionPane.showMessageDialog(btnNewButton_1,"Removed Parking Space From Data");		
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
				
			
		});
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setBounds(268, 91, 147, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalLogin.main(null);
			}
		});
		btnNewButton_2.setBackground(Color.MAGENTA);
		btnNewButton_2.setBounds(10, 219, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("PEO Portal");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(292, 203, 111, 21);
		frame.getContentPane().add(lblNewLabel_2);
	}
	
	public void addParkingSpace(String parkingId) throws IOException {
		File xm = new File("peoData.txt");
		FileWriter dsd=new FileWriter("peoData.txt",true);
		BufferedWriter qe = new BufferedWriter(dsd);
		PrintWriter ty = new PrintWriter(qe);
		
		if (!xm.exists()) {
			xm.createNewFile();
			System.out.println("The File exists In Data");
		} else {
			System.out.println("File Doesn't Exists In Data");
		}
		ty.printf("%s\n", parkingId);
		ty.flush();							
		ty.close();							
	}
	
	public void deleteParking(String parkingId) {
		String com = "";
		File firstFile = new File("peoData.txt");
		File secondFile = new File("tmp.csv");
		
		try {
			FileWriter xm = new FileWriter("tmp.csv", true);
			BufferedWriter dsd = new BufferedWriter(xm);
			PrintWriter qe = new PrintWriter(dsd);
			m = new Scanner(new File("peoData.txt"));
			m.useDelimiter("[,\n]");
			
			while (m.hasNext()) {
				com = m.next();
				if (!com.equals(parkingId)) {
					qe.println(com);
				}
			}
			m.close();
			qe.flush();
			qe.close();
			firstFile.delete();
			File dmp = new File("peoData.txt");
			secondFile.renameTo(dmp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
	
	
	


