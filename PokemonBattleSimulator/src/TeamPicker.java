/*This class is what is used to pick player 1's pokemon team
 * 
 * 
 */

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

//TYPE CLASS AND HAVE TWO DRAW BOX FOR ONE TYPE 2TYPE WORK ON POKEMON CLASS

public class TeamPicker extends JPanel implements MouseListener {
	
	private JFrame w;
	private static Pokemon player11;
	private static Pokemon player12;
	private static Pokemon player13;

	private Pokemon charizard, blastoise, venusaur, raichu, luxray, jolteon, swampert, sceptile, blaziken, empoleon, infernape, torterra, magnezone, ampharos, walrein, greninja, delphox, chesnaught, salamence, flygon, metagross, camerupt, gardevoir;
	private Pokemon alakazam, starmie, exeggutor, scizor, heracross, mawile, lucario, machamp, breloom, tyranitar, garchomp, dragonite, golem, gengar, dusknoir, absol, cacturne, houndoom, drapion, lapras, abomasnow, staraptor;
	
	private Button choose;
	private Font font;
	private Font big;
	private int slideNum;
	private Button next;
	private Button previous;
	private int pokeNum;
	
	private Button finalize;
	private Button delete;
	
	//TAKE OUT X AND Y COORDS IN SPRITE CLASS AS FIELDS IN CONSTRUCTOR AND ADD TO DRAW METHOD INSTEAD
	//type class
	public TeamPicker(JFrame window) {
		setBackground(Color.WHITE);
		slideNum =0;
		pokeNum = 0;
		next = new Button(1820, 950, 100, 100, new ImageIcon("next.png").getImage());
		previous = new Button(10, 950, 100, 100, new ImageIcon("previous.png").getImage());
		font = new Font("Lucida Console", Font.BOLD, 15);
		big = new Font("Lucida Console", Font.BOLD, 30);
		w = window;
		delete = new Button(1650, 940, 150, 50, new ImageIcon("delete.png").getImage());
		finalize = new Button(1650, 990, 150, 50, new ImageIcon("confirm.png").getImage());
		
		//making all of the moves
		PokemonMove icebeam = new PokemonMove( 90, "Ice Beam",true, 100, "Ice");
		PokemonMove flamethrower = new PokemonMove( 90, "Flamethrower",true, 100, "Fire");
		PokemonMove aerialace = new PokemonMove( 60, "Aerial Ace",false, 100, "Flying");
		PokemonMove crunch = new PokemonMove( 80, "Crunch",false, 100, "Dark");
		PokemonMove earthquake = new PokemonMove( 100, "Earthquake",false, 100, "Ground");
		PokemonMove hydrocannon = new PokemonMove( 150, "Hydro Cannon",true, 50, "Water");
		PokemonMove surf = new PokemonMove( 90, "Surf",true, 100, "Water");
		PokemonMove sludgebomb = new PokemonMove( 90, "Sludge Bomb",true, 100, "Poison");
		PokemonMove frenzyplant = new PokemonMove( 150, "Frenzy Plant",true, 50, "Grass");
		PokemonMove magicalleaf = new PokemonMove( 60, "Magical Leaf",true, 100, "Grass");
		PokemonMove blastburn = new PokemonMove(150, "Blast Burn", true, 50, "Fire");
		PokemonMove thunderbolt = new PokemonMove(90, "Thunderbolt", true, 100, "Electric");
		PokemonMove thunder = new PokemonMove(110, "Thunder", true, 60, "Electric");
		PokemonMove takedown = new PokemonMove(80, "Take Down", false, 80, "Normal");
		PokemonMove irontail = new PokemonMove(100, "Iron Tail", false, 75, "Steel");
		PokemonMove swift = new PokemonMove(60, "Swift", true, 100, "Normal");
		PokemonMove icepunch = new PokemonMove(75, "Ice Punch", false, 100, "Ice");
		PokemonMove rockslide = new PokemonMove(75, "Rock Slide", false, 90, "Rock");
		PokemonMove leafblade = new PokemonMove(90, "Leaf Blade", false, 100, "Grass");
		PokemonMove energyball = new PokemonMove(90, "Energy Ball", true, 90, "Grass");
		PokemonMove firepunch = new PokemonMove(75, "Fire Punch", false, 100, "Fire");
		PokemonMove brickbreak = new PokemonMove(75, "Brick Break", false, 100, "Fighting");
		PokemonMove blazekick = new PokemonMove(85, "Blaze Kick", false, 90, "Fire");
		PokemonMove closecombat = new PokemonMove(120, "Close Combat", false, 70, "Fighting");
		PokemonMove flashcannon = new PokemonMove(80, "Flash Cannon", true, 100, "Steel");
		PokemonMove earthpower = new PokemonMove(90, "Earth Power", true, 100, "Ground");
		PokemonMove dragonpulse = new PokemonMove(85, "Dragon Pulse", true, 100, "Dragon");
		PokemonMove blizzard = new PokemonMove(110, "Blizzard", true, 70, "Ice");
		PokemonMove psychic = new PokemonMove(90, "Psychic", true, 100, "Psychic");
		PokemonMove fireblast = new PokemonMove(110, "Fire Blast", true, 85, "Fire");
		PokemonMove zenhead = new PokemonMove(80, "Zen Headbutt", false, 90, "Psychic");
		PokemonMove moonblast = new PokemonMove(95, "Moonblast", true, 100, "Fairy");
		PokemonMove shadowball = new PokemonMove(80, "Shadow Ball", true, 100, "Ghost");
		PokemonMove bugbuzz = new PokemonMove(90, "Bug Buzz", true, 100, "Bug");
		PokemonMove playrough = new PokemonMove(90, "Play Rough", false, 90, "Fairy");
		PokemonMove aurasphere = new PokemonMove(80, "Aura Sphere", true, 100, "Fighting");
		PokemonMove dragonclaw = new PokemonMove(80, "Dragon Claw", false, 100, "Dragon");
		PokemonMove darkpulse = new PokemonMove(80, "Dark Pulse", true, 100, "Dark");
		PokemonMove gunkshot = new PokemonMove(120, "Gunk Shot", true, 70, "Poison");
		
		charizard = new Pokemon("Charizard", "Fire","Flying", 78,84,78,109,85,100, new ImageIcon("charizard.png").getImage(),flamethrower, crunch, aerialace, blastburn, 360);
		blastoise = new Pokemon("Blastoise", "Water",79,83,100,85,105,78, new ImageIcon("blastoise.png").getImage(), hydrocannon, surf, crunch, icebeam, 362);
		venusaur = new Pokemon("Venusaur", "Grass", "Poison", 80,82,83,100,100,80, new ImageIcon("venasaur.png").getImage(), sludgebomb, frenzyplant, earthquake, magicalleaf, 364);
		raichu = new Pokemon("Raichu", "Electric", 60, 90, 55, 90, 80, 110, new ImageIcon("raichu.png").getImage(), thunderbolt, thunder, takedown, irontail, 324);
		luxray = new Pokemon("Luxray", "Electric", "Dark", 80, 120, 79, 95, 79, 70, new ImageIcon("luxray.png").getImage(), thunderbolt, swift, crunch, irontail, 364);
		jolteon = new Pokemon("Jolteon", "Electric", 65, 65, 60, 110, 95, 130, new ImageIcon("jolteon.png").getImage(), thunderbolt, thunder, irontail, swift, 334);
		swampert = new Pokemon("Swampert", "Water", "Ground", 100,150,110,95,110,70, new ImageIcon("swampert.png").getImage(), surf, earthquake, icepunch, rockslide, 404);
		sceptile = new Pokemon("Sceptile", "Grass", 70, 85, 65, 105, 85, 120, new ImageIcon("sceptile.png").getImage(), leafblade, frenzyplant, energyball, rockslide, 344);
		blaziken = new Pokemon("Blaziken", "Fire", "Fighting", 80,120,70,110,70,80, new ImageIcon("blaziken.png").getImage(), closecombat, firepunch, blazekick, brickbreak, 364);
		empoleon = new Pokemon("Empoleon", "Water", "Steel", 84,86,88,111,101,60, new ImageIcon("empoleon.png").getImage(), surf, flashcannon, icebeam, hydrocannon, 372);
		infernape = new Pokemon("Infernape", "Fire", "Fighting", 76, 104, 71, 104, 71, 108, new ImageIcon("infernape.png").getImage(), closecombat, firepunch, flamethrower, brickbreak, 356);
		torterra = new Pokemon("Torterra", "Grass", "Ground", 95, 109, 105, 75, 85, 56, new ImageIcon("torterra.png").getImage(), earthquake, frenzyplant, magicalleaf, earthpower, 394);
		magnezone = new Pokemon("Magnezone", "Electric", "Steel", 70,70,115,130,90,60, new ImageIcon("magnezone.png").getImage(), flashcannon, thunderbolt, thunder, earthquake, 344);
		ampharos = new Pokemon("Ampharos", "Electric", 90,75,85,115,90,55, new ImageIcon("ampharos.png").getImage(), thunderbolt, thunder, dragonpulse, takedown, 384);
		walrein = new Pokemon("Walrein", "Water", "Ice", 110, 80, 90, 95, 90, 65, new ImageIcon("walrein.png").getImage(), blizzard, surf, icebeam, thunderbolt, 424);
		
		
		greninja = new Pokemon("Greninja", "Water", "Dark", 72, 95, 67, 103, 71, 122, new ImageIcon("greninja.png").getImage(), surf, icebeam, magicalleaf, darkpulse, 348);
		delphox = new Pokemon("Delphox", "Fire", "Psychic", 75, 69, 72, 114, 100, 104, new ImageIcon("delphox.png").getImage(), flamethrower, psychic, fireblast, energyball, 354);
		chesnaught = new Pokemon("Chesnaught", "Grass", "Fighting", 88, 107, 122, 74, 75, 64, new ImageIcon("chesnaught.png").getImage(), irontail, energyball, frenzyplant, brickbreak, 380);
		salamence = new Pokemon("Salamence", "Dragon", "Flying",95, 135, 80, 110, 80, 100, new ImageIcon("salamence.png").getImage(), dragonpulse, aerialace, flamethrower, crunch, 394);
		flygon = new Pokemon("Flygon", "Dragon", "Ground", 80, 100, 80, 80, 80, 100, new ImageIcon("flygon.png").getImage(), flamethrower, dragonpulse, earthquake, crunch, 364);
		metagross = new Pokemon("Metagross", "Steel", "Psychic",80, 135, 130, 95, 90, 70, new ImageIcon("metagross.png").getImage(), flashcannon, zenhead, psychic, brickbreak, 364);
		camerupt = new Pokemon("Camerupt", "Fire", "Ground", 70, 100, 70, 105, 75, 40, new ImageIcon("camerupt.png").getImage(), flamethrower, fireblast, earthquake, earthpower, 344);
		gardevoir = new Pokemon("Gardevoir", "Psychic", "Fairy", 68,65,65,125,115,80, new ImageIcon("gardevoir.png").getImage(), psychic, moonblast, shadowball, zenhead, 340);
		alakazam = new Pokemon("Alakazam", "Psychic", 55,50,45,135,95,120, new ImageIcon("alakazam.png").getImage(), psychic, shadowball, energyball, flamethrower, 314);
		starmie = new Pokemon("Starmie", "Water","Psychic", 60, 75, 85, 100, 85, 115, new ImageIcon("starmie.png").getImage(), psychic, zenhead, surf, icepunch, 324);
		exeggutor = new Pokemon("Exeggutor", "Grass","Psychic", 95, 95, 85, 125, 65, 55, new ImageIcon("exeggutor.png").getImage(), psychic, energyball, shadowball, magicalleaf, 394);
		scizor = new Pokemon("Scizor", "Bug","Steel", 70, 130, 100, 55, 80, 65, new ImageIcon("scizor.png").getImage(), flashcannon, bugbuzz, irontail, brickbreak, 344);
		heracross= new Pokemon("Heracross", "Bug", "Fighting", 80, 125, 75, 40, 95, 85, new ImageIcon("heracross.png").getImage(), brickbreak, irontail, bugbuzz, closecombat, 364);
		mawile = new Pokemon("Mawile", "Steel", "Fairy", 50, 85, 85, 55, 55, 50, new ImageIcon("mawile.png").getImage(), playrough, flashcannon, irontail, moonblast, 304);
		lucario = new Pokemon("Lucario", "Steel", "Fighting", 70, 110, 70, 115, 70, 90, new ImageIcon("lucario.png").getImage(), aurasphere, brickbreak, flashcannon, closecombat, 344);
		
		machamp = new Pokemon("Machamp", "Fighting", 90, 130, 80, 65, 85, 55, new ImageIcon("machamp.png").getImage(), closecombat, brickbreak, firepunch, icepunch, 384);
		breloom = new Pokemon("Breloom", "Grass", "Fighting",  60, 130, 80, 60, 60, 70, new ImageIcon("breloom.png").getImage(), closecombat, brickbreak, firepunch, leafblade, 324);
		tyranitar = new Pokemon("Tyranitar", "Rock", "Dark", 100, 134, 110, 95, 100, 61, new ImageIcon("tyranitar.png").getImage(), rockslide, earthquake, crunch, brickbreak, 404);
		garchomp = new Pokemon("Garchomp", "Dragon", "Ground", 108, 130, 95, 80, 85, 102, new ImageIcon("garchomp.png").getImage(), earthquake, dragonpulse, dragonclaw, crunch, 420);
		dragonite = new Pokemon("Dragonite", "Dragon", "Flying", 91,134,95,100,100,80, new ImageIcon("dragonite.png").getImage(), dragonpulse, dragonclaw, aerialace, flamethrower, 386);
		golem = new Pokemon("Golem", "Ground", "Rock", 80, 120, 130, 55, 65, 45, new ImageIcon("golem.png").getImage(), earthquake, earthpower, rockslide, takedown, 364);
		gengar = new Pokemon("Gengar", "Ghost", "Poison", 60,65,60,130,75,110, new ImageIcon("gengar.png").getImage(), shadowball, psychic, sludgebomb, gunkshot, 324);
		dusknoir = new Pokemon("Dusknoir", "Ghost", 45, 100, 135, 65, 135, 45, new ImageIcon("dusknoir.png").getImage(), shadowball, firepunch, darkpulse, psychic, 294);
		absol = new Pokemon("Absol", "Dark", 65, 130, 60, 75, 60, 75, new ImageIcon("absol.png").getImage(), darkpulse, shadowball, psychic, irontail, 334);
		cacturne = new Pokemon("Cacturne", "Grass", "Dark", 70, 115, 60, 115,60, 55, new ImageIcon("cacturne.png").getImage(), darkpulse, shadowball, energyball, brickbreak, 344);
		houndoom = new Pokemon("Houndoom", "Dark", "Fire", 75, 90, 50, 110, 80,95, new ImageIcon("houndoom.png").getImage(), darkpulse, flamethrower, crunch, fireblast, 354);
		drapion = new Pokemon("Drapion", "Poison", "Dark", 70, 90, 110, 60, 75, 95, new ImageIcon("drapion.png").getImage(), darkpulse, bugbuzz, sludgebomb, shadowball, 344);
		lapras = new Pokemon("Lapras", "Water", "Ice", 130, 85, 80, 85, 95, 60, new ImageIcon("lapras.png").getImage(), icebeam, surf, blizzard, hydrocannon, 464);
		abomasnow = new Pokemon("Abomasnow", "Grass", "Ice", 90, 92, 75, 92, 85, 60, new ImageIcon("abomasnow.png").getImage(), blizzard, icebeam, energyball, magicalleaf, 384);
		staraptor = new Pokemon("Staraptor", "Normal", "Flying", 85, 120, 70, 50, 50, 100, new ImageIcon("staraptor.png").getImage(), closecombat, brickbreak, takedown, aerialace, 374);
		
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.scale(getWidth()/1920.0, getHeight()/1080.0);
		
		next.draw(g2, this);
		previous.draw(g2, this);
		
		
		//drawing the grid of pokemon
		if(slideNum == 0) {
			drawBox(charizard, 0,0,g);
			drawBox(blastoise, 384,0,g);
			drawBox(luxray, 768,0,g);
			drawBox(jolteon, 1152,0,g);
			drawBox(swampert, 1536,0,g);
			drawBox(blaziken, 0,311,g);
			drawBox(sceptile, 384,311,g);
			drawBox(empoleon, 768,311,g);
			drawBox(infernape, 1152,311,g);
			drawBox(torterra, 1536,311,g);
			drawBox(magnezone, 0,622,g);
			drawBox(ampharos, 384,622,g);
			drawBox(walrein, 768,622,g);
			drawBox(raichu, 1152,622,g);
			drawBox(venusaur, 1536,622,g);

		}else if (slideNum == 1) {
			drawBox(greninja, 0,0,g);
			drawBox(delphox, 384,0,g);
			drawBox(chesnaught, 768,0,g);
			drawBox(salamence, 1152,0,g);
			drawBox(flygon, 1536,0,g);
			drawBox(metagross, 0,311,g);
			drawBox(camerupt, 384,311,g);
			drawBox(gardevoir, 768,311,g);
			drawBox(alakazam, 1152,311,g);
			drawBox(starmie, 1536,311,g);
			drawBox(exeggutor, 0,622,g);
			drawBox(scizor, 384,622,g);
			drawBox(heracross, 768,622,g);
			drawBox(mawile, 1152,622,g);
			drawBox(lucario, 1536,622,g);
		}else if(slideNum == 2) {
			drawBox(machamp, 0,0,g);
			drawBox(breloom, 384,0,g);
			drawBox(tyranitar, 768,0,g);
			drawBox(garchomp, 1152,0,g);
			drawBox(dragonite, 1536,0,g);
			drawBox(golem, 0,311,g);
			drawBox(gengar, 384,311,g);
			drawBox(dusknoir, 768,311,g);
			drawBox(absol, 1152,311,g);
			drawBox(cacturne, 1536,311,g);
			drawBox(houndoom, 0,622,g);
			drawBox(drapion, 384,622,g);
			drawBox(lapras, 768,622,g);
			drawBox(abomasnow, 1152,622,g);
			drawBox(staraptor, 1536,622,g);
		}
		
		g.setFont(big);
		g.drawString("Player 1", 800, 1045);
		g.setFont(font);
		
		g.setColor(Color.RED);
		g2.setStroke(new BasicStroke(2));
		g.drawRect(150, 940, 1500, 75);
		g.setColor(Color.BLACK);
		g.drawString("Current", 160, 960);
		g.drawString("Team", 170, 980);
		g.drawString("Max: 3", 170, 1000);
		g.drawLine(250, 940, 250, 1015);
		g.drawRect(250, 940, 466, 75);
		g.drawRect(716, 940, 466, 75);
		g.drawRect(1182, 940, 467, 75);

		g.setFont(big);
		
		//checking whether they are done with their team and drawing delete and confirm buttons
		if(pokeNum ==0) {
			
		}else if(pokeNum == 1) {
			g.drawString(player11.getName(),400, 1000);
			delete.draw(g, this);
		}else if(pokeNum == 2) {
			g.drawString(player11.getName(),400, 1000);
			g.drawString(player12.getName(),866, 1000);
			delete.draw(g, this);

		}else if(pokeNum == 3) {
			g.drawString(player11.getName(),400, 1000);
			g.drawString(player12.getName(),866, 1000);
			g.drawString(player13.getName(), 1332, 1000);
			finalize.draw(g, this);
			delete.draw(g, this);

			
		}else if(pokeNum == 4) {
			w.dispose();
	    	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	    	JFrame w = new JFrame("TEAM PICKER FOR PLAYER 2");
	    	//System.out.println(screensize.toString());
	        w.setBounds(0, 0, screensize.width, screensize.height);
	       
	  	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	    TeamPicker2 panel = new TeamPicker2(w);
	   	    w.add(panel);
	        w.addMouseListener(panel);
	   	    w.setResizable(true);
	   	    w.setVisible(true);
			
		}
		
		
		
		g.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(3));
		g.drawLine(384, 0, 384, 933);
		g.drawLine(768, 0, 768, 933);
		g.drawLine(1152, 0, 1152, 933);
		g.drawLine(1536, 0, 1536, 933);
		
		g.drawLine(0, 0, 1920, 0);
		g.drawLine(0, 311, 1920, 311);
		g.drawLine(0, 622, 1920, 622);
		g.drawLine(0, 933, 1920, 933);


	}
	
	

	
	//method for drawing each individual box\
	public void drawBox(Pokemon pkmn, int x, int y, Graphics g) {
		choose = new Button(x+185, y+200, 199, 70,new ImageIcon("choose.jpg").getImage());

		//whole rect
		g.drawRect(x, y, 384, 311);
		//name and type
		g.drawRect(x, y, 180, 50);
		g.setColor(Color.RED);
		g.setFont(font); 
		g.drawString(pkmn.getName(), x + 5,y+15);
		if(pkmn.getType2() == null) {
			g.drawString(pkmn.getType(), x + 5, y +40);

		}else {
			g.drawString(pkmn.getType() + " " + pkmn.getType2(), x + 5, y +40);

		}
		
		//image
		g.drawImage(pkmn.getPokeImage(), x + 180, y, 204, 200, this); 
		
		//movesetbox
		g.setColor(Color.GREEN);
		g.drawRect(x, y+50, 180, 100);
		
		//drawing lines for moveset box
		g.setColor(Color.black);
		g.drawLine(x, y+75, x+180, y+75);
		g.drawLine(x, y+100, x+180, y+100);
		g.drawLine(x, y+125, x+180, y+125);
		g.drawLine(x+145, y+50, x+145, y+311);
		
		//drawing moves and damage
		g.drawString(pkmn.getMove1().getName(), x+5, y+70);
		g.drawString(pkmn.getMove1().getDamage() + "", x +150, y+70);
		g.drawString(pkmn.getMove2().getName(), x+5, y+95);
		g.drawString(pkmn.getMove2().getDamage()+"", x+150, y+95);
		g.drawString(pkmn.getMove3().getName(), x+5, y+120);
		g.drawString(pkmn.getMove3().getDamage()+"", x+150, y+120);
		g.drawString(pkmn.getMove4().getName(), x+5, y+145);
		g.drawString(pkmn.getMove4().getDamage()+"", x+150, y+145);
		
		
		//drawing stats box and its lines
		g.setColor(Color.GREEN);
		g.drawRect(x, y+150, 180, 161);
		g.setColor(Color.BLACK);
		g.drawLine(x, y+182, x+180, y+182);
		g.drawLine(x, y+214, x+180, y+214);
		g.drawLine(x, y+246, x+180, y+246);
		g.drawLine(x, y+278, x+384, y+278);
		
		
		//drawing stats
		g.drawString("Stats: HP", x, y+175);
		g.drawString("Stats: Attack", x, y+209);
		g.drawString("Stats: Defense", x, y+241);
		g.drawString("SpecialAttack", x, y+273);
		g.drawString("SpecialDefense", x, y+305);
		g.drawString("Stats: Speed", x+185, y+305);
		
		g.drawString(pkmn.getHP()+"", x+150, y+175);
		g.drawString(pkmn.getAtk()+"", x+150, y+209);
		g.drawString(pkmn.getDef()+"", x+150, y+241);
		g.drawString(pkmn.getSPA()+"", x+150, y+273);
		g.drawString(pkmn.getSPD()+"", x+150, y+305);
		g.drawString(pkmn.getSpeed()+"", x+330, y+305);
		
		
		//button
		
		choose.draw(g, this);
	}
	
	
	
	
	public void mouseClicked(MouseEvent e) {
		
		
	}

	
	public void mouseEntered(MouseEvent e) {
		
	}

	
	public void mouseExited(MouseEvent e) {
		
	}

	
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		//insane amount of ifs to check for each choose button
		if(slideNum == 0&& pokeNum<3) {
			if(isPointInRectangle(mouseX, mouseY,185, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = charizard;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = charizard;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = charizard;
					pokeNum++;	
				}
			}else if(isPointInRectangle(mouseX, mouseY,185, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = blaziken;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = blaziken;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = blaziken;
					pokeNum++;	
				}				
			}else if(isPointInRectangle(mouseX, mouseY,185, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = magnezone;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = magnezone;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = magnezone;
					pokeNum++;	
				}		
			}else if(isPointInRectangle(mouseX, mouseY,569, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = blastoise;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = blastoise;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = blastoise;
					pokeNum++;	
				}				
			}else if(isPointInRectangle(mouseX, mouseY,569, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = sceptile;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = sceptile;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = sceptile;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,569, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = ampharos;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = ampharos;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = ampharos;
					pokeNum++;	
				}	
			}else if(isPointInRectangle(mouseX, mouseY,953, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = luxray;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = luxray;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = luxray;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,953, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = empoleon;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = empoleon;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = empoleon;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,953, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = walrein;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = walrein;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = walrein;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,1337, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = jolteon;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = jolteon;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = jolteon;
					pokeNum++;	
				}				
			}else if(isPointInRectangle(mouseX, mouseY,1337, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = infernape;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = infernape;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = infernape;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,1337, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = raichu;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = raichu;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = raichu;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,1721, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = swampert;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = swampert;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = swampert;
					pokeNum++;	
				}				
			}else if(isPointInRectangle(mouseX, mouseY,1721, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = torterra;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = torterra;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = torterra;
					pokeNum++;	
				}				
			}else if(isPointInRectangle(mouseX, mouseY,1721, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = venusaur;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = venusaur;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = venusaur;
					pokeNum++;	
				}			
			}
			
		}else if(slideNum == 1&& pokeNum<3) {
				if(isPointInRectangle(mouseX, mouseY,185, 200, 199, 70)) {
					if(pokeNum == 0) {
						player11 = greninja;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = greninja;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = greninja;
						pokeNum++;	
					}
				}else if(isPointInRectangle(mouseX, mouseY,185, 511, 199, 70)) {
					if(pokeNum == 0) {
						player11 = metagross;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = metagross;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = metagross;
						pokeNum++;	
					}				
				}else if(isPointInRectangle(mouseX, mouseY,185, 822, 199, 70)) {
					if(pokeNum == 0) {
						player11 = exeggutor;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = exeggutor;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = exeggutor;
						pokeNum++;	
					}				
				}else if(isPointInRectangle(mouseX, mouseY,569, 200, 199, 70)) {
					if(pokeNum == 0) {
						player11 = delphox;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = delphox;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = delphox;
						pokeNum++;	
					}		
				}else if(isPointInRectangle(mouseX, mouseY,569, 511, 199, 70)) {
					if(pokeNum == 0) {
						player11 = camerupt;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = camerupt;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = camerupt;
						pokeNum++;	
					}		
				}else if(isPointInRectangle(mouseX, mouseY,569, 822, 199, 70)) {
					if(pokeNum == 0) {
						player11 = scizor;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = scizor;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = scizor;
						pokeNum++;	
					}
				}else if(isPointInRectangle(mouseX, mouseY,953, 200, 199, 70)) {
					if(pokeNum == 0) {
						player11 = chesnaught;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = chesnaught;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = chesnaught;
						pokeNum++;	
					}			
				}else if(isPointInRectangle(mouseX, mouseY,953, 511, 199, 70)) {
					if(pokeNum == 0) {
						player11 = gardevoir;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = gardevoir;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = gardevoir;
						pokeNum++;	
					}			
				}else if(isPointInRectangle(mouseX, mouseY,953, 822, 199, 70)) {
					if(pokeNum == 0) {
						player11 = heracross;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = heracross;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = heracross;
						pokeNum++;	
					}			
				}else if(isPointInRectangle(mouseX, mouseY,1337, 200, 199, 70)) {
					if(pokeNum == 0) {
						player11 = salamence;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = salamence;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = salamence;
						pokeNum++;	
					}			
				}else if(isPointInRectangle(mouseX, mouseY,1337, 511, 199, 70)) {
					if(pokeNum == 0) {
						player11 = alakazam;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = alakazam;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = alakazam;
						pokeNum++;	
					}			
				}else if(isPointInRectangle(mouseX, mouseY,1337, 822, 199, 70)) {
					if(pokeNum == 0) {
						player11 = mawile;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = mawile;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = mawile;
						pokeNum++;	
					}		
				}else if(isPointInRectangle(mouseX, mouseY,1721, 200, 199, 70)) {
					if(pokeNum == 0) {
						player11 = flygon;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = flygon;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = flygon;
						pokeNum++;	
					}		
				}else if(isPointInRectangle(mouseX, mouseY,1721, 511, 199, 70)) {
					if(pokeNum == 0) {
						player11 = starmie;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = starmie;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = starmie;
						pokeNum++;	
					}		
				}else if(isPointInRectangle(mouseX, mouseY,1721, 822, 199, 70)) {
					if(pokeNum == 0) {
						player11 = lucario;
						pokeNum++;	
					}else if(pokeNum == 1) {
						player12 = lucario;
						pokeNum++;	
					}else if(pokeNum == 2) {
						player13 = lucario;
						pokeNum++;	
					}		
				}
		}else if(slideNum == 2 && pokeNum<3) {
			if(isPointInRectangle(mouseX, mouseY,185, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = machamp;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = machamp;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = machamp;
					pokeNum++;	
				}
			}else if(isPointInRectangle(mouseX, mouseY,185, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = golem;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = golem;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = golem;
					pokeNum++;	
				}				
			}else if(isPointInRectangle(mouseX, mouseY,185, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = houndoom;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = houndoom;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = houndoom;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,569, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = breloom;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = breloom;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = breloom;
					pokeNum++;	
				}				
			}else if(isPointInRectangle(mouseX, mouseY,569, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = gengar;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = gengar;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = gengar;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,569, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = drapion;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = drapion;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = drapion;
					pokeNum++;	
				}
			}else if(isPointInRectangle(mouseX, mouseY,953, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = tyranitar;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = tyranitar;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = tyranitar;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,953, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = dusknoir;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = dusknoir;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = dusknoir;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,953, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = lapras;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = lapras;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = lapras;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,1337, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = garchomp;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = garchomp;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = garchomp;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,1337, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = absol;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = absol;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = absol;
					pokeNum++;	
				}			
			}else if(isPointInRectangle(mouseX, mouseY,1337, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = abomasnow;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = abomasnow;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = abomasnow;
					pokeNum++;	
				}				
			}else if(isPointInRectangle(mouseX, mouseY,1721, 200, 199, 70)) {
				if(pokeNum == 0) {
					player11 = dragonite;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = dragonite;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = dragonite;
					pokeNum++;	
				}
				
				
			}else if(isPointInRectangle(mouseX, mouseY,1721, 511, 199, 70)) {
				if(pokeNum == 0) {
					player11 = cacturne;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = cacturne;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = cacturne;
					pokeNum++;	
				}
			}else if(isPointInRectangle(mouseX, mouseY,1721, 822, 199, 70)) {
				if(pokeNum == 0) {
					player11 = staraptor;
					pokeNum++;	
				}else if(pokeNum == 1) {
					player12 = staraptor;
					pokeNum++;	
				}else if(pokeNum == 2) {
					player13 = staraptor;
					pokeNum++;	
				}
				
				
							
			}
		}
		
		
		
		
		
		
		
		
		if(next.isClicked(mouseX, mouseY)) {
			if(slideNum<2) {
				slideNum++;
			}else {
				slideNum=0;
			}
		}else if(previous.isClicked(mouseX, mouseY)) {
			if(slideNum>0) {
				slideNum--;
			}else{
				slideNum = 2;
			}
		}else if(finalize.isClicked(mouseX, mouseY)) {
			pokeNum++;
		}else if(delete.isClicked(mouseX, mouseY)) {
			pokeNum--;
		}
		repaint();

	}

	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public boolean isPointInRectangle(int x, int y, int rectX, int rectY, int rectWidth, int rectHeight)
	  {

	  	boolean result;

	  	// Complete your if statement (or series of if statements) here
	  	if ((rectX<=x && x<=(rectX+rectWidth)) && (rectY<=y && y<=(rectY+rectHeight))) {
	  		result = true;
	  		
	  	}else {
	  		result = false;
	  	}

	  	return result;
	  }
	
	public static Pokemon getPlayer11() {
		return player11;
	}
	
	public static Pokemon getPlayer12() {
		return player12;
	}
	
	public static Pokemon getPlayer13() {
		return player13;
	}
}
