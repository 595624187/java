package TestCalc;

import java.util.Scanner;
import java.util.Vector;
abstract class Operation {
    Operation(double num1,double num2){
        this.num1=num1;
        this.num2=num2;
    }
    Operation(){}//
    private double  num1;
    private double num2;

    public void setNum1(double num1) {
        this.num1=num1;
    }
    public void setNum2(double num2) {
        this.num2=num2;
    }
    public double getNum1() {
        return num1;
    }
    public double getNum2() {
        return num2;
    }
    public double add() {
        return getNum1()+getNum2();
    }
    public double decline() {
        return getNum1()-getNum2();
    }
    public double multy() {
        return getNum1()*getNum2();
    }
    public double division() {
        return getNum1()/getNum2();
    }
}

class Add extends Operation{
    Add(double num1,double num2){
        super(num1,num2);
    }
    public double add() {
        return getNum1()+getNum2();
    }
}

class Decline extends Operation{
    Decline(double num1,double num2){
        super(num1,num2);
    }
}

class Multy extends Operation{
    Multy(double num1,double num2){
        super(num1,num2);
    }
}

class Division extends Operation{
    Division(double num1,double num2){
        super(num1,num2);
    }
}

class TestCalc{

    static char precede(char a,char b) {
        if(a=='+'||a=='-') {
            if(b=='*'||b=='/'||b=='(')return '<';
            else return '>';
        }
        else if(a=='*'||a=='/') {
            if(b=='(') return '<';
            else return '>';
        }
        else if(a=='(') {
            if(b==')') return '=';//���=�� ��ʾ�����ڵ����ݼ������ ��Ȼ��ɾ��������
            else return '<';//�������� ��������ʱ �������ȼ���ͣ� ����������ͬʱ���� ���ȼ����
        }
        else if(a==')') {
            return'>';//�������ŵ�������ʱ�����ȼ����
        }
        else if(a=='=') {
            if(b=='=')return '=';// ��x1��ջ��Ԫ�غ� c ��Ϊ=ʱ ����־�˳�whileѭ��,�����������
            else return'<';
        }
        else return ' ';
    }// =���㼶���   �������㼶���
    public static void main(String []args) {

        Operation a;
        char c,e;//c����������ʽ��ÿ���ַ���e ֻ��������
        double num1,num2;
        String d;
        System.out.println("��������ʽ:");
        Scanner scan=new Scanner(System.in);
        d=scan.next();
        scan.close();
        Vector x1=new Vector();//x1�������
        Vector <Double>x2=new Vector<>();//x2��������
        x1.add('=');// = ��ջx1
        int i=0;
        c=d.charAt(i++);//charAt() �������ڷ���ָ�����������ַ���������ΧΪ�� 0 �� length() - 1����c�ȴ���d�ĵ�һ���ַ�
        while(c!='='||(char)x1.get(x1.size()-1)!='='){//  " (char)x1.get(x1.size()-1)" ��ʾx1��ջ��  ��c��x1��ջ����Ԫ�ض�Ϊ=��ʱ������whileѭ��//
            if(Character.isDigit(c)) {//isDigit() ���������ж�ָ���ַ��Ƿ�Ϊ����, Ϊ���ַ���true//��Ϊ������ ��ջx2 Ϊ����� ��ջx1
                x2.add((double) (c-'0'));//��ASCII�뽫string תdouble  ����ȱ���ǲ������븡����
                c=d.charAt(i++);
            }
            else
                switch(precede((char)x1.get(x1.size()-1),c)){//��ջ��Ԫ�غ�c Ŀǰ�洢��������������ȼ��Ƚ�
                    case'<':
                        x1.add(c);
                        c=d.charAt(i++);break;//�����<�� ��ǰ�������ջ x1;c �����洢����d ����һ���ַ�
                    case '=':
                        x1.removeElementAt(x1.size()-1);//ɾ��ջ��Ԫ��
                        c=d.charAt(i++);break;
                    case'>'://��������-��ʱ ���>,��Ϊ *�����ȼ�>  -  ;����c ="-"  -�Ŵ�ʱ��û����x1ջ�� �ȶ�5*6��������
                        e=(char)x1.get(x1.size()-1);
                        x1.removeElementAt(x1.size()-1);//�Ѿ���*�ŷ���e�У������԰�ջ��ɾȥ
                        num1=Double.parseDouble(x2.get(x2.size()-1).toString());//ת��Ϊdouble��
                        x2.removeElementAt(x2.size()-1);//6��ջ
                        num2=Double.parseDouble(x2.get(x2.size()-1).toString());//ת��x2���ڵ�ջ��5
                        x2.removeElementAt(x2.size()-1);//5��ջ
                        if(e=='+') {
                            a=new Add(num1,num2);
                            x2.add(a.add());
                        }
                        if(e=='-') {
                            a=new Decline(num2,num1);
                            x2.add(a.decline());
                        }
                        if(e=='*') {
                            a=new Multy(num1,num2);
                            x2.add(a.multy());//5*6=30, �� ��30��x2ջ��

                        }
                        if(e=='/') {
                            a=new Division(num2,num1);
                            x2.add(a.division());
                        }
                }
        }
        System.out.println("������Ϊ:"+x2.get(x2.size()-1));//


    }
}//�����ǰ�charλ��ȡ�ģ�����ASCII��ת��ʱ�޷�תС�� ����ȱ���������޷�double  �Ż��������������
