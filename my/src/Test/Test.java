package Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Test {
public static void main(String[] args) throws Exception {
// �������ݿ��������
String driverClass = "com.mysql.cj.jdbc.Driver";//�������ݿ�����
String databaseName = "test";// ���ӵ���һ�����ݿ�
String serverIp = "localhost";// ������Ip��ַ
String username = "root";// �û���
String password = "123456";// ����
// ƴ�ճ�һ��������URL��ַ
String jdbcUrl = "jdbc:mysql://" + serverIp + ":3306/" + databaseName
+ "?serverTimezone=Asia/Shanghai&useSSL=true";// ÿ�����ݿⶼ��һ��
// ��һ�����������ݿ�����(Լ�����㰲װ��mysql�ͻ���)
Class.forName(driverClass);
System.out.println("����");
// �ڶ�������ȡ���ӣ�Լ����mysql��½��
// �������Ѿ�����ִ�����ݿ�Ĳ���
Connection conn = DriverManager.getConnection(jdbcUrl, username, password);


PreparedStatement pst = conn.prepareStatement("delete from student where id='4652973' ");


// ���Ĳ���ִ��sql
pst.execute();

// ���һ�����ر�
pst.close();
conn.close();
}
}