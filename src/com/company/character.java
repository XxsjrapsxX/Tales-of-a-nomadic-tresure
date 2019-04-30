package com.company;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;
import java.util.Scanner;

public class character extends livingbeing {
    Scanner console = new Scanner(System.in);
    private final static String[] choices={"go east","go west","go north","go south","stats","quit"};
    //personal only meant for char, was meant to be for decriptions or for a romance option later on
    String haircolor;
    String eyecolor;
    String races;
    inventory inv;
    String bodybuild;
    boolean inGame;
    Point location=new Point(0,0);

    public character(){
        super();
        inGame=true;
    }

    public int totalatkbuff() {
        return inv.weaponSlot.atkBuff + inv.helmetslot.atkBuff + inv.gloveslot.atkBuff + inv.pantslot.atkBuff + inv.chestplateslot.atkBuff + inv.bootslot.atkBuff;
    }

    public int totalDefBuff() {
        return inv.weaponSlot.defBuff + inv.helmetslot.defBuff + inv.gloveslot.defBuff + inv.pantslot.defBuff + inv.chestplateslot.defBuff + inv.bootslot.defBuff;
    }

    public int totalMagAtkBuff() {
        return inv.weaponSlot.magatkBuff + inv.helmetslot.magatkBuff + inv.gloveslot.magatkBuff + inv.pantslot.magatkBuff + inv.chestplateslot.magatkBuff + inv.bootslot.magatkBuff;
    }
    public int totalMagDefBuff() {
        return inv.weaponSlot.magDefBuff + inv.helmetslot.magDefBuff + inv.gloveslot.magDefBuff + inv.pantslot.magDefBuff + inv.chestplateslot.magDefBuff + inv.bootslot.magDefBuff;
    }

    public int totalHealthBuff() {
        return inv.weaponSlot.healthbuff + inv.helmetslot.healthbuff + inv.gloveslot.healthbuff + inv.pantslot.healthbuff + inv.chestplateslot.healthbuff + inv.bootslot.healthbuff;
    }

    public void block(Enemy enemy) {
        if(enemy.attackType == 1) {
            def = def + totalDefBuff();
            enemy.atk = enemy.atk - def;
            if(enemy.atk >=0) {
                health = health - enemy.atk;
            }

        }
        else if(attackType == 2){
            magDef = magDef + totalMagDefBuff();
            enemy.magAtk = enemy.atk - magDef;
            if(enemy.magDef >=0) {
                health = health - enemy.magAtk;
            }
        }
    }

    public void magicAttack(Enemy enemy) {
        Random r = new Random();
        int randomInt = r.nextInt(45) + 1;
        if (randomInt < 12) {
            System.out.println("You swung your sword but lost your footing" +
                    "\n you missed");

        } else if (randomInt >= 12) {
            magAtk = magAtk + totalMagAtkBuff();
            enemy.health = enemy.health - magAtk;

        }
    }

        public void attack (Enemy enemy){
            Random r = new Random();
            int randomInt = r.nextInt(45) + 1;
            if (randomInt < 12) {
                System.out.println("You swung your sword but lost your footing" +
                        "\n you missed");

            } else if (randomInt >= 12) {
                atk = atk + totalatkbuff();
                enemy.health = totalHealthBuff() - atk;
            }
        }
    public int chance() {
        Random rand = new Random();
        int n = rand.nextInt(25) + 1;
        return n;
    }
    public void choice(){
            System.out.println("What would you like to do?");
        String input=console.nextLine();
        if(input.equals(choices[0])){
            //go east
            location.move(location.x-1,location.y);
        } else if (input.equals(choices[1])){
            //go west
            location.move(location.x+1,location.y);
        } else if (input.equals(choices[2])){
            //go north
            location.move(location.x,location.y-1);
        } else if (input.equals(choices[3])){
            //go south
            location.move(location.x,location.y+1);
        } else if (input.equals(choices[4])){
            //print statistics
            printStats();
        } else if (input.equals(choices[5])){
            //exit
            System.out.println("Where did you go? Did you exit the game?");
            inGame=false;
        }
    }

    public void printStats(){
        System.out.println("Location: ("+location.x+","+location.y+")");
        System.out.println("Health: "+health+"/"+maxHealth);
    }

    }

