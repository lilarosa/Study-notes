package selektion;

import java.util.Scanner;

public class LeapYearCheck {

	public static void main(String[] args) {
		// 题目 2：用户输入一个年份，判断是不是闰年。（闰年条件：能被 4 整除但不能被 100 整除，或者能被 400 整除）
		Scanner input = new Scanner (System.in);
		while(true) {
			
		System.out.println("Give your year:");
		
		int year= input.nextInt();
		if (year==0) 
		{
			
			System.out.println("Programmend");
		          break;
		}
		if ((year%4==0 && year%100!=0)||year%400==0) {
			
			System.out.println("This is a leap year.");
			
		}
		
		else {System.out.println("This is not leap year.");}
		
	}
		input.close();
}
}
