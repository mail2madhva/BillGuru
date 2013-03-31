package com.ictforu.bill;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainEntry {
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(100,100);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
		
		
		
	}

}
