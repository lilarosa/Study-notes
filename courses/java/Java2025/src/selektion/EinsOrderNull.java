package selektion;

import java.util.Scanner;

public class EinsOrderNull {

	public static void main(String[] args) {
		// 题目 1：用户输入一个整数，判断它是正数、负数还是 0。
		
		Scanner input = new Scanner (System.in);
		System.out.println("Give your number:");
		int number= input.nextInt();
		if (number>0)
			System.out.println("是正数");
		else if (number<0)
			System.out.println("是负数");
		else
			System.out.println("是0");
		input.close();
			
	}

}
