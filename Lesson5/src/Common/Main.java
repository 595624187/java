package Common;



import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[]args) throws Exception{

			
		String tip_system = "����ϵͳ";
		String tip_menu = "��ѡ��˵�: ";
		String tip_exit = "ϵͳ�˳���ллʹ��!";
		String infos = " *******��ӭ����"+tip_system+"**********\n\t  "+
					   "1����½ \n \t  2���˳�\n " +
					   "******************************";
		System.out.println(tip_system+"\n"+infos+"\n"+tip_menu);
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		choice = scan.nextInt();
		
		 while(choice>0){
			 try{
			 switch(choice){
			case 1:
				
			System.out.println("�������û�����");
			String name = scan.next();
			System.out.println("���������룺");
			String password = scan.next();
			User user = null;
			
			user = DataProcessing.searchUser(name, password);
			System.out.println("Welcome ! "+user.getRole()+"��ѡ��˵�:\n");
			user.showMenu();
		
			
			break;
			case 2:
			System.err.println(tip_exit);
			System.exit(0);
			break;
			default:
				System.out.println("�������!");
	
		}

		System.out.println(infos);
		choice= scan.nextInt();
			}catch(Exception e){
			System.out.println("�˺Ż����������������������:");
			}

	
	}

	}
}
