package com.theiron.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.theiron.bean.Student;




public class DataMain {
	private Connection conn;
	private Statement statement;
	private ResultSet rs;
	public int OPRATE_INSERT = 0;
	public int OPRATE_UPDATE = 1;
	public int OPRATE_DELETE = 2;
	public int OPRATE_SELECT = 3;
	
	public DataMain(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","123456");
			statement = conn.createStatement();
			/*String sql = "select * from student";
            // 结果集
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
            	System.out.println(rs.getString("name"));
            	rs.getInt("age");
            }*/
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param stu 在增删改 的时候为Student类型 在查时为String类型或是student类型
	 * @param oprateType 
	 */
	public void OprateFactory(Object stu,int oprateType){
		switch (oprateType) {
		case 0:
			oprateInsert(stu);
			break;
		case 1:
			oprateUpdate(stu);		
			break;
		case 2:
			oprateDelete(stu);
			break;
		case 3:
			oprateSelect(stu);
			break;
		default:
			break;
		}
	}
	private void oprateInsert(Object stu){
		String sql = "";
		Student student = (Student)stu;
		sql = "insert into student values(\"";
		sql += student.getId()+"\",'";
		sql += student.getName()+"','";
		sql += student.getSex()+"','";
		sql += student.getAge()+"')";
//		System.out.println("test:"+sql);
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void oprateUpdate(Object stu){
		String sql = "";
		Student student = (Student)stu;
		sql = "update student set ";
		sql += "name = '" + student.getName() + "', ";
		sql += "sex = '" + student.getSex() + "', ";
		sql += "age = '" + student.getAge() + "' ";
		sql += "where stuId = '"+student.getId()+"'";
//		System.out.println("test:"+sql);
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void oprateDelete(Object stu){
		String sql = "";
		Student student = (Student)stu;
		sql += "delete from student where stuId='";
		sql += student.getId()+"'";
//		System.out.println("test:"+sql);
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void oprateSelect(Object stu){
		String sql = "";
		if(stu.equals("all")){
			sql = "select * from student";
		}else{
			Student student = (Student)stu;
			sql = "select * from student where stuId = '"+student.getId()+"'";
		}
//		System.out.println("test:"+sql);
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet getResult(){
		return rs;
	}
	public void close(){
		try {
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
