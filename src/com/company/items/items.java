package com.company.items;

import java.util.ArrayList;

import com.company.livingbeing;

public class items extends livingbeing {
    protected String itemname;
    protected String itemtype;
    protected int healthbuff;
    protected int atkBuff;
    protected int defBuff;
    protected int magDefBuff;
    protected int magatkBuff;
    protected int goldvalue;
    protected int itemweight;
    //statuseffect
    protected String statusEffect;
    //usability
    protected double Durability;
    protected int specialEvents;
    ArrayList<weapon> weapons = new ArrayList<weapon>();
    ArrayList<chestplate>chestplates = new ArrayList<chestplate>();
    ArrayList<helmet>helmets = new ArrayList<helmet>();
    ArrayList<boots>boots = new ArrayList<boots>();
    ArrayList<pants>pants = new ArrayList<>();
    
    public items(int x,int y) {
    	super(x,y);
    	itemtype="misc";
    	itemname="item.null";
    }
    
    public items(int x,int y,String name) {
    	super(x,y);
    	itemtype="misc";
    	itemname=name;
    }
    
    public items(int x,int y,String name,String type) {
    	super(x,y);
    	itemtype=type;
    	itemname=name;
    }
    
    public String name() {
    	return itemname;
    }
    
    public String type() {
    	return itemtype;
    }
    
    public int goldvalue() {
    	return goldvalue;
    }
    
    public int weight() {
    	return itemweight;
    }
    
    public int healthbuff() {
    	return healthbuff;
    }
    
    public int atkBuff() {
    	return atkBuff();
    }
    
    public int defBuff() {
    	return defBuff;
    }
    
    public int magDefBuff() {
    	return magDefBuff;
    }
    
    public int magatkBuff() {
    	return magatkBuff;
    }
    
    public int itemweight() {
    	return itemweight;
    }
}
