package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import gameutil.text.Console;

public class Main extends inventory {
    static ArrayList<Enemy>enemies= new ArrayList<Enemy>();
    static character player;
    static Random rand=new Random();
    public static void main(String[] args) {
    	Console.s.setTheme(Console.theme.forest);
        enemies.add(new Enemy(5,1));
        player=new character();
        while (player.inGame){
            player.choice();
        }

    }
    
    public static void battle(Enemy e) {
    	if (e.dex>player.dex) {
    		//enemy goes first
    		
    	} else if (e.dex<player.dex) {
    		//player goes first
    		
    	} else {
    		//both go at the same time
    		
    	}
    }
    
    public static void checkForBattle() {
    	for (Enemy e:enemies) {
    		//if enemy is in the space of the player they will enter a battle (battle function is called)
    		e.checkBattle();
    	}
    }

}
