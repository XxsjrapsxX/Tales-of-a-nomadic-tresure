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
    Point location=new Point(0,0);

    public character(){
        super(0,0);
        inGame=true;
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
        Console.s.print("What is your name?");
        name=Console.s.readLine();
        skillPtScreen();
    }
    
    public void skillPtScreen() {
    	boolean done=false;
    	while (!done) {
    		Console.s.println("You have "+skillPts+". What would you like to spend them on?");
        	Console.s.println("(type ? for help");
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
        		int points=Console.s.readInt();
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
        				atk+=points/2;
        				skillPts-=points;
        			break;
        			case "magAtk":
        				magAtk+=points/2;
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
        				def+=points/2;
        				skillPts-=points;
        				skillPts-=points;
        			break;
        			case "magDef":
        				magDef+=points/2;
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
        return inv.weaponSlot.atkBuff() + inv.helmetslot.atkBuff() + inv.gloveslot.atkBuff() + inv.pantslot.atkBuff() + inv.chestplateslot.atkBuff() + inv.bootslot.atkBuff();
    }

    public int totalDefBuff() {
        return inv.weaponSlot.defBuff() + inv.helmetslot.defBuff() + inv.gloveslot.defBuff() + inv.pantslot.defBuff() + inv.chestplateslot.defBuff() + inv.bootslot.defBuff();
    }

    public int totalMagAtkBuff() {
        return inv.weaponSlot.magatkBuff() + inv.helmetslot.magatkBuff() + inv.gloveslot.magatkBuff() + inv.pantslot.magatkBuff() + inv.chestplateslot.magatkBuff() + inv.bootslot.magatkBuff();
    }
    public int totalMagDefBuff() {
        return inv.weaponSlot.magDefBuff() + inv.helmetslot.magDefBuff() + inv.gloveslot.magDefBuff() + inv.pantslot.magDefBuff() + inv.chestplateslot.magDefBuff() + inv.bootslot.magDefBuff();
    }

    public int totalHealthBuff() {
        return inv.weaponSlot.healthbuff() + inv.helmetslot.healthbuff() + inv.gloveslot.healthbuff() + inv.pantslot.healthbuff() + inv.chestplateslot.healthbuff() + inv.bootslot.healthbuff();
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
                atk = atk + totalatkbuff();
                enemy.health = totalHealthBuff() - atk;
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
        		location.move(location.x-1,location.y);
        	break;
        	case "go west":
        		location.move(location.x+1,location.y);
        	break;
        	case "go north":
        		location.move(location.x,location.y-1);
        	break;
        	case "go south":
        		location.move(location.x,location.y+1);
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

