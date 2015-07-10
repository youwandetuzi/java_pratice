package com.theiron.bean;

public class Student {
	private String id;
	private String name;
	private String sex;
	private int age;
	/*public Student(String id="0000000000",String name=" ",string sex=" ",int age=-1) {
		// TODO Auto-generated constructor stub
	}*/
	public Student(String id,String name,String sex,int age){
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getSex(){
		return this.sex;
	}
	public int getAge(){
		return this.age;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public void setAge(int age){
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		str += "学号:"+this.id+"\t ";
		str += "姓名:"+this.name+"\t ";
		str += "年龄:"+this.age+"\t ";
		str += "性别"+this.sex+"\t ";
		return str;
	}
}
