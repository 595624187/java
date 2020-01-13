package Area;

import java.util.Scanner;

public class triangleArea{
double h,l;
private Scanner scan;

void Tarea(){

	double area;
	System.out.println("请输入长方形的详细信息：");
	scan = new Scanner(System.in);
	System.out.println("高为：");

	h = scan.nextDouble();
	System.out.println("底为：");

	l = scan.nextDouble();
	area = h*l/2;	
	System.out.println("该三角形的面积为:"+area);

}
}
