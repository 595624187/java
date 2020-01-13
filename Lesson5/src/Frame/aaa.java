package Frame;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Common.*;

public class aaa extends JFrame{
	JTabbedPane tabbedPane;

	public aaa(final User auser)  {
	setSize(500,500);
	setTitle("文件管理界面");
	Toolkit toolkit=getToolkit();
	Dimension dimension=toolkit.getScreenSize();
	int screenHeight=dimension.height;
	int screenWidth=dimension.width;
	int frm_Height=this.getHeight();
	int frm_Width=this.getWidth();
	this.setLocation((screenWidth-frm_Width)/2, (screenHeight-frm_Height)/2);
	tabbedPane=new JTabbedPane(JTabbedPane.TOP);
	getContentPane().add(tabbedPane,BorderLayout.CENTER);
	final JPanel panel_down=new JPanel();
	tabbedPane.addTab("文件下载", panel_down);
	final JPanel panel_up=new JPanel();
	tabbedPane.addTab("文件上传", panel_up);
	if(auser.getRole().equals("系统管理人员")||auser.getRole().equals("系统浏览人员")) {
		tabbedPane.setEnabledAt(1, false);
		String[] columnname= {"档案号","创建者","时间","文件名","描述"};
		final String[][]data=new String [10][10];
		Enumeration<Doc> m = null;
		int j=0;
		try {
			m=DataProcessing.getAllDocs();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		while (m.hasMoreElements()) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Doc a1=m.nextElement();
			data[j][0]=a1.getID();
			data[j][1]=a1.getCreator();
			data[j][2]=df.format(a1.getTimestamp());
			data[j][3]=a1.getFilename();
			data[j][4]=a1.getDescription();
		
		   }
		
		final JTable ta=new JTable(data,columnname);
		panel_down.setLayout(new BorderLayout());
		panel_down.add(ta.getTableHeader(), BorderLayout.PAGE_START);
		panel_down.add(ta, BorderLayout.CENTER);
		JButton downbutton1=new JButton("下载");
		JButton downbutton2=new JButton("返回");
		JPanel buttonpa=new JPanel();
		panel_down.add(buttonpa, BorderLayout.SOUTH);
		buttonpa.add(downbutton1);
		buttonpa.add(downbutton2);
		downbutton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc1=new JFileChooser();
				fc1.setDialogTitle("下载文件");
				int result=fc1.showSaveDialog(panel_up);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file =fc1.getSelectedFile();
					try {
						if(ta.getSelectedRow()!=-1) {
						if(auser.downloadFile(file.getName())==true) {
							warnFrame wa7=new warnFrame(8);
							wa7.setVisible(true);
						}
						else{
							dispose();
						}
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}


			}
			
		});
	}
	else {
		final Operator a=new Operator(auser.getName(),auser.getPassword(),auser.getRole());
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
		if (tabbedPane.getSelectedComponent().equals(panel_up)) {
		panel_up.removeAll();
		panel_up.updateUI();
		JLabel ID=new JLabel("档案号"),des=new JLabel("档案描述"),file=new JLabel("档案文件名");
		final JTextField id=new JTextField(35);
		final JTextField f=new JTextField(30);
		final JTextArea Dec=new JTextArea(5,35);
		JButton upbutton1=new JButton("打开");
		JButton upbutton2=new JButton("上传");
		JButton upbutton3=new JButton("取消");
		panel_up.add(ID);
		panel_up.add(id);
		panel_up.add(des);
		panel_up.add(Dec);
		panel_up.add(file);
		panel_up.add(f);
		panel_up.add(upbutton1);
		panel_up.add(upbutton2);
		panel_up.add(upbutton3);
		upbutton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc2=new JFileChooser();
				fc2.setDialogTitle("选择文件");
				int result2=fc2.showOpenDialog(panel_up);
				if (result2 == JFileChooser.APPROVE_OPTION) {
					f.setText(fc2.getSelectedFile().getName());
			}
			}
		});
		upbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(a.updateFile(id.getText(), a.getName(), Dec.getText(), f.getText()))
					{
						warnFrame wa9=new warnFrame(10);
						wa9.setVisible(true);
					}
					else {
						warnFrame wa10=new warnFrame(11);
						wa10.setVisible(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
	}
	else if(tabbedPane.getSelectedComponent().equals(panel_down)) {
		panel_down.removeAll();
		panel_down.updateUI();
		String[] columnname= {"档案号","创建者","时间","文件名","描述"};
		final String[][]data=new String [10][10];
		Enumeration<Doc> m = null;
		int j=0;
		try {
			m=DataProcessing.getAllDocs();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		while (m.hasMoreElements()) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Doc a1=m.nextElement();
			data[j][0]=a1.getID();
			data[j][1]=a1.getCreator();
			data[j][2]=df.format(a1.getTimestamp());
			data[j][3]=a1.getFilename();
			data[j][4]=a1.getDescription();
		
		   }
		
		final JTable ta=new JTable(data,columnname);
		panel_down.setLayout(new BorderLayout());
		panel_down.add(ta.getTableHeader(), BorderLayout.PAGE_START);
		panel_down.add(ta, BorderLayout.CENTER);
		JButton downbutton1=new JButton("下载");
		JButton downbutton2=new JButton("返回");
		JPanel buttonpa=new JPanel();
		panel_down.add(buttonpa, BorderLayout.SOUTH);
		buttonpa.add(downbutton1);
		buttonpa.add(downbutton2);
		downbutton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc1=new JFileChooser();
				fc1.setDialogTitle("下载文件");
				int result=fc1.showSaveDialog(panel_up);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file =fc1.getSelectedFile();
					try {
						if(ta.getSelectedRow()!=-1) {
						if(auser.downFileList(file,data[ta.getSelectedRow()][0])==true) {
							warnFrame wa7=new warnFrame(8);
							wa7.setVisible(true);
						}
						else{
							warnFrame wa8=new warnFrame(9);
							wa8.setVisible(true);
						}
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}


			}
			
		});
	}
			}
			});
	}
		
	}
}

