package com.code.sample4.travel;

public class RTest {
	
	public static void main(String[] args) {
		RTest o = new RTest();
		o.R();
	}
	
	public void R() {
		for(int i=0; i<10; i++) {
			RFn(0 + 1);
		}
	}
	
	public void RFn(int i) {
		System.out.println(i);
	}

}
