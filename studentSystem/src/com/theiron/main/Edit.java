package com.theiron.main;

import java.util.HashMap;
import java.util.Scanner;

import com.theiron.bean.Student;
import com.theiron.database.DataMain;
import com.theiron.tool.OutputTool;

public class Edit implements OprateImp{
	@Override
	public void start(Scanner input, HashMap<String, Student> stus, DataMain db) {
		// TODO Auto-generated method stub
		String id = "";
		String name = "";
		String sex = "";
		int age = -1;
		while(!stus.containsKey(id)){
			OutputTool.printId();
			id = input.next();
		}
		OutputTool.printName();
		name = input.next();
		OutputTool.printSex();
		sex = input.next();
		OutputTool.printAge();
		age = Integer.valueOf(input.next());
		Student student = stus.get(id);
		student.setName(name);
		student.setAge(age);
		student.setSex(sex);
		db.OprateFactory(student, db.OPRATE_UPDATE);
		stus.put(id, student);
	}

}
