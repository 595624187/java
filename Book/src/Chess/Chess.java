package Chess;

class Game{
	Game(int i){
		System.out.println("����Game"+i);
	}
}
class BoardGame extends Game{

	BoardGame(int i){
		super(i);
		System.out.println("����BoardGame"+i);
	}
}
public class Chess extends BoardGame{
	Chess(){
		super(44);
		System.out.println("����Chess");
	}
	public static void main(String[]args){
		//Chess x= new Chess();
		new Chess();
	}
}