package com.theiron.main;

import java.util.HashMap;
import java.util.Scanner;

import com.theiron.bean.Student;
import com.theiron.database.DataMain;
import com.theiron.tool.OutputTool;

public class Delete implements OprateImp{
	@Override
	public void start(Scanner input, HashMap<String, Student> stus,DataMain db) {
		String id = "";
		while(!stus.containsKey(id)){
			OutputTool.printId();
			id = input.next();
		}
		Student student = new Student(id, "", "", -1);
		db.OprateFactory(student, db.OPRATE_DELETE);
		stus.remove(id);
	}

}
