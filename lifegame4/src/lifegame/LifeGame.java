package lifegame;

import javax.swing.JFrame;  


  
    
/** 
 * ������Ϸ 
 *  
 */  
  
public class LifeGame extends JFrame{  
  
      
      
  
    LifeGame(){  
        this.setSize(630,600);  
        this.setTitle("������Ϸ[LifeGame]DEMO");  
        this.add(new WorldMap());  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  //������С
    }  
      
    public static void main(String[] args){  
        LifeGame game = new LifeGame();  
        game.setVisible(true);  
    }  
  
}
