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
		System.out.println("������Դ�ļ���:");
		String soursefile = scan2.next();
		System.out.println("�����뵵����:");
		String ID = scan2.next();
		while (DataProcessing.searchDoc(ID)!=null){
			System.out.println("�õ������Ѵ���");
			System.out.println("�����뵵����:");
			ID = scan2.next();
		}
		System.out.println("�����뵵������:");
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
		System.out.println("�ϴ��ɹ�");
		}catch(SQLException e){
			System.out.println("���ݿ��쳣"+e.getMessage());
		}catch(FileNotFoundException e){
			System.out.println("δ�ҵ����ļ�"+e.getMessage());
		}catch(IOException e){
			System.out.println("IO���쳣"+e.getMessage());
		}

	}
	public void showMenu(){
		Hashtable<String, User> users;
		String tip_Info ="******"+"��ӭ���뵵��¼��Ա�˵�!"+"*******"+
				"\n\t1���ϴ��ļ�"+"\n\t2�������ļ�"+"\n\t3���ļ��б�"+
				"\n\t4���޸�����"+"\n\t5���˳�"+ "\n******************************";
		String tip_exit = "ϵͳ�˳���ллʹ��!";
		System.out.println(tip_Info);
		int i = scan2.nextInt();
		while(i!=5){
			
			switch(i){
			case 1:
				System.out.println("������Դ�ļ���:");
				String soursefile = scan2.next();
				System.out.println("�����뵵����:");
				String ID = scan2.next();
				try {
					while (DataProcessing.searchDoc(ID)!=null){
						System.out.println("�õ������Ѵ���");
						System.out.println("�����뵵����:");
						ID = scan2.next();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("�����뵵������:");
				String discription = scan2.next();
				updateFile(ID,soursefile,discription);
				break;
			case 2:
				System.out.println("��������Ҫ���ص��ļ���:");
				String file = scan2.next();
				try{
				if(downloadFile(file)){
					System.out.println("���سɹ�!");
				}else{
					System.err.println("error!");
				}

				}catch(IOException e){
					System.out.println("�ļ����ʴ���Error in accessing file");
				}
				break;
			case 3:
				System.out.println("�ļ��б����£�");
				try{
				showFileList();
				}catch(SQLException e){
					System.out.println("�ļ����ʴ���Error in accessing file");
				}
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
				break;
				
			}
			System.out.println(tip_Info);
			i=scan2.nextInt();

		}
		System.out.println(tip_exit);
	}




}
	