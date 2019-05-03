package com.company.items;

public class chestplate extends items {
	public chestplate(int x,int y,String name) {
		super (x,y,name,"chplt;");
	}
	
	public chestplate(int x,int y,String name,String additionalTypes) {
		super (x,y,name,"chplt;"+additionalTypes);
	}
}
