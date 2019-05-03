package com.company.items;

public class gloves extends items{
	
	public gloves(int x,int y,String name) {
		super (x,y,name,"glov;");
	}
	
	public gloves(int x,int y,String name,String additionalTypes) {
		super (x,y,name,"glov;"+additionalTypes);
	}
	
}
