/*This class greets the user and explains the program briefly.
 * 
 * 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
   Coded by Ayush Satyavarpu
 */
public class PokemonIntro extends JPanel implements MouseListener, ActionListener
{
  // TODO Your Instance Variables Here
  private Image gif;
  private Timer clock;
  private Image profOak;
  private Font blocky, blocky2;
  private int sceneNum;
  private Font formal;
  private double xscale;
  private double yscale;
  Button next;
  
  
  private JFrame window;

  public PokemonIntro (JFrame window) {
	  super();
	  this.window = window;
	  gif = (new ImageIcon("gifforpkmn.gif")).getImage();
	  profOak = (new ImageIcon("profoak.png")).getImage();
	  setBackground(Color.WHITE);
	  blocky = new Font("Lucida Console", Font.BOLD, 23);
	  blocky2 = new Font("Lucida Console", Font.BOLD, 19);
	  formal = new Font("Serif", Font.BOLD, 15);
	  sceneNum = 0;
	  
	  next = new Button(675, 500, 100, 100, new ImageIcon("next.png").getImage());
  	 //to1.setVerticalTextPosition(AbstractButton.BOTTOM);

	  	clock = new Timer(4900, this); 
	    clock.start();
	  //add(to1);
  }
  
  
  
  
  

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

    int width = getWidth();
    int height = getHeight();
    
    
    Graphics2D g2 = (Graphics2D)g;
    xscale = width/800.0;
    yscale = height/600.0;
    
    
    //drawing all of the text and images
    
    
    g2.scale(xscale, yscale);
    if(clock.isRunning()) {
    	g2.drawImage(gif, 0,0,800, 600, this);
    	return;
    } else if(sceneNum == 1) {
    	g.drawImage(profOak, 300,0, 150, 300, this);
    	next.draw(g2, this);
    	g.setFont(blocky2);
    	g.drawString("Hello there! Welcome to the world of Pokémon! My name is Oak!", 10, 350);
    	g.drawString("People call me the Pokémon Prof! This world is inhabited by ", 10, 400);
    	g.drawString("creatures called Pokémon! For some people, Pokémon are pets.", 10, 450);
    	g.drawString("Others use them for fights. Myself...I study Pokémon as a ", 10, 500);
    	g.drawString("profession --Professor Oak, Pokémon Red version", 10, 550);
    	g.setFont(formal);
    	g.drawString("Coded by Ayush Satyavarpu, Period 2, Mr.Shelby", 250, 585);
    	
    }else if(sceneNum == 2) {
    	super.paintComponent(g2);
    	g.drawImage(profOak, 300,0, 150, 300, this);
    	next.draw(g2, this);
    	g.setFont(blocky);
    	g.setColor(new Color(0,0,0));
    	g.drawString("Hello and welcome to the Pokemon Battle Simulator!", 10,  400);
    	g.setFont(formal);
    	g.drawString("Coded by Ayush Satyavarpu, Period 2, Mr.Shelby", 250, 585);
    	
    }else if(sceneNum == 3) {
    	super.paintComponent(g2);
    	g.drawImage(profOak, 300,0, 150, 300, this);
    	next.draw(g2, this);
    	g.setFont(blocky2); 
    	g.drawString("This battle simulator lets the user choose their own Pokemon and", 10, 350);
    	g.drawString("battle against another player on the same computer with a", 10, 400);
    	g.drawString("different team.", 10, 450);
    	g.setFont(formal);
    	g.drawString("Coded by Ayush Satyavarpu, Period 2, Mr.Shelby", 250, 585);
    }else if(sceneNum == 4) {
    	super.paintComponent(g2);
    	g.drawImage(profOak, 300,0, 150, 300, this);
    	next.draw(g2, this);
    	g.setFont(blocky2); 
    	
    	g.drawString("So what are you waiting for?" , 10, 350);
    	g.drawString("The instructions on how to use the program are self explanatory.", 10, 400);
    	g.drawString("Click the next button to start making a team", 10, 450);
    	
    	g.setFont(formal);
    	g.drawString("Coded by Ayush Satyavarpu, Period 2, Mr.Shelby", 250, 585);
    }else if(sceneNum == 5) {
    	window.dispose();
    	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    	JFrame w = new JFrame("TEAM PICKER FOR PLAYER 1");
    	//System.out.println(screensize.toString());
        w.setBounds(0, 0, screensize.width, screensize.height);
       
  	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	    TeamPicker panel = new TeamPicker(w);
   	    w.add(panel);
        w.addMouseListener(panel);
   	    w.setResizable(true);
   	    w.setVisible(true);
    	    
    }
    
    
  }

    public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(clock)) {
			sceneNum++;
			clock.stop();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
			
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		int mouseX = (int)(e.getX()/xscale);
		int mouseY = (int)(e.getY()/yscale);
		//changing the slides
		if(next.isClicked(mouseX,mouseY)) {
			sceneNum++;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
