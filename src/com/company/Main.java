package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

import com.company.enemies.Mage;
import com.company.enemies.Slime;
import com.company.enemies.Wizard;
import com.company.tiles.Tile;

import gameutil.geom.g2D.PointR2;
import gameutil.text.Console;

public class Main extends inventory {
    public static character player;
    public static Random rand=new Random();
    public static Hashtable<PointR2,Tile> tiles;
    public static ArrayList<Enemy> deadEnemies;
    public static void main(String[] args) {
		//Console.s.readLineInt();
		Console.s.setUserNextLineEnabled(false);
    	Console.s.setTheme(Console.theme.shell2);
        player=new character();
        while (player.inGame){
        	Console.s.setTheme(Console.theme.sea);
            player.choice();
            Console.s.setTheme(Console.theme.sea);
            checkForBattle();
        }

    }
    
    public static void battle(ArrayList<Enemy> enemies) {
    	for (Enemy e:enemies) {
    		if (e.dex>player.dex) {
        		//enemy goes first
        		e.act();
        		if (player.alive) {
        			player.combatChoice(e);
        			if (!e.checkAlive()) {
        				player.loot(e);
        				player.lvUp(e);
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
        			player.lvUp(e);
        		}
        	} else {
        		//both go at the same time
        		player.combatChoice(e);
        		e.act();
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
        		for (Enemy e:deadEnemies){
        			if (!e.checkAlive()){
        			enemies.remove(e);
        			}
        		}
    	}
    }
    
    public static void addTile(Tile t) {
    	tiles.put(new PointR2(t.getX(), t.getY()),t);
    }

}
