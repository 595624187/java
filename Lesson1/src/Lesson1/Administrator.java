package Lesson1;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Administrator extends User{
	Administrator(String name ,String password , String role){
		super(name , password , role);
	}
	public void showMenu(){
		Scanner scan1 = new Scanner(System.in);
		int i;
		String tip_system = "ϵͳ�������Ա�˵�";
		String tip_menu = "��ѡ��˵���";
		String info = "******"+tip_system+"******"+"\n"+tip_menu+
				"\n\t1���޸��û�"+"\n\t2��ɾ���û�"+"\n\t3�������û�"+
				"\n\t4���г��û�"+"\n\t5�������ļ�"+"\n\t6���ļ��б�"+"\n\t7���޸�����"+
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
				System.out.println("������������");
				String role = scan1.next();
				if(DataProcessing.update(name,password,role)){
					System.out.println("�޸ĳɹ�!");
				}else{
					System.out.println("�������!");
				}
				break;
			case 2://ɾ���û�
				System.out.println("������Ҫɾ�����û�:");
				String delname = scan1.next();
				User del=DataProcessing.searchUser(delname);
				if((del.getName()).equals(delname)){
					DataProcessing.delete(delname);
					System.out.println("ɾ���ɹ�");
				}else{
					System.out.println("error!");
				}
				break;
			case 3:
				System.out.println("��������û����û���:");
				String newName = scan1.next();
				System.out.println("��������û�������:");
				String newPassword = scan1.next();
				System.out.println("��������û�������:");
				String newRole = scan1.next();
				DataProcessing.insert(newName,newPassword,newRole);
				break;
			case 4:
				System.out.println("�û���Ϣ�б�����:");
				Enumeration<User> e  = DataProcessing.getAllUser();
				while(e.hasMoreElements()){
					User d =(User)e.nextElement();
					System.out.println("�û���:"+d.getName()+"  ����:"+d.getPassword()+"  ����:"+d.getRole());
					
				}
				
				break;
			case 5:
				System.out.println("��������Ҫ���ص��ļ���:");
				String file = scan1.next();
				if(downloadFile(file)){
					System.out.println("���سɹ�!");
				}else{
					System.err.println("error!");
				}
				break;
			case 6:
				System.out.println("�ļ��б����£�");
				showFileList();
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
					System.err.println("�������!");
			}
			
			System.out.println(info);
			i=scan1.nextInt();


		}	
		System.out.println(tip_exit);

	}




}
	