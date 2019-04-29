package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends inventory {
    static ArrayList<Enemy>enemies= new ArrayList<Enemy>();
    public static void main(String[] args) {
        // write your code here
        Scanner console = new Scanner(System.in);

        enemies.add(new Enemy(new livingbeing()));
        character player=new character();
        while (player.inGame){
            player.choice();
        }

    }

}
