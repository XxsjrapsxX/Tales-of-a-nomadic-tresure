package com.company.map;

import java.util.ArrayList;

public class Map {
    ArrayList<Sector> sectors;
    public Map(){
        sectors=new ArrayList<>();
    }
    public void addSector(Sector sector){
        sectors.add(sector);
    }
}
