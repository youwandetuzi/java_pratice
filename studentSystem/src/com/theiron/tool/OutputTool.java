package com.theiron.tool;

import com.theiron.bean.StringSource;

public class OutputTool {
	/**
	 * 输出系统基本信息
	 */
	public static void printInitMessage() {
		showSubLine(10, StringSource.SUB_STRING);
		System.out.print(StringSource.SYSTEM_NAME);
		showSubLine(10, StringSource.SUB_STRING);
		System.out.println();

		showSubLine(10, StringSource.SUB_STRING);
		System.out.print(StringSource.ITEM_ADD);
		showSubLine(10, StringSource.SUB_STRING);
		System.out.println();

		showSubLine(10, StringSource.SUB_STRING);
		System.out.print(StringSource.ITEM_EDIT);
		showSubLine(10, StringSource.SUB_STRING);
		System.out.println();

		showSubLine(10, StringSource.SUB_STRING);
		System.out.print(StringSource.ITEM_DELETE);
		showSubLine(10, StringSource.SUB_STRING);
		System.out.println();

		showSubLine(10, StringSource.SUB_STRING);
		System.out.print(StringSource.ITEM_SEARCH);
		showSubLine(10, StringSource.SUB_STRING);
		System.out.println();

		showSubLine(10, StringSource.SUB_STRING);
		System.out.print(StringSource.ITEM_SHOW);
		showSubLine(10, StringSource.SUB_STRING);
		System.out.println();

		showSubLine(10, StringSource.SUB_STRING);
		System.out.print(StringSource.ITEM_EXIT);
		showSubLine(10, StringSource.SUB_STRING);
		System.out.println();
	}

	/**
	 * @param times
	 *            输出分隔符的次数
	 * @param sub
	 *            使用分隔符
	 */
	private static void showSubLine(int times, String sub) {
		for (int i = 0; i < times; i++) {
			System.out.print(sub);
		}
	}

	public static void printId() {
		System.out.println("请输入学号:");
	}

	public static void printName() {
		System.out.println("请输入姓名:");
	}

	public static void printSex() {
		System.out.println("请输入性别:");
	}

	public static void printAge() {
		System.out.println("请输入年龄:");
	}

}
