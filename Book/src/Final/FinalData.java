package Final;

class Value{
	int i = 1;
}
public class FinalData{
	final int i1=9;
	static final int i2=99;
	public static final int i3=39;
	final int i4 = (int)(Math.random()*20);
	static final int i5 = (int)(Math.random()*20);
	final int i6;
	final Value v2= new Value();
	static final Value v3 = new Value();
	final Value v4;
	final int[] a= {1,2,3,4,5,6};
	FinalData(){
		i6=16;
		v4 = new Value();
	}
	public void print(String id){
		System.out.println(id +":"+"i4="+i4+",i5="+i5);
		for(int i:a)
			System.out.println(i+"");
		System.out.println();
	}
	public static void main(String[]args){
		FinalData fd1= new FinalData();
		//fd1.i1++;
		for(int i=0;i<fd1.a.length;++i)
		fd1.a[i]++;
		//!fd1.v2=new Value();
		//!fd1.v3= new Value();
		//!fd1.a = new int[3];
		FinalData fd2 = new FinalData();
		fd1.print("fd1");
		fd2.print("fd2");
	}
}