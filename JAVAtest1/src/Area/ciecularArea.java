package Area;


import java.util.Scanner;

public class ciecularArea{
double r;
private Scanner scan;
void Carea(){
	
	double area;
	System.out.println("�����볤���ε���ϸ��Ϣ��");
	scan = new Scanner(System.in);
	System.out.println("�뾶Ϊ��");
	r = scan.nextDouble();
	area = 3.14159*r*r;	
	System.out.println("�ó�Բ�ε����Ϊ:"+area);
}
}