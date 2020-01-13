package Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Test {
public static void main(String[] args) throws Exception {
// 连接数据库的五大参数
String driverClass = "com.mysql.cj.jdbc.Driver";//加载数据库驱动
String databaseName = "test";// 连接到哪一个数据库
String serverIp = "localhost";// 服务器Ip地址
String username = "root";// 用户名
String password = "123456";// 密码
// 拼凑成一个完整的URL地址
String jdbcUrl = "jdbc:mysql://" + serverIp + ":3306/" + databaseName
+ "?serverTimezone=Asia/Shanghai&useSSL=true";// 每个数据库都不一样
// 第一步：加载数据库驱动(约等于你安装了mysql客户端)
Class.forName(driverClass);
System.out.println("启动");
// 第二步：获取连接（约等于mysql登陆）
// 代表你已经可以执行数据库的操作
Connection conn = DriverManager.getConnection(jdbcUrl, username, password);


PreparedStatement pst = conn.prepareStatement("delete from student where id='4652973' ");


// 第四步：执行sql
pst.execute();

// 最后一步，关闭
pst.close();
conn.close();
}
}