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
		p.add(new Label("�û���:"));
		tf1 = new TextField("�������û�����",10);	
		p.add(tf1);
		p.add(new Label("��    ��:"));
		tf2 = new TextField("���������룺",10);
		p.add(tf2);
		Button bt =new Button("��½");
		bt.addActionListener(new MyFrame());
		p.add(bt);
		MenuBar mb = new MenuBar();
		fr.setMenuBar(mb);
		Menu m1 = new Menu("�ļ�");
		mb.add(m1);
		Menu m2 = new Menu("��");
		mb.add(m2);
		Menu m3 = new Menu("�༭");
		mb.add(m3);
		Menu m4 = new Menu("���ļ���");
		m1.add(m4);
		fr.setVisible(true);
	}
}
