

import java.sql.SQLException;
import java.util.Enumeration;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public abstract class User {
	private String name;
	private String password;
	private String role;
	String uploadpath="e:\\OPP\\uploadfile\\";
 	String downloadpath="e:\\OPP\\downloadfile\\";
	
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
	public boolean changeSelfInfo(String password) throws SQLException{
		//写用户信息到存储
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("修改成功");
			return true;
		}else
			return false;
	}
	
	public boolean downloadFile(String filename) throws IOException{
		try{
			Doc e = DataProcessing.searchDoc(filename);
			if(e == null){
				return false;
			}
			File a = new File(uploadpath+e.getFilename());
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(a));
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(downloadpath+e.getFilename()));
			byte[]b = new byte[1024];
			int t = 0;
			while((t = in.read(b))!=-1){
				out.write(b,0,t);
			}
			in.close();
			out.close();
			
		}catch(SQLException e){
			System.out.println("数据库异常"+e.getMessage());
		}
		
		return true;
	}
	
	public void showFileList() throws SQLException{
		Enumeration<Doc> e  =  DataProcessing.getAllDocs();
		while(e.hasMoreElements()){
			Doc d =(Doc)e.nextElement();
			System.out.println("ID:"+d.getID()+"  Time:"
			+d.getTimestamp()+"  Filename:"+d.getFilename()+
			"  Creator:"+d.getCreator()+
			"  Description:"+d.getDescription());
		}
	}
	
	public abstract void showMenu();
	
	public void exitSystem(){
		System.out.println("系统退出, 谢谢使用 ! ");
		System.exit(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
