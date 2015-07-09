package com.theiron.main;

import java.util.HashMap;
import java.util.Scanner;

import com.theiron.bean.Student;
import com.theiron.database.DataMain;

public interface OprateImp {
	public abstract void start(Scanner input,HashMap<String, Student> stus,DataMain db);
}
