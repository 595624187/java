package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Common.DataProcessing;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class userDelFrame extends JFrame{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */
	public  userDelFrame() {
		frame = new JFrame();
		frame.setTitle("\u5220\u9664\u7528\u6237");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8BE5\u7528\u6237\u540D");
		label.setBounds(97, 86, 93, 32);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(224, 90, 143, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataProcessing.deleteUser(textField.getText());
					System.out.println("É¾³ý³É¹¦");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(97, 157, 113, 27);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ÍË³ö");
				dispose();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(235, 157, 113, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}
}
