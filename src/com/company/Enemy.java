package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends livingbeing {
    String StatusEffect;
    String Niceness;
    int agro;
    public static final ArrayList<Enemy> instances=new ArrayList<>();
    //Type/race/monstername
    public Enemy(int x,int y){
        super(x,y);
        instances.add(this);
    }

    public double attack (character guy){
        Random r = new Random();
        int randomInt = r.nextInt(45) + 1;
        if (randomInt < 12) {
            System.out.println("the enemey swung your sword but lost its footing" +
                    "\n it missed");

        } else if (randomInt >= 12) {

            guy.health = health - atk;
            attackType = 1;
            return attackType;
        }
        return guy.health;
    }

    public double magicAttack(character guy) {
        Random r = new Random();
        int randomInt = r.nextInt(45) + 1;
        if (randomInt < 12) {
            System.out.println("the enemy casted a wicked spell" +
                    "\n but it missed");

        } else if (randomInt >= 12) {

            guy.health = guy.health - magAtk;
            attackType = 2;
            return attackType;

        }
        return guy.health;
    }
    public int chance() {
        Random rand = new Random();
        int n = rand.nextInt(25) + 1;
        return n;
    }

}
