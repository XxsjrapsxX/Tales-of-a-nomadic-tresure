package com.company.enemies.Bosses;
import com.company.Enemy;
import com.company.Main;
import com.company.character;

import gameutil.text.Console;

public class theGreatSlimeKing extends Enemy{

    public theGreatSlimeKing(int x, int y) {
        super(x, y);
        name="The theGreatSlimeKing";
        race="Half-elf";
        maxHealth=125;
        health=125;
        dex=9;
        atk=17;
        charisma=0;
        magAtk=16;
        karma=10;
        focus=8;
        accuracy=10;
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
