package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class DragonView extends JPanel{
	
	public JPanel wishes,dragoninfo;
	public JButton ability,senzu,satt,ultatt;
	private JLabel lbl;
	public JTextArea draginfo;
	
	public DragonView(){ 
		
	this.setLayout(new BorderLayout());
	
	//set image:
	
	JLabel thumb = new JLabel();
	ImageIcon icon = new ImageIcon("dragon.jpg"); 
	thumb.setIcon(icon);
	this.add(thumb,BorderLayout.CENTER);
	
	dragoninfo = new JPanel();
	dragoninfo.setBackground(Color.BLACK);
	draginfo = new JTextArea();
	Font font1 = new Font("SansSerif", Font.BOLD, 15);
	draginfo.setFont(font1);
	draginfo.setBackground(Color.BLACK);
	draginfo.setForeground(Color.WHITE);
	draginfo.setEditable(false);
	
	
	//draginfo.setBackground(Color.BLUE);
	
	dragoninfo.add(draginfo);
	this.add(dragoninfo, BorderLayout.NORTH);
	
	wishes = new JPanel();
	wishes.setLayout(new FlowLayout());
	wishes.setBackground(Color.BLACK);
	
	lbl = new JLabel("CHOOSE A WISH: ");
	lbl.setForeground(Color.WHITE);
	wishes.add(lbl);
	
	ability = new JButton("CHOOSE ABILITY POINTS");
	wishes.add(ability);
	
	senzu = new JButton("CHOOSE SENZU BEANS");
	wishes.add(senzu);
	
	satt = new JButton("CHOOSE SUPER ATTACK");
	wishes.add(satt);
	
	ultatt = new JButton("CHOOSE ULTIMATE ATTACK");
	wishes.add(ultatt);
	
	this.add(wishes, BorderLayout.SOUTH);
	
	
	

	}
	public static void main (String[]args)
	{
		JFrame b = new JFrame();
		b.setVisible(true);
		b.setTitle("Dragon");
		b.setSize(1000, 1000);
		DragonView bt = new DragonView();
		b.add(bt);
		b.repaint();
		b.revalidate();
	}
}