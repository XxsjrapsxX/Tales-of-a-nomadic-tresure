package com.company.enemies;

import com.company.Enemy;
import com.company.Main;
import com.company.character;

import gameutil.text.Console;

public class Warrior extends Enemy{

    public Warrior(int x, int y) {
        super(x, y);
        name="The Warrior";
        race="Dwarf";
        maxHealth=60;
        health=60;
        dex=6;
        atk=8;
        charisma=4;
        magAtk=0;
        karma=8;
        focus=12;
        accuracy=13;
        def=14;
        magDef=0;
    }

    public void HeavySwing(){
        Console.s.println("The warrior sliced through the air with great force!!");
        Main.player.health-=atk * 2;
    }

    public void decideAttack(character guy) {
        int atkType=Main.rand.nextInt(3);
        if (atkType==0) {
            attack(guy);
        } else if(atkType == 1) {
            HeavySwing();
        }
    }

    public void act(){
        moveToward(Main.player,2);
    }
}
