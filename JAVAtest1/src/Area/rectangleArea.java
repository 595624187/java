package Area;


import java.util.Scanner;

	
public class rectangleArea{
	int lenth;
	int width;
	private Scanner scan;
void Rarea(){
		
		System.out.println("�����볤���ε���ϸ��Ϣ��");
		scan = new Scanner(System.in);
		System.out.println("��Ϊ��");
		lenth = scan.nextInt();
		System.out.println("��Ϊ��");
		width = scan.nextInt();
		int area;
		area = lenth*width;
		System.out.println("�ó����ε����Ϊ:"+area);
	}
}