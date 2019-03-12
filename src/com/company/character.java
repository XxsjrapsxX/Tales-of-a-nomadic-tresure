package com.company;

import java.util.Random;

public class character extends livingbeing {
    String haircolor;
    String eyecolor;
    String races;
    inventory inv;
    livingbeing stats;

    public int totalatkbuff() {
        return inv.weaponSlot.atkBuff + inv.helmetslot.atkBuff + inv.gloveslot.atkBuff + inv.pantslot.atkBuff + inv.chestplateslot.atkBuff + inv.bootslot.atkBuff;
    }

    public int totalDefBuff() {
        return inv.weaponSlot.defBuff + inv.helmetslot.defBuff + inv.gloveslot.defBuff + inv.pantslot.defBuff + inv.chestplateslot.defBuff + inv.bootslot.defBuff;
    }

    public int totalMagAtkBuff() {
        return inv.weaponSlot.magatkBuff + inv.helmetslot.magatkBuff + inv.gloveslot.magatkBuff + inv.pantslot.magatkBuff + inv.chestplateslot.magatkBuff + inv.bootslot.magatkBuff;
    }

    public int totalHealthBuff() {
        return inv.weaponSlot.healthbuff + inv.helmetslot.healthbuff + inv.gloveslot.healthbuff + inv.pantslot.healthbuff + inv.chestplateslot.healthbuff + inv.bootslot.healthbuff;
    }

    public void block(Enemy enemy) {
        def = def + totalDefBuff();
        atk = atk - def;
        health = health - atk;

    }

    public void magicAttack(Enemy enemy) {
        Random r = new Random();
        int randomInt = r.nextInt(45) + 1;
        if (randomInt < 12) {
            System.out.println("You swung your sword but lost your footing" +
                    "\n you missed");

        } else if (randomInt >= 12) {
            magAtk = magAtk + totalMagAtkBuff();
            health = totalHealthBuff() - magAtk;

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
                health = totalHealthBuff() - atk;
            }
        }
    }

