package Lesson2;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[]args) throws SQLException{
		int choice=0;	
		String tip_system = "����ϵͳ";
		String tip_menu = "��ѡ��˵�: ";
		String tip_exit = "ϵͳ�˳���ллʹ��!";
		String infos = " *******��ӭ����"+tip_system+"**********\n\t  "+
					   "1����½ \n \t  2���˳�\n " +
					   "******************************";
		System.out.println(tip_system+"\n"+infos+"\n"+tip_menu);
		Scanner scan = new Scanner(System.in);
		choice= scan.nextInt();
		while(choice!=2){
			switch(choice){
			case 1:
			System.out.println("�������û�����");
			String name = scan.next();
			System.out.println("���������룺");
			String password = scan.next();
			User user = null;
			try{
			user = DataProcessing.search(name, password);
			if(user!=null){
				System.out.println("Welcome  "+user.getRole()+"  ��ѡ��˵�:");
				user.showMenu();
			}else{
				System.out.println("�˺Ż��������!");
			}
			}catch(SQLException e){
				System.out.println("���ݿ����"+e.getMessage());
			}
			break;
			case 2:
			System.out.println(tip_exit);
			System.exit(0);
			break;
			default:
				System.out.println("�������!");
		    }

	   }
  }
}
