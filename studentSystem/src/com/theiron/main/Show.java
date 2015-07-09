package com.theiron.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.theiron.bean.Student;
import com.theiron.database.DataMain;

public class Show implements OprateImp{

	@Override
	public void start(Scanner input, HashMap<String, Student> stus,DataMain db) {
		Set<String> set = stus.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			Student student = stus.get(iterator.next());
			System.out.println(student);
		}
	}

}
