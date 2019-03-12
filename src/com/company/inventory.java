package com.company;

import java.util.ArrayList;

public class inventory  {
    weapon weaponSlot;
    chestplate chestplateslot;
    pants pantslot;
    boots bootslot;
    gloves gloveslot;
    helmet helmetslot;
    int gold;

    ArrayList <items> storageslots;

    public void equipWep(String wep){
       
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).itemname.equalsIgnoreCase(wep)){
                weaponSlot=(weapon) storageslots.get(i);
                storageslots.remove(storageslots.get(i));
            }
            else {
                System.out.println("you dont have this item.");
            }
        }

    }
    public void equipBoot(String boot){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).itemname.equalsIgnoreCase(boot)){
                bootslot=(boots)storageslots.get(i);
                storageslots.remove(storageslots.get(i));
            }
            else {
                System.out.println("you dont have this item.");
            }
        }

    }
    public void equipglove(String glove){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).itemname.equalsIgnoreCase(glove)){
                gloveslot=(gloves) storageslots.get(i);
                storageslots.remove(storageslots.get(i));
            }
            else {
                System.out.println("you dont have this item.");
            }
        }

    }
    public void equiphelm(String helm){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).itemname.equalsIgnoreCase(helm)){
                helmetslot=(helmet) storageslots.get(i);
                storageslots.remove(storageslots.get(i));
            }
            else {
                System.out.println("you dont have this item.");
            }
        }

    }
    public void equipchestplate(String plate){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).itemname.equalsIgnoreCase(plate)){
                chestplateslot=(chestplate) storageslots.get(i);
                storageslots.remove(storageslots.get(i));
            }
            else {
                System.out.println("you dont have this item.");
            }
        }

    }

    public void sellItem(String sell){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).itemname.equalsIgnoreCase(sell)){
                gold = storageslots.get(i).goldvalue + gold;
                storageslots.remove(storageslots.get(i));
            }
            else {
                System.out.println("you dont have this item.");
            }
        }

    }
    public void additem(items item){
        storageslots.add(item);
    }


}
