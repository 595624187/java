package Lesson1;

import java.util.Scanner;

public class Main {
	public static void main(String[]args){
		while(true){
		String tip_system = "档案系统";
		String tip_menu = "请选择菜单: ";
		String tip_exit = "系统退出，谢谢使用!";
		String infos = " *******欢迎进入"+tip_system+"**********\n\t  "+
					   "1、登陆 \n \t  2、退出\n " +
					   "******************************";
		System.out.println(tip_system+"\n"+infos+"\n"+tip_menu);
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch(choice){
		case 1:
		
		System.out.println("请输入用户名：");
			String name = scan.next();
			System.out.println("请输入密码：");
			String password = scan.next();		
			User user = DataProcessing.search(name, password);
			if(user==null){
				System.out.println("用户名或密码错误");
			}else{
				System.out.println("Welcome ! "+user.getRole()+"请选择菜单:\n");
						user.showMenu();
				}
			break;
		
		case 2:
			System.out.println(tip_exit);
			System.exit(0);
			break;
		default:
			System.err.println("error!");
			break;
		
	}
		
	}
}
}
