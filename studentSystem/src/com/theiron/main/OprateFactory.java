package com.theiron.main;

import java.util.ArrayList;

public class OprateFactory {
	public static OprateImp createOprate(int choice){
		ArrayList<String> items = new ArrayList<String>();
		items.add("Add");
		items.add("Edit");
		items.add("Delete");
		items.add("Search");
		items.add("Show");
		Object newObject = null;
		try {
			newObject = Class.forName("com.theiron.main."+items.get(choice-1)).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (OprateImp)newObject;
	}
}
