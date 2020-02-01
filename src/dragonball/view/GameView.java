package dragonball.view;

//import java.awt.*;

import java.awt.event.KeyListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class GameView extends JFrame {
	
	
	public JFrame main;
	
	//private GUI gui;
	
	public GameView(KeyListener k )
	{
		
		//this.gui = gui;
		
		//Fullscreen
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
		this.setTitle("Dragon Ball Adventure");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		this.addKeyListener(k);
		
		
		
	}
	
	
	
	

	

}
