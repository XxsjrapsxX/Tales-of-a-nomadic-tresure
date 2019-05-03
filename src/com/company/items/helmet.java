package com.company.items;

public class helmet extends items {
	
	public helmet(int x,int y,String name) {
		super(x,y,name,"helm;");
	}
	
	public helmet(int x,int y,String name,String additionalTypes) {
		super(x,y,name,"helm;"+additionalTypes);
	}
}
