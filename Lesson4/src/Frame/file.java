package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Common.DataProcessing;


import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Common.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class file extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	public file() {
		setTitle("\u6587\u4EF6\u7BA1\u7406\u754C\u9762");
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		dispose();
		setBounds((width-100)/2, (height-100)/2, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 422, 243);
		panel.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("文件下载", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 417, 171);
		panel_2.add(scrollPane);
		
		String List[][] = new String[100][5];
		Enumeration<Doc> e  = null;
		try {
			e=DataProcessing.getAllDocs();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		int n=0;
		while(e.hasMoreElements()){
			Doc doc=e.nextElement();
			List[n][0]=doc.getID();
			List[n][1]=doc.getCreator();
			List[n][2]=doc.getTimestamp().toString();
			List[n][3]=doc.getFilename();
			List[n][4]=doc.getDescription();
			n++;
		}
	
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel mymodel=(DefaultTableModel)table.getModel();
	    String[] tableheads = new String[] {"档案号","创建者","时间","文件名","描述" } ; 
	    mymodel.setColumnIdentifiers(tableheads);
	    for(int i=0;i<n;i++) {
	    	Vector<String> v = new Vector<String>();
	    	v.add(List[i][0]);
	    	v.add(List[i][1]);
	    	v.add(List[i][2]);
	    	v.add(List[i][3]);
	    	v.add(List[i][4]);
	    	mymodel.insertRow(i,v);
	    }
	    table.setRowHeight(40);
	    table.setRowSelectionAllowed(true);
	    
	    JButton btnNewButton = new JButton("\u4E0B\u8F7D");
	    btnNewButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		try {
					LoginFrame.user.downloadFile((String) table.getValueAt(table.getSelectedRow(), 0));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	    	}	
	    });
	   
	    
	 
	    

	    btnNewButton.setBounds(35, 184, 113, 27);
	    panel_2.add(btnNewButton);
	    
	    JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    	}
	    });
	    btnNewButton_1.setBounds(236, 184, 113, 27);
	    panel_2.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("文件上传", null, panel_1, null);
		
		if(!LoginFrame.user.getRole().equals("operator")) {
			panel_1.disable();
		}
		
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u6863\u6848\u53F7");
		label.setBounds(82, 37, 72, 18);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setBounds(168, 34, 118, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6863\u6848\u63CF\u8FF0");
		lblNewLabel.setBounds(70, 87, 72, 18);
		panel_1.add(lblNewLabel);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(168, 85, 118, 53);
		panel_1.add(textArea);
		
		JLabel label_1 = new JLabel("\u6863\u6848\u6587\u4EF6\u540D");
		label_1.setBounds(70, 159, 84, 18);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 156, 118, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u6253\u5F00");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("D:\\OOP\\download");
				String filepath = null;
				int state = jfc.showOpenDialog(null);
				if(state == JFileChooser.APPROVE_OPTION) {
					File fp = jfc.getSelectedFile();
					filepath=fp.getPath();
				}
				textField_1.setText(filepath);
			}
		});
		button.setBounds(308, 155, 72, 27);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u4E0A\u4F20");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operator op = new Operator(LoginFrame.user.getName(), LoginFrame.user.getPassword(), LoginFrame.user.getRole());
	    		try {
					op.updateFile(textField_1.getText(), textField.getText(), textArea.getText());
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
	    	}
			
		});
		button_1.setBounds(111, 184, 72, 27);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u53D6\u6D88");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setBounds(247, 184, 72, 27);
		panel_1.add(button_2);
		panel.setVisible(true);
	}
}
