package day01;

import java.util.Scanner;

public class Number6 {

	public static void main(String[] args) {
		// 数字6是一个伟大的数字， 键盘录入两个整数，
		// 如果是6 ，输出true， 如果两个数字的和为6输出true
		// 其他输出false。
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input the first number:");
		int num1 = input.nextInt();
		
		System.out.println("Please input the second number:");
		int num2 = input.nextInt();
		
		Boolean result = num1== 6 || num2== 6 || (num1+num2) % 6 == 0;
		
		System.out.println(result);
		
		input.close();
		

	}

}
