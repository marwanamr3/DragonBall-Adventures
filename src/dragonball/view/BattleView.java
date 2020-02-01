package dragonball.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.battle.Battle;


@SuppressWarnings("serial")
public class BattleView extends JPanel{
	
	private JPanel info,mepanel,foepanel,actionpanel,turnpanel,combopanel;
	private JLabel mhp,hp,mki,ki,mst,st,nm,lvl;
	public JLabel mhpf,hpf,mkif,kif,mstf,stf ;
	public JLabel nmf;
	public JLabel lvlf;
	private JLabel mhp2,hp2,mki2,ki2,mst2,st2,nm2,lvl2;
	public JLabel mhpf2,hpf2,mkif2,kif2,mstf2,stf2,nmf2,lvlf2 ;
	public JLabel turnlabel,turn;
	public JButton phyatt,block,use;
	public JButton superattack, ultimateattack;
	private JPanel center;
	public Battle battle;
	
	public void setBattle(Battle battle) {
		this.battle = battle;
	}





	public BattleView(){
		
		
		this.setLayout(new BorderLayout());
		
		//set background image:
		
		JLabel thumb = new JLabel();
		ImageIcon icon = new ImageIcon("battle.png"); 
		thumb.setIcon(icon);
		
		JLabel foeimg = new JLabel();
		ImageIcon icon2 = new ImageIcon("foe.png"); 
		foeimg.setIcon(icon2);
		foeimg.setBounds(800,600,50,200);
		
		//this.add(thumb,BorderLayout.CENTER);
		
		center = new JPanel();
		center.setLayout(null);
		thumb.setBounds(0, 0, 1400, 750);
		center.add(thumb);
		center.add(foeimg);
		
		this.add(center,BorderLayout.CENTER);
		
		//upper main panel:
		
		info = new JPanel();
		info.setLayout(new GridLayout(1,3));
		this.add(info, BorderLayout.NORTH);
		
		//upper left panel:
		
		mepanel = new JPanel();
		mepanel.setLayout(new GridLayout(8,2));
		
		nm = new JLabel("- Name: ");
		nmf = new JLabel();
		
		lvl = new JLabel("- Level: ");
		lvlf = new JLabel();
		
		mhp = new JLabel("- max Health points: ");
		mhpf = new JLabel();
		
		hp = new JLabel("- Health points: ");
		hpf = new JLabel();
		
		mki = new JLabel("- max ki: ");
		mkif = new JLabel();
		
		ki = new JLabel("- ki: ");
		kif = new JLabel();
		
		mst = new JLabel("- max stamina: ");
		mstf = new JLabel();

		st = new JLabel("- stamina :");
		stf = new JLabel();
		
		mepanel.add(nm);
		mepanel.add(nmf);
		mepanel.add(lvl);
		mepanel.add(lvlf);
		mepanel.add(hp);
		mepanel.add(hpf);
		mepanel.add(mhp);
		mepanel.add(mhpf);
		mepanel.add(ki);
		mepanel.add(kif);
		mepanel.add(mki);
		mepanel.add(mkif);
		mepanel.add(st);
		mepanel.add(stf);
		mepanel.add(mst);
		mepanel.add(mstf);
		
		info.add(mepanel);
		
		
		//upper middle panel:
		
		actionpanel = new JPanel();
		actionpanel.setLayout(new GridLayout(4,1));
		
		
		
		turnpanel = new JPanel();
		turnpanel.setLayout(new FlowLayout());
		turnlabel = new JLabel();
		turn = new JLabel("'s Turn");
		turnpanel.add(turnlabel);
		turnpanel.add(turn);
		
		
//		lblpanel = new JPanel();
//		lblpanel.setLayout(new GridLayout(1,3));
//		JLabel att = new JLabel("");
//		JLabel supatt = new JLabel("SUPER ATTACK");
//		JLabel ultatt = new JLabel("ULTIMATE ATTACK");
//		lblpanel.add(att);
//		lblpanel.add(supatt);
//		lblpanel.add(ultatt);
		
		
//		String[] options = { "Spain", "Germany", "Ireland", "The kingdom of far far away" };
		
		
		combopanel= new JPanel();
		combopanel.setLayout(new GridLayout(1,3));
		phyatt = new JButton("PHYSICAL ATTACK");
		superattack = new JButton("SUPER ATTACK");
		ultimateattack = new JButton("ULTIMATE ATTACK");
		combopanel.add(phyatt);
		combopanel.add(superattack);
		combopanel.add(ultimateattack);
		
	
		
		block = new JButton("BLOCK");
		use = new JButton("USE");
		
		actionpanel.add(turnpanel);
		actionpanel.add(combopanel); 
		actionpanel.add(block);
		actionpanel.add(use);
		
		info.add(actionpanel);
		
		
		//upper right panel:
		
		foepanel = new JPanel();
		foepanel.setLayout(new GridLayout(8,2));
		
		nm2 = new JLabel("- Name: ");
		nmf2 = new JLabel();
		
		lvl2 = new JLabel("- Level: ");
		lvlf2 = new JLabel();
		
		mhp2 = new JLabel("- max Health points: ");
		mhpf2 = new JLabel();
		
		hp2 = new JLabel("- Health points: ");
		hpf2 = new JLabel();
		
		mki2 = new JLabel("- max ki: ");
		mkif2 = new JLabel();
		
		ki2 = new JLabel("- ki: ");
		kif2 = new JLabel();
		
		mst2 = new JLabel("- max stamina: ");
		mstf2 = new JLabel();

		st2 = new JLabel("- stamina :");
		stf2 = new JLabel();
		
		foepanel.add(nm2);
		foepanel.add(nmf2);
		foepanel.add(lvl2);
		foepanel.add(lvlf2);
		foepanel.add(hp2);
		foepanel.add(hpf2);
		foepanel.add(mhp2);
		foepanel.add(mhpf2);
		foepanel.add(ki2);
		foepanel.add(kif2);
		foepanel.add(mki2);
		foepanel.add(mkif2);
		foepanel.add(st2);
		foepanel.add(stf2);
		foepanel.add(mst2);
		foepanel.add(mstf2);
		
		info.add(foepanel);
		

		repaint();
		revalidate();
	}

	
	
	

public static void main (String[]args)
{
	JFrame b = new JFrame();
	b.setVisible(true);
	b.setTitle("Battle");
	b.setSize(1000, 1000);
	BattleView bt = new BattleView();
	b.add(bt);
	b.repaint();
	b.revalidate();


}


	
}