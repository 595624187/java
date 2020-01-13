package Frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import Common.DataProcessing;
import Common.User;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{

	private JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
    public String name;
    public String code;
    public static User user;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */

	public   LoginFrame() {		
	JFrame f = new JFrame();
	f.getContentPane().setLayout(new BorderLayout());
	f.setTitle("系统登录");
	f.setSize(445,314);

	Toolkit toolkit = f.getToolkit();
	Dimension dimension = toolkit.getScreenSize();
	int screenHeight = dimension.height;
	int screenWidth = dimension.width;
	int frm_Height = f.getHeight();
	int frm_Width = f.getWidth();
	f.setLocation((screenWidth-frm_Width)/2,(screenHeight-frm_Height)/2);
	//f.setAlwaysOnTop(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Panel p = new Panel();
	f.getContentPane().add(p);
	f.getContentPane().add(p);
	p.setLayout(null);
	Label label_1 = new Label("用户名:");
	label_1.setBounds(127, 72, 63, 25);
	p.add(label_1);
	
	textField = new JTextField();
	textField.setText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
	textField.setToolTipText("");
	textField.setBounds(196, 72, 120, 24);
	p.add(textField);
	textField.setColumns(10);
	Label label = new Label("密码:");
	label.setBounds(127, 122, 48, 25);
	p.add(label);
	
	textField_1 = new JTextField();
	textField_1.setText("\u8BF7\u8F93\u5165\u5BC6\u7801");
	textField_1.setToolTipText("");
	textField_1.setBounds(196, 123, 120, 24);
	p.add(textField_1);
	textField_1.setColumns(10);
	
	JButton button = new JButton("\u767B\u9646");
	button.addActionListener(new ActionListener() {
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e) {
			
			try {
				if((user=DataProcessing.searchUser(textField.getText(), textField_1.getText()))!=null) {
				LoginUser win = new LoginUser();
				//win.setVisible(true);
				}else {
					System.out.println("用户名或密码错误!");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	button.setBounds(127, 177, 63, 27);
	p.add(button);
	
	JButton button_1 = new JButton("\u9000\u51FA");
	button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			System.exit(DO_NOTHING_ON_CLOSE);
		}
	});
	button_1.setBounds(241, 177, 63, 27);
	p.add(button_1);
	f.setVisible(true);
	}
	
	
}
