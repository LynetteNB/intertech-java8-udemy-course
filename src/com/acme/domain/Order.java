package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	String product;
	int quantity;
	public static double taxRate;

	static {
		taxRate = .05;
	}
	
	public Order(MyDate d, double amt, String c, String p, int q){
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}
	public Order(MyDate d, double amt, String c) {
		this(d, amt, c, "Anvil", 1);
	}
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}

	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}

	public static void computeTaxOn(double amount) {
		System.out.println("The tax for " + amount + " is: " + amount * taxRate);
	}

	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * taxRate);
		return orderAmount * taxRate;
	}

	public char jobSize() {
		if(quantity <= 25) {
			return 'S';
		} else if(quantity <= 75) {
			return 'M';
		} else if(quantity <= 150) {
			return 'L';
		} else {
			return 'X';
		}
	}

	public double computeTotal() {
		double discount = 0.0;
		switch(jobSize()) {
			case 'M':
				discount = .01;
				break;
			case 'L':
				discount = .02;
				break;
			case 'X':
				discount = .03;
				break;
		}
		double orderTotal = orderAmount - discount * orderAmount;
		if(orderAmount < 1500) {
			orderTotal += computeTax();
		}
		return orderTotal;
	}
}
