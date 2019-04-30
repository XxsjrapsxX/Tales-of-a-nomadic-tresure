package com.company;

import java.util.ArrayList;

public class items extends livingbeing {
    String itemname;
    int healthbuff;
    int atkBuff;
    int defBuff;
    int magDefBuff;
    int magatkBuff;
    int goldvalue;
    int itemweight;
    //statuseffect
    String statusEffect;
    //usability
    double Durability;
    int specialEvents;
    ArrayList<weapon> weapons = new ArrayList<weapon>();
    ArrayList<chestplate>chestplates = new ArrayList<chestplate>();
    ArrayList<helmet>helmets = new ArrayList<helmet>();
    ArrayList<boots>boots = new ArrayList<boots>();
    ArrayList<pants>pants = new ArrayList<>();

}
