package Common;



import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Browser extends User{
	Browser(String name ,String password , String role){
		super(name , password , role);
	}
	public void showMenu(){
		Hashtable<String, User> users;
		String tip_Info ="******"+"欢迎进入浏览员菜单!"+"*******"+
						"\n\t1、下载文件"+"\n\t2、文件列表"+"\n\t3、修改密码"+
						"\n\t4、退出"+ "\n******************************";
		String tip_exit = "系统退出，谢谢使用!";
		System.out.println(tip_Info);
		Scanner scan2 = new Scanner(System.in);
		int i = scan2.nextInt();
		while(i!=4){
			switch(i){
				case 1:
					System.out.println("请输入需要下载的文件号:");
					String file = scan2.next();
					try{
					try {
						if(downloadFile(file)){
							System.out.println("下载成功!");
						}else{
							System.err.println("error!");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					}catch(IOException e){
						System.out.println("文件访问错误Error in accessing file");
					}
					break;
				case 2:
					System.out.println("文件列表如下：");
					try{
					showFileList();
					}catch(SQLException e){
						System.out.println("文件访问错误Error in accessing file");
					}
					break;
				case 3:
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
					break;
			}
			System.out.println(tip_Info);
			i=scan2.nextInt();

		}
		System.out.println(tip_exit);

	}




}
	