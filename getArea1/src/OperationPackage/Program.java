package OperationPackage;

import java.util.*; 

 class Operation {
	private double num1;
	private double num2;
	public double getNum1(){
		return num1;
	}
	public double getNum2(){
		return num2;
	}
	public void setNum1(double num){
		this.num1=num;
	}
	public void setNum2(double num){
		this.num2=num;
	}
	double getResult(){
		double result=0;
		return result;
	}
 }
class OperationAdd extends Operation{
	public double  getResult(){
		return (this.getNum1()+this.getNum2());
	}
}
class OperationSub extends Operation{
	public double getResult(){
		return (this.getNum1()-this.getNum2());
	}
}
class OperationMul extends Operation{
	public double getResult(){
		return (this.getNum1()*this.getNum2());
	}
}
class OperationDiv extends Operation{
	public double getResult(){
		return (this.getNum1()/this.getNum2());
	}
}

public class Program{
	public static void main(String[]args){
		double num1,num2;
		String operator;
		Scanner sc = new Scanner(System.in);
		Operation op =null;
		System.out.println("�������һ�����֣�");
		num1 = sc.nextDouble();
		System.out.println("�����������:");
		operator = sc.next();
		System.out.println("��������һ�����֣�");
		num2 = sc.nextDouble();
		if(operator.equals("+"))
			op = new OperationAdd();
		else if(operator.equals("-"))
			op = new OperationSub();
		else if(operator.equals("*"))
			op = new OperationMul();
		else if(operator.equals("/"))
			op = new OperationDiv();
		else
			op = null;
		if(!(op==null)){
			op.setNum1(num1);
			op.setNum2(num2);
			System.out.println("���Ϊ:"+op.getResult());
		}else{
			System.out.println("�������!");
		}
	}
}
 