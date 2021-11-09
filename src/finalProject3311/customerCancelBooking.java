package finalProject3311;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class customerCancelBooking {

	private JFrame frame;
	private JTextField id;
	private static Scanner m;
	private JTextField iniTime;
	private JTextField finTime;
	private JTextField dur;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerCancelBooking window = new customerCancelBooking();
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
	public customerCancelBooking() {
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
		
		JLabel lblNewLabel = new JLabel("Parking ID:");
		lblNewLabel.setBounds(28, 57, 69, 13);
		frame.getContentPane().add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(119, 54, 106, 19);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel Booked spot");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ide = id.getText();
				String init = iniTime.getText();
				String fint = finTime.getText();
				String durt = dur.getText();
				
				deleteParking(ide, init, fint, durt);
				JOptionPane.showMessageDialog(btnNewButton,"Booking has been cancelled");
			}
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setBounds(247, 165, 131, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Cancellation Portal");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(28, 10, 299, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerHome.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setBounds(39, 165, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Initial Time:");
		lblNewLabel_2.setBounds(28, 86, 106, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Final Time:");
		lblNewLabel_3.setBounds(28, 109, 116, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Time Duration:");
		lblNewLabel_4.setBounds(28, 132, 116, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		iniTime = new JTextField();
		iniTime.setBounds(119, 83, 96, 19);
		frame.getContentPane().add(iniTime);
		iniTime.setColumns(10);
		
		finTime = new JTextField();
		finTime.setBounds(119, 109, 96, 19);
		frame.getContentPane().add(finTime);
		finTime.setColumns(10);
		
		dur = new JTextField();
		dur.setBounds(119, 132, 96, 19);
		frame.getContentPane().add(dur);
		dur.setColumns(10);
	}
	
	public void deleteParking(String spotId,String iniTime,String finalTime, String timeDuration) {
		
		String com1 = "";
		String com3 = "";
		String com2 = "";
		String com4 = "";
		File firstFile = new File("parkingSpotsData.txt");
		File secondFile = new File("odd.csv");
		try {
			FileWriter yu = new FileWriter("odd.csv", true);
			BufferedWriter tu = new BufferedWriter(yu);
			PrintWriter qw = new PrintWriter(tu);
			m = new Scanner(new File("parkingSpotsData.txt"));			
			m.useDelimiter("[,\n]");						
			
		
			while (m.hasNext()) {
				com1 = m.next();
				com2 = m.next();
				com3 = m.next();
				com4 = m.next();
				
				
				if (!com1.equals(spotId)  && !com2.equals(iniTime) && !com3.equals(finalTime) && !com4.equals(timeDuration)) {
					qw.println(com1 + ","+ com2 + "," + com3 + "," + com4);
				}		
			}
			m.close();
			qw.flush();
			qw.close();
			firstFile.delete();		
			File cmv = new File("parkingSpotsData.txt");
			secondFile.renameTo(cmv);								
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
