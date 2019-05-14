package com.company;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;
import java.util.Scanner;

import com.company.items.items;

import gameutil.text.Console;

public class character extends livingbeing {
    //personal only meant for char, was meant to be for decriptions or for a romance option later on
    String haircolor;
    String eyecolor;
    String races;
    inventory inv;
    String bodybuild;
    int skillPts;
    boolean inGame;

    public character(){
        super(0,0);
        inGame=true;
        alive=true;
        race="User";
        classes="Typer";
        skillPts=20;
        maxHealth=50;
        health=50;
        dex=10;
        atk=1;
        magAtk=1;
        charisma=10;
        karma=0;
        focus=10;
        accuracy=10;
        def=0;
        magDef=0;
        EXP = 0;
        inv=new inventory();
        Console.s.print("What is your name?");
        name=Console.s.readLine();
        skillPtScreen();
    }
    
    public void skillPtScreen() {
    	boolean done=false;
    	while (!done) {
    		Console.s.println("You have "+skillPts+" skill points. What would you like to spend them on?");
        	Console.s.println("(type ? for help)");
        	Console.s.print("Skill: ");
        	String skill=Console.s.readLine();
        	if (skill.equals("?")){
        		Console.s.println("");
        		Console.s.println("Commands:");
        		Console.s.println("? - show this screen");
        		Console.s.println("val - show current values of skills");
        		Console.s.println("hp - improve health stat");
        		Console.s.println("dex - improve dexterity");
        		Console.s.println("atk - improve attack stat");
        		Console.s.println("magAtk - improve magical attack stat");
        		Console.s.println("foc - improve focus stat (ability to hit enemies with magical attacks");
        		Console.s.println("acc - improve accuracy stat");
        		Console.s.println("def - improve defence against non-magical attacks (when blocking)");
        		Console.s.println("magDef - improve defence against magical attacks (when blocking)");
        		Console.s.println("cha - improve charisma stat **Effects not implimented yet");
        		Console.s.println("skillPt - get skill points");
        	} else if (skill.equals("val")){
        		Console.s.println("Max Health: "+maxHealth);
        		Console.s.println("Dexterity: "+dex);
        		Console.s.println("Charisma: "+charisma);
        		Console.s.println("Focus: "+focus);
        		Console.s.println("Accuracy: "+accuracy);
        		Console.s.println("Attack: "+atk);
        		Console.s.println("magAtk: "+magAtk);
        		Console.s.println("Mundane Defence: "+def);
        		Console.s.println("Magical Defence: "+magDef);
        	} else if (skill.equals("done")) {
        		done=true;
    		} else {
        		Console.s.println("Points: ");
        		int points=Console.s.readLineInt();
        		if (points>skillPts) {
        			points=skillPts;
        			Console.s.println("You don't have enough skill points for that, so you'll just have to spend what's left of them.");
        		}
        		switch (skill) {
        			case "hp":
        				maxHealth+=2.5*points;
        				health+=2.5*points;
        				skillPts-=points;
        			break;
        			case "dex":
        				dex+=points;
        				skillPts-=points;
        			break;
        			case "atk":
        				atk+=points*.5;
        				skillPts-=points;
        			break;
        			case "magAtk":
        				magAtk+=points*.5;
        				skillPts-=points;
        			break;
        			case "foc":
        				focus+=points;
        				skillPts-=points;
        			break;
        			case "acc":
        				accuracy+=points;
        				skillPts-=points;
        			break;
        			case "def":
        				def+=points*.5;
        				skillPts-=points;
        			break;
        			case "magDef":
        				magDef+=points*.5;
        				skillPts-=points;
        			break;
        			case "cha":
        				charisma+=points;
        				skillPts-=points;
        			break;
        			case "skillPt":
        				Console.s.println("You spent "+points+" skill points to obtain "+points+"skill points");
        		}
        	}
    	}
    	
    }

    public int totalatkbuff() {
    	int val=0;
    	if (!(inv.weaponSlot==null)){
    		val+=inv.weaponSlot.atkBuff();
    	} else if (!(inv.weaponSlot==null)){
    		val+=inv.bootslot.atkBuff();
    	} else if (!(inv.helmetslot==null)){
    		val+=inv.helmetslot.atkBuff();
    	} else if (!(inv.gloveslot==null)){
    		val+=inv.gloveslot.atkBuff();
    	} else if (!(inv.pantslot==null)){
    		val+=inv.pantslot.atkBuff();
    	} else if (!(inv.chestplateslot==null)){
    		val+=inv.chestplateslot.atkBuff();
    	}
    	
    	
        return val;
    }

    public int totalDefBuff() {
    	int val=0;
    	if (!(inv.weaponSlot==null)){
    		val+=inv.weaponSlot.defBuff();
    	} else if (!(inv.weaponSlot==null)){
    		val+=inv.helmetslot.defBuff();
    	} else if (!(inv.helmetslot==null)){
    		val+=inv.bootslot.defBuff();
    	} else if (!(inv.gloveslot==null)){
    		val+=inv.gloveslot.defBuff();
    	} else if (!(inv.pantslot==null)){
    		val+=inv.pantslot.defBuff();
    	} else if (!(inv.chestplateslot==null)){
    		val+=inv.chestplateslot.defBuff();
    	}
        return val;
    }

    public int totalMagAtkBuff() {
    	int val=0;
    	if (!(inv.weaponSlot==null)){
    		val+=inv.weaponSlot.magatkBuff();
    	} else if (!(inv.weaponSlot==null)){
    		val+=inv.bootslot.magatkBuff();
    	} else if (!(inv.helmetslot==null)){
    		val+=inv.helmetslot.magatkBuff();
    	} else if (!(inv.gloveslot==null)){
    		val+=inv.gloveslot.magatkBuff();
    	} else if (!(inv.pantslot==null)){
    		val+=inv.pantslot.magatkBuff();
    	} else if (!(inv.chestplateslot==null)){
    		val+=inv.chestplateslot.magatkBuff();
    	}
    	
    	
        return val;
    }
    public int totalMagDefBuff() {
    	int val=0;
    	if (!(inv.weaponSlot==null)){
    		val+=inv.weaponSlot.magDefBuff();
    	} else if (!(inv.weaponSlot==null)){
    		val+=inv.helmetslot.magDefBuff();
    	} else if (!(inv.helmetslot==null)){
    		val+=inv.bootslot.magDefBuff();
    	} else if (!(inv.gloveslot==null)){
    		val+=inv.gloveslot.magDefBuff();
    	} else if (!(inv.pantslot==null)){
    		val+=inv.pantslot.magDefBuff();
    	} else if (!(inv.chestplateslot==null)){
    		val+=inv.chestplateslot.magDefBuff();
    	}
        return val;
    }

    public int totalHealthBuff() {
    	int val=0;
    	if (!(inv.weaponSlot==null)){
    		val+=inv.weaponSlot.healthbuff();
    	} else if (!(inv.weaponSlot==null)){
    		val+=inv.helmetslot.healthbuff();
    	} else if (!(inv.helmetslot==null)){
    		val+=inv.bootslot.defBuff();
    	} else if (!(inv.gloveslot==null)){
    		val+=inv.gloveslot.healthbuff();
    	} else if (!(inv.pantslot==null)){
    		val+=inv.pantslot.healthbuff();
    	} else if (!(inv.chestplateslot==null)){
    		val+=inv.chestplateslot.healthbuff();
    	}
        return val;
    }

    public void block(Enemy enemy) {
        double def = this.def + totalDefBuff();
        enemy.block+=def;
        double magDef = this.magDef + totalMagDefBuff();
        enemy.blockMag+=magDef;
    }

    public void magicAttack(Enemy enemy) {
        Random r = new Random();
        int randomInt = r.nextInt(35+focus) + 1;
        if (randomInt < 12+enemy.dex) {
            Console.s.println("You swung your sword but lost your footing" +
                    "\n you missed");

        } else if (randomInt >= 12+enemy.dex) {
        	Console.s.println(name+" hit "+enemy.name+" with a wicked spell!");
            magAtk = magAtk + totalMagAtkBuff();
            enemy.health = enemy.health - magAtk;

        }
    }

        public void attack (Enemy enemy){
            Random r = new Random();
            int randomInt = r.nextInt(35+accuracy) + 1;
            if (randomInt < 12+enemy.dex) {
                Console.s.println("You swung your sword but lost your footing" +
                        "\n you missed");

            } else if (randomInt >= 12+enemy.dex) {
            	Console.s.println(name+" hit "+enemy.name+"!");
                atk = atk + totalatkbuff();
                enemy.health -=atk;
            }
        }
    public int chance() {
        Random rand = new Random();
        int n = rand.nextInt(25) + 1;
        return n;
    }
    public void choice(){
        Console.s.println("What would you like to do?");
        String input=Console.s.readLine();
        switch (input) {
        	case "go east":
        		move(new Point(location.x+1,location.y));
        	break;
        	case "go west":
        		move(new Point(location.x-1,location.y));
        	break;
        	case "go north":
        		move(new Point(location.x,location.y+1));
        	break;
        	case "go south":
        		move(new Point(location.x,location.y-1));
        	break;
        	case "stats":
        		printStats();
        	break;
        	case "skills":
        		skillPtScreen();
        	break;
        	case "quit":
        		Console.s.println("Where did you go? Did you exit the game?");
        		inGame=false;
        	break;
        }
    }
    
    public void combatChoice(Enemy e) {
    	Console.s.print("What do you do? ");
    	String choice=Console.s.readLine();
    	switch (choice){
    		case "attack":
    			attack(e);
    		break;
    		case "attack mag":
    			magicAttack(e);
    		break;
    		case "block":
    			block(e);
    		break;
    		case "?":
    			Console.s.println("? - shows this screen");
    			Console.s.println("attack - attack the enemy");
    			Console.s.println("attack - attack the enemy with magic");
    			Console.s.println("block - block the enemy");
    		break;
    	}
    }

    public void printStats(){
    	Console.s.println("--"+name+"--");
        Console.s.println("Location: ("+location.x+","+location.y+")");
        Console.s.println("Health: "+health+"/"+maxHealth);
    }
    
    public void loot(livingbeing l) {
    	//put looting code here
    	for (items i:l.inv) {
    		inv.additem(i);
    		l.inv.remove(i);
    	}
    	skillPts++;
    }
    }

