package com.company.map.Tile;

import com.company.items;
import com.company.livingbeing;

import java.awt.*;
import java.util.ArrayList;

public class Tile {
    protected Point location;
    protected String name;
    protected String desc;
    protected boolean collidable;
    protected ArrayList<items> items;

    public Tile(int x,int y,boolean collidable){
        location=new Point(x,y);
        this.collidable=collidable;
    }

    public void entityEnteredTile(livingbeing entity){
        //interact with entity
    }

}
