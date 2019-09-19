package com.company.enemies;

import com.company.Enemy;
import com.company.Main;
import com.company.character;

public class Slime extends Enemy {
	public Slime(int x,int y) {
		super(x,y);
		name="Slime";
		race="Slime";
		classes="none";
		maxHealth=10;
		health=10;
		dex=2;
		atk=4;
		charisma=1;
        magAtk=0;
        karma=0;
        focus=0;
        accuracy=12;
        def=0;
        magDef=0;
        EXP = 5;
	}
	
	public void decideAttack(character guy){
		attack(guy);
	}
	
	public void act(){
		
	}
}
