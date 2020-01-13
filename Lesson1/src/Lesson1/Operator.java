package Lesson1;
import java.util.Hashtable;
import java.util.Scanner;
public class Operator extends User{
	Operator(String name ,String password , String role){
		super(name , password , role);
	}
	public void showMenu(){
		Hashtable<String, User> users;
		String tip_Info ="******"+"欢迎进入档案录入员菜单!"+"*******"+
				"\n\t1、上传文件"+"\n\t2、下载文件"+"\n\t3、文件列表"+
				"\n\t4、修改密码"+"\n\t5、退出"+ "\n******************************";
		String tip_exit = "系统退出，谢谢使用!";
		System.out.println(tip_Info);
		Scanner scan2 = new Scanner(System.in);
		int i = scan2.nextInt();
		while(i!=5){
			
			switch(i){
			case 1:
				System.out.println("请输入原文件名:");
				String newfile = scan2.next();
				System.out.println("请输入档案号:");
				String newnumber = scan2.next();
				System.out.println("请输入档案描述:");
				String newdiscription = scan2.next();
				System.out.println("上传成功!");
				break;
			case 2:
				System.out.println("请输入需要下载的文件号:");
				String file = scan2.next();
				if(downloadFile(file)){
					System.out.println("下载成功!");
				}else{
					System.err.println("error!");
				}
				break;
			case 3:
				System.out.println("文件列表如下：");
				showFileList();
				break;
			case 4:
				System.out.println("请输入当前密码:");
				String prePassword = scan2.next();
				if(prePassword.equals(getPassword())){
					System.out.println("请输入新密码:");
					String newPassword1 = scan2.next();
					setPassword(newPassword1);
					System.out.println("修改成功！");
				}else{
					System.out.println("输入错误!");
				}
				break;
			default :
				System.err.println("输入错误!");
				
			}
			System.out.println(tip_Info);
			i=scan2.nextInt();

		}
		System.out.println(tip_exit);
	}




}
	