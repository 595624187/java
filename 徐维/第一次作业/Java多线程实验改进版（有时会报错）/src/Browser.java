import java.util.Scanner;

import java.sql.SQLException;
import java.io.IOException;

public class Browser extends User {
    Browser(String name, String password, String role) {
        super(name, password, role);
        setName(name);
        setPassword(password);
        setRole(role);
    }

    public void showMenu() {
            System.out.println("欢迎进入游客模式");
            System.out.println("1、文件列表");
            System.out.println("2、下载文件");
            System.out.println("3、修改密码");
            System.out.println("请输入选择命令：");
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            switch (n) {
                case 1:
                    try {
                        showFileList();
                    } catch (SQLException a) {a.printStackTrace();break;
                    }

                case 2:
                    try {
                        downloadFile("df");
                    } catch (IOException o) {
                        o.printStackTrace();break;
                    }
                    break;
                case 3:
                    try {
                        changeSelfInfo("af");
                    } catch (SQLException e) {
                        e.printStackTrace();break;
                    }

                default:
                    System.out.println("输入有误！");
                    break;
            }
        }
    }





