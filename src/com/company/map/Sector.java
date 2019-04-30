package com.company.map;

import com.company.map.Biome.Biome;
import com.company.map.Tile.Tile;

import java.util.ArrayList;

public class Sector {
    Biome biome;
    Tile[] tiles;
    public Sector(Tile[] tiles,Biome biome){
        this.tiles=tiles;
        this.biome=biome;
    }
}
