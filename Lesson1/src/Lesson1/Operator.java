package Lesson1;
import java.util.Hashtable;
import java.util.Scanner;
public class Operator extends User{
	Operator(String name ,String password , String role){
		super(name , password , role);
	}
	public void showMenu(){
		Hashtable<String, User> users;
		String tip_Info ="******"+"��ӭ���뵵��¼��Ա�˵�!"+"*******"+
				"\n\t1���ϴ��ļ�"+"\n\t2�������ļ�"+"\n\t3���ļ��б�"+
				"\n\t4���޸�����"+"\n\t5���˳�"+ "\n******************************";
		String tip_exit = "ϵͳ�˳���ллʹ��!";
		System.out.println(tip_Info);
		Scanner scan2 = new Scanner(System.in);
		int i = scan2.nextInt();
		while(i!=5){
			
			switch(i){
			case 1:
				System.out.println("������ԭ�ļ���:");
				String newfile = scan2.next();
				System.out.println("�����뵵����:");
				String newnumber = scan2.next();
				System.out.println("�����뵵������:");
				String newdiscription = scan2.next();
				System.out.println("�ϴ��ɹ�!");
				break;
			case 2:
				System.out.println("��������Ҫ���ص��ļ���:");
				String file = scan2.next();
				if(downloadFile(file)){
					System.out.println("���سɹ�!");
				}else{
					System.err.println("error!");
				}
				break;
			case 3:
				System.out.println("�ļ��б����£�");
				showFileList();
				break;
			case 4:
				System.out.println("�����뵱ǰ����:");
				String prePassword = scan2.next();
				if(prePassword.equals(getPassword())){
					System.out.println("������������:");
					String newPassword1 = scan2.next();
					setPassword(newPassword1);
					System.out.println("�޸ĳɹ���");
				}else{
					System.out.println("�������!");
				}
				break;
			default :
				System.err.println("�������!");
				
			}
			System.out.println(tip_Info);
			i=scan2.nextInt();

		}
		System.out.println(tip_exit);
	}




}
	