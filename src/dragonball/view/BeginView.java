package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BeginView extends JPanel{
	
	//public JPanel begin;
	public JButton newgame,loadgame;
	
	public BeginView() {
		
		JLabel thumb = new JLabel();
		ImageIcon icon = new ImageIcon("intro.png"); 
		thumb.setIcon(icon);
		
		
		this.setLayout(new BorderLayout());
		this.add(thumb);
		
		
		newgame = new JButton("NEW GAME");
		newgame.setBackground(Color.magenta);
		//newgame.addActionListener(this);
		this.add(newgame,BorderLayout.WEST);
		
		
		loadgame = new JButton("LOAD GAME");
		loadgame.setBackground(Color.cyan);
		//loadgame.addActionListener(this);
		this.add(loadgame,BorderLayout.EAST);
		
		repaint();
		revalidate();
		
	}
	
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//			if(e.getActionCommand().equals("NEW GAME"))
//			{
//				NewGame n = new NewGame();
//			}
//			if(e.getActionCommand().equals("LOAD GAME"))
//			{
//				LoadGame load = new LoadGame();
//			}
//		
//	}
//	
//	
	public static void main (String[]args)
	{
		JFrame b = new JFrame();
		b.setVisible(true);
		b.setTitle("Battle");
		b.setSize(1000, 1000);
		BeginView bg = new BeginView();
		b.add(bg);
		b.repaint();
		b.revalidate();


	}


}