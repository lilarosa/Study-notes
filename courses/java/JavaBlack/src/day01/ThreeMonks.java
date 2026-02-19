package day01;

public class ThreeMonks {

	public static void main(String[] args) {
		// 已知三个和尚的身高, 156cm,160cm,210cm
		//通过程序得到三个和尚里谁是最高的身高
		
		int height1=165;
		int height2=150;
		int height3=210;
		
		int taller= height1 > height2 ? height1:height2;
		int tallest= taller > height3 ? taller:height3;
		
		System.out.println("the tallest monk is :" + tallest);
		
		
		
		
		
}
}
