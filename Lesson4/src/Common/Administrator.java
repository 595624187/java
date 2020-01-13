package Common;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JFrame;

public class Administrator extends User{
	public Administrator(String name ,String password , String role){
		super(name , password , role);
	}
	
	public void showMenu(){
		
		
		
		Frame f1 = new Frame();
		f1.setTitle("ϵͳ��¼");
		f1.setSize(380,200);
		f1.setVisible(true);
		/*
		TextField tf1; 		
		TextField tf2; 

		JFrame f = new JFrame();
		f.setTitle("ϵͳ��¼");
		f.setSize(380,200);
		f.setVisible(true);
		Toolkit toolkit = f.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int screenHeight = dimension.height;
		int screenWidth = dimension.width;
		int frm_Height = f.getHeight();
		int frm_Width = f.getWidth();
		f.setLocation((screenWidth-frm_Width)/2,(screenHeight-frm_Height)/2);
		f.setAlwaysOnTop(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel();
		f.add(p);
		p.add(new Label("�û���:"));
		tf1 = new TextField();
		tf1 = new TextField("�������û���",12);
		p.add(tf1);
		f.add(p);
		p.add(new Label("����:"));
		tf2 = new TextField("����������",12);
		p.add(tf2);
		Button bt1 = new Button("��½");
		p.add(bt1);
		bt1.addActionListener(new loginFrame());
		Button bt2 = new Button("�˳�");
		p.add(bt2);
		bt2.addActionListener(new loginFrame());
		
		*/
		
		
		
		
		
		Hashtable<String, User> users;
		users = new Hashtable<String, User>();
		Scanner scan1 = new Scanner(System.in);

		int i;
		String tip_system = "ϵͳ�������Ա�˵�";
		String tip_menu = "��ѡ��˵���";
		String info = "******"+tip_system+"******"+"\n"+tip_menu+
				"\n\t1���޸��û�"+"\n\t2��ɾ���û�"+"\n\t3�������û�"+
				"\n\t4���г��û�"+"\n\t5�������ļ�"+"\n\t7���޸�����"+
				"\n\t8����    ��"+ "\n******************************";
		String tip_exit = "ϵͳ�˳���ллʹ��!";
		System.out.println(info);
			i=scan1.nextInt();
		while(i!=8){
			switch(i){
			case 1:
				System.out.println("�޸��û�"+"\n�������û�����");
				String name = scan1.next();
				System.out.println("������������:");
				String password = scan1.next();
				System.out.println("�����������");
				String role = scan1.next();
				try{
				if(DataProcessing.updateUser(name,password,role)){
					System.out.println("�޸ĳɹ�!");
				}else{
					System.out.println("�������!");
				}
				}catch(SQLException e){
					System.out.println("�ļ����ʴ���Error in accessing file");
				}
				break;
			case 2:
				System.out.println("������Ҫɾ�����û�:");
				String delname = scan1.next();
				try{
					DataProcessing.deleteUser(delname);
				}catch(SQLException e){
					System.out.println("���ݿ����Not Connected to Database");
				}
				break;
			case 3:

				System.out.println("��������û����û���:");
				String newName = scan1.next();
				System.out.println("��������û�������:");
				String newPassword = scan1.next();
				System.out.println("��������û������:");
				String newRole = scan1.next();
				try{
				DataProcessing.insertUser(newName,newPassword,newRole);
				}catch(SQLException e){
					System.out.println("�ļ����ʴ���Error in accessing file");
				}
				break;
			case 4:
				System.out.println("�û���Ϣ�б�����:");
				try{
				Enumeration<User> e  = DataProcessing.getAllUser();
				while(e.hasMoreElements()){
					User d =(User)e.nextElement();
					System.out.println("�û���:"+d.getName()+"  ����:"+d.getPassword()+"  ���:"+d.getRole());
					
				}
				}catch(SQLException e){
					System.out.println("�ļ����ʴ���Error in accessing file");
				}
				break;
			case 5:
				System.out.println("��������Ҫ���ص��ļ���:");
				String file = scan1.next();
				try{
				try {
					if(downloadFile(file)){
						System.out.println("���سɹ�!");
					}else{
						System.err.println("error!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				}catch(IOException e){
					System.out.println("�ļ����ʴ���Error in accessing file");
				}
		
				break;
			case 6:
				System.out.println("�ļ��б����£�");
				try{
				showFileList();
				}catch(SQLException e){
					System.out.println("�ļ����ʴ���Error in accessing file");
				}
				break;
			case 7:
				//System.out.println("������Ҫ�޸ĵ��û�:");
				
				System.out.println("�����뵱ǰ����:");
				String prePassword = scan1.next();
				if(prePassword.equals(getPassword())){
					System.out.println("������������:");
					String newPassword1 = scan1.next();
					setPassword(newPassword1);
					System.out.println("�޸ĳɹ���");
				}else{
					System.out.println("�������!");
				}
				break;
				default :
					System.out.println("�������!");
					break;
			}
			
			System.out.println(info);
			i=scan1.nextInt();


		}	
		

	

	}


}
	