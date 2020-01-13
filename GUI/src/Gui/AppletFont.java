package Gui;
import java.awt.*;
import java.applet.*;
public class AppletFont extends Applet{
	Font f1 = new Font ("TimesRoman",Font.PLAIN,15);
	Font f2 = new Font ("TimesRoman",Font.BOLD,30);
	Font f3 = new Font ("TimesRoman",Font.ITALIC,45);
	public void paint(Graphics g){
		g.setFont(f1);
		g.setColor(Color.red);
		g.drawString("Java is very simpe",50,20);
		g.drawString(f1.getFontName(), 220, 20);
		g.setFont(f2);
		g.setColor(Color.green);
		g.drawString("Java is good", 50, 50);
		g.drawString(f2.getFontName(), 260, 50);
		g.setFont(f3);
		g.setColor(Color.blue);
		g.drawString("Java is OK", 50, 90);
		g.drawString(f3.getFontName(), 280, 90);
	}
}
