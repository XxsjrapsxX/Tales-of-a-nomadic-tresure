package com.company.tiles;

public class Tile {
	int x;
	int y;
	double battleChance;
	double itemChance;
	
	public Tile(int x,int y) {
		this.x=x;
		this.y=y;
		battleChance=0;
		itemChance=0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
