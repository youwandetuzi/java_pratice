package com.theiron.main;

import java.util.HashMap;
import java.util.Scanner;


import com.theiron.bean.Student;
import com.theiron.database.DataMain;
import com.theiron.tool.DataInit;
import com.theiron.tool.OutputTool;

public class Index {
	public static void main(String[] args){
		int choice = -1;
		Scanner input = new Scanner(System.in);
		HashMap<String, Student> suts = new HashMap<String, Student>();
		DataMain db = new DataMain();
		DataInit.dataInit(db, suts);
		OutputTool.printInitMessage();
		
		while(choice!=0){
			//获取选项
			System.out.print("请输入操作号:");
			try{
				choice = Integer.valueOf(input.next());
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入不符合要求请重新输入！");
			}
			if(choice!=0){
				OprateImp oprate = OprateFactory.createOprate(choice);
				oprate.start(input, suts,db);
			}
		}
		db.close();
		/*String id = "0000000002";
		String name = "haha";
		String sex = "F";
		int age = 19;
		Student testStudent = new Student(id, name, sex, age);
		DataMain test = new DataMain();
		test.OprateFactory(testStudent, test.OPRATE_DELETE);*/
		System.out.println("退出系统");
	}
}
