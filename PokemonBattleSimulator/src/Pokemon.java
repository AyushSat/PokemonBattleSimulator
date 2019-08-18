/*This is the class that all basic Pokemon objects are made of.
 * 
 * 
 */

import java.awt.*;

public class Pokemon{
	
	private String name;//The name of the Pokemon  ex. Pikachu
	private String type, type2;//The type of the Pokemon  ex. Electric
	private final int maxHP;
	private int HP, Atk, Def,  SPA, SPD, Speed;
	private Image PokeImage;
	private PokemonMove move1, move2, move3, move4;
	
	//single typed pokemon
	public Pokemon(String name, String type, int HP, int Atk, int Def, int SPA, int SPD, int Spd, Image image, PokemonMove move1, PokemonMove move2, PokemonMove move3, PokemonMove move4, int maxHP) {
		
		
		this.name = name;
		this.type = type;
		this.HP = HP;
		this.Atk = Atk;
		this.Def = Def;
		this.SPA = SPA;
		this.SPD = SPD;
		this.Speed = Spd;
		PokeImage = image;
		this.move1 = move1;
		this.move2 = move2;
		this.move3 = move3;
		this.move4 = move4;
		this.maxHP = maxHP;
		
	}
	//constructor for a pokemon with 2 types
	public Pokemon(String name, String type, String type2, int HP, int Atk, int Def, int SPA, int SPD, int Spd, Image image, PokemonMove move1, PokemonMove move2, PokemonMove move3, PokemonMove move4, int maxHP) {
		this.name = name;
		this.type = type;
		this.type2=type2;
		this.HP = HP;
		this.Atk = Atk;
		this.Def = Def;
		this.SPA = SPA;
		this.SPD = SPD;
		this.Speed = Spd;
		PokeImage = image;
		this.move1 = move1;
		this.move2 = move2;
		this.move3 = move3;
		this.move4 = move4;
		this.maxHP = maxHP;

	}
	
	public Pokemon(Pokemon base) {
		this.name = base.name;
		this.type = base.type;
		this.HP = base.HP;
		this.Atk = base.Atk;
		this.Def = base.Def;
		this.SPA = base.SPA;
		this.SPD = base.SPD;
		this.Speed = base.Speed;
		PokeImage = base.PokeImage;
		this.move1 = base.move1;
		this.move2 = base.move2;
		this.move3 = base.move3;
		this.move4 = base.move4;
		if(!(base.type2 == null)) {
			this.type2 = base.type2;
		}
		this.maxHP = base.maxHP;

	}
	public String getName() {
		return name;
	}


	public String getType() {
		return type;
	}


	


	public String getType2() {
		return type2;
	}


	public int getMaxHP() {
		return maxHP;
	}


	public int getHP() {
		return HP;
	}


	

	public int getAtk() {
		return Atk;
	}


	


	public int getDef() {
		return Def;
	}


	


	public int getSPA() {
		return SPA;
	}


	public int getSPD() {
		return SPD;
	}



	public int getSpeed() {
		return Speed;
	}


	


	public Image getPokeImage() {
		return PokeImage;
	}


	

	public PokemonMove getMove1() {
		return move1;
	}


	

	public PokemonMove getMove2() {
		return move2;
	}


	


	public PokemonMove getMove3() {
		return move3;
	}



	public PokemonMove getMove4() {
		return move4;
	}

	
	
	

	



	


	


	
	
	
	
	
	//pass in pokemon to darwBox with all of the parameters



}
