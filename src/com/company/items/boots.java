package com.company.items;

public class boots extends items {
	
	public boots(int x,int y,String name) {
		super(x,y,name,"boot;");
	}
	
	public boots(int x,int y,String name,String additionalTypes) {
		super (x,y,name,"boot;"+additionalTypes);
	}
	
}
