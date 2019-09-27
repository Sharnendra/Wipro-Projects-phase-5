package com.spring;
import java.sql.*;  
public class MySQLConn {

	public static void main(String args[]){  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
		//here sonoo is database name, root is username and password  
		if(null!=con && !con.isClosed())
		{
			System.out.println("con is connected");
			con.close();
		}
		}catch(Exception e){ 
			e.printStackTrace();
			System.out.println(e);}  
		}  
		} 

