package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import gameutil.text.Console;

public class Main extends inventory {
    static ArrayList<Enemy>enemies= new ArrayList<Enemy>();
    static character player;
    public static Random rand=new Random();
    public static void main(String[] args) {
    	Console.s.setTheme(Console.theme.sea);
        enemies.add(new Enemy(5,1));
        player=new character();
        while (player.inGame){
        	Console.s.setTheme(Console.theme.sea);
            player.choice();
            Console.s.setTheme(Console.theme.sea);
            for (Enemy e:enemies) {
            	e.act();
            }
        }

    }
    
    public static void battle(Enemy e) {
    	if (e.dex>player.dex) {
    		//enemy goes first
    		e.decideAttack(player);
    		if (player.alive) {
    			player.combatChoice(e);
    			if (!e.checkAlive()) {
    				player.loot(e);
    			}
    		} else {
    			Console.s.setTheme(Console.theme.shell2);
    			Console.s.println("GAME OVER");
    			player.inGame=false;
    		}
    	} else if (e.dex<player.dex) {
    		//player goes first
    		player.combatChoice(e);
    		if (e.checkAlive()) {
    			e.decideAttack(player);
    		} else {
    			player.loot(e);
    		}
    	} else {
    		//both go at the same time
    		player.combatChoice(e);
    		e.decideAttack(player);
    		if (!e.checkAlive()&&player.checkAlive()) {
    			player.loot(e);
    		}
    	}
    }
    
    public static void checkForBattle() {
    	for (Enemy e:enemies) {
    		if (!player.alive) {
    			break;
    		}
    		//if enemy is in the space of the player they will enter a battle (battle function is called)
    		e.checkBattle();
    	}
    }

}
