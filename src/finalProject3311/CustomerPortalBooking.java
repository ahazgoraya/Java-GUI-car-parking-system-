package finalProject3311;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CustomerPortalBooking {

	private JFrame frame;
	private JTextField spotId;
	private JTextField timeDuration;
	private JTextField iniTime;
	private JTextField finalTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPortalBooking window = new CustomerPortalBooking();
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
	public CustomerPortalBooking() {
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
		
		JLabel lblNewLabel = new JLabel("Parking Spot ID:");
		lblNewLabel.setBounds(10, 60, 102, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time Duration:");
		lblNewLabel_1.setBounds(10, 163, 85, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		spotId = new JTextField();
		spotId.setBounds(122, 57, 96, 19);
		frame.getContentPane().add(spotId);
		spotId.setColumns(10);
		
		timeDuration = new JTextField();
		timeDuration.setBounds(122, 160, 96, 19);
		frame.getContentPane().add(timeDuration);
		timeDuration.setColumns(10);
	
		
		try {	
		FileWriter rd = new FileWriter("paymentInfo.txt",true);
		BufferedWriter dof = new BufferedWriter(rd);

//		spots.write("s1" + "s2" + "s3" + "s4" + "s5" + "s6" + "s7" + "s8" + "s9" + "s10" + "s11" + "" + "" + "" + "" + "" + "" +);
			
			dof.newLine();
	        dof.close();
	}
		catch(Exception e1){
			System.out.print("Exception");
		}				
		
		JButton btnNewButton = new JButton("Proceed To Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             try{
					
				    FileWriter rd=new FileWriter("parkingSpotsData.txt",true);
					BufferedWriter we=new BufferedWriter(rd);
					String f = spotId.getText();
					String g = iniTime.getText();	
					String h = finalTime.getText();
					String j = timeDuration.getText();
					
					we.write(f + " " + g + " " + h + " " + j);
						
						we.newLine();
				        we.close();
					}
					catch(Exception e1){
						System.out.print("Exception");
					}				
					
				customerPayment.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setBounds(210, 207, 185, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check Spot Availability");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				FileReader vf=new FileReader("parkingSpotsData.txt");
				BufferedReader hg=new BufferedReader(vf);
				String de=hg.readLine();
				
				String[] nol = de.split(" ");
				for(int u=0;u<50;u++) {
				
					if(nol[u].equals(spotId.getText())) {
				JOptionPane.showMessageDialog(btnNewButton_1,"Parking Spot Available");
				break;
				}
					
				else{
					JOptionPane.showMessageDialog(btnNewButton_1,"Parking Spot is not Available");
					break;
				}
					
				}
				hg.close();
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
				
				
				
				}
		});
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setBounds(234, 56, 145, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Parking Spots Map");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(btnNewButton_2,new ImageIcon("pic2.jpg"));
			}
		});
		btnNewButton_2.setBackground(Color.MAGENTA);
		btnNewButton_2.setBounds(147, 10, 145, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("See Spots Available:");
		lblNewLabel_2.setBounds(10, 14, 117, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Go Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerHome.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBackground(Color.MAGENTA);
		btnNewButton_3.setBounds(27, 207, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Start Time:");
		lblNewLabel_3.setBounds(10, 100, 85, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		iniTime = new JTextField();
		iniTime.setBounds(122, 97, 96, 19);
		frame.getContentPane().add(iniTime);
		iniTime.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("End Time:");
		lblNewLabel_4.setBounds(10, 133, 66, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		finalTime = new JTextField();
		finalTime.setBounds(122, 131, 96, 19);
		frame.getContentPane().add(finalTime);
		finalTime.setColumns(10);
	}
}
