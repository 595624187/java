package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Common.DataProcessing;
import Common.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class selfChangeFrame extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	public selfChangeFrame() {
		frame = new JFrame();
		frame.setTitle("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		frame.setBounds(100, 100, 501, 204);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		label.setBounds(102, 34, 90, 18);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(230, 31, 124, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = null;
				try {
					DataProcessing.updateUser(user.getName(), textField.getText(), user.getRole());
					System.out.println("ÃÜÂëÐÞ¸Ä³É¹¦");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(102, 84, 113, 27);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				frame.setVisible(false);
			}
		});
		button_1.setBounds(241, 84, 113, 27);
		frame.getContentPane().add(button_1);
		frame.setVisible(true);
	}



}
