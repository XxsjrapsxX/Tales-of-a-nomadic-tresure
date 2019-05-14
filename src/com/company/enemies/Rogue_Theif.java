package com.company.enemies;
import com.company.Enemy;
import com.company.Main;
import com.company.character;

import gameutil.text.Console;

public class Rogue_Theif extends Enemy{

    public Rogue_Theif(int x, int y) {
        super(x, y);
        name="The Rogue_Theif";
        race="Half-elf";
        maxHealth=25;
        health=25;
        dex=10;
        atk=5;
        charisma=19;
        magAtk=5;
        karma=8;
        focus=12;
        accuracy=13;
        def=8;
        magDef=0;
    }

    public void doubleSlash(){
        Console.s.println("The rogue raised the first dagger and cut vertically");
        Main.player.health-=atk *1.5;
        Console.s.println("The rogue raised the second dagger and cut horizontally");
        Main.player.health-=atk *1.5;
    }

    public void decideAttack(character guy) {
        int atkType=Main.rand.nextInt(3);
        if (atkType==0) {
            attack(guy);
        } else if(atkType == 1) {
            doubleSlash();
        }
    }

    public void act(){
        moveToward(Main.player,2);
    }
}
