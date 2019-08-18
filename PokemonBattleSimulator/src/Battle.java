/*This class represents what is going on while the user sees
 * battling going on. It controls all of the damage and drawing
 * for pokemon and drawing of moves
 * 
 * 
 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Battle extends JPanel implements ActionListener, MouseListener{
	
	Image red;
	Image blue;
	Font vs, turn, REGULAR, console;
	Timer clock;
	boolean isPlayer1Turn;
	int pl1PokeNum;
	int pl2PokeNum;
	JFrame w;
	
	BattlePokemon pl11;
	BattlePokemon pl12;
	BattlePokemon pl13;
	BattlePokemon pl21;
	BattlePokemon pl22;
	BattlePokemon pl23;
	
	String consoleText;
	String damageText;
	
	BattlePokemon atkPkmn, defPkmn;

	
	
	public Battle(JFrame w) {
		super();
		this.w = w;
		consoleText = "Choose your move by clicking!";
		damageText = "";
		pl11= new BattlePokemon(TeamPicker.getPlayer11());
		pl12= new BattlePokemon(TeamPicker.getPlayer12());
		pl13= new BattlePokemon(TeamPicker.getPlayer13());
		pl21= new BattlePokemon(TeamPicker2.getPlayer21());
		pl22= new BattlePokemon(TeamPicker2.getPlayer22());
		pl23= new BattlePokemon(TeamPicker2.getPlayer23());

		isPlayer1Turn =  true;
		pl1PokeNum = 1;
		pl2PokeNum = 1;
		setBackground(Color.WHITE);
		clock = new Timer(2000, this);
		clock.start();
		red = new ImageIcon("red.png").getImage();
		blue = new ImageIcon("blue.png").getImage();
		vs = new Font("Impact", Font.BOLD, 100);
		turn = new Font("Lucida Console", Font.BOLD, 50);
		REGULAR = new Font("Lucida Console", Font.BOLD, 40);
		console = new Font("Lucida Console", Font.BOLD, 20);

	}
	
	public void paintComponent(Graphics g) {
		/*
		g.drawString(pl11.getName(), 100, 100);
		g.drawString(pl12.getName(), 100, 110);

		g.drawString(pl13.getName(), 100, 120);

		g.drawString(pl21.getName(), 100, 130);
		g.drawString(pl22.getName(), 100, 140);
		g.drawString(pl23.getName(), 100, 150);
		*/
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

    	g2.scale(getWidth()/1920.0, getHeight()/1080.0);		
		
		if(clock.isRunning()) {
			
			//drawing the initial viewer for showing who is battling
			g2.setStroke(new BasicStroke(5));
			g.drawLine(960, 0, 960, 1080);
			
			g.drawImage(red, 100,100, 300, 700, this);
			g.drawImage(blue, 1360, 100, 400, 700, this);
			g.setFont(vs);
			g.drawString("VS", 900, 520);
			
			g.drawImage(pl11.getPokeImage(), 500,0,300,300, this);
			g.drawImage(pl12.getPokeImage(), 500,350,300,300, this);
			g.drawImage(pl13.getPokeImage(), 500,700,300,300, this);
			g.drawImage(pl21.getPokeImage(), 1100, 0,300,300, this);
			g.drawImage(pl22.getPokeImage(), 1100,350,300,300, this);
			g.drawImage(pl23.getPokeImage(), 1100,700,300,300, this);


		}else {
			super.paintComponent(g);
			g2.setStroke(new BasicStroke(3));
			g.drawLine(0, 700, 1920, 700);
			g.drawImage(red, 0, 250, 200, 400, this);
			g.drawImage(blue, 1720, 250, 200,400, this);
			g2.setStroke(new BasicStroke(1));
			g.drawRect(0, 700, 500,  75);
			g.setFont(turn);
			if(isPlayer1Turn) {
				g.drawString("Player 1's turn", 0, 750);
			}else {
				g.drawString("Player 2's turn", 0, 750);
			}
			g2.setStroke(new BasicStroke(3));
			g.drawRect(500, 700, 1420, 320);
			g.drawLine(1210, 700, 1210, 1020);
			g.drawLine(500, 860, 1920, 860);
			g.setFont(console);
			g.drawString(consoleText, 0, 900);
			g.drawString(damageText, 0, 950);
			
			//drawing moves
			g.setFont(REGULAR);
			if(isPlayer1Turn) {
				if(pl1PokeNum == 1) {
					g.setColor(Color.BLUE);

					g.drawString(pl11.getMove1().getName(), 520, 825);
					g.drawString(pl11.getMove2().getName(), 520, 975);
					g.drawString(pl11.getMove3().getName(), 1220, 825);
					g.drawString(pl11.getMove4().getName(), 1220, 975);

					g.setColor(Color.BLACK);
					g.drawString(pl11.getMove1().getType() + "," + pl11.getMove1().getAccuracy() + "%", 520, 775);
					g.drawString(pl11.getMove2().getType() + "," + pl11.getMove2().getAccuracy() + "%", 520, 925);
					g.drawString(pl11.getMove3().getType() + "," + pl11.getMove3().getAccuracy() + "%", 1220, 775);
					g.drawString(pl11.getMove4().getType() + "," + pl11.getMove4().getAccuracy() + "%", 1220, 925);
					
					g.setColor(Color.RED);
					g.drawString("Damage: " + pl11.getMove1().getDamage(), 900, 825);
					g.drawString("Damage: " + pl11.getMove2().getDamage(), 900, 975);
					g.drawString("Damage: " + pl11.getMove3().getDamage(), 1600, 825);
					g.drawString("Damage: " + pl11.getMove4().getDamage(), 1600, 975);
					
					g.setColor(Color.cyan);
					
					
					

				}else if(pl1PokeNum ==2) {
					g.setColor(Color.BLUE);

					g.drawString(pl12.getMove1().getName(), 520, 825);
					g.drawString(pl12.getMove2().getName(), 520, 975);
					g.drawString(pl12.getMove3().getName(), 1220, 825);
					g.drawString(pl12.getMove4().getName(), 1220, 975);

					g.setColor(Color.BLACK);
					g.drawString(pl12.getMove1().getType() + "," + pl11.getMove1().getAccuracy() + "%", 520, 775);
					g.drawString(pl12.getMove2().getType() + "," + pl11.getMove2().getAccuracy() + "%", 520, 925);
					g.drawString(pl12.getMove3().getType() + "," + pl11.getMove3().getAccuracy() + "%", 1220, 775);
					g.drawString(pl12.getMove4().getType() + "," + pl11.getMove4().getAccuracy() + "%", 1220, 925);
					
					g.setColor(Color.RED);
					g.drawString("Damage: " + pl12.getMove1().getDamage(), 900, 825);
					g.drawString("Damage: " + pl12.getMove2().getDamage(), 900, 975);
					g.drawString("Damage: " + pl12.getMove3().getDamage(), 1600, 825);
					g.drawString("Damage: " + pl12.getMove4().getDamage(), 1600, 975);
				}else if(pl1PokeNum == 3) {
					g.setColor(Color.BLUE);

					g.drawString(pl13.getMove1().getName(), 520, 825);
					g.drawString(pl13.getMove2().getName(), 520, 975);
					g.drawString(pl13.getMove3().getName(), 1220, 825);
					g.drawString(pl13.getMove4().getName(), 1220, 975);
					
					g.setColor(Color.BLACK);
					g.drawString(pl13.getMove1().getType() + "," + pl11.getMove1().getAccuracy() + "%", 520, 775);
					g.drawString(pl13.getMove2().getType() + "," + pl11.getMove2().getAccuracy() + "%", 520, 925);
					g.drawString(pl13.getMove3().getType() + "," + pl11.getMove3().getAccuracy() + "%", 1220, 775);
					g.drawString(pl13.getMove4().getType() + "," + pl11.getMove4().getAccuracy() + "%", 1220, 925);
					
					g.setColor(Color.RED);
					g.drawString("Damage: " + pl13.getMove1().getDamage(), 900, 825);
					g.drawString("Damage: " + pl13.getMove2().getDamage(), 900, 975);
					g.drawString("Damage: " + pl13.getMove3().getDamage(), 1600, 825);
					g.drawString("Damage: " + pl13.getMove4().getDamage(), 1600, 975);
				}
			}else {
				if(pl2PokeNum == 1) {
					g.setColor(Color.BLUE);

					g.drawString(pl21.getMove1().getName(), 520, 825);
					g.drawString(pl21.getMove2().getName(), 520, 975);
					g.drawString(pl21.getMove3().getName(), 1220, 825);
					g.drawString(pl21.getMove4().getName(), 1220, 975);

					g.setColor(Color.BLACK);
					g.drawString(pl21.getMove1().getType() + "," + pl11.getMove1().getAccuracy() + "%", 520, 775);
					g.drawString(pl21.getMove2().getType() + "," + pl11.getMove2().getAccuracy() + "%", 520, 925);
					g.drawString(pl21.getMove3().getType() + "," + pl11.getMove3().getAccuracy() + "%", 1220, 775);
					g.drawString(pl21.getMove4().getType() + "," + pl11.getMove4().getAccuracy() + "%", 1220, 925);
					
					g.setColor(Color.RED);
					g.drawString("Damage: " + pl21.getMove1().getDamage(), 900, 825);
					g.drawString("Damage: " + pl21.getMove2().getDamage(), 900, 975);
					g.drawString("Damage: " + pl21.getMove3().getDamage(), 1600, 825);
					g.drawString("Damage: " + pl21.getMove4().getDamage(), 1600, 975);

					

				}else if(pl2PokeNum ==2) {
					g.setColor(Color.BLUE);

					g.drawString(pl22.getMove1().getName(), 520, 825);
					g.drawString(pl22.getMove2().getName(), 520, 975);
					g.drawString(pl22.getMove3().getName(), 1220, 825);
					g.drawString(pl22.getMove4().getName(), 1220, 975);

					g.setColor(Color.BLACK);
					g.drawString(pl22.getMove1().getType() + "," + pl11.getMove1().getAccuracy() + "%", 520, 775);
					g.drawString(pl22.getMove2().getType() + "," + pl11.getMove2().getAccuracy() + "%", 520, 925);
					g.drawString(pl22.getMove3().getType() + "," + pl11.getMove3().getAccuracy() + "%", 1220, 775);
					g.drawString(pl22.getMove4().getType() + "," + pl11.getMove4().getAccuracy() + "%", 1220, 925);
					
					g.setColor(Color.red);
					g.drawString("Damage: " + pl22.getMove1().getDamage(), 900, 825);
					g.drawString("Damage: " + pl22.getMove2().getDamage(), 900, 975);
					g.drawString("Damage: " + pl22.getMove3().getDamage(), 1600, 825);
					g.drawString("Damage: " + pl22.getMove4().getDamage(), 1600, 975);
				}else if(pl2PokeNum == 3) {
					g.setColor(Color.BLUE);

					g.drawString(pl23.getMove1().getName(), 520, 825);
					g.drawString(pl23.getMove2().getName(), 520, 975);
					g.drawString(pl23.getMove3().getName(), 1220, 825);
					g.drawString(pl23.getMove4().getName(), 1220, 975);
					
					g.setColor(Color.BLACK);
					g.drawString(pl23.getMove1().getType() + "," + pl11.getMove1().getAccuracy() + "%", 520, 775);
					g.drawString(pl23.getMove2().getType() + "," + pl11.getMove2().getAccuracy() + "%", 520, 925);
					g.drawString(pl23.getMove3().getType() + "," + pl11.getMove3().getAccuracy() + "%", 1220, 775);
					g.drawString(pl23.getMove4().getType() + "," + pl11.getMove4().getAccuracy() + "%", 1220, 925);
					
					g.setColor(Color.red);
					g.drawString("Damage: " + pl23.getMove1().getDamage(), 900, 825);
					g.drawString("Damage: " + pl23.getMove2().getDamage(), 900, 975);
					g.drawString("Damage: " + pl23.getMove3().getDamage(), 1600, 825);
					g.drawString("Damage: " + pl23.getMove4().getDamage(), 1600, 975);
				}    
			}
			
			g.setColor(Color.BLACK);
			
			g.drawString("Note that the percent sign is the accuracy", 400, 1060);
			
			
			//drawing the team
			
			
			
			
			g.drawImage(pl11.getPokeImage(), 0, 0, 100, 100, this);
			g.drawImage(pl12.getPokeImage(), 0, 110, 100, 100, this);
			g.drawImage(pl13.getPokeImage(), 110, 0, 100, 100, this);
			g.drawImage(pl21.getPokeImage(), 1710, 0, 100, 100, this);
			g.drawImage(pl22.getPokeImage(), 1820, 0, 100, 100, this);
			g.drawImage(pl23.getPokeImage(), 1820, 110, 100, 100, this);
			
			
			Image bigx = new ImageIcon("bigx.png").getImage();
			if(pl11.getIsDead()) {
				g.drawImage(bigx, 0, 0, 100, 100, this);

			}
			if(pl12.getIsDead()) {
				g.drawImage(bigx, 0, 110, 100, 100, this);

			}
			if(pl13.getIsDead()) {
				g.drawImage(bigx, 110, 0, 100, 100, this);

			}
			if(pl21.getIsDead()) {
				g.drawImage(bigx, 1710, 0, 100, 100, this);

			}
			if(pl22.getIsDead()) {
				g.drawImage(bigx, 1820, 0, 100, 100, this);

			}
			if(pl23.getIsDead()) {
				g.drawImage(bigx, 1820, 110, 100, 100, this);

			}
			

			
			
			
			//drawing the battle pokemon
			if(pl1PokeNum == 1) {
				pl11.draw(250, 300, 400, 400, g, this);
			}else if(pl1PokeNum == 2) {
				pl12.draw(250, 300, 400, 400, g, this);
			}else if(pl1PokeNum == 3) {
				pl13.draw(250, 300, 400, 400, g, this);

			}
			
			if(pl2PokeNum == 1) {
				pl21.draw(1250, 300, 400, 400, g, this);
			}else if(pl2PokeNum == 2) {
				pl22.draw(1250, 300, 400, 400, g, this);
			}else if(pl2PokeNum == 3) {
				pl23.draw(1250, 300, 400, 400, g, this);

			}
			
			
			//drawing HP
			g.setColor(Color.MAGENTA);
			if(pl1PokeNum == 1) {
				g.drawString("HP: " + pl11.getCurrentHP(), 300, 100);
			}else if(pl1PokeNum == 2) {
				g.drawString("HP: " + pl12.getCurrentHP(), 300, 100);
			}else if(pl1PokeNum == 3) {
				g.drawString("HP: " + pl13.getCurrentHP(), 300, 100);

			}
			
			if(pl2PokeNum == 1) {
				g.drawString("HP: " + pl21.getCurrentHP(), 1350, 100);
			}else if(pl2PokeNum == 2) {
				g.drawString("HP: " + pl22.getCurrentHP(), 1350, 100);
			}else if(pl2PokeNum == 3) {
				g.drawString("HP: " + pl23.getCurrentHP(), 1350, 100);

			}
			
			//for winner and loser
			
			
			if(pl1PokeNum == 4) {
				
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				w.dispose();
				Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

				JFrame w = new JFrame("BATTLE");
			    w.setBounds(0, 0, screensize.width, screensize.height);
			    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    Win panel = new Win(w, false);
			    w.add(panel);
			    w.setResizable(true);
			    w.setVisible(true);
				
			}
			if(pl2PokeNum == 4) {
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				w.dispose();
				Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

				JFrame w = new JFrame("BATTLE");
			    w.setBounds(0, 0, screensize.width, screensize.height);
			    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    Win panel = new Win(w, true);
			    w.add(panel);
			    w.setResizable(true);
			    w.setVisible(true);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			//drawing whether it is super effective
			
			
			if(isPlayer1Turn) {
				
				
				if(pl1PokeNum == 1 && pl2PokeNum == 1) {
					atkPkmn = pl11;
					defPkmn = pl21;
					
			
				}else if(pl1PokeNum == 1 && pl2PokeNum == 2) {
					atkPkmn = pl11;
					defPkmn = pl22;
					
			
				}else if(pl1PokeNum == 1 && pl2PokeNum == 3) {
					atkPkmn = pl11;
					defPkmn = pl23;
					
			
				}else if(pl1PokeNum == 2 && pl2PokeNum == 1) {
					atkPkmn = pl12;
					defPkmn = pl21;
					
			
				}else if(pl1PokeNum == 2 && pl2PokeNum == 2) {
					atkPkmn = pl12;
					defPkmn = pl22;
					
			
				}else if(pl1PokeNum == 2 && pl2PokeNum == 3) {
					atkPkmn = pl12;
					defPkmn = pl23;
					
			
				}else if(pl1PokeNum == 3 && pl2PokeNum == 1) {
					atkPkmn = pl13;
					defPkmn = pl21;
					
			
				}else if(pl1PokeNum == 3 && pl2PokeNum == 2) {
					atkPkmn = pl13;
					defPkmn = pl22;
					
			
				}else if(pl1PokeNum == 3 && pl2PokeNum == 3) {
					atkPkmn = pl13;
					defPkmn = pl23;
					
			
				}
						
				
					
			}else {
				if(pl1PokeNum == 1 && pl2PokeNum == 1) {
					defPkmn = pl11;
					atkPkmn = pl21;
					
			
				}else if(pl1PokeNum == 1 && pl2PokeNum == 2) {
					defPkmn = pl11;
					atkPkmn = pl22;
					
			
				}else if(pl1PokeNum == 1 && pl2PokeNum == 3) {
					defPkmn = pl11;
					atkPkmn = pl23;
					
			
				}else if(pl1PokeNum == 2 && pl2PokeNum == 1) {
					defPkmn = pl12;
					atkPkmn = pl21;
					
			
				}else if(pl1PokeNum == 2 && pl2PokeNum == 2) {
					defPkmn = pl12;
					atkPkmn = pl22;
					
			
				}else if(pl1PokeNum == 2 && pl2PokeNum == 3) {
					defPkmn = pl12;
					atkPkmn = pl23;
					
			
				}else if(pl1PokeNum == 3 && pl2PokeNum == 1) {
					defPkmn = pl13;
					atkPkmn = pl21;
					
			
				}else if(pl1PokeNum == 3 && pl2PokeNum == 2) {
					defPkmn = pl13;
					atkPkmn = pl22;
					
			
				}else if(pl1PokeNum == 3 && pl2PokeNum == 3) {
					defPkmn = pl13;
					atkPkmn = pl23;
					
			
				}
			}
			
			//move 1
			
			if(defPkmn.getType2() == null) {
				if(ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType()) == 2.0 || ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType()) == 4.0) {
					g.setColor(Color.GREEN);
					g.drawString("STRONG", 900, 775);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType())  == .5 || ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType())== .25) {
					g.setColor(Color.RED);
					g.drawString("WEAK", 900, 775);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType())  == 1)  {
					g.setColor(Color.PINK);
					g.drawString("REGULAR", 900, 775);
				}else {
					g.setColor(Color.BLACK);
					g.drawString("NO EFFECT", 900, 775);
				}
			
			}else {
				if(ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType()) * ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType2()) == 2.0 || ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType()) * ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType2()) == 4.0) {
					g.setColor(Color.GREEN);
					g.drawString("STRONG", 900, 775);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType2()) == .5 || ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType2())== .25) {
					g.setColor(Color.RED);
					g.drawString("WEAK", 900, 775);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove1().getType(), defPkmn.getType2()) == 1)  {
					g.setColor(Color.PINK);
					g.drawString("REGULAR", 900, 775);
				}else {
					g.setColor(Color.BLACK);
					g.drawString("NO EFFECT", 900, 775);
				}
			}
			
			
			//move 2
			if(defPkmn.getType2() == null) {
				if(ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType()) == 2.0 || ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType()) == 4.0) {
					g.setColor(Color.GREEN);
					g.drawString("STRONG", 900, 925);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType())  == .5 || ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType())== .25) {
					g.setColor(Color.RED);
					g.drawString("WEAK", 900, 925);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType())  == 1)  {
					g.setColor(Color.PINK);
					g.drawString("REGULAR", 900, 925);
				}else {
					g.setColor(Color.BLACK);
					g.drawString("NO EFFECT", 900, 925);
				}
			
			}else {
				if(ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType()) * ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType2()) == 2.0 || ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType()) * ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType2()) == 4.0) {
					g.setColor(Color.GREEN);
					g.drawString("STRONG", 900, 925);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType2()) == .5 || ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType2())== .25) {
					g.setColor(Color.RED);
					g.drawString("WEAK", 900, 925);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove2().getType(), defPkmn.getType2()) == 1)  {
					g.setColor(Color.PINK);
					g.drawString("REGULAR", 900, 925);
				}else {
					g.setColor(Color.BLACK);
					g.drawString("NO EFFECT", 900, 925);
				}
			}
			//move 3
			if(defPkmn.getType2() == null) {
				if(ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType()) == 2.0 || ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType()) == 4.0) {
					g.setColor(Color.GREEN);
					g.drawString("STRONG", 1600, 775);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType())  == .5 || ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType())== .25) {
					g.setColor(Color.RED);
					g.drawString("WEAK", 1600, 775);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType())  == 1)  {
					g.setColor(Color.PINK);
					g.drawString("REGULAR", 1600, 775);
				}else {
					g.setColor(Color.BLACK);
					g.drawString("NO EFFECT", 1600, 775);
				}
			
			}else {
				if(ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType()) * ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType2()) == 2.0 || ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType()) * ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType2()) == 4.0) {
					g.setColor(Color.GREEN);
					g.drawString("STRONG", 1600, 775);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType2()) == .5 || ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType2())== .25) {
					g.setColor(Color.RED);
					g.drawString("WEAK", 1600, 775);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove3().getType(), defPkmn.getType2()) == 1)  {
					g.setColor(Color.PINK);
					g.drawString("REGULAR", 1600, 775);
				}else {
					g.setColor(Color.BLACK);
					g.drawString("NO EFFECT", 1600, 775);
				}
			}

			//move 4
			
			if(defPkmn.getType2() == null) {
				if(ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType()) == 2.0 || ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType()) == 4.0) {
					g.setColor(Color.GREEN);
					g.drawString("STRONG", 1600, 925);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType())  == .5 || ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType())== .25) {
					g.setColor(Color.RED);
					g.drawString("WEAK", 1600, 925);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType())  == 1)  {
					g.setColor(Color.PINK);
					g.drawString("REGULAR", 1600, 925);
				}else {
					g.setColor(Color.BLACK);
					g.drawString("NO EFFECT", 1600, 925);
				}
			
			}else {
				if(ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType()) * ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType2()) == 2.0 || ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType()) * ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType2()) == 4.0) {
					g.setColor(Color.GREEN);
					g.drawString("STRONG", 1600, 925);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType2()) == .5 || ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType2())== .25) {
					g.setColor(Color.RED);
					g.drawString("WEAK", 1600, 925);
				}else if(ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType())  * ToolBox.getTypeBonus(atkPkmn.getMove4().getType(), defPkmn.getType2()) == 1)  {
					g.setColor(Color.PINK);
					g.drawString("REGULAR", 1600, 925);
				}else {
					g.setColor(Color.BLACK);
					g.drawString("NO EFFECT", 1600, 925);
				}
			}
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getConsoleText(BattlePokemon atkPkmn, PokemonMove move) {
		return atkPkmn.getName() + " used " + move.getName() ;
		
	}
	
	
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		//checking whether the user clicked a move
		if(mouseX>500 && mouseX<1210 && mouseY>700 && mouseY<860) {
			if(isPlayer1Turn) {
				if(pl1PokeNum == 1) {
					if(pl2PokeNum == 1) {
						damagePoke(pl11.getMove1(), pl21, pl11);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl11.getMove1(), pl22, pl11);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl11.getMove1(), pl23, pl11);

					}
				}else if(pl1PokeNum == 2) {
					if(pl2PokeNum == 1) {
						damagePoke(pl12.getMove1(), pl21, pl12);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl12.getMove1(), pl22, pl12);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl12.getMove1(), pl23, pl12);

					}
				}else if(pl1PokeNum == 3) {
					if(pl2PokeNum == 1) {
						damagePoke(pl13.getMove1(), pl21, pl13);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl13.getMove1(), pl22, pl13);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl13.getMove1(), pl23, pl13);

					}
				}
			}else {
				if(pl2PokeNum == 1) {
					if(pl1PokeNum == 1) {
						damagePoke(pl21.getMove1(), pl11, pl21);
					}else if(pl1PokeNum == 2) {
						damagePoke(pl21.getMove1(), pl12, pl21);

					}else if(pl1PokeNum == 3) {
						damagePoke(pl21.getMove1(), pl13, pl21);

					}
				}else if(pl2PokeNum == 2) {
					if(pl1PokeNum == 1) {
						damagePoke(pl22.getMove1(), pl11, pl22);
					}else if(pl1PokeNum == 2) {
						damagePoke(pl22.getMove1(), pl12, pl22);

					}else if(pl1PokeNum == 3) {
						damagePoke(pl22.getMove1(), pl13, pl22);

					}
				}else if(pl2PokeNum == 3) {
					if(pl1PokeNum == 1) {
						damagePoke(pl23.getMove1(), pl11, pl23);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl23.getMove1(), pl12, pl23);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl23.getMove1(), pl13, pl23);

					}
				}
			}
			
		}else if(mouseX>500 && mouseX<1210 && mouseY>860 && mouseY<1020) {
			if(isPlayer1Turn) {
				if(pl1PokeNum == 1) {
					if(pl2PokeNum == 1) {
						damagePoke(pl11.getMove2(), pl21, pl11);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl11.getMove2(), pl22, pl11);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl11.getMove2(), pl23, pl11);

					}
				}else if(pl1PokeNum == 2) {
					if(pl2PokeNum == 1) {
						damagePoke(pl12.getMove2(), pl21, pl12);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl12.getMove2(), pl22, pl12);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl12.getMove2(), pl23, pl12);

					}
				}else if(pl1PokeNum == 3) {
					if(pl2PokeNum == 1) {
						damagePoke(pl13.getMove2(), pl21, pl13);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl13.getMove2(), pl22, pl13);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl13.getMove2(), pl23, pl13);

					}
				}
			}else {
				if(pl2PokeNum == 1) {
					if(pl1PokeNum == 1) {
						damagePoke(pl21.getMove2(), pl11, pl21);
					}else if(pl1PokeNum == 2) {
						damagePoke(pl21.getMove2(), pl12, pl21);

					}else if(pl1PokeNum == 3) {
						damagePoke(pl21.getMove2(), pl13, pl21);

					}
				}else if(pl2PokeNum == 2) {
					if(pl1PokeNum == 1) {
						damagePoke(pl22.getMove2(), pl11, pl22);
					}else if(pl1PokeNum == 2) {
						damagePoke(pl22.getMove2(), pl12, pl22);

					}else if(pl1PokeNum == 3) {
						damagePoke(pl22.getMove2(), pl13, pl22);

					}
				}else if(pl2PokeNum == 3) {
					if(pl1PokeNum == 1) {
						damagePoke(pl23.getMove2(), pl11, pl23);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl23.getMove2(), pl12, pl23);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl23.getMove2(), pl13, pl23);

					}
				}
			}

			
		}else if(mouseX>1210&& mouseX<1920 && mouseY>700 && mouseY<860) {
			if(isPlayer1Turn) {
				if(pl1PokeNum == 1) {
					if(pl2PokeNum == 1) {
						damagePoke(pl11.getMove3(), pl21, pl11);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl11.getMove3(), pl22, pl11);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl11.getMove3(), pl23, pl11);

					}
				}else if(pl1PokeNum == 2) {
					if(pl2PokeNum == 1) {
						damagePoke(pl12.getMove3(), pl21, pl12);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl12.getMove3(), pl22, pl12);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl12.getMove3(), pl23, pl12);

					}
				}else if(pl1PokeNum == 3) {
					if(pl2PokeNum == 1) {
						damagePoke(pl13.getMove3(), pl21, pl13);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl13.getMove3(), pl22, pl13);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl13.getMove3(), pl23, pl13);

					}
				}
			}else {
				if(pl2PokeNum == 1) {
					if(pl1PokeNum == 1) {
						damagePoke(pl21.getMove3(), pl11, pl21);
					}else if(pl1PokeNum == 2) {
						damagePoke(pl21.getMove3(), pl12, pl21);

					}else if(pl1PokeNum == 3) {
						damagePoke(pl21.getMove3(), pl13, pl21);

					}
				}else if(pl2PokeNum == 2) {
					if(pl1PokeNum == 1) {
						damagePoke(pl22.getMove3(), pl11, pl22);
					}else if(pl1PokeNum == 2) {
						damagePoke(pl22.getMove3(), pl12, pl22);

					}else if(pl1PokeNum == 3) {
						damagePoke(pl22.getMove3(), pl13, pl22);

					}
				}else if(pl2PokeNum == 3) {
					if(pl1PokeNum == 1) {
						damagePoke(pl23.getMove3(), pl11, pl23);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl23.getMove3(), pl12, pl23);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl23.getMove3(), pl13, pl23);

					}
				}
			}
		}else if(mouseX>1210&& mouseX<1920 && mouseY>860 && mouseY<1020) {
			if(isPlayer1Turn) {
				if(pl1PokeNum == 1) {
					if(pl2PokeNum == 1) {
						damagePoke(pl11.getMove4(), pl21, pl11);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl11.getMove4(), pl22, pl11);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl11.getMove4(), pl23, pl11);

					}
				}else if(pl1PokeNum == 2) {
					if(pl2PokeNum == 1) {
						damagePoke(pl12.getMove4(), pl21, pl12);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl12.getMove4(), pl22, pl12);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl12.getMove4(), pl23, pl12);

					}
				}else if(pl1PokeNum == 3) {
					if(pl2PokeNum == 1) {
						damagePoke(pl13.getMove4(), pl21, pl13);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl13.getMove4(), pl22, pl13);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl13.getMove4(), pl23, pl13);

					}
				}
			}else {
				if(pl2PokeNum == 1) {
					if(pl1PokeNum == 1) {
						damagePoke(pl21.getMove4(), pl11, pl21);
					}else if(pl1PokeNum == 2) {
						damagePoke(pl21.getMove4(), pl12, pl21);

					}else if(pl1PokeNum == 3) {
						damagePoke(pl21.getMove4(), pl13, pl21);

					}
				}else if(pl2PokeNum == 2) {
					if(pl1PokeNum == 1) {
						damagePoke(pl22.getMove4(), pl11, pl22);
					}else if(pl1PokeNum == 2) {
						damagePoke(pl22.getMove4(), pl12, pl22);

					}else if(pl1PokeNum == 3) {
						damagePoke(pl22.getMove4(), pl13, pl22);

					}
				}else if(pl2PokeNum == 3) {
					if(pl1PokeNum == 1) {
						damagePoke(pl23.getMove4(), pl11, pl23);
					}else if(pl2PokeNum == 2) {
						damagePoke(pl23.getMove4(), pl12, pl23);

					}else if(pl2PokeNum == 3) {
						damagePoke(pl23.getMove4(), pl13, pl23);

					}
				}
			}
		}
		
		
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == clock) {
			clock.stop();
		}
		repaint();
	}
	
	public void damagePoke(PokemonMove move, BattlePokemon defPkmn, BattlePokemon atkPkmn) {
		int damage = ToolBox.getDamage(atkPkmn, move, defPkmn);
		int currentHP = defPkmn.getCurrentHP() - damage;
		//this damages the pokemon
		if(damage != 0) {
			damageText = "It did " + damage + "damage";

		}else {
			damageText = "It missed";
		}
		
		if(currentHP>0) {
			defPkmn.setCurrentHP(currentHP);

		}else {
			defPkmn.setCurrentHP(currentHP);
			defPkmn.setIsDead(true);
			
			damageText = defPkmn.getName() + " died!";
			
			if(isPlayer1Turn) {
				pl2PokeNum++;
			}else {
				pl1PokeNum++;
			}
		}
		
		consoleText = getConsoleText(atkPkmn, move);
		
		isPlayer1Turn = !isPlayer1Turn;
	}

}
