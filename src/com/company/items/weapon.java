package com.company.items;

public class weapon extends items {
    //statuseffect
    //usability
	public weapon(int x,int y,String name) {
		super (x,y,name,"wep;");
	}
	
	public weapon(int x,int y,String name,String additionalTypes) {
		super (x,y,name,"wep;"+additionalTypes);
	}


}
