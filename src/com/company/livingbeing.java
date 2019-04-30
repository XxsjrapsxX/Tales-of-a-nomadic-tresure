package com.company;

import java.awt.*;
import java.util.ArrayList;

public class livingbeing{
    String name;
    Point location;
    double health;
    double maxHealth;
    double atk=0.0;
    double def;
    double magLimit;
    double magAtk;
    double magDef;
    double karma;
    double charisma;
    double dex;
    String[] classes;
    String[] race ;
    int bluntWeaponresistance;
    int swordresistance;
    int axeresistance;
    int arrowresistence;
    int potionresistence;
    double attackType;
    double dmgTaken;
    public static final double PHYSICAL_ATK=1;
    public static final double MAGICAL_ATK=2;

    public livingbeing(int x,int y){
      location=new Point(x,y);
    }
}
