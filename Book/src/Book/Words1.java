package Book;


class Book1 {
	protected int pages = 300;
	
	public void setPages(int pages){this.pages = pages;}
	public int getPages(){return pages;}
	
}

class Dictionary extends Book1{
	private int definitions = 5000;
	public double computeRatio(){return definitions / pages;}
	public void setDefinitions(int definitions){this.definitions = definitions;}
	public int getDefinitions(){return definitions;}
	
}
public class Words1{
	public static void main(String[]args){
		Dictionary xinhua = new Dictionary();
		System.out.println("ҳ��:"+xinhua.getPages());
		System.out.println("������:"+xinhua.getDefinitions());
		System.out.println("ÿҳ������:"+xinhua.computeRatio());
		
	}
}
