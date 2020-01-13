package Shapes;

class Shape{
	void draw(){}
	void erase(){}
}
class Circle extends Shape{
	void draw(){
		System.out.println("Cirrcle.draw()");
	}
	void erase(){
		System.out.println("Cirlcle.erase()");
	}
}
class Square extends Shape{
	void draw(){
		System.out.println("Square.draw()");
	}
	void erase(){
		System.out.println("Square.erase()");
	}
}
class Line extends Shape{
	void draw(){
		System.out.println("Line.draw()");
	}
	void erase(){
		System.out.println("Line.erase()");
	}
}
public class Shapes{
	public static Shape randShape(){
		switch((int)(Math.random()*3)){
		default:
		case 0:return new Circle();
		case 1:return new Square();
		case 2:return new Line();
		}
	}
	public static void main(String[]args){
		Shape[]s = new Shape[9];
		for(int i=0;i<s.length;++i)
			s[i]=randShape();
		for(int i=0;i<s.length;++i)
			s[i].draw();
	}
}