/*This is simply a class to hold 2 very important
 * mathy methods for one simple purpose: Damage Calculation 
 * 
 */
public class ToolBox {
	
	
	//returns what the type multiplier should be
	public static double getTypeBonus(String atkType, String defType) {
		//checking each input against every output to see which multiplier should be returned
		
		
		
		
		if(atkType.equals("Psychic")) {//done
			if(defType.equalsIgnoreCase("Psychic") || defType.equalsIgnoreCase("Steel")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Dark")) {
				return 0;
			}else if(defType.equalsIgnoreCase("Fighting") ||defType.equalsIgnoreCase("Poison")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Fighting")) {//done
			if(defType.equalsIgnoreCase("Poison") || defType.equalsIgnoreCase("Flying") || defType.equalsIgnoreCase("Psychic") || defType.equalsIgnoreCase("Bug") || defType.equalsIgnoreCase("Fairy")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Normal") ||defType.equalsIgnoreCase("Ice") || defType.equalsIgnoreCase("Steel") || defType.equalsIgnoreCase("Rock") || defType.equalsIgnoreCase("Dark")) {
				return 2;
			}else if(defType.equalsIgnoreCase("Ghost")) {
				return 0;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Dark")) {//done
			if(defType.equalsIgnoreCase("Fighting") || defType.equalsIgnoreCase("Dark") || defType.equalsIgnoreCase("Fairy")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Ghost") ||defType.equalsIgnoreCase("Psychic")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Ground")) {//done
			if(defType.equalsIgnoreCase("Grass") || defType.equalsIgnoreCase("Bug")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Flying")) {
				return 0;
			}else if(defType.equalsIgnoreCase("Fire") ||defType.equalsIgnoreCase("Poison") || defType.equalsIgnoreCase("Electric")|| defType.equalsIgnoreCase("Rock")|| defType.equalsIgnoreCase("Steel")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Flying")) {//done
			if(defType.equalsIgnoreCase("Electric") || defType.equalsIgnoreCase("Steel") || defType.equalsIgnoreCase("Rock")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Fighting") ||defType.equalsIgnoreCase("Grass")|| defType.equalsIgnoreCase("Bug")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Electric")) {
			if(defType.equalsIgnoreCase("Electric") || defType.equalsIgnoreCase("Grass")|| defType.equalsIgnoreCase("Dragon")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Ground")) {
				return 0;
			}else if(defType.equalsIgnoreCase("Water") ||defType.equalsIgnoreCase("Flying")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Normal")) {//done
			if(defType.equalsIgnoreCase("Rock") || defType.equalsIgnoreCase("Steel")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Ghost")) {
				return 0;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Ice")) {//done
			if(defType.equalsIgnoreCase("Fire") || defType.equalsIgnoreCase("Water")|| defType.equalsIgnoreCase("Ice")|| defType.equalsIgnoreCase("Steel")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Grass") ||defType.equalsIgnoreCase("Ground")|| defType.equalsIgnoreCase("Flying")|| defType.equalsIgnoreCase("Dragon")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Bug")) {//done
			if(defType.equalsIgnoreCase("Fire") || defType.equalsIgnoreCase("Steel")|| defType.equalsIgnoreCase("Fighting")|| defType.equalsIgnoreCase("Poison")|| defType.equalsIgnoreCase("Flying")|| defType.equalsIgnoreCase("Dragon")|| defType.equalsIgnoreCase("Fairy")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Grass") ||defType.equalsIgnoreCase("Psychic") || defType.equalsIgnoreCase("Dark")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Water")) {//done
			if(defType.equalsIgnoreCase("Water") || defType.equalsIgnoreCase("Grass")|| defType.equalsIgnoreCase("Dragon")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Fire") ||defType.equalsIgnoreCase("Ground")|| defType.equalsIgnoreCase("Rock")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Fire")) {//done
			if(defType.equalsIgnoreCase("Fire") || defType.equalsIgnoreCase("Water")|| defType.equalsIgnoreCase("Rock")|| defType.equalsIgnoreCase("Dragon")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Grass") ||defType.equalsIgnoreCase("Ice")|| defType.equalsIgnoreCase("Bug")|| defType.equalsIgnoreCase("Steel")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Fairy")) {//done
			if(defType.equalsIgnoreCase("Fire") || defType.equalsIgnoreCase("Poison")|| defType.equalsIgnoreCase("Steel")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Fighting") ||defType.equalsIgnoreCase("Dragon")|| defType.equalsIgnoreCase("Dark")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Rock")) {//done
			if(defType.equalsIgnoreCase("Fighting") || defType.equalsIgnoreCase("Ground")|| defType.equalsIgnoreCase("Steel")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Fire") ||defType.equalsIgnoreCase("Ice")|| defType.equalsIgnoreCase("Flying")|| defType.equalsIgnoreCase("Bug")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Poison")) {//done
			if(defType.equalsIgnoreCase("Poison") || defType.equalsIgnoreCase("Ground")|| defType.equalsIgnoreCase("Rock")|| defType.equalsIgnoreCase("Ghost")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Steel")) {
				return 0;
			}else if(defType.equalsIgnoreCase("Grass") ||defType.equalsIgnoreCase("Fairy")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Ghost")) {//done
			if(defType.equalsIgnoreCase("Dark")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Normal")) {
				return 0;
			}else if(defType.equalsIgnoreCase("Psychic") ||defType.equalsIgnoreCase("Ghost")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Dragon")) {//done
			if(defType.equalsIgnoreCase("Steel")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Fairy")) {
				return 0;
			}else if(defType.equalsIgnoreCase("Dragon")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Grass")) {
			if(defType.equalsIgnoreCase("Fire") || defType.equalsIgnoreCase("Grass")|| defType.equalsIgnoreCase("Poison")|| defType.equalsIgnoreCase("Flying")|| defType.equalsIgnoreCase("Bug")|| defType.equalsIgnoreCase("Dragon")|| defType.equalsIgnoreCase("Steel")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Water") ||defType.equalsIgnoreCase("Ground") || defType.equalsIgnoreCase("Rock")) {
				return 2;
			}else {
				return 1;
			}
		}else if(atkType.equalsIgnoreCase("Steel")) {
			if(defType.equalsIgnoreCase("Fire") || defType.equalsIgnoreCase("Water") || defType.equalsIgnoreCase("Electric") || defType.equalsIgnoreCase("Steel")) {
				return .5;
			}else if(defType.equalsIgnoreCase("Ice") ||defType.equalsIgnoreCase("Rock") || defType.equalsIgnoreCase("Fairy")) {
				return 2;
			}else {
				return 1;
			}
		}
		
		
		return 1;
	}
	
	//calculates damage
	public static int getDamage(BattlePokemon atkPkmn, PokemonMove move, BattlePokemon defPkmn) {
		int damage;
		int power = move.getDamage();
		boolean isSP = move.isSpecial();
		double typeBonus;
		double stabBonus;
		double randVal = (Math.random() * 15 + 85)/100;
		double SPAorATK;
		double SPDorDEF;
		int didHit;
		
		if(Math.random() > (1 - (move.getAccuracy()/100.0))) {
			didHit = 1;
		}else {
			didHit = 0;
		}
		
		if(atkPkmn.getType2() == null) {
			if(atkPkmn.getType().equals(move.getType())) {
				stabBonus = 1.5;
			}else {
				stabBonus = 1;
			}
		}else {
			if(atkPkmn.getType().equals(move.getType()) || atkPkmn.getType2().equals(move.getType())) {
				stabBonus = 1.5;
			}else {
				stabBonus = 1;
			}
		}

		if(defPkmn.getType2() != null) {
			typeBonus = getTypeBonus(move.getType(), defPkmn.getType()) * getTypeBonus(move.getType(), defPkmn.getType2());
		}else {
			typeBonus = getTypeBonus(move.getType(), defPkmn.getType());
		}

		
		
		if(isSP) {
			SPAorATK = atkPkmn.getSPA();
			SPDorDEF = defPkmn.getSPD();
		}else {
			SPAorATK = atkPkmn.getAtk();
			SPDorDEF = defPkmn.getDef();
		}
		//the actual formula
		damage = (int)((((210.0/5) * power * (SPAorATK/SPDorDEF))/50 +2) * stabBonus * typeBonus * randVal) * didHit;
	
		
		
		return damage;
	}
	
	
}
