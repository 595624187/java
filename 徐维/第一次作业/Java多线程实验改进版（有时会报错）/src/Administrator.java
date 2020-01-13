import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;
public class Administrator extends User {
    Administrator(String name,String password,String role){
        super(name,password,role );
        setName(name);
        setPassword(password);
        setRole(role);
    }
    public void changeUserInfo()throws SQLException {

            String newname, newpassword, newpassword2, newrole;
            Scanner in = new Scanner(System.in);
            System.out.println("请输入用户名");
            System.out.println("请输入原密码");
            System.out.println("请输入原身份");
            String name = in.nextLine();
            String password = in.nextLine();
            String role = in.nextLine();
            try{
            DataProcessing.search(name, password);
           }catch(SQLException a){
            System.out.println("您输入的用户名或密码错误");
            a.printStackTrace();
            }
            System.out.println("请输入新用户名");
            System.out.println("请输入新密码");
            System.out.println("请再次输入新密码");
            newname = in.nextLine();
            newpassword = in.nextLine();
            newpassword2 = in.nextLine();
            System.out.println("请输入新身份");
            newrole = in.nextLine();
            try {
                if (newpassword.equals(newpassword2)) {
                    DataProcessing.update(newname, newpassword, newrole);
                    System.out.println("更改个人信息成功！");
                }
            }catch(SQLException b){
                System.out.println("更改个人信息失败");
                b.printStackTrace();
            }
            in.close();


    }



    public void delUser() {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        try{
            DataProcessing.delete(name);
            System.out.println("删除用户成功！");
        }
        catch(SQLException a){
            System.out.println("删除用户失败！");
            a.printStackTrace();
        }
        in.close();
    }
    public void addUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入新增用户用户名：");
        System.out.println("请输入新增用户密码：");
        System.out.println("请输入新增用户身份：");
        String name = in.nextLine();
        String password = in.nextLine();
        String role = in.nextLine();
        try {
            if (DataProcessing.insert(name, password, role)) {
                System.out.println("新增用户成功！");
            }
        }catch(SQLException c){
            System.out.println("新增用户失败");
            c.printStackTrace();
        }
        in.close();
    }
    public void listUser() {
        Enumeration<User> ele = DataProcessing.users.elements();
        while(ele.hasMoreElements()) {
            User a = (User)ele.nextElement();
            System.out.println("姓名："+a.getName()+"  密码："+a.getPassword()+"  身份："+a.getRole());
        }
    }
    public void showMenu() {
        System.out.println("***欢迎进入管理人员系统***");
        System.out.println("1、展示用户列表");
        System.out.println("2、新增用户");
        System.out.println("3、修改用户");
        System.out.println("4、删除用户");
        System.out.println("5、文件列表");
        System.out.println("6、下载文件");
        System.out.println("7、修改密码");
        System.out.println("请输入选择命令：");
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        switch(n) {
            case 1:listUser();
                break;
            case 2:addUser();
                break;
            case 3:try{
                changeUserInfo();}
                catch (SQLException w){w.printStackTrace();break;}

            case 4:delUser();
                break;
            case 5:
                try {
                showFileList();}
                catch (SQLException a){a.printStackTrace();break;}

            case 6:
                try{
                downloadFile("af");}
                catch (IOException a){a.printStackTrace();break;}

            case 7:
                try{
                    changeSelfInfo("af");
                }
                catch (SQLException a){a.printStackTrace();break;}

            default:
                System.out.println("输入有误！");
                break;
        }
    }
}
