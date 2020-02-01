package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class WorldView extends JPanel{
	
	//JPanel mainworld ;
	public JPanel worldmap,grid3; 
	public JPanel info, upinfo, leftinfo,rightinfo;
	public LineBorder cellborder;
	public JLabel plname, fightname, lvl, senzu, dragon, maxhp, phydmg, blastdmg, maxki, maxst, abtpts;
	public JButton[][] grid;
	public JButton createbutt;
	public JButton switchs ;
	public JButton upgrade;
	public JButton assign ;
	public JButton save ;
	public JButton exit;
	public ImageIcon play;
	//public GUI maplistener;
		
	public WorldView(KeyListener key)
	{
		this.addKeyListener(key);
		
		//set image:-
		//back = new JLabel();
		//back.setIcon(new ImageIcon("brown.jpg"));
		
		
		//law 3ayzha fel center:-
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
			
		//setFocusable(true);
		
		this.setLayout(new BorderLayout());
		
		
		worldmap = new JPanel();
		worldmap.setLayout(new GridLayout(10,10));
		worldmap.setBackground(Color.LIGHT_GRAY);
		this.add(worldmap,BorderLayout.CENTER);
		
		
		info = new JPanel();
		info.setLayout(new GridLayout(0,1));
		info.setPreferredSize(new Dimension(300,getHeight()));
		this.add(info,BorderLayout.EAST);
		
		
		grid = new JButton[10][10];
		cellborder = new LineBorder(Color.BLACK, 3);
		for(int i = 0 ; i<grid.length ; i++ )
		{	
			for(int j=0 ; j<grid[i].length; j++)
			{
				grid[i][j] = new JButton("");
				grid[i][j].setBackground(Color.LIGHT_GRAY);
				grid[i][j].setBorder(cellborder);
				grid[i][j].setEnabled(false);
				worldmap.add(grid[i][j]);
				
				
			}
		}
		
		
//		play = new JLabel();
//		play.setIcon(new ImageIcon("player.png"));
		
//		play = new ImageIcon("foe.png");
//		grid[9][9].setIcon(play);
//		grid[9][9].setDisabledIcon(play);
		
		grid[9][9].setText("PLAYER");
		grid[9][9].setBackground(Color.GREEN);
		//grid[9][9].setForeground(Color.BLACK);
		grid[0][0].setText("BOSS");
		grid[0][0].setBackground(Color.RED);
		//grid[0][0].setForeground(Color.BLACK);

		
		
		
		upinfo = new JPanel();
		upinfo.setLayout(new GridLayout(1,0));
		
		//Info
		leftinfo = new JPanel();
		leftinfo.setLayout(new GridLayout(0,1));
		JLabel name = new JLabel("NAME: \n");
		leftinfo.add(name);
		JLabel currfighter = new JLabel("FIGHTER: \n");
		leftinfo.add(currfighter);
		JLabel currlevel = new JLabel("LEVEL: \n");
		leftinfo.add(currlevel);
		JLabel mHp = new JLabel("MAX HEALTH POINTS: \n");
		leftinfo.add(mHp);
		JLabel pdmg = new JLabel("PHYSICAL DAMAGE: \n");
		leftinfo.add(pdmg);
		JLabel bdmg = new JLabel("BLAST DAMAGE: \n");
		leftinfo.add(bdmg);
		JLabel mKi = new JLabel("MAX KI: \n");
		leftinfo.add(mKi);
		JLabel mSt = new JLabel("MAX STAMINA: \n");
		leftinfo.add(mSt);
		JLabel currDBZ = new JLabel("DRAGON BALLS: \n");
		leftinfo.add(currDBZ);
		JLabel currSBZ = new JLabel("SENZU BEANS: \n");
		leftinfo.add(currSBZ);
		JLabel abp = new JLabel("ABILITY POINTS: \n");
		leftinfo.add(abp);
		
		
		
		
		
		upinfo.add(leftinfo);
		
		
		rightinfo = new JPanel();
		rightinfo.setLayout(new GridLayout(0,1));
		
		//JLabel plname, fightname, lvl, senzu, dragon, maxhp, phydmg, blastdmg, maxki, maxst, abtpts;
		
		plname = new JLabel();
		fightname = new JLabel();
		lvl = new JLabel();
		senzu= new JLabel();
		dragon = new JLabel();
		maxhp= new JLabel();
		phydmg= new JLabel();
		blastdmg = new JLabel();
		maxki = new JLabel();
		maxst = new JLabel();
		abtpts= new JLabel();
		
		rightinfo.add(plname);
		rightinfo.add(fightname);
		rightinfo.add(lvl);
		rightinfo.add(maxhp);
		rightinfo.add(phydmg);
		rightinfo.add(blastdmg);
		rightinfo.add(maxki);
		rightinfo.add(maxst);
		rightinfo.add(dragon);
		rightinfo.add(senzu);
		rightinfo.add(abtpts);
		
		upinfo.add(rightinfo);
				
		
		//Options
		grid3 = new JPanel();
		grid3.setLayout(new GridLayout(6,0));
		
		createbutt = new JButton("CREATE FIGHTER");
		grid3.add(createbutt);
		
		switchs = new JButton("SWITCH FIGHTER");
		grid3.add(switchs);
		
		upgrade = new JButton("UPGRADE FIGHTER");
		grid3.add(upgrade);
		
		assign = new JButton("ASSIGN ATTACK");
		grid3.add(assign);
		
		save = new JButton("SAVE");
		grid3.add(save);
		
		exit = new JButton("EXIT");
		grid3.add(exit);
		
		
		info.add(upinfo);
		info.add(grid3);
		
		setFocusable(true);
		revalidate();
		repaint();

	}
	
	public static void main (String[]args)
	{
		JFrame b = new JFrame();
		b.setVisible(true);
		b.setTitle("Omar");
		b.setSize(1000, 1000);
			WorldView wld = new WorldView(null);
			b.add(wld);
			b.repaint();
			b.revalidate();
	}

	
}
