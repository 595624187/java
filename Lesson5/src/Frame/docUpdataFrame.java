package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Common.DataProcessing;
import Common.User;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class docUpdataFrame extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String uploadpath="e:\\OPP\\uploadfile\\";

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */
	
	public docUpdataFrame() {
		frame = new JFrame();
		frame.setTitle("\u4E0A\u4F20\u6587\u4EF6");
		frame.setBounds(100, 100, 518, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u6587\u6863\u53F7");
		lblNewLabel.setBounds(76, 25, 96, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(194, 22, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u539F\u6587\u4EF6\u540D");
		label.setBounds(76, 70, 117, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u6587\u6863\u63CF\u8FF0");
		label_1.setBounds(76, 121, 117, 18);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 67, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 118, 117, 76);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u4E0A\u4F20");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = null;
				File tempfile = new File(textField_1.getText());
				String filename = tempfile.getName();
				@SuppressWarnings("null")
				String creator = user.getRole();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
				try {
					DataProcessing.insertDoc(textField.getText(),creator,timestamp,textField_2.getText(),filename);
					//docs.put("0001",new Doc("0001","jack",timestamp,"Doc Source Java","Doc.java"));
					byte [] b = new byte[1024];
					BufferedInputStream in = new BufferedInputStream(new FileInputStream(tempfile));
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(uploadpath+filename));
					int t = 0;
					while((t = in.read(b))!=-1){
						out.write(b,0,t);
					}
					in.close();
					out.close();
					System.out.println("上传成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button.setBounds(80, 237, 113, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(248, 237, 113, 27);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton = new JButton("\u6253\u5F00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
						JFileChooser jfc = new JFileChooser("e:\\OPP\\uploadfile\\");
						String filepath = null;
						int state = jfc.showOpenDialog(null);
						if(state == JFileChooser.APPROVE_OPTION) {
							File fp = jfc.getSelectedFile();
							filepath=fp.getPath();
						}
						textField_1.setText(filepath);
					}
				
		});
		btnNewButton.setBounds(300, 66, 113, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);

	}
}
