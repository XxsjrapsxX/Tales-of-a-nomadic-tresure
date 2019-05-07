package com.company;

import java.util.Random;

import gameutil.text.Console;

public class Enemy extends livingbeing {
    String StatusEffect;
    String Niceness;
    int agro;
    double block=0;
    double blockMag=0;
    //Type/race/monstername
    public Enemy(int x,int y){
    	super(x,y);
    }

    public double attack (character guy){
        Random r = new Random();
        int randomInt = r.nextInt(35+accuracy) + 1;
        if (randomInt < 12+guy.dex) {
            Console.s.println("the enemey swung your sword but lost its footing" +
                    "\n it missed");

        } else if (randomInt >= 12+guy.dex) {
        	double damage=atk-block;
        	if (damage<0) {
        		damage=0;
        	}
            guy.health = health - damage;
            attackType = 1;
            return attackType;
        }
        block=0;
        blockMag=0;
        return guy.health;
    }

    public double magicAttack(character guy) {
        Random r = new Random();
        int randomInt = r.nextInt(35+focus) + 1;
        if (randomInt < 12+guy.dex) {
            Console.s.println("the enemy casted a wicked spell" +
                    "\n but it missed");

        } else if (randomInt >= 12+guy.dex) {
        	double damage=magAtk-blockMag;
        	if (damage<0) {
        		damage=0;
        	}
            guy.health = guy.health - magAtk;
            attackType = 2;
            return attackType;

        }
        block=0;
        blockMag=0;
        return guy.health;
    }
    public int chance() {
        Random rand = new Random();
        int n = rand.nextInt(25) + 1;
        return n;
    }
    
    public void decideAttack(character guy) {
    	int atkType=Main.rand.nextInt(2);
    	if (atkType==0) {
    		attack(guy);
    	} else {
    		magicAttack(guy);
    	}
    }
    
    public void checkBattle() {
    	if (location.equals(Main.player.location)) {
    		Console.s.setTheme(Console.theme.forest);
    		while (Main.player.checkAlive()&&checkAlive()) {
    			Main.battle(this);
    		}
    	}
    }
    
    /**What the enemy should do on it's turn outside of combat
     * 
     */
    public void act() {
    	
    }

}
