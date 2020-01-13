package Common;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.sql.*;
 

public  class DataProcessing {

	private static boolean connectToDB=false;
	
	static Hashtable<String, User> users;
	static Hashtable<String, Doc> docs;

	static {
		users = new Hashtable<String, User>();
		users.put("jack", new Operator("jack","123","operator"));
		users.put("rose", new Browser("rose","123","browser"));
		users.put("kate", new Administrator("kate","123","administrator"));
		Init();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		docs = new Hashtable<String,Doc>();
		docs.put("0001",new Doc("0001","jack",timestamp,"Doc Source Java","Doc.java"));
		
		
	}
	
	public static  void Init(){
		// connect to database
		
		// update database connection status
//		if (Math.random()>0.2)
//			connectToDB = true;
//		else
//			connectToDB = false;
	}
	
	public static Doc searchDoc(String ID) throws SQLException {
		if (docs.containsKey(ID)) {
			Doc temp =docs.get(ID);
			return temp;
		}
		return null;
	}
	
	public static Enumeration<Doc> getAllDocs() throws SQLException{		
		Enumeration<Doc> e  = docs.elements();
		return e;
	} 
	
	public static boolean insertDoc(String ID, String creator, Timestamp timestamp, String description, String filename) throws SQLException{
		Doc doc;		
	
		if (docs.containsKey(ID))
			return false;
		else{
			doc = new Doc(ID,creator,timestamp,description,filename);
			docs.put(ID, doc);
			return true;
		}
	} 
	
	public static User searchUser(String name) throws SQLException{
//		if ( !connectToDB ) 
//			throw new SQLException( "Not Connected to Database" );
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Query" );
		
		if (users.containsKey(name)) {
			return users.get(name);			
		}
		return null;
	}
	
	public static User searchUser(String name, String password) throws SQLException {
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Query" );
		
		if (users.containsKey(name)) {
			User temp =users.get(name);
			if ((temp.getPassword()).equals(password))
				return temp;
		}
		return null;
	}
	
	public static Enumeration<User> getAllUser() throws SQLException{
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Query" );
		
		Enumeration<User> e  = users.elements();
		return e;
	}

	
	
	public static boolean updateUser(String name, String password, String role) throws SQLException{
		User user;
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Update" );
		
		if (users.containsKey(name)) {
			if (role.equalsIgnoreCase("administrator"))
				user = new Administrator(name,password, role);
			else if (role.equalsIgnoreCase("operator"))
				user = new Operator(name,password, role);
			else
				user = new Browser(name,password, role);
			users.put(name, user);
			return true;
		}else
			return false;
	}
	
	public static boolean insertUser(String name, String password, String role) throws SQLException{
		User user;
		
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Insert" );
		
		if (users.containsKey(name))
			return false;
		else{
			if (role.equalsIgnoreCase("administrator"))
				user = new Administrator(name,password, role);
			else if (role.equalsIgnoreCase("operator"))
				user = new Operator(name,password, role);
			else
				user = new Browser(name,password, role);
			users.put(name, user);
			return true;
		}
	}
	
	public static boolean deleteUser(String name) throws SQLException{
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Delete" );
		
		if (users.containsKey(name)){
			users.remove(name);
			return true;
		}else
			return false;
		
	}	
            
	public static void disconnectFromDB() {
		if ( connectToDB ){
			// close Statement and Connection            
			try{
//				if (Math.random()>0.5)
//					throw new SQLException( "Error in disconnecting DB" );      
//			}catch ( SQLException sqlException ){                                            
//			    sqlException.printStackTrace();           
			}finally{                                            
				connectToDB = false;              
			}                             
		} 
   }           

	
	public static void main(String[] args) {		

	}
	
}



/*
public  class DataProcessing {
    
	
	
	//static Hashtable<String, User> users;
	//static Hashtable<String, Doc> docs;

static {
		users = new Hashtable<String, User>();
		users.put("jack", new Operator("jack","123","����¼����Ա"));
		users.put("rose", new Browser("rose","123","���������Ա"));
		users.put("kate", new Administrator("kate","123","ϵͳ������Ա"));
		Init();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		docs = new Hashtable<String,Doc>();
		docs.put("0001",new Doc("0001","jack",timestamp,"Doc Source Java","Doc.java"));
		docs.put("0002",new Doc("0002","rose",timestamp,"Doc","Doc1.java"));
		
		
	}
	
	public static  void Init(){
		// connect to database
		
		// update database connection status
//		if (Math.random()>0.2)
//			connectToDB = true;
//		else
//			connectToDB = false;
	}
	

	
	public static Enumeration<Doc> getAllDocs() throws SQLException{		
		Enumeration<Doc> e  = docs.elements();
		return e;
	} 
	
	public static boolean insertDoc(String ID, String creator, Timestamp timestamp, String description, String filename) throws SQLException{
		Doc doc;		
	
		if (docs.containsKey(ID))
			return false;
		else{
			doc = new Doc(ID,creator,timestamp,description,filename);
			docs.put(ID, doc);
			return true;
		}
	} 
	
	public static User searchUser(String name) throws SQLException{
//		if ( !connectToDB ) 
//			throw new SQLException( "Not Connected to Database" );
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Query" );
		
		if (users.containsKey(name)) {
			return users.get(name);			
		}
		return null;
	}
	
	public static User searchUser(String name, String password) throws SQLException {
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Query" );
		
		if (users.containsKey(name)) {
			User temp =users.get(name);
			if ((temp.getPassword()).equals(password))
				return temp;
		}
		return null;
	}
	
	public static Enumeration<User> getAllUser() throws SQLException{
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Query" );
		
		Enumeration<User> e  = users.elements();
		return e;
	}
	
	
	
	public static boolean updateUser(String name, String password, String role) throws SQLException{
		User user;
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Update" );
		
		if (users.containsKey(name)) {
			if (role.equalsIgnoreCase("ϵͳ������Ա"))
				user = new Administrator(name,password,"ϵͳ������Ա");
			else if (role.equalsIgnoreCase("����¼����Ա"))
				user = new Operator(name,password,"����¼����Ա");
			else
				user = new Browser(name,password,"���������Ա");
			users.put(name, user);
			return true;
		}else
			return false;
	}
	
	public static boolean insertUser(String name, String password, String role) throws SQLException{
		User user;
		
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Insert" );
		
		if (users.containsKey(name))
			return false;
		else{
			if (role.equalsIgnoreCase("ϵͳ������Ա"))
				user = new Administrator(name,password,"ϵͳ������Ա");
			else if (role.equalsIgnoreCase("����¼����Ա"))
				user = new Operator(name,password,"����¼����Ա");
			else
				user = new Browser(name,password,"���������Ա");
			users.put(name, user);
			return true;
		}
	}
	
	public static boolean deleteUser(String name) throws SQLException{
//		if ( !connectToDB ) 
//	        throw new SQLException( "Not Connected to Database" );
//		
//		double ranValue=Math.random();
//		if (ranValue>0.5)
//			throw new SQLException( "Error in excecuting Delete" );
		
		if (users.containsKey(name)){
			users.remove(name);
			return true;
		}else
			return false;
		
	}	
            
	/*public static void disconnectFromDB() {
		if ( connectToDB ){
			// close Statement and Connection            
			try{
//				if (Math.random()>0.5)
//					throw new SQLException( "Error in disconnecting DB" );      
//			}catch ( SQLException sqlException ){                                            
//			    sqlException.printStackTrace();           
			}finally{                                            
				connectToDB = false;              
			}                             
		} 
	}*/
	
	/*
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	//private static ResultSet resultSet;
	private static boolean connectedToDatabase=false;
	public static void connectToDatabase(String driverName)  {
		String url="jdbc:mysql://localhost:3306/document";       // �������ݿ��URL
		String user="root";                                      // ���ݿ��û�
		String password="123456";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�������ݿ�������
		try {
			connection=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectedToDatabase=true;
	}
	public static void disconnectFromDatabase() {
		if(connectedToDatabase) {
			try {
				//resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				connectedToDatabase=false;
			}
		}
	}
	public static Enumeration getAllDocs() throws SQLException{
		if(!connectedToDatabase)
			throw new SQLException("Not Connected to Database");
		ResultSet resultSet;
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql="select * from doc_info";
		resultSet=statement.executeQuery(sql);
		Vector ve=new Vector();
		while (resultSet.next()) {
			String id=new String(resultSet.getString("Id"));
			ve.addElement(id);
			String cre=new String(resultSet.getString("creator"));
			ve.addElement(cre);
			Timestamp time=resultSet.getTimestamp("timestamp");
			ve.addElement(time);
			String des=new String(resultSet.getString("description"));
			ve.addElement(des);
			String filena=new String(resultSet.getString("filename"));
			ve.addElement(filena);
			
		}
		Enumeration e=ve.elements();
		resultSet.close();
		return e;
		
	} 
	public static Enumeration getAllUser() throws SQLException{
		if(!connectedToDatabase)
			throw new SQLException("Not Connected to Database");
		ResultSet resultSet;
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql="select * from user_info";
		resultSet=statement.executeQuery(sql);
		Vector ve=new Vector();
		while (resultSet.next()) {
			String name=new String(resultSet.getString("username"));
			ve.addElement(name);
			String pass=new String(resultSet.getString("password"));
			ve.addElement(pass);
			String role=new String(resultSet.getString("role"));
			ve.addElement(role);
		}
		Enumeration e=ve.elements();
		resultSet.close();
		return e;
	} 
	public static Doc searchDoc(String DocID) throws SQLException {
		Doc temp=null;
		ResultSet resultSet;
		if(!connectedToDatabase)
			throw new SQLException("Not Connected to Database");
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql="select * from doc_info where Id='"+DocID+"'";
		resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			String ID=resultSet.getString("Id");
			String creator=resultSet.getString("creator");
			Timestamp timestamp=resultSet.getTimestamp("timestamp");
			String description=resultSet.getString("description");
			String filename=resultSet.getString("filename");
			temp=new Doc(ID,creator,timestamp,description,filename);
		}
		resultSet.close();
		return temp;
	}
	public static User searchUser(String name,String Pass)throws SQLException{
		User temp=null;
		ResultSet resultSet;
		if(!connectedToDatabase)
			throw new SQLException("Not Connected to Database");
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql="select * from user_info where username='"+name+"'";
		resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			String name1=resultSet.getString("username");
			String password=resultSet.getString("password");
			if(!password.equals(Pass))
				return null;
			String role=resultSet.getString("role");
		    if (name1.equals("ϵͳ������Ա")) 
		    	temp=new Administrator(name1,password,role);
		    	else if(name1.equals("����¼����Ա"))
		    		temp=new Operator(name1,password,role);
		    	else
		    		temp=new Browser(name1,password,role);
		    
		}
		resultSet.close();
		return temp;
	}
	public static User searchUser(String name) throws SQLException{
		User temp=null;
		ResultSet resultSet;
		if(!connectedToDatabase)
			throw new SQLException("Not Connected to Database");
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql="select * from user_info where username='"+name+"'";
		resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			String name1=resultSet.getString("username");
			String password=resultSet.getString("password");
			String role=resultSet.getString("role");
		    if (name1.equals("ϵͳ������Ա")) 
		    	temp=new Administrator(name1,password,role);
		    	else if(name1.equals("����¼����Ա"))
		    		temp=new Operator(name1,password,role);
		    	else
		    		temp=new Browser(name1,password,role);
		    
		}
		resultSet.close();
		return temp;
	}
	public static boolean insertDoc(String ID, String creator, Timestamp timestamp, String description, String filename) throws SQLException{
		if(!connectedToDatabase)
		{
			return false;
			
		}
		String sql="insert into doc_info(Id,creator,timestamp,description,filename) values('"+ID+"','"+creator+"','"+timestamp+"','"+description+"','"+filename+"')";
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		statement.execute(sql);
		return true;
	}
	public static boolean insertUser(String name, String password, String role) throws SQLException {
		if(!connectedToDatabase)
		{
			return false;
			
		}
		String sql="insert into user_info(username,password,role) values('"+name+"','"+password+"','"+role+"')";
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		statement.execute(sql);
		return true;
	}
	public static boolean updateUser(String name, String password, String role) throws SQLException {
		if(!connectedToDatabase)
		{
			return false;
			
		}
		String sql="update user_info set password = '"+password+"',role ='"+role+"' where username ='"+name+"'";
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		statement.execute(sql);
		return true;
	}
	public static boolean deleteUser(String name) throws SQLException {
		if(!connectedToDatabase)
		{
			return false;
			
		}
		String sql="delete from user_info where username='"+name+"'";
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		statement.execute(sql);
		return true;
	}

}
*/


