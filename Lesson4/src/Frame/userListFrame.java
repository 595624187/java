package Frame;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Common.DataProcessing;
import Common.User;

public class userListFrame extends JFrame{

	private JFrame frame;
	private JTable table;
	public userListFrame () {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String u[][] = new String[50][3];
		Enumeration<User> e = null;
		try {
			e = DataProcessing.getAllUser();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User user;
		int n = 0;
		while(e.hasMoreElements()){
			user = e.nextElement();
			u[n][0] = user.getName();
			u[n][1] = user.getPassword();
			u[n][2] = user.getRole();
			n++;
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 432, 253);
		frame.getContentPane().add(scrollPane);
		
		String[] title = {"name","password","role"};
		table = new JTable(u,title);
		scrollPane.setViewportView(table);
		frame.setVisible(true);
	}
}
