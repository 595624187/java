package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Common.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class docDowloadFrame extends JFrame{
	
	
	
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
	public docDowloadFrame() {
		frame = new JFrame();
		frame.setTitle("\u4E0B\u8F7D\u6587\u4EF6");
		frame.setBounds(100, 100, 469, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u6587\u6863\u53F7");
		label.setBounds(119, 60, 90, 18);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(232, 57, 123, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u4E0B\u8F7D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					//downloadFile(textField.getText());
					System.out.println("œ¬‘ÿ≥…π¶");
					//Loginframe.user.downloadFile((String) table.getValueAt(table.getSelectedRow(), 0));

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(117, 104, 113, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(242, 104, 113, 27);
		frame.getContentPane().add(button_1);
		frame.setVisible(true);
	}

}
