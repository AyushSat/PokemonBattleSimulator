/*This is a class used to make buttons in the JPanel.
 * 
 * 
 */

import java.awt.*;
import java.awt.image.ImageObserver;
public class Button{
	private int x;
	private int y;
	private int height;
	private int width;
	private Image image;
	
	
	public Button(int x, int y, int width, int height, Image image) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.image = image;	}
	
	//checking whether the button was clicked
	public boolean isClicked(int mouseX, int mouseY) {
		if(mouseX>x && mouseX<x+width && mouseY>y && mouseY<y+height) {
			return true;
		}else {
			return false;
		}
	}
	
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image, x, y, width, height, io);
	}
	
	
//have click method
}
