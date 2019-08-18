/*This is a class for representing the state that 
 * a pokemon is in(why it extends pokemon) while
 * in battle.
 */

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class BattlePokemon extends Pokemon {
	
	private int currentHP;
	private boolean isDead;
	
	
	public BattlePokemon(Pokemon base) {
		super(base);
		currentHP = base.getMaxHP();
		setIsDead(false);

		
	}
	
	public void draw(int x, int y, int width, int height, Graphics g, ImageObserver io) {
		g.drawImage(super.getPokeImage(), x, y, width, height, io);
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int newHP) {
		this.currentHP = newHP;
	}

	public boolean getIsDead() {
		return isDead;
	}

	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}
	

	
	
		
	
	
}
