package Area;


import java.util.Scanner;
public class Area{

	private static Scanner scan;

	public static void main(String[]args){
		
		System.out.println("������ѡ��(1:����/2��Բ��/3��������):");
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		switch(n){
		case 1:
			rectangleArea s1= new rectangleArea();
			s1.Rarea();
			break;
		case 2:
			ciecularArea s2 =new ciecularArea();
			s2.Carea();
			break;

		case 3:  
			triangleArea s3 =new triangleArea();
			s3.Tarea();
			break;

		}
		
	}
}
