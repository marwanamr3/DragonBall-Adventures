package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewGame extends JPanel{
	
	public JPanel createnewgame,playfightname,combopanel;
	private JLabel name,fighterName,race;
	public JTextField playername,fightername;
	public JComboBox<String> fighterRace;
	public JButton create;
	private String[] raceArray;
	private ImageIcon img;
	public JLabel imglabel;
	
	public NewGame()
	{
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		img = new ImageIcon("fighters.png");
		imglabel = new JLabel(img);
		this.add(imglabel,BorderLayout.CENTER);
		
		
		create= new JButton("CREATE NEW GAME");
		
		//info Panel:
		
		createnewgame = new JPanel();
		createnewgame.setLayout(new GridLayout(3,1));
		
		playfightname = new JPanel();
		playfightname.setLayout(new GridLayout(8,1));
		
		
		combopanel = new JPanel();
		combopanel.setLayout(new GridLayout(4,1));
		
		
		//Left Labels:
		
		name = new JLabel("NAME: ");
		fighterName = new JLabel("FIGHTER: ");
		race = new JLabel("RACE: ");
		
		
		//Right Text Fields:
		
		playername = new JTextField();
		fightername = new JTextField();
		
		//Right ComboBox:
				
		raceArray = new String[6];
		raceArray[0] = "None";
		raceArray[1] = "Earthling";  //a[0]
		raceArray[2] = "Saiyan";	//a[1]
		raceArray[3] = "Namekian";	//a[2]
		raceArray[4] = "Frieza";	//a[3]
		raceArray[5] = "Majin";		//a[4]
		
		fighterRace = new JComboBox<String>(raceArray);
		
		
		//first panel:
		
		playfightname.add(name);
		playfightname.add(playername);
		playfightname.add(fighterName);
		playfightname.add(fightername);
		
		//second panel:
		
		combopanel.add(race);
		combopanel.add(fighterRace);
		
		//Adding panels to info Panel:
		
		createnewgame.add(playfightname);
		createnewgame.add(combopanel);
		createnewgame.add(create);
		
		
		//Placing info Panel on main Panel:
		
		createnewgame.setPreferredSize(new Dimension(300, getHeight()));
		this.add(createnewgame,BorderLayout.EAST);
		
	
		repaint();
		revalidate();
		
	}
	
	
	public String getSelected()
	{
		String x = (String) fighterRace.getSelectedItem();
		return x;
	}
	public char getChar(){
		String x = getSelected();
		char r = x.charAt(0);
		return r;
	}
	
	public static void main (String[]args)
	{
		JFrame b = new JFrame();
		b.setVisible(true);
		b.setTitle("Battle");
		b.setSize(1000, 1000);
		NewGame bt = new NewGame();

		b.add(bt);
		b.repaint();
		b.revalidate();


	}
	
	
	

}
