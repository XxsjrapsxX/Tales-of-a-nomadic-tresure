package com.company;

import java.awt.Point;
import java.util.ArrayList;

import com.company.items.items;

import gameutil.text.Console;

public class livingbeing{
	public String name;
    public double health;
    public double maxHealth;
    public double atk=0.0 ;
    public double wisdom;
    public double def;
    public double magLimit ;
    public double magAtk;
    public double magDef ;
    public double karma ;
    public double charisma ;
    public double dex;
    public int EXP;
    public int focus;//(magic accuracy)
    public int accuracy;
    public String classes;
    public String race ;
    public int bluntWeaponresistance;
    public int swordresistance;
    public int axeresistance;
    public int arrowresistence;
    public int potionresistence;
    public double attackType;
    public double dmgTaken;
    public Point location;
    public boolean alive;
    public boolean sneaking=false;
    public ArrayList<items> inv;
    public static final int D_E=1;
    public static final int D_N=0;
    public static final int D_W=3;
    public static final int D_S=2;
    public static final int D_NE=4;
    public static final int D_SE=5;
    public static final int D_SW=6;
    public static final int D_NW=7;
    public static final int D_NULL=8;
    
    public static final int spdX[]={0,1,0,-1,1,1,-1,-1,0};
    public static final int spdY[]={1,0,-1,0,1,-1,-1,1,0};
    
    
    public livingbeing(int x,int y) {
    	location=new Point(x,y);
    	alive=true;
    	inv=new ArrayList<>();
    }
    
    public void move(Point p){
    	location=p;
    	Console.s.println(name+" move to ("+p.x+", "+p.y+")");
    }
    
    public void move(int direction) {
    	location.setLocation(location.x+spdX[direction], location.y+spdY[direction]);
    }
    
    public void move(int direction,int velocity) {
    	location.setLocation(location.x+(spdX[direction]*velocity), location.y+(spdY[direction]*velocity));
    }
    
    public int directionTo(livingbeing l) {
    	if (l.location.x>location.x) {
    		//is east
    		if (l.location.y>location.y) {
        		//is north east
    			return D_NE;
    		} if (l.location.y<location.y) {
    			//is south east
    			return D_SE;
    		} else {
    			//is east
    			return D_E;
    		}
    	} else if (l.location.y>location.y) {
    		//is north and not east or south
    		if (l.location.x<location.x) {
    			//is north west
    			return D_NW;
    		}
    	} else if (l.location.y<location.y) {
    		//is south and not north or east
    		if (l.location.x<location.x) {
    			//is south west
    			return D_SW;
    		} else {
    			//is south
    			return D_S;
    		}
    	} else if (l.location.x<location.x) {
    		//is west
    		return D_W;
    	}
    	return D_NULL;
    }
    
    public void moveToward(livingbeing l,int velocity){
    	if (velocity>distanceTo(l)){
    		move(l.location);
    	} else {
    		move(directionTo(l),velocity);
    	}
    	Console.s.println(name+" is focused on "+l.name+"...");
    }
    
    public void moveTowardWithSenses(livingbeing l,int velocity){
    	int direction=DirectionToWithSenses(l);
    	if (direction==D_NULL) {
    		move(Main.rand.nextInt(7),velocity);
    		Console.s.println(name+" is looking for "+l.name+"...");
    	} else if (velocity>distanceTo(l)){
    		move(direction,(int)distanceTo(l));
    		Console.s.println(name+" is focused on "+l.name+"...");
    	} else {
    		move(direction,velocity);
    		Console.s.println(name+" is focused on "+l.name+"...");
    	}
    	
    }
    
    public double distanceTo(livingbeing l) {
    	return l.location.distance(location);
    }
    
    public boolean checkAlive() {
    	if (health>=0) {
    		alive=true;
    		return true;
    	} else {
    		alive=false;
    		return false;
    	}
    }
    
    public void heal(double amount){
    	health+=amount;
    	if (health>maxHealth){
    		health=maxHealth;
    	}
    }
    
    public int DirectionToWithSenses(livingbeing l) {
    	if (l.sneaking) {
    		if (Main.rand.nextInt((int) (20+wisdom))>Main.rand.nextInt((int) (20+l.dex))) {
    			return directionTo(l);
    		} else {
    			return D_NULL;
    		}
    	} else {
    		return directionTo(l);
    	}
    }
    
    public String directionToString(int direction) {
    	if (direction==D_E) {
    		return "East";
    	} else if (direction==D_N) {
    		return "North";
    	} else if (direction==D_W) {
    		return "West";
    	} else if (direction==D_S) {
    		return "South";
    	} else if (direction==D_NE) {
    		return "North-East";
    	} else if (direction==D_SE) {
    		return "South-East";
    	} else if (direction==D_NW) {
    		return "North-West";
    	} else if (direction==D_SW) {
    		return "South-West";
    	} else {
    		return "Unknown";
    	}
    }
}
