import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while (true) {
            String name;
            String password;
            String logininter = "   ****欢迎进入档案系统****\n\t" + "1.登陆\n  \t2.退出\n   \t" + "************************";
            User a;
            System.out.println(logininter);
            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            switch (i) {
                case 1:
                    try {
                        System.out.println("请输入用户名");
                        System.out.println("请输入口令");
                        Scanner scan1 = new Scanner(System.in);
                        name = scan1.next();
                        Scanner scan2 = new Scanner(System.in);
                        password = scan2.next();
                        a = DataProcessing.search(name, password);
                        a.showMenu();
                    }
                    catch(SQLException g){
                        g.printStackTrace();
                    }

                case 2:
                    System.out.println("退出系统");
                    System.exit(0);
            }
        }
    }
}

