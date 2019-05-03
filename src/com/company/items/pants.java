package com.company.items;

public class pants extends items {
	
	public pants(int x,int y,String name) {
		super (x,y,name,"pant;");
	}
	
	public pants(int x,int y,String name,String additionalTypes) {
		super (x,y,name,"pant;"+additionalTypes);
	}
	
}
