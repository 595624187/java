


import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Administrator extends User{
	Administrator(String name ,String password , String role){
		super(name , password , role);
	}
	public void showMenu(){
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
				if(downloadFile(file)){
					System.out.println("���سɹ�!");
				}else{
					System.err.println("error!");
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
		System.out.println(tip_exit);

	}




}
	