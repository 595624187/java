import java.util.Scanner;
import java.sql.SQLException;
import java.io.IOException;

public class Operator extends User {
    Operator(String name,String password,String role){
        super(name, password,role);
        setName(name);
        setPassword(password);
        setRole(role);
    }
    public void showMenu() {
        System.out.println("***欢迎进入档案录入人员系统***");
        System.out.println("1、文件列表");
        System.out.println("2、上传文档");
        System.out.println("3、下载文件");
        System.out.println("4、修改密码");
        System.out.println("请输入选择命令：");
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        switch(n) {
            case 1:
                try {
                    showFileList();
                }
                catch(SQLException e){e.printStackTrace();break;}
            case 2:
                try{
                    uploadFile("as");
                }
                catch(IOException a) {a.printStackTrace();
                break;}

            case 3:
                try{downloadFile("ad");}
                catch(IOException e){e.printStackTrace();break;}
            case 4:
                try{changeSelfInfo("absd");}
                catch(SQLException a){a.printStackTrace();break;}
            default:
                System.out.println("输入有误！");
                break;
        }
    }

}