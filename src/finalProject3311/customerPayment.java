package finalProject3311;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class customerPayment {

	private JFrame frame;
	private JTextField parkingNum;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JTextField cardNumber;
	private JTextField cardExpiryDate;
	private JLabel lblNewLabel_3;
	private JTextField cardCvv;
	private JLabel lblNewLabel_4;
	int money = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerPayment window = new customerPayment();
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
	public customerPayment() {
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
		
		JLabel lblNewLabel = new JLabel("Parking Space Number:");
		lblNewLabel.setBounds(10, 54, 119, 13);
		frame.getContentPane().add(lblNewLabel);
		
		parkingNum = new JTextField();
		parkingNum.setBounds(139, 51, 96, 19);
		frame.getContentPane().add(parkingNum);
		parkingNum.setColumns(10);
		
		btnNewButton = new JButton("Get Order Price");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton,"Payment Due is: " + money);

			}
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setBounds(259, 50, 119, 21);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Card Number:");
		lblNewLabel_1.setBounds(10, 88, 96, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Card Expiry Date:");
		lblNewLabel_2.setBounds(10, 124, 96, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Pay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               try{
					
				    FileWriter bu=new FileWriter("paymentData.txt",true);
					BufferedWriter er=new BufferedWriter(bu);
					String z = cardNumber.getText();	
					String x = cardExpiryDate.getText();
					String c = cardCvv.getText();
					
					String v = Integer.toString(money);
					
					er.write(z + " " + x + " " + c + " " + v);
						
						er.newLine();
				        er.close();
					}
					catch(Exception e1){
						System.out.print("Exception");
					}				
				
				finalLogin.main(null);
				frame.setVisible(false);
			
				JOptionPane.showMessageDialog(btnNewButton_1,"Payment Successful!!!");
		}
		});
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setBounds(150, 198, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		cardNumber = new JTextField();
		cardNumber.setBounds(139, 85, 96, 19);
		frame.getContentPane().add(cardNumber);
		cardNumber.setColumns(10);
		
		cardExpiryDate = new JTextField();
		cardExpiryDate.setBounds(139, 121, 96, 19);
		frame.getContentPane().add(cardExpiryDate);
		cardExpiryDate.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Card CVV:");
		lblNewLabel_3.setBounds(10, 158, 72, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		cardCvv = new JTextField();
		cardCvv.setBounds(139, 155, 96, 19);
		frame.getContentPane().add(cardCvv);
		cardCvv.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Secure Payment Portal:");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(25, 10, 243, 13);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
