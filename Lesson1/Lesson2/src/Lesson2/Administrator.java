package Lesson2;


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
		users = new Hashtable<String,User>();
		Scanner scan1 = new Scanner(System.in);
		int i;
		String tip_system = "系统进入管理员菜单";
		String tip_menu = "请选择菜单：";
		String info = "******"+tip_system+"******"+"\n"+tip_menu+
				"\n\t1、修改用户"+"\n\t2、删除用户"+"\n\t3、新增用户"+
				"\n\t4、列出用户"+"\n\t5、下载文件"+"\n\t7、修改密码"+
				"\n\t8、退    出"+ "\n******************************";
		String tip_exit = "系统退出，谢谢使用!";
		System.out.println(info);
			i=scan1.nextInt();
		while(i!=8){
			switch(i){
			case 1:
				System.out.println("修改用户"+"\n请输入用户名：");
				String name = scan1.next();
				System.out.println("请输入新密码:");
				String password = scan1.next();
				System.out.println("请输入新身份");
				String role = scan1.next();
				try{
				if(DataProcessing.update(name,password,role)){
					System.out.println("修改成功!");
				}else{
					System.out.println("密码错误!");
				}
				}catch(SQLException e){
					System.out.println("文件访问错误Error in accessing file");
				}catch(IllegalArgumentException e){
					System.out.println("用户名或密码错误!!!");
					
				}
				break;
			case 2:
				System.out.println("请输入要删除的用户:");
				String delname = scan1.next();
				try{
				User del = DataProcessing.searchUser(delname);
				if((del.getName()).equals(delname)){
					DataProcessing.delete(delname);
				}else{
					System.out.println("error!");
				}
				break;
				}catch(SQLException e){
					System.out.println("无法删除！！！");
				}
			case 3:
				try{
				System.out.println("请输入该用户的用户名:");
				String newName = scan1.next();
				System.out.println("请输入该用户的密码:");
				String newPassword = scan1.next();
				System.out.println("请输入该用户的身份:");
				String newRole = scan1.next();
				DataProcessing.insert(newName,newPassword,newRole);
				break;
				}catch(SQLException e){
					System.out.println("无法新增！！！");
				}
			case 4:
				System.out.println("用户信息列表如下:");
				try{
				Enumeration<User> e  = DataProcessing.getAllUser();
				while(e.hasMoreElements()){
					User d =(User)e.nextElement();
					System.out.println("用户名:"+d.getName()+"  密码:"+d.getPassword()+"  身份:"+d.getRole());
					
				}
				
				break;
				}catch(SQLException e){
					System.out.println("无法列出列表!!!");
				}
			case 5:
				System.out.println("请输入需要下载的文件号:");
				try{
				String file = scan1.next();
				if(downloadFile(file)){
					System.out.println("下载成功!");
				}else{
					System.err.println("error!");
				}
				break;
				}catch(IOException e){
					System.out.println("无法下载!!!");
				}
			case 6:
				System.out.println("文件列表如下：");
				try{
				showFileList();
				break;
				}catch(SQLException e){
					System.out.println("无法列出列表");
				}
			case 7:
				//System.out.println("请输入要修改的用户:");
				
				System.out.println("请输入当前密码:");
				String prePassword = scan1.next();
				if(prePassword.equals(getPassword())){
					System.out.println("请输入新密码:");
					String newPassword1 = scan1.next();
					setPassword(newPassword1);
					System.out.println("修改成功！");
				}else{
					System.out.println("输入错误!");
				}
				break;
				default :
					System.out.println("输入错误!");
			}
			
			System.out.println(info);
			i=scan1.nextInt();


		}	
		System.out.println(tip_exit);

	}




}
	