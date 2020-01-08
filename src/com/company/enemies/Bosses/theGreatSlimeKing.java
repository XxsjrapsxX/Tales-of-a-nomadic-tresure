package com.company.enemies.Bosses;
import com.company.Enemy;
import com.company.Main;
import com.company.character;

import gameutil.text.Console;

public class theGreatSlimeKing extends Enemy {

    public theGreatSlimeKing(int x, int y) {
        super(x, y);
        name = "The theGreatSlimeKing";
        race = "Slime";
        maxHealth = 125;
        health = 125;
        dex = 8;
        atk = 17;
        charisma = 0;
        magAtk = 16;
        karma = 10;
        focus = 8;
        accuracy = 10;
        def = 20;
        magDef = 20;
        EXP=200;
    }

    public void slimeSpikeVolley() {
        Console.s.println("The great slime king sent slime flying");
        attack(Main.player);
        attack(Main.player);
        attack(Main.player);
    }

    public void decideAttack(character guy) {
        int atkType = Main.rand.nextInt(3);
        if (atkType == 0) {
            attack(guy);
        } else if (atkType == 1) {
            slimeSpikeVolley();
        }
    }

    public void act(){
        
    }
}
