package com.company;

import java.awt.Point;
import java.util.ArrayList;

public class livingbeing{
	protected String name;
    protected double health;
    protected double maxHealth;
    protected double atk=0.0 ;
    protected double def ;
    protected double magLimit ;
    protected double magAtk;
    protected double magDef ;
    protected double karma ;
    protected double charisma ;
    protected double dex ;
    protected String classes;
    protected double race ;
    protected int bluntWeaponresistance;
    protected int swordresistance;
    protected int axeresistance;
    protected int arrowresistence;
    protected int potionresistence;
    protected double attackType;
    protected double dmgTaken;
    protected Point location;
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
    
    public double distanceTo(livingbeing l) {
    	return l.location.distance(location);
    }
}
