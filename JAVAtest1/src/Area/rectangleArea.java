package Area;


import java.util.Scanner;

	
public class rectangleArea{
	int lenth;
	int width;
	private Scanner scan;
void Rarea(){
		
		System.out.println("请输入长方形的详细信息：");
		scan = new Scanner(System.in);
		System.out.println("长为：");
		lenth = scan.nextInt();
		System.out.println("宽为：");
		width = scan.nextInt();
		int area;
		area = lenth*width;
		System.out.println("该长方形的面积为:"+area);
	}
}