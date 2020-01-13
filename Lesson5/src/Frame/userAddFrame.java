package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Common.DataProcessing;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class userAddFrame extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String new_role;
	/**
	 * Launch the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	public userAddFrame(){
		
		frame = new JFrame();
		frame.setTitle("\u6DFB\u52A0\u7528\u6237");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7528\u6237\u540D");
		label.setBounds(95, 51, 105, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801");
		label_1.setBounds(95, 83, 105, 18);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u9009\u62E9\u8EAB\u4EFD");
		label_2.setBounds(95, 117, 105, 18);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(224, 48, 113, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 83, 113, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 new_role = (String) e.getItem();
			}
		});
		
	
        frame.getContentPane().add(comboBox);
		String[] role= {"browser","operator","administrator"};
		for(int i=0;i<3;i++)
			comboBox.addItem(role[i]);

		
		comboBox.setToolTipText("Administrator");
		comboBox.setBounds(224, 114, 113, 24);
		frame.getContentPane().add(comboBox);
		
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataProcessing.insertUser(textField.getText(), textField_1.getText(),new_role);
					System.out.println("Ìí¼Ó³É¹¦");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(87, 169, 113, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame.setVisible(false);

			}

		});
		

		
		button_1.setBounds(227, 169, 113, 27);
		frame.getContentPane().add(button_1);
		frame.setVisible(true);
	}
}
