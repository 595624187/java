package Gui;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class keyColorProc extends Applet implements KeyListener{
	Color c;
	Label l = new Label ("Input R G B");
	TextField tf = new TextField(10);
	char PressKey;
	public void init(){
		add(l);
		add(tf);
		tf.addKeyListener(this);

	}
	public void paint(Graphics g){
		if(PressKey != 0){
			g.drawString("Press Key:"+PressKey,60,50);
		}
	}
	public void keyPressed(KeyEvent e){
		c= Color.white;
		PressKey = e.getKeyChar();
		if     (PressKey=='r')
			c = Color.red;
		else if(PressKey=='g')
			c = Color.green;
		else if(PressKey=='b')
			c = Color.blue;
		else if(PressKey=='y')
			c= Color.yellow;
		else if(PressKey=='o')
			c= Color.orange;
		else if(PressKey=='p')
			c=Color.PINK;
		else if(PressKey=='c')
			c =Color.cyan;
		else if(PressKey=='m')
			c=Color.magenta;		
		else if(PressKey=='h')
			c=Color.black;		
		else if(PressKey=='l')
			c=Color.LIGHT_GRAY;
		setBackground(c);
		repaint();
		}
		public void keyTyped(KeyEvent e){
			
		}
		public void keyReleased(KeyEvent e){
			
		}
	}
