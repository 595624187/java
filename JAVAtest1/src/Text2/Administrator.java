package Text2;

public class Administrator {
	String name;
	int key;
	void show(){	
		System.out.println("ĞÕÃû£º"+this.name+",ÃÜÂë"+this.key);
	}
	public static void main(String[]args){
		Administrator a1= new Administrator();
		Administrator a2= new Administrator();
		a1.name="admin1";
		a1.key=111111;
		a2.name="admin2";
		a2.key=222222;
		a1.show();
		a2.show();
	}
}