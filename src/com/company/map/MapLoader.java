package com.company.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MapLoader {
    public static void main(String[] unicornMaps){
        MapLoader mappy=new MapLoader();
        mappy.LoadSector(0,0);
    }
    public MapLoader(){
    }

    public void LoadSector(int x,int y){
        File file;
        file=new File("assets/maps/"+x+"y"+y+".sec");
        FileInputStream fileIn;
        try {
            new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        
    }
}
