package com.theiron.tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.theiron.bean.Student;
import com.theiron.database.DataMain;

public class DataInit {
	public static void dataInit(DataMain db,HashMap<String, Student> stu){
		db.OprateFactory("all", db.OPRATE_SELECT);
		ResultSet rs = db.getResult();
		Student tempStudent;
		try {
			while (rs.next()) {
				tempStudent = new Student(rs.getString("stuId"), rs.getString("name"), rs.getString("sex"), rs.getInt("age"));
				stu.put(tempStudent.getId(), tempStudent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
