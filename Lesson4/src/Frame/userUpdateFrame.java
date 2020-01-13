package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Common.DataProcessing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import Common.*;
public class userUpdateFrame extends JFrame{

	private JFrame frame;
	private JTextField textField_1;
	private String new_role;
	private JTextField textField_2;
	private User user;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	public userUpdateFrame() {
		frame = new JFrame();
		frame.setTitle("\u4FEE\u6539\u7528\u6237");
		frame.setBounds(100, 100, 453, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		label.setBounds(81, 93, 116, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u65B0\u8EAB\u4EFD");
		label_1.setBounds(81, 138, 105, 18);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 90, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(DataProcessing.updateUser(textField_2.getText(), textField_1.getText(), new_role)) {
					System.out.println("修改成功");
					}else {
						dispose();
						System.out.println("修改失败");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(57, 182, 113, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("退出");
				dispose();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(222, 182, 113, 27);
		frame.getContentPane().add(button_1);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				new_role=(String) e.getItem();
			}
		});
		
	
        frame.getContentPane().add(comboBox);
		String[] role= {"browser","operator","administrator"};
		for(int i=0;i<3;i++)
			comboBox.addItem(role[i]);

		
		comboBox.setToolTipText("Administrator");
		comboBox.setBounds(200, 135, 86, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u7528\u6237\u540D");
		label_2.setBounds(57, 62, 129, 18);
		frame.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 53, 86, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		frame.setVisible(true);
	}
}
