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
		String tip_Info ="******"+"��ӭ�������Ա�˵�!"+"*******"+
						"\n\t1�������ļ�"+"\n\t2���ļ��б�"+"\n\t3���޸�����"+
						"\n\t4���˳�"+ "\n******************************";
		String tip_exit = "ϵͳ�˳���ллʹ��!";
		System.out.println(tip_Info);
		Scanner scan2 = new Scanner(System.in);
		int i = scan2.nextInt();
		while(i!=4){
			switch(i){
				case 1:
					System.out.println("��������Ҫ���ص��ļ���:");
					String file = scan2.next();
					try{
					try {
						if(downloadFile(file)){
							System.out.println("���سɹ�!");
						}else{
							System.err.println("error!");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					}catch(IOException e){
						System.out.println("�ļ����ʴ���Error in accessing file");
					}
					break;
				case 2:
					System.out.println("�ļ��б����£�");
					try{
					showFileList();
					}catch(SQLException e){
						System.out.println("�ļ����ʴ���Error in accessing file");
					}
					break;
				case 3:
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
					break;
			}
			System.out.println(tip_Info);
			i=scan2.nextInt();

		}
		System.out.println(tip_exit);

	}




}
	