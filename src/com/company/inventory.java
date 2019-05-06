package com.company;

import java.util.ArrayList;

import com.company.items.boots;
import com.company.items.chestplate;
import com.company.items.gloves;
import com.company.items.helmet;
import com.company.items.items;

import gameutil.text.Console;

import com.company.items.*;

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
            if(storageslots.get(i).type().equalsIgnoreCase(wep)){
            	//makes sure that item can be used as a weapon
            	if (storageslots.get(i).type().contains("wep;")) {
            		weapon equipedWeapon=weaponSlot;
            		weaponSlot=(weapon) storageslots.get(i);
            		storageslots.remove(storageslots.get(i));
            		//put the current weapon back into inventory if there is one
            		if (!(weaponSlot==null)) {
            			storageslots.add(i,weaponSlot);
            		}
            		
            	} else {
            		Console.s.println("That is not a weapon.");
            	}
            }
            else {
                Console.s.println("You don't have this item.");
            }
        }

    }
    public void equipBoot(String boot){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).name().equalsIgnoreCase(boot)){
            	if (storageslots.get(i).type().contains("boot;")) {
            		boots equipedBoots=bootslot;
            		bootslot=(boots)storageslots.get(i);
            		storageslots.remove(storageslots.get(i));
            		if (!(bootslot==null)){
            			storageslots.add(i,equipedBoots);
            		}
            		
            	} else {
            		Console.s.println("That is not a boot or set of boots.");
            	}
            }
            else {
                Console.s.println("You don't have this item.");
            }
        }

    }
    public void equipglove(String glove){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).name().equalsIgnoreCase(glove)){
            	if (storageslots.get(i).type().contains("glov;")) {
            		gloves equipedGloves = gloveslot;
            		gloveslot=(gloves) storageslots.get(i);
            		storageslots.remove(storageslots.get(i));
            		if (!(equipedGloves==null)) {
            			storageslots.add(equipedGloves);
            		}
            	} else {
            		Console.s.println("That is not a glove or a set of gloves.");
            	}
                
            }
            else {
                Console.s.println("You don't have this item.");
            }
        }

    }
    public void equiphelm(String helm){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).name().equalsIgnoreCase(helm)){
            	if (storageslots.get(i).type().contains("helm;")) {
            		helmet equipedHelmet=helmetslot;
                	helmetslot=(helmet) storageslots.get(i);
                	storageslots.remove(storageslots.get(i));
                	if (!(equipedHelmet==null)) {
                		storageslots.add(equipedHelmet);
                	}
            	} else {
            		Console.s.println("You dont have this item.");
            	}
            }
        }
    }
    
    public void equipchestplate(String plate){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).name().equalsIgnoreCase(plate)){
            	if (storageslots.get(i).type().contains("chplt;")) {
            		chestplate equipchestplate=chestplateslot;
            		chestplateslot=(chestplate) storageslots.get(i);
                	storageslots.remove(storageslots.get(i));
               		if (!(equipchestplate==null)) {
                		storageslots.add(equipchestplate);
                	}
            	} else {
            		Console.s.println("That is not a chestplate or a set of chestplates.");
            	}
            } else {
                Console.s.println("You dont have this item.");
            }
        }

    }

    public void sellItem(String sell){
        for(int i=0; i<storageslots.size(); i++ ){
            if(storageslots.get(i).name().equalsIgnoreCase(sell)){
                gold = storageslots.get(i).goldvalue() + gold;
                storageslots.remove(storageslots.get(i));
            } else {
                Console.s.println("you dont have this item.");
            }
        }
    }
    
    public void additem(items item){
        storageslots.add(item);
    }


}
