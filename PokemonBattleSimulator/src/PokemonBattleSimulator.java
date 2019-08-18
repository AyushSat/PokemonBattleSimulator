/*The main method, which starts the intro
 * 
 * 
 */

import javax.swing.JFrame;

public class PokemonBattleSimulator {

	public static void main(String[] args)
	  {
		JFrame w = new JFrame("Pokemon");
	    w.setBounds(100, 100, 800, 600);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    PokemonIntro panel = new PokemonIntro(w);
	    w.add(panel);
	    w.addMouseListener(panel);
	    w.setResizable(true);
	    w.setVisible(true);
	    
	  }

}
