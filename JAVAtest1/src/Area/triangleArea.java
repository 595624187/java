package Area;

import java.util.Scanner;

public class triangleArea{
double h,l;
private Scanner scan;

void Tarea(){

	double area;
	System.out.println("�����볤���ε���ϸ��Ϣ��");
	scan = new Scanner(System.in);
	System.out.println("��Ϊ��");

	h = scan.nextDouble();
	System.out.println("��Ϊ��");

	l = scan.nextDouble();
	area = h*l/2;	
	System.out.println("�������ε����Ϊ:"+area);

}
}
