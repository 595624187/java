package Common;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Frame.LoginFrame;

public class MainGUI {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame loginframe = new LoginFrame();
					//loginframe.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
