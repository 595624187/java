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
            if(b==')') return '=';//输出=号 表示括号内的内容计算完毕 ，然后删除左括号
            else return '<';//当左括号 单独存在时 运算优先级最低； 当与右括号同时存在 优先级最高
        }
        else if(a==')') {
            return'>';//当右括号单独存在时，优先级最高
        }
        else if(a=='=') {
            if(b=='=')return '=';// 当x1的栈顶元素和 c 都为=时 即标志退出while循环,结束运算操作
            else return'<';
        }
        else return ' ';
    }// =运算级最低   （）运算级最高
    public static void main(String []args) {

        Operation a;
        char c,e;//c储存解析表达式的每个字符，e 只针对运算符
        double num1,num2;
        String d;
        System.out.println("请输入表达式:");
        Scanner scan=new Scanner(System.in);
        d=scan.next();
        scan.close();
        Vector x1=new Vector();//x1放运算符
        Vector <Double>x2=new Vector<>();//x2放运算数
        x1.add('=');// = 入栈x1
        int i=0;
        c=d.charAt(i++);//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。让c先储存d的第一个字符
        while(c!='='||(char)x1.get(x1.size()-1)!='='){//  " (char)x1.get(x1.size()-1)" 表示x1的栈顶  当c和x1的栈顶的元素都为=的时候跳出while循环//
            if(Character.isDigit(c)) {//isDigit() 方法用于判断指定字符是否为数字, 为数字返回true//若为运算数 入栈x2 为运算符 入栈x1
                x2.add((double) (c-'0'));//用ASCII码将string 转double  ！！缺陷是不能输入浮点数
                c=d.charAt(i++);
            }
            else
                switch(precede((char)x1.get(x1.size()-1),c)){//对栈顶元素和c 目前存储的运算符进行优先级比较
                    case'<':
                        x1.add(c);
                        c=d.charAt(i++);break;//如输出<号 则当前运算符入栈 x1;c 继续存储解析d 的下一个字符
                    case '=':
                        x1.removeElementAt(x1.size()-1);//删除栈顶元素
                        c=d.charAt(i++);break;
                    case'>'://当解析到-号时 输出>,因为 *号优先级>  -  ;另外c ="-"  -号此时还没有入x1栈， 先对5*6进行运算
                        e=(char)x1.get(x1.size()-1);
                        x1.removeElementAt(x1.size()-1);//已经把*号放在e中，故阔以把栈顶删去
                        num1=Double.parseDouble(x2.get(x2.size()-1).toString());//转化为double类
                        x2.removeElementAt(x2.size()-1);//6出栈
                        num2=Double.parseDouble(x2.get(x2.size()-1).toString());//转化x2现在的栈顶5
                        x2.removeElementAt(x2.size()-1);//5出栈
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
                            x2.add(a.multy());//5*6=30, 再 将30入x2栈；

                        }
                        if(e=='/') {
                            a=new Division(num2,num1);
                            x2.add(a.division());
                        }
                }
        }
        System.out.println("输出结果为:"+x2.get(x2.size()-1));//


    }
}//由于是按char位读取的，在用ASCII码转化时无法转小数 ，故缺陷在输入无法double  优化可以这个方向走
