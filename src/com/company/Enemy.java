package com.company;

import java.util.Random;

import gameutil.text.Console;

public class Enemy extends livingbeing {
    String StatusEffect;
    String Niceness;
    int agro;
    //Type/race/monstername
    public Enemy(int x,int y){
    	super(x,y);
    }

    public double attack (character guy){
        Random r = new Random();
        int randomInt = r.nextInt(45) + 1;
        if (randomInt < 12) {
            Console.s.println("the enemey swung your sword but lost its footing" +
                    "\n it missed");

        } else if (randomInt >= 12) {

            guy.health = health - atk;
            attackType = 1;
            return attackType;
        }
        return guy.health;
    }

    public double magicAttack(character guy) {
        Random r = new Random();
        int randomInt = r.nextInt(45) + 1;
        if (randomInt < 12) {
            Console.s.println("the enemy casted a wicked spell" +
                    "\n but it missed");

        } else if (randomInt >= 12) {
        	double damage=magAtk-guy.magDef;
        	if (damage<0) {
        		damage=0;
        	}
            guy.health = guy.health - (magAtk-guy.magDef);
            attackType = 2;
            return attackType;

        }
        return guy.health;
    }
    public int chance() {
        Random rand = new Random();
        int n = rand.nextInt(25) + 1;
        return n;
    }
    
    public void decideAttack() {
    	
    }
    
    public void checkBattle() {
    	if (location.equals(Main.player.location)) {
    		Main.battle(this);
    	}
    }
    
    public 

}
