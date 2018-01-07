package lab.shutdownhook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShutdownhookSample {
	public static void main(String args[]){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(50, 50));
		panel.setBackground(Color.yellow);
		frame.add(panel);
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				frame.dispose();
				System.out.println("Close from listener...");
				/**
				 * Add cleanup operations here
				 */
			}
		});
		frame.pack();
		frame.setVisible(true);
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void start(){
				System.out.println("Close from shutdownhook...");
				/**
				 * Add cleanup operations here
				 */
			}
		});
	
	}
	
}
