package com.homework0524;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//1 自定义 创建一个student表，向其中添加一条或多条记录，然后在控制台输出目前表中记录的总数。
public class jdbcStudent {
	
	public static void main(String[] args) throws Exception {
		
		Connection conn=null;
	  PreparedStatement pst =null;
	  
	try {
		conn=getConn();
	    String sql="insert into student1 (name,email) values(?,?)";
	    pst=conn.prepareStatement(sql);
	    pst.setString(1, "wuanjing");
	    pst.setString(2, "waj.com");
	    
	    pst.setString(1, "ganxinping");
	    pst.setString(2, "gxp.com");
	    
	   
	    pst.executeUpdate();
	    
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		realse(pst,conn);
	}
	
	
	

	}	
	
	
	/*public static  void modify(String sql){
		Connection conn=null;
		PreparedStatement pst=null;
			try {
				conn=getConn();
				pst=conn.prepareStatement(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					realse(pst,conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		
	}*/
	
	
	
public static   Connection getConn() throws Exception{
		
		String  driver=null;
		String  url=null;
		String  user=null;
		String  password=null;
		
		Properties p=new Properties();
		
		InputStream in =jdbcStudent.class .getClassLoader().getResourceAsStream("jdbc.properties");
		
		p.load(in);
		
		 driver = p.getProperty("driver");
		 url = p.getProperty("url");
		 user = p.getProperty("user");
		 password= p.getProperty("password");
		
		 Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
		
		
	}

	public  static  void  realse(Statement st,Connection conn) throws Exception{
	
	if(st!=null){
		st.close();
	}
	if(conn!=null){
		st.close();
	}
	
}
}

	


