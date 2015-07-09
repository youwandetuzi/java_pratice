package com.theiron.main;

import java.util.HashMap;
import java.util.Scanner;

import com.theiron.bean.Student;
import com.theiron.database.DataMain;
import com.theiron.tool.OutputTool;

public class Search implements OprateImp{
	@Override
	public void start(Scanner input, HashMap<String, Student> stus,DataMain db) {
		// TODO Auto-generated method stub
		String id = "";
		while(!stus.containsKey(id)){
			OutputTool.printId();
			id = input.next();
		}
		System.out.println(stus.get(id));
	}
	
}
