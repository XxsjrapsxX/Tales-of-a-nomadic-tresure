package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.company.enemies.Slime;
import com.company.enemies.Wizard;

import gameutil.text.Console;

public class Main extends inventory {
    static ArrayList<Enemy>enemies= new ArrayList<Enemy>();
    public static character player;
    public static Random rand=new Random();
    public static void main(String[] args) {
		Console.s.readLineInt();
		Console.s.setUserNextLineEnabled(false);
    	Console.s.setTheme(Console.theme.shell2);
        enemies.add(new Slime(5,1));
        enemies.add(new Slime(10,10));
        enemies.add(new Slime(-20,42));
        enemies.add(new Wizard(100,-500));
        player=new character();
        while (player.inGame){
        	Console.s.setTheme(Console.theme.sea);
            player.choice();
            Console.s.setTheme(Console.theme.sea);
            for (Enemy e:enemies) {
            	e.act();
            }
            checkForBattle();
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
    	ArrayList<Enemy> deadEnemies=new ArrayList<>();
    	for (Enemy e:enemies) {
    		if (!player.alive) {
    			break;
    		}
    		//if enemy is in the space of the player they will enter a battle (battle function is called)
    		e.checkBattle();
    		if (!e.checkAlive()){
    			deadEnemies.add(e);
    		}
    	}
    	for (Enemy e:deadEnemies){
    		if (!e.checkAlive()){
    			enemies.remove(e);
    		}
    	}
    }

}
