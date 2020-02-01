package dragonball.controller;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dragonball.model.attack.PhysicalAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.battle.BattleOpponent;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MapIndexOutOfBoundsException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.BattleView;
import dragonball.view.BeginView;
import dragonball.view.DragonView;
import dragonball.view.GameView;
import dragonball.view.NewGame;
import dragonball.view.WorldView;

@SuppressWarnings("serial")
public class GUI implements GameListener, ActionListener, KeyListener {
	
	private Game gameModel;
	private GameView gameView;
	private BeginView beginView;
	private NewGame newgameView;
	private WorldView worldView;
	private BattleView battleView;
	private DragonView dragonView;
	private Dragon wisher;
	private ImageIcon img;
	private int rowx,coly;
	
	
	
	
	public GUI ()
	{
		
			try {
				gameModel = new Game();
			} catch (MissingFieldException e) {
				JOptionPane.showMessageDialog(gameView, "Missing Field!");
			} catch (UnknownAttackTypeException e) {
				JOptionPane.showMessageDialog(gameView, "Unknown Attack Type");
			}
			gameModel.setListener(this);
		
		gameView = new GameView(this);
		beginView = new BeginView();
		newgameView = new NewGame();
		worldView = new WorldView(this);
		battleView = new BattleView();
		dragonView = new DragonView();
		gameView.add(beginView);
		
		//Begin view:
		beginView.newgame.addActionListener(this);
		beginView.loadgame.addActionListener(this);
		
		//Newgameview :
		newgameView.create.addActionListener(this);
		newgameView.fighterRace.addActionListener(this);
		
		//world view:
		worldView.createbutt.addActionListener(this);
		worldView.switchs.addActionListener(this);
		worldView.upgrade.addActionListener(this);
		worldView.assign.addActionListener(this);
		worldView.save.addActionListener(this);
		worldView.exit.addActionListener(this);
		
		
		//battle view:
		battleView.phyatt.addActionListener(this);
		battleView.block.addActionListener(this);
		battleView.use.addActionListener(this);
		battleView.superattack.addActionListener(this);
		battleView.ultimateattack.addActionListener(this);
		
		//dragon view:
		dragonView.ability.addActionListener(this);
		dragonView.senzu.addActionListener(this);
		dragonView.satt.addActionListener(this);
		dragonView.ultatt.addActionListener(this);
		
		System.out.println(gameModel.getWorld().toString());
		
		
	//	gameModel.getPlayer().getUltimateAttacks().add((UltimateAttack) gameModel.getAttacks().get(90));
//		gameModel.getPlayer().getUltimateAttacks().add((UltimateAttack) gameModel.getAttacks().get(65));
//	//	gameModel.getPlayer().getActiveFighter().setKi(3);
		
		
		gameView.repaint();
		gameView.revalidate();
	}
	
	//Getters & Setters:
	
	public Game getGame() {
		return gameModel;
	}

	public void setGame(Game game) {
		this.gameModel = game;
	}

	public GameView getGameView() {
		return gameView;
	}

	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}
	
	
	
	//------------------------------------------------//
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		//attributes
		String plname = newgameView.playername.getText();
		String comborace = (String) newgameView.fighterRace.getSelectedItem();
		char race = newgameView.getChar();
		
		
		//changing images:
		
		if(comborace.equals("Earthling"))
		{
			newgameView.imglabel.removeAll();
			img = new ImageIcon("Earthling.png");
			newgameView.imglabel.setIcon(img);
			
			gameView.repaint();
			gameView.revalidate();
		
		}
		if(comborace.equals("Saiyan"))
		{
			newgameView.imglabel.removeAll();
			img = new ImageIcon("goku.png");
			newgameView.imglabel.setIcon(img);
			
			gameView.repaint();
			gameView.revalidate();
		
		}
		if(comborace.equals("Namekian"))
		{
			newgameView.imglabel.removeAll();
			img = new ImageIcon("Namekian.png");
			newgameView.imglabel.setIcon(img);
			
			gameView.repaint();
			gameView.revalidate();
		
		}
		if(comborace.equals("Frieza"))
		{
			newgameView.imglabel.removeAll();
			img = new ImageIcon("Frieza.png");
			newgameView.imglabel.setIcon(img);
			
			gameView.repaint();
			gameView.revalidate();
		
		}
		if(comborace.equals("Majin"))
		{
			newgameView.imglabel.removeAll();
			img = new ImageIcon("Majin.png");
			newgameView.imglabel.setIcon(img);
			
			gameView.repaint();
			gameView.revalidate();
		
		}
		
		 
		
		//newgame
		if(e.getActionCommand().equals("NEW GAME"))
		{
			//String comboname = (String) newgameView.fighterRace.getSelectedItem();
			
			gameView.remove(beginView);
			gameView.add(newgameView);
			
			gameView.repaint();
			gameView.revalidate();
		}
		
		//loadgame
		if(e.getActionCommand().equals("LOAD GAME"))
		{
			if(gameModel.getLastSavedFile()!=null){	
			try {
				gameModel.load(gameModel.getLastSavedFile());
				gameView.remove(beginView);
				gameView.add(worldView);
				worldView.requestFocusInWindow();
			} catch (ClassNotFoundException | IOException e1) {
				JOptionPane.showMessageDialog(gameView, "No Saved Game!");
			}
			}
			
			gameView.repaint();
			gameView.revalidate();
		}
		
		//-----------------------------------------//
		
		
		
		
		//NEW GAME VIEW:
		
		if(e.getActionCommand().equals("CREATE NEW GAME"))
		{
			String fightname = newgameView.fightername.getText();
		///	JLabel image ;
			
			if(plname.equals(""))
			{
				JOptionPane.showMessageDialog(newgameView, "No Player name entered!");
			}else 
				if(fightname.equals(""))
				{
					JOptionPane.showMessageDialog(newgameView, "No Fighter name entered!");
				}else
					if(comborace=="None")
					{
						JOptionPane.showMessageDialog(newgameView, "No Fighter race selected!");
					}
					else
					{
						
						
						
						
						gameModel.getPlayer().setName(plname);
						gameModel.getPlayer().createFighter(race, fightname);
						gameView.remove(newgameView);
						gameView.add(worldView);
						
						
						//System.out.println(gameModel.getPlayer().getActiveFighter().getName());
						
						
						
						
						worldView.requestFocusInWindow();
						gameView.revalidate();
						gameView.repaint();
						
						
						
						//add info of fighter to world view:
						
						assignAttributes();
						
	
						
						
					}
					
			gameView.repaint();
			gameView.revalidate();
		
		}
			
			
			//--------------------------------------------//
			
			
			//WORLD VIEW:
			
			//create fighter button:
			
			if(e.getActionCommand().equals("CREATE FIGHTER"))
			{	
			
			//new fighter popup
				
			JPanel fields = new JPanel(new GridLayout(2, 1));
			JTextField field = new JTextField(10);
			JComboBox<String> comboBox = new JComboBox<>(new String[]{"Earthing","Saiyan", "Namekian", "Frieza","Majin"});
			fields.add(field);
			fields.add(comboBox);
			JOptionPane.showConfirmDialog(gameView, fields, "Create Fighter", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
			if(field.equals(""))
			{
				JOptionPane.showMessageDialog(gameView, "No Fighter Name Entered!");
			}
			else
			{
				String fightname = field.getText();
				String s = (String) comboBox.getSelectedItem();
				char newrace = s.charAt(0);
				
				gameModel.getPlayer().createFighter(newrace, fightname);
				
				worldView.requestFocusInWindow();
				gameView.revalidate();
				gameView.repaint();
				
			}		
				
			 gameView.repaint();
			 gameView.revalidate();
			}
			
			
			//switch fighter button
			
			if(e.getActionCommand().equals("SWITCH FIGHTER"))
			{
				
				//switch fighter popup
				String[] fighters = new String [gameModel.getPlayer().getFighters().size()];
				
				for (int i = 0; i < fighters.length; i++) {
					
					fighters[i] = gameModel.getPlayer().getFighters().get(i).getName();
				}
				
				JComboBox<String> comboBox = new JComboBox<String>(fighters);
				String [] options = {"OK"};
				
				JOptionPane.showOptionDialog(gameView, comboBox,"Select Fighter" ,JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null,options, null);
					
					
				gameModel.getPlayer().setActiveFighter(gameModel.getPlayer().getFighters().get(comboBox.getSelectedIndex()));
					
				assignAttributes();
				String s = (String) comboBox.getSelectedItem();
				worldView.fightname.setText(s);
					
				worldView.requestFocusInWindow();
				gameView.revalidate();
				gameView.repaint();
					
				
			}
			
			
			
			
			
			
			
			
			
			
			//upgrade fighter button
			
			if(e.getActionCommand().equals("UPGRADE FIGHTER"))
			{
					String[] upg = {"None","Health Points","Blast Damage","Physical Damage","Ki","Stamina"};
					JComboBox<String> upgcombo = new JComboBox<String>(upg);
					
					JOptionPane.showMessageDialog(gameView, upgcombo);
					
					String itemupg = (String) upgcombo.getSelectedItem();
					System.out.println(itemupg);
					char charupg = itemupg.charAt(0);
					System.out.println(charupg);
					
				if(itemupg.equals("None"))	
				{
				JOptionPane.showMessageDialog(gameView, "No Attribute Selected!");
				JOptionPane.showMessageDialog(gameView, upgcombo);
				}
				else{	
					try {
						gameModel.getPlayer().upgradeFighter(gameModel.getPlayer().getActiveFighter(),charupg);
						assignAttributes();
					} catch (NotEnoughAbilityPointsException e1) {
						JOptionPane.showMessageDialog(gameView, "Not Enough Ability Points!");
					}
				}	
			}
			
			
			//assign attacks button
			
			if(e.getActionCommand().equals("ASSIGN ATTACK"))
			{
				String[] options ={"None","Super Attack","Ultimate Attack"};
				JComboBox<String> suatt = new JComboBox<String>(options);
				
				
				
				JOptionPane.showMessageDialog(gameView, suatt);
				
				String att = (String) suatt.getSelectedItem();
				
//					gameModel.getPlayer().getSuperAttacks().add((SuperAttack)gameModel.getAttacks().get(1));
//					gameModel.getPlayer().getSuperAttacks().add((SuperAttack)gameModel.getAttacks().get(2));
//					gameModel.getPlayer().getActiveFighter().getSuperAttacks().add((SuperAttack)gameModel.getAttacks().get(4));
					
					//System.out.println(gameModel.getPlayer().getActiveFighter().getSuperAttacks().get(0).getName());
					
					
					if(att.equals("None"))
					
					JOptionPane.showMessageDialog(gameView,"No Attack Selected!");
						
					
						//assign super attack
						if(att.equals("Super Attack"))
						{
							
						//old fighter's superattack (from fighter)
							
						String[] oldsupatt = new String [gameModel.getPlayer().getActiveFighter().getSuperAttacks().size()];
							
							for (int i = 0; i < oldsupatt.length; i++) {
								oldsupatt[i] = gameModel.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName();
							}
							
							JComboBox<String> oldsup = new JComboBox<String>(oldsupatt);
							String[] options2 = {"OK"};
							//JOptionPane.showOptionDialog(gameView, oldsup,"Choose Old Super Attack" ,JOptionPane.DEFAULT_OPTION,
								//	JOptionPane.PLAIN_MESSAGE, null,options2, null);
	
							
							
						//new fighter's superattack (from player)	
							
						String[] newsupatt = new String [gameModel.getPlayer().getSuperAttacks().size()];
						
						for (int i = 0; i < newsupatt.length; i++) {
							
							newsupatt[i] = gameModel.getPlayer().getSuperAttacks().get(i).getName();
						}
						
						JComboBox<String> newsup = new JComboBox<String>(newsupatt);
						String[] options3 = {"OK"};
						//JOptionPane.showOptionDialog(gameView, newsup,"Choose new Super Attack" ,JOptionPane.DEFAULT_OPTION,
							//	JOptionPane.PLAIN_MESSAGE, null,options3, null);
						
						
						//Conditions- superattacks
												
						
						if((oldsup.getSelectedIndex()==-1)&&(newsup.getSelectedIndex()==-1))
						{
							JOptionPane.showMessageDialog(gameView, "No Attacks Found!");
						}
						else if((oldsupatt.length<4)&&(newsupatt.length>0))
						{
							JOptionPane.showOptionDialog(gameView, newsup,"Choose new Super Attack" ,JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,options3, null);
							try {
								gameModel.getPlayer().assignAttack(gameModel.getPlayer().getActiveFighter(),gameModel.getPlayer().getSuperAttacks().get(newsup.getSelectedIndex()),null);
							} catch (MaximumAttacksLearnedException
									| DuplicateAttackException
									| NotASaiyanException e1) {
								JOptionPane.showMessageDialog(gameView, "Can not assign attack");
							}
						}
						else
						{
							JOptionPane.showOptionDialog(gameView, oldsup,"Choose Old Super Attack" ,JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,options2, null);
							
							JOptionPane.showOptionDialog(gameView, newsup,"Choose new Super Attack" ,JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,options3, null);
							
							try {
								gameModel.getPlayer().assignAttack(gameModel.getPlayer().getActiveFighter(),gameModel.getPlayer().getSuperAttacks().get(newsup.getSelectedIndex()),gameModel.getPlayer().getActiveFighter().getSuperAttacks().get(oldsup.getSelectedIndex()));
							} catch (MaximumAttacksLearnedException
									| DuplicateAttackException
									| NotASaiyanException e1) {
								JOptionPane.showMessageDialog(gameView, "Can not assign attack");
							}
							
						}
	
						}
						
						worldView.requestFocusInWindow();
									
						//assign ultimate attack
						
						if(att.equals("Ultimate Attack"))
						{
							
							//old fighter's ultimateattack (from fighter)
							
							String[] oldultatt = new String [gameModel.getPlayer().getActiveFighter().getUltimateAttacks().size()];
								
								for (int i = 0; i < oldultatt.length; i++) {
									oldultatt[i] = gameModel.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName();
								}
								
								JComboBox<String> oldult = new JComboBox<String>(oldultatt);
								String[] options2 = {"OK"};
//								JOptionPane.showOptionDialog(gameView, oldult,"Choose Old Ultimate Attack" ,JOptionPane.DEFAULT_OPTION,
//										JOptionPane.PLAIN_MESSAGE, null,options2, null);
		
							//new fighter's ultimateattack (from player)	
								
							String[] newultatt = new String [gameModel.getPlayer().getUltimateAttacks().size()];
							
							for (int i = 0; i < newultatt.length; i++) {
								
								newultatt[i] = gameModel.getPlayer().getUltimateAttacks().get(i).getName();
							}
							
							JComboBox<String> newult = new JComboBox<String>(newultatt);
							String[] options3 = {"OK"};
//							JOptionPane.showOptionDialog(gameView, newult,"Choose new Ultimate Attack" ,JOptionPane.DEFAULT_OPTION,
//									JOptionPane.PLAIN_MESSAGE, null,options3, null);
							
							
							//Conditions- ultimateattacks
													
							
							if((oldult.getSelectedIndex()==-1)&&(newult.getSelectedIndex()==-1))
							{
								JOptionPane.showMessageDialog(gameView, "No Attacks Found");
							}
							else if((oldultatt.length<2)&&(newultatt.length>0))
							{
								JOptionPane.showOptionDialog(gameView, newult,"Choose new Ultimate Attack" ,JOptionPane.DEFAULT_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,options3, null);
								try {
									gameModel.getPlayer().assignAttack(gameModel.getPlayer().getActiveFighter(),gameModel.getPlayer().getUltimateAttacks().get(newult.getSelectedIndex()),null);
								} catch (MaximumAttacksLearnedException
										| DuplicateAttackException
										| NotASaiyanException e1) {
									JOptionPane.showMessageDialog(gameView, "Can not assign attack");
								}
							}
							else
							{
								JOptionPane.showOptionDialog(gameView, oldult,"Choose Old Ultimate Attack" ,JOptionPane.DEFAULT_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,options2, null);
								
								JOptionPane.showOptionDialog(gameView, newult,"Choose new Ultimate Attack" ,JOptionPane.DEFAULT_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,options3, null);
								
								try {
								gameModel.getPlayer().assignAttack(gameModel.getPlayer().getActiveFighter(),gameModel.getPlayer().getUltimateAttacks().get(newult.getSelectedIndex()),gameModel.getPlayer().getActiveFighter().getUltimateAttacks().get(oldult.getSelectedIndex()));
								} catch (MaximumAttacksLearnedException
										| DuplicateAttackException
										| NotASaiyanException e1) {
									JOptionPane.showMessageDialog(gameView, "Can not assign attack");
								}
							}
	
					}	
//						System.out.println(gameModel.getPlayer().getActiveFighter().getSuperAttacks().get(0).getName());
//						System.out.println(gameModel.getPlayer().getActiveFighter().getSuperAttacks().get(1).getName());
						
						worldView.requestFocusInWindow();
					
				
			}
			
			
			//save button:
			if(e.getActionCommand().equals("SAVE"))
			{
			JPanel fields = new JPanel(new GridLayout(1, 1));
			JTextField field = new JTextField(10);
			//JComboBox<String> comboBox = new JComboBox<>(new String[]{"Earthing","Saiyan", "Namekian", "Frieza","Majin"});
			fields.add(field);
			//fields.add(comboBox);
			JOptionPane.showConfirmDialog(gameView, fields, "File name:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
			
			//exit button:
			
			if(e.getActionCommand().equals("EXIT"))
			{
				int onexit = JOptionPane.showConfirmDialog(gameView, "Are You Sure?" , "EXIT", JOptionPane.YES_NO_OPTION);
				
				if(onexit == JOptionPane.YES_OPTION )
				gameView.dispose();
				
				//worldView.requestFocusInWindow();
				
					
			}
			
			//Battle :
			
			//block button
			
			if(e.getActionCommand().equals("BLOCK"))
			{
				
				
				//JOptionPane.showMessageDialog(gameView, attacker.getName() + "   Blocked");
				battleView.battle.block();
			}
			
			
			//use button
			
			if(e.getActionCommand().equals("USE"))
			{
				
				
				try {
					battleView.battle.use(gameModel.getPlayer(),Collectible.SENZU_BEAN);
				} catch (NotEnoughSenzuBeansException e1) {
					JOptionPane.showMessageDialog(gameView, "Not Enough SenzuBeans!");
				}		
				
			
				
			}
			
			
			//attack button
			
			if(e.getActionCommand().equals("PHYSICAL ATTACK"))
			{
				try {
					battleView.battle.attack(new PhysicalAttack());
					
				} catch (NotEnoughKiException e1) {
				}	
			}
			
			//super attack button
			
			if(e.getActionCommand().equals("SUPER ATTACK"))
			{
				
				String[] btsatt = new String [gameModel.getPlayer().getActiveFighter().getSuperAttacks().size()];
				
				for (int i = 0; i < btsatt.length; i++) {
					
					btsatt[i] = gameModel.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName();
				}
				
				JComboBox<String> battlesuper = new JComboBox<String>(btsatt);
				String[] options3 = {"OK"};
				
				
				if((battlesuper.getSelectedIndex()==-1))
					{
						JOptionPane.showMessageDialog(gameView, "NO SUPER ATTACK FOUND!");
					}
				else
				{
					JOptionPane.showOptionDialog(gameView, battlesuper,"Choose Super Attack" ,JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,options3, null);
					
					try {
						battleView.battle.attack(gameModel.getPlayer().getActiveFighter().getSuperAttacks().get(battlesuper.getSelectedIndex()));
					} catch (NotEnoughKiException e1) {
						JOptionPane.showMessageDialog(gameView, "Not Enough Ki");
					
				}
				
			}
					
			}
			
			//ultimate attack button
			
			if(e.getActionCommand().equals("ULTIMATE ATTACK"))
			{
				
				String[] btuatt = new String [gameModel.getPlayer().getActiveFighter().getUltimateAttacks().size()];
				
				for (int i = 0; i < btuatt.length; i++) {
					
					btuatt[i] = gameModel.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName();
				}
				
				JComboBox<String> battleult = new JComboBox<String>(btuatt);
				String[] options3 = {"OK"};
				
				
				if((battleult.getSelectedIndex()==-1))
				{
					JOptionPane.showMessageDialog(gameView, "NO ULTIMATE ATTACK FOUND!");
				}
				else
				{
					
					JOptionPane.showOptionDialog(gameView, battleult,"Choose Ultimate Attack" ,JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,options3, null);
					
					if((battleult.getSelectedItem().equals("Super Saiyan")) &&  (gameModel.getPlayer().getActiveFighter().getKi() >= 3))
					{
						JOptionPane.showMessageDialog(gameView, "YOU ARE TRANSFORMED!!");
					}
					
					try {
						battleView.battle.attack(gameModel.getPlayer().getActiveFighter().getUltimateAttacks().get(battleult.getSelectedIndex()));
						
					} catch (NotEnoughKiException e1) {
						JOptionPane.showMessageDialog(gameView, "Not Enough Ki");
					}
					
				}					
			}
			
			
			//DRAGON VIEW
			
			if(e.getActionCommand().equals("CHOOSE SENZU BEANS"))
			{
				JOptionPane.showMessageDialog(gameView, "You Chose Senzu Beans");
				
				gameModel.getPlayer().chooseWish(wisher.getWishes()[0]);
				assignAttributes();
				
				gameView.remove(dragonView);
				gameView.add(worldView);
				gameView.revalidate();
				gameView.repaint();
				
			}
			if(e.getActionCommand().equals("CHOOSE ABILITY POINTS"))
			{
				JOptionPane.showMessageDialog(gameView, "You Chose Abiity Points");
				
				gameModel.getPlayer().chooseWish(wisher.getWishes()[1]);
				assignAttributes();
				
				gameView.remove(dragonView);
				gameView.add(worldView);
				gameView.revalidate();
				gameView.repaint();
			}
			if(e.getActionCommand().equals("CHOOSE SUPER ATTACK"))
			{
				JOptionPane.showMessageDialog(gameView, "You Chose Super Attack");
				
				gameModel.getPlayer().chooseWish(wisher.getWishes()[2]);
				assignAttributes();
				
				gameView.remove(dragonView);
				gameView.add(worldView);
				gameView.revalidate();
				gameView.repaint();
			}
			if(e.getActionCommand().equals("CHOOSE ULTIMATE ATTACK"))
			{
				JOptionPane.showMessageDialog(gameView, "You Chose Ultimate Attack");
				
				gameModel.getPlayer().chooseWish(wisher.getWishes()[3]);
				assignAttributes();
				
				gameView.remove(dragonView);
				gameView.add(worldView);
				gameView.revalidate();
				gameView.repaint();
			}
				worldView.requestFocusInWindow();
			
						
			}
		
		//-----------------------------------------//
		
	

	@Override
	public void onDragonCalled(Dragon dragon) {
		
		JOptionPane.showMessageDialog(gameView, "You Have Summoned A Dragon!");
		
		gameView.remove(worldView);
		gameView.add(dragonView);
		gameView.repaint();
		gameView.revalidate();

		wisher = dragon;
		
		dragonView.draginfo.setText("- Dragon:  " + wisher.getName() + "\n" + wisher.getSenzuBeans() + "  SENZU BEANS\n"
				+ wisher.getAbilityPoints() + "  ABILITY POINTS\n" + "- SUPER ATTACKS: \n" + wisher.getSuperAttacks().get(0).getName() + " , "
				+ wisher.getSuperAttacks().get(1).getName() + " , " + wisher.getSuperAttacks().get(2).getName() + " , " + wisher.getSuperAttacks().get(3).getName() 
				+ "\n" + "- ULTIMATE ATTACKS: \n" + wisher.getUltimateAttacks().get(0).getName() + " , " +  wisher.getUltimateAttacks().get(1).getName()+ " , " 
				+ wisher.getUltimateAttacks().get(2).getName() + " , " + wisher.getUltimateAttacks().get(3).getName());
		

	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		if(collectible == Collectible.SENZU_BEAN)
		{
			JOptionPane.showMessageDialog(gameView, "You Found A Senzu Bean!");
			worldView.senzu.setText("" + gameModel.getPlayer().getSenzuBeans() );
		}
		
		if(collectible == Collectible.DRAGON_BALL)
		{
			JOptionPane.showMessageDialog(gameView, "You Found A DragonBall!");
			worldView.dragon.setText("" + gameModel.getPlayer().getDragonBalls() );
		}
		
		
		
		
	}
	int oldlvl ;
	int oldap ;


	@Override
	public void onBattleEvent(BattleEvent e) {
		
		//Found a foe : 
		
		// Battle :
		
		battleView.setBattle((Battle) e.getSource());	

		Fighter attacker = (Fighter) battleView.battle.getAttacker();
				
		//handle events
		
		if(e.getType().equals(BattleEventType.STARTED))
		{
			oldlvl =  gameModel.getPlayer().getActiveFighter().getLevel();
			oldap= gameModel.getPlayer().getActiveFighter().getAbilityPoints();
			
			JOptionPane.showMessageDialog(gameView,"LET THE BATTLE BEGIN!");
			
			gameView.remove(worldView);
			gameView.add(battleView);
			
			updateinfo(battleView.battle);
			gameView.repaint();
			gameView.revalidate();
		
		}
		
		if(e.getType().equals(BattleEventType.BLOCK))
		{
			
			JOptionPane.showMessageDialog(gameView, attacker.getName() + "   BLOCKED!");
			
			updateinfo(battleView.battle);
		}
		
		if(e.getType().equals(BattleEventType.USE))
		{
			JOptionPane.showMessageDialog(gameView, attacker.getName() + "   USED A SENZU BEAN!");
			
			updateinfo(battleView.battle);
		}
		
		if(e.getType().equals(BattleEventType.ATTACK))
		{
			JOptionPane.showMessageDialog(gameView, attacker.getName() + "   IS ATTACKING");
			updateinfo(battleView.battle);	
		}
		if(e.getType().equals(BattleEventType.NEW_TURN))
		{			
		
			if(battleView.battle.getAttacker()==battleView.battle.getFoe())
			{
				NonPlayableFighter foe = (NonPlayableFighter) battleView.battle.getFoe();
				
				battleView.turnlabel.setText(foe.getName());
				
				try {
					//System.out.println("HI");
					battleView.battle.play();
					//System.out.println("HI");
				} catch (NotEnoughKiException e1) {
					//JOptionPane.showMessageDialog(gameView, "Not Enough Ki");
					battleView.battle.block();
				}
				
			} else
			{
				if(battleView.battle.getAttacker()==battleView.battle.getMe())
				{
					PlayableFighter me = (PlayableFighter) battleView.battle.getMe();
					
					battleView.turnlabel.setText(me.getName());
				}
				
			}
			
			updateinfo(battleView.battle);
					
		}
		
//		int oldlvl = gameModel.getPlayer().getActiveFighter().getLevel();
//		int oldap = gameModel.getPlayer().getActiveFighter().getAbilityPoints();
		
		if(e.getType().equals(BattleEventType.ENDED))
		{
			//TODO
			BattleOpponent me =  battleView.battle.getMe();
			BattleOpponent foe =  battleView.battle.getFoe();
			NonPlayableFighter ff = (NonPlayableFighter) battleView.battle.getFoe(); 
			if(e.getWinner() == me)
			{
				
				
				JOptionPane.showMessageDialog(gameView, "YOU WON!");
				
				if(ff.isStrong() == true)
				{
				 resetPosition();
					JOptionPane.showMessageDialog(gameView, "YOU HAVE DEFEATED THE BOSS!");
					
				}
				else
				{
					if(ff.isStrong() == false)
					{
						resetPosition();
						worldView.grid[rowx][coly].setText("PLAYER");
						worldView.grid[rowx][coly].setBackground(Color.GREEN);
					}
				}
				JOptionPane.showMessageDialog(gameView, "updated XP: \n" + gameModel.getPlayer().getActiveFighter().getXp() 
						+ "\n" +"Gained Skills: " + gainedSkills(battleView.battle));
				
				int newlvl = gameModel.getPlayer().getActiveFighter().getLevel();
				int newap= gameModel.getPlayer().getActiveFighter().getAbilityPoints();
				
				if( newlvl > oldlvl  )
				{
					JOptionPane.showMessageDialog(gameView, "YOU LEVELED UP!");
					JOptionPane.showMessageDialog(gameView, "New Level: " + newlvl + "\n" +
					"Target XP:" + gameModel.getPlayer().getActiveFighter().getTargetXp()+
					"\n" + "Gained Abilty points: " + (newap-oldap));
					
					gameView.revalidate();
					gameView.repaint();
				}
				
			}
			else
			{
				if(e.getWinner() == foe)
				{
				JOptionPane.showMessageDialog(gameView, "YOU LOST!");	
				resetPosition();

				}
			}
			
			
			assignAttributes();
			gameView.remove(battleView);
			gameView.add(worldView);
			worldView.requestFocusInWindow();
			gameView.repaint();
			gameView.revalidate();
			
		}
		
		
		
		
		
		
		
	}
	
	public String gainedSkills(Battle battle){
		
		NonPlayableFighter foe = (NonPlayableFighter) battle.getFoe(); 
		String attacks = "";
		
		for(int i=0 ; i <(foe.getSuperAttacks().size()); i++)
		{
			attacks= attacks+ foe.getSuperAttacks().get(i).getName() + " ";
			
		}
		
		
		for (int i = 0; i < foe.getUltimateAttacks().size(); i++)
		{
			attacks = attacks + foe.getUltimateAttacks().get(i).getName() + " ";
		}
		return attacks;
	}
	
	
	
	
	
	public void resetPosition()
	{
		worldView.grid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
		worldView.grid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
		
		worldView.grid[rowx][coly].setText("");
		worldView.grid[rowx][coly].setBackground(Color.LIGHT_GRAY);
		
		worldView.grid[0][0].setText("BOSS");
		worldView.grid[0][0].setBackground(Color.RED);
		
		gameView.repaint();
		gameView.revalidate();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	
	JButton [][] mapgrid= worldView.grid;
	
	//Move left
	
	if(e.getKeyCode()==37)
	{
		
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.lightGray);
			try{
			gameModel.getWorld().moveLeft();
			System.out.println(gameModel.getWorld().getPlayerRow() + "&" + gameModel.getWorld().getPlayerColumn());
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
			}
			catch(MapIndexOutOfBoundsException exp){
				
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
				
			}
			
			gameView.repaint();
			gameView.revalidate();
			
	
	}
	
	
	//Move up
	
	if(e.getKeyCode()==38)
	{
		
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.lightGray);
			try{
			gameModel.getWorld().moveUp();
			System.out.println(gameModel.getWorld().getPlayerRow() + "&" + gameModel.getWorld().getPlayerColumn());
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
			}
			catch(MapIndexOutOfBoundsException exp){
				
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
				
			}
			
			gameView.repaint();
			gameView.revalidate();
			
	
	}
	
	//Move right
	
	if(e.getKeyCode()==39)
	{
		
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.lightGray);
			try{
			gameModel.getWorld().moveRight();
			System.out.println(gameModel.getWorld().getPlayerRow() + "&" + gameModel.getWorld().getPlayerColumn());
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
			}
			catch(MapIndexOutOfBoundsException exp){
				
				mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
				mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
				
			}
			
			gameView.repaint();
			gameView.revalidate();
			
	
	}
	
	//Move Down:
	
	if(e.getKeyCode()==40)
	{
		
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.lightGray);
			try{
			gameModel.getWorld().moveDown();
			System.out.println(gameModel.getWorld().getPlayerRow() + "&" + gameModel.getWorld().getPlayerColumn());
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
			mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
			}
			catch(MapIndexOutOfBoundsException exp){
				
				mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setText("PLAYER");
				mapgrid[gameModel.getWorld().getPlayerRow()][gameModel.getWorld().getPlayerColumn()].setBackground(Color.GREEN);
				
			}
			
		gameView.repaint();
		gameView.revalidate();
			
	
	}
	
	rowx = gameModel.getWorld().getPlayerRow();
	coly = gameModel.getWorld().getPlayerColumn();
	
	gameView.repaint();
	gameView.revalidate();
}



	
	
	
	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	
	//add info of fighter to world view:

	public void assignAttributes(){
		
		int level = gameModel.getPlayer().getActiveFighter().getLevel();
		int sbz = gameModel.getPlayer().getSenzuBeans();
		int dbz = gameModel.getPlayer().getDragonBalls();
		int maxhpts = gameModel.getPlayer().getActiveFighter().getMaxHealthPoints();
		int pdg =	gameModel.getPlayer().getActiveFighter().getPhysicalDamage();
		int bdg =	gameModel.getPlayer().getActiveFighter().getBlastDamage();
		int mki =	gameModel.getPlayer().getActiveFighter().getMaxKi();
		int mstm =	gameModel.getPlayer().getActiveFighter().getMaxStamina();
		int ab =	gameModel.getPlayer().getActiveFighter().getAbilityPoints();
		String plname = newgameView.playername.getText();
		String fightname = newgameView.fightername.getText();
		
		worldView.plname.setText(plname);
		worldView.fightname.setText(fightname);
		worldView.lvl.setText("" + level);
		worldView.senzu.setText(""+ sbz);
		worldView.dragon.setText(""+ dbz);
		worldView.maxhp.setText(""+maxhpts);
		worldView.phydmg.setText(""+ pdg);
		worldView.blastdmg.setText("" + bdg);
		worldView.maxki.setText(""+ mki);
		worldView.maxst.setText(""+ mstm);
		worldView.abtpts.setText(""+ab);
	}
	
	//update info of me and foe in battle
	
	public void updateinfo(Battle battle)
	{
		PlayableFighter me = (PlayableFighter) battle.getMe();
		NonPlayableFighter foe = (NonPlayableFighter) battle.getFoe();
		
		
		//Me data : 
		battleView.nmf.setText(me.getName());
		battleView.lvlf.setText("" +me.getLevel());
		battleView.hpf.setText("" +me.getHealthPoints());
		battleView.mhpf.setText("" +me.getMaxHealthPoints());
		battleView.kif.setText("" +me.getKi());
		battleView.mkif.setText("" +me.getMaxKi());
		battleView.stf.setText("" +me.getStamina());
		battleView.mstf.setText("" +me.getMaxStamina());
		
		//Foe data :
		
		battleView.nmf2.setText(foe.getName());
		battleView.lvlf2.setText("" +foe.getLevel());
		battleView.hpf2.setText("" +foe.getHealthPoints());
		battleView.mhpf2.setText("" +foe.getMaxHealthPoints());
		battleView.kif2.setText("" +foe.getKi());
		battleView.mkif2.setText("" +foe.getMaxKi());
		battleView.stf2.setText("" +foe.getStamina());
		battleView.mstf2.setText("" +foe.getMaxStamina());
	}
	
	@SuppressWarnings("unused")
	public static void main(String[]args)
	{
		GUI DragonBall = new GUI();
	}

}
