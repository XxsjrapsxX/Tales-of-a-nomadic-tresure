package com.company.enemies;

import com.company.Enemy;
import com.company.Main;
import com.company.character;

import gameutil.text.Console;

public class Mage extends Enemy{

    public Mage(int x, int y) {
        super(x, y);
        name="The mage";
        race="Mage";
        maxHealth=30;
        health=30;
        dex=3;
        atk=2;
        charisma=10;
        magAtk=4;
        karma=0;
        focus=12;
        accuracy=8;
        def=0;
        magDef=4;
    }

    public void castFireSpell(){
        Console.s.println("Wizard cast a Fire spell!");
        Main.player.health-=magAtk +atk;
    }

    public void decideAttack(character guy) {
        int atkType=Main.rand.nextInt(3);
        if (atkType==0) {
            attack(guy);
        } else if (atkType==1){
            magicAttack(guy);
        } else {
            castFireSpell();
        }
    }

    public void act(){
        if (distanceTo(Main.player)>15&&health<30){
            castHealSpell();
        } else if (health<=10){
            castHealSpell();
        } else {
            moveToward(Main.player,2);
        }
    }
}