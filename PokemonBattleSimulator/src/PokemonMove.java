/*This class represents moves that pokemon have
 * 
 * 
 */
public class PokemonMove {
	private int damage;
	private String name;
	private boolean isSpecial;
	private int accuracy;
	private String type;
	
	
	public PokemonMove(int damage, String name, boolean isSpecialAtk, int accuracy, String type) {
		this.damage = damage;
		this.name = name;
		isSpecial = isSpecialAtk;
		this.accuracy = accuracy;
		this.type = type;
		
		if(name.equalsIgnoreCase("blizzard")) {
			System.out.println("test");
		}
				
	}
	
	
	
	public int getDamage() {
		//System.out.println(damage);

		return damage;
	}

	public String getName() {
		return name;
	}


	public boolean isSpecial() {
		return isSpecial;
	}



	public int getAccuracy() {
		return accuracy;
	}



	public String getType() {
		return type;
	}



	


	


	

	
}
