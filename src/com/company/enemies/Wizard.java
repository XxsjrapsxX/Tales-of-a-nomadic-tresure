package com.company.enemies;

import com.company.Enemy;
import com.company.Main;
import com.company.character;

import gameutil.text.Console;

public class Wizard extends Enemy{

	public Wizard(int x, int y) {
		super(x, y);
		name="Wizard";
		race="Wizard";
		maxHealth=30;
		health=30;
		dex=3;
		atk=2;
		charisma=10;
		magAtk=4;
		karma=0;
		focus=12;
		accuracy=8;
		def=0;
		magDef=4;
		EXP = 20;
	}

	public void castHealSpell(){
		Console.s.println("Wizard cast a healing spell!");
		heal(Main.rand.nextInt(2)+.1);
	}

	public void decideAttack(character guy) {
		int atkType=Main.rand.nextInt(3);
		if (atkType==0) {
			attack(guy);
		} else if (atkType==1){
			magicAttack(guy);
		} else {
			castHealSpell();
		}
	}

	public void act(){
		if (distanceTo(Main.player)>15&&health<30){
			castHealSpell();
		} else if (health<=10){
			castHealSpell();
		} else {
			moveToward(Main.player,2);
		}
	}
}
