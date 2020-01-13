package Common;
import java.sql.*;

public class SQLtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		String driverName="com.mysql.cj.jdbc.Driver";               // �������ݿ�������
	    String url="jdbc:mysql://localhost:3306/document";       // �������ݿ��URL
	    String user="root";                                      // ���ݿ��û�
	    String password="123456";
	    try{
	    	Class.forName(driverName);		
			connection=DriverManager.getConnection(url, user, password);   // �������ݿ�����
			statement = connection.createStatement( 
			         ResultSet.TYPE_SCROLL_INSENSITIVE,
			         ResultSet.CONCUR_READ_ONLY );
			String sql="select * from user_info";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()){
				String username=resultSet.getString("username");
				String pwd=resultSet.getString("password");
				String role=resultSet.getString("role");
				System.out.println(username+";"+pwd+";"+role);
			}	
			resultSet.close();                        
            statement.close();                        
            connection.close();  
	    }catch(ClassNotFoundException e ){
	    	System.out.println("������������");
	    }catch(SQLException e){
	    	System.out.println("���ݿ����");
	    	//e.printStackTrace();
	    }
	}

}