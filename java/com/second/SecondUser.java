package com.second;

import org.springframework.stereotype.Component;

@Component
public class SecondUser {
	public void secondUser() {
		System.out.println("			Second User Called ");
	}

	public SecondUser() {
		super();
		System.out.println("			 Object Created for Second User ");
	}

}
