/*This class represents what the user sees after either player
 * has won the game. It simply consists of a victory gif and 
 * a statement of who won.
 * 
 * 
 */





import java.awt.*;


import javax.swing.*;

public class Win extends JPanel{
	JFrame w;
	boolean pl1Win;
	Image win;
	Dimension screensize;
	Font big;
	
	public Win(JFrame w, boolean didPlayer1Win) {
		setBackground(Color.WHITE);
		this.w = w;

		big = new Font("Lucida Console", Font.BOLD, 50);
		screensize = Toolkit.getDefaultToolkit().getScreenSize();
		win = new ImageIcon("win.gif").getImage();
		pl1Win = didPlayer1Win;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//drawing the gif and text
		g.setFont(big);
		g.drawImage(win, 0, 0, screensize.width, screensize.height - 200, this);
		g.setColor(Color.RED);
		if(pl1Win) {
			g.drawString("Player 1 Wins", screensize.width/2 - 300, screensize.height - 150);
		}else {
			g.drawString("Player 2 Wins", screensize.width/2 - 300, screensize.height - 150);
		}
	}


}
