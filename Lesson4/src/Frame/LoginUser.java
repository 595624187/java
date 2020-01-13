package Frame;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Common.DataProcessing;
import Common.Doc;
import Common.User;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LoginUser extends JFrame {
	static TextField tf1; 		
	static TextField tf2; 

	public    LoginUser(){
		JFrame f = new JFrame();
		f.setTitle("档案录入员界面");
		f.setSize(722,396);
		f.setLocation(100,200);
		//f.setAlwaysOnTop(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//f.setMenuBar(mb);
		

		JMenuBar menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(menu);
		
	    if(!LoginFrame.user.getRole().equals("administrator")) {
	    	menu.enable(false);
	    }

		JMenuItem menuItem = new JMenuItem("\u6DFB\u52A0\u7528\u6237");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("添加用户");
				userAddFrame add = new userAddFrame();
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u7528\u6237");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userUpdateFrame up = new userUpdateFrame();
				System.out.println("修改用户");
				
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5220\u9664\u7528\u6237");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("删除用户");
				userDelFrame udf = new userDelFrame();
				

			}
		});
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5217\u51FA\u7528\u6237");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userListFrame uf = new userListFrame();
				
			}
		});
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u6863\u6848\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_8 = new JMenuItem("\u6587\u4EF6\u7BA1\u7406");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file fe = new file();
				System.out.println("文件管理");
				fe.setVisible(true);
			}
		});
		menu_1.add(menuItem_8);
		
		JMenu menu_2 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_7 = new JMenuItem("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selfChangeFrame sf = new selfChangeFrame();
				
			}
		});
		menu_2.add(menuItem_7);

		f.setVisible(true);
	}

	

}
