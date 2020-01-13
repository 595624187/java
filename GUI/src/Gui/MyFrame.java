package Gui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
	


	public class MyFrame implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String str =MyFrame.tf1.getText();
			String str1 =MyFrame.tf2.getText();
			MyFrame.tf1.setText(str1);
			MyFrame.tf2.setText(str);
		}
		
		static TextField tf1;
		static TextField tf2;
		public static void main(String[]args){
		Frame fr = new Frame();
		Color c1 = new Color(255,175,175);
		fr.setBackground(c1);
		fr.setSize(800, 600);
		Panel p = new Panel();
		fr.add(p);
		p.add(new Label("用户名:"));
		tf1 = new TextField("请输入用户名：",10);	
		p.add(tf1);
		p.add(new Label("密    码:"));
		tf2 = new TextField("请输入密码：",10);
		p.add(tf2);
		Button bt =new Button("登陆");
		bt.addActionListener(new MyFrame());
		p.add(bt);
		MenuBar mb = new MenuBar();
		fr.setMenuBar(mb);
		Menu m1 = new Menu("文件");
		mb.add(m1);
		Menu m2 = new Menu("打开");
		mb.add(m2);
		Menu m3 = new Menu("编辑");
		mb.add(m3);
		Menu m4 = new Menu("打开文件夹");
		m1.add(m4);
		fr.setVisible(true);
	}
}
