package AreaPackage;

import java.util.Scanner;
import java.lang.*;

interface Geometricinterface{
	 void printArea();
	 void printPerimeter();
}


class Rectangular implements Geometricinterface{
	int a,b;
	public void printArea() {
		System.out.println("The rectangular's Area is :"+a*b);
	}
	public void printPerimeter() {
		System.out.println("The rectangular's Perimeter is :"+2*(a+b));
	}
}

class Triangle implements Geometricinterface{
	double a1,b1,c1;
	double p,area;
	public void printArea() {
		p=(a1+b1+c1)/2;
		area= Math.sqrt(p*(p-a1)*(p-b1)*(p-c1));
		System.out.println("The triangle's Area is :"+area);
	}
	public void printPerimeter() {
		System.out.println("The triangle's Perimeter is :"+(a1+b1+c1));
	}
}

public class Area {
	public static void main(String[]args){
		System.out.println("请输入需要计算的类型:1-三角形|2-矩形");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			Triangle tg = new Triangle();
			System.out.println("请输入该三角形的三条边:");
			tg.a1=sc.nextDouble();
			tg.b1=sc.nextDouble();
			tg.c1=sc.nextDouble();
			tg.printArea();
			tg.printPerimeter();
			break;
		case 2:
			Rectangular rg = new Rectangular();
			System.out.println("请输入该矩形的长和宽:");
			rg.a=sc.nextInt();
			rg.b=sc.nextInt();
			rg.printArea();
			rg.printPerimeter();
			break;
		default :System.out.println("输入错误!");
		}
	}
}