package Common;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
public class Operator extends User{
	public Operator(String name ,String password , String role){
		super(name , password , role);
	}		
	Scanner scan2 = new Scanner(System.in);

	
	public void updateFile(String soursefile, String ID, String discription){
		try{
			/*
		System.out.println("请输入源文件名:");
		String soursefile = scan2.next();
		System.out.println("请输入档案号:");
		String ID = scan2.next();
		while (DataProcessing.searchDoc(ID)!=null){
			System.out.println("该档案号已存在");
			System.out.println("请输入档案号:");
			ID = scan2.next();
		}
		System.out.println("请输入档案描述:");
		String discription = scan2.next();
		*/
		File tempfile = new File(soursefile);
		String filename = tempfile.getName();
		String creator = this.getRole();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		DataProcessing.insertDoc(ID,creator,timestamp,discription,filename);
		//docs.put("0001",new Doc("0001","jack",timestamp,"Doc Source Java","Doc.java"));
		byte [] b = new byte[1024];
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(tempfile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(uploadpath+filename));
		int t = 0;
		while((t = in.read(b))!=-1){
			out.write(b,0,t);
		}
		in.close();
		out.close();
		System.out.println("上传成功");
		}catch(SQLException e){
			System.out.println("数据库异常"+e.getMessage());
		}catch(FileNotFoundException e){
			System.out.println("未找到该文件"+e.getMessage());
		}catch(IOException e){
			System.out.println("IO流异常"+e.getMessage());
		}

	}
	public void showMenu(){
		Hashtable<String, User> users;
		String tip_Info ="******"+"欢迎进入档案录入员菜单!"+"*******"+
				"\n\t1、上传文件"+"\n\t2、下载文件"+"\n\t3、文件列表"+
				"\n\t4、修改密码"+"\n\t5、退出"+ "\n******************************";
		String tip_exit = "系统退出，谢谢使用!";
		System.out.println(tip_Info);
		int i = scan2.nextInt();
		while(i!=5){
			
			switch(i){
			case 1:
				System.out.println("请输入源文件名:");
				String soursefile = scan2.next();
				System.out.println("请输入档案号:");
				String ID = scan2.next();
				try {
					while (DataProcessing.searchDoc(ID)!=null){
						System.out.println("该档案号已存在");
						System.out.println("请输入档案号:");
						ID = scan2.next();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("请输入档案描述:");
				String discription = scan2.next();
				updateFile(ID,soursefile,discription);
				break;
			case 2:
				System.out.println("请输入需要下载的文件号:");
				String file = scan2.next();
				try{
				if(downloadFile(file)){
					System.out.println("下载成功!");
				}else{
					System.err.println("error!");
				}

				}catch(IOException e){
					System.out.println("文件访问错误Error in accessing file");
				}
				break;
			case 3:
				System.out.println("文件列表如下：");
				try{
				showFileList();
				}catch(SQLException e){
					System.out.println("文件访问错误Error in accessing file");
				}
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
				break;
				
			}
			System.out.println(tip_Info);
			i=scan2.nextInt();

		}
		System.out.println(tip_exit);
	}




}
	