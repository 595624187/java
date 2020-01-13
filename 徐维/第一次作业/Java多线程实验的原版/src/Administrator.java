import java.util.Enumeration;
import java.util.Scanner;
public class Administrator extends User {
    Administrator(String name,String password,String role){
        super(name,password,role );
        setName(name);
        setPassword(password);
        setRole(role);
    }
    public void changeUserInfo() {
        String newname,newpassword,newpassword2,newrole;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名");
        System.out.println("请输入原密码");
        System.out.println("请输入原身份");
        String name = in.nextLine();
        String password = in.nextLine();
        String role = in.nextLine();
        if(DataProcessing.search(name, password)==null) {System.out.println("您输入的用密码有误！");}
        System.out.println("请输入新用户名");
        System.out.println("请输入新密码");
        System.out.println("请再次输入新密码");
        newname = in.nextLine();
        newpassword = in.nextLine();
        newpassword2 = in.nextLine();
        System.out.println("请输入新身份");
        newrole = in.nextLine();
        if(newpassword.equals(newpassword2)) {
            if(DataProcessing.update(newname, newpassword,newrole)) {System.out.println("更改个人信息成功！");}
            else {System.out.println("更改个人信息失败！");}
        }
        in.close();
    }
    public void delUser() {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        if(DataProcessing.delete(name)) {
            System.out.println("删除用户成功！");
        }
        else {
            System.out.println("删除用户失败！");
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
        if(DataProcessing.insert(name, password, role)) {System.out.println("新增用户成功！");}
        else {System.out.println("新增用户失败！");}
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
            case 3:changeUserInfo();
                break;
            case 4:delUser();
                break;
            case 5:showFileList();
                break;
            case 6:downloadFile("af");
                break;
            case 7:changeSelfInfo("af");
                break;
            default:
                System.out.println("输入有误！");
        }
    }
}




