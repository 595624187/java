package Area;


import java.util.Scanner;

public class ciecularArea{
double r;
private Scanner scan;
void Carea(){
	
	double area;
	System.out.println("请输入长方形的详细信息：");
	scan = new Scanner(System.in);
	System.out.println("半径为：");
	r = scan.nextDouble();
	area = 3.14159*r*r;	
	System.out.println("该长圆形的面积为:"+area);
}
}