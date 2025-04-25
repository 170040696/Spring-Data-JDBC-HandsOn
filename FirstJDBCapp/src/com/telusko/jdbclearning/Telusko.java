package com.telusko.jdbclearning;

public class Telusko {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
	//	demo d=new demo();
		Class.forName("com.telusko.jdbclearning.demo").newInstance();
	}
}

class demo{
//	demo(){
//		System.out.println("Constructor");
//	}
	{
		System.out.println("non-static block  or   Instance block");
	}
	static{
		System.out.println("Static block");
	}
	
	
}
