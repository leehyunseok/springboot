package com.example.app;

import org.springframework.stereotype.Component;

@Component
public class AddCalculator implements Calculator {

	@Override
	public int calc(int a, int b) {
		// TODO Auto-generated method stub
		return  a  +  b ;
	}

}
