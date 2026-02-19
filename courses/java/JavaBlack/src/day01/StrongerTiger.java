package day01;

import java.util.Scanner;

public class StrongerTiger {

	public static void main(String[] args) {
		// 通过键盘输入给出两只老虎的重量
		// 通过三元表达式 对比两只老虎的体重
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How much weight the first Tiger?");
		int weight1 = sc.nextInt();
		
		System.out.println("How much weight the Second Tiger?");
		int weight2 = sc.nextInt();
		
		String result= weight1 == weight2 ? "they are same" : "they are different";
		
		System.out.println(result);
		
		sc.close();
		
		
		

	}

}
