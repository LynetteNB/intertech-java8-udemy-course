package com.acme.domain;

import com.acme.utils.HolidayOrdersNotAllowedException;
import com.acme.utils.MyDate;

public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
	private static double taxRate;
	private static Rushable rushable;

	static {
		taxRate = .05;
	}
	
	public Order(MyDate d, double amt, String c, Product p, int q){
		try {
			setOrderDate(d);
		} catch (HolidayOrdersNotAllowedException e) {
			System.out.println("The order date for an order cannot be a holiday! Application closing");
			System.exit(0);
		}
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}

	public Order(MyDate d, double amt, String c) {
		this(d, amt, c, new Solid("Acme Anvil", 1668, 0.3, Good.UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3), 1);
	}

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) throws HolidayOrdersNotAllowedException{
		if(isHoliday(orderDate)) {
			System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
			throw new HolidayOrdersNotAllowedException(orderDate);
		}
		else {
			this.orderDate = orderDate;
		}
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if(orderAmount >= 0) {
			this.orderAmount = orderAmount;
		}
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public static Rushable getRushable() {
		return rushable;
	}

	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}

	public void setQuantity(int quantity) {
		if(quantity >= 0) {
			this.quantity = quantity;
		}
	}

	public static double getTaxRate() {
		return taxRate;
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

	public boolean isPriorityOrder() {
		boolean priorityOrder = false;
		if(rushable != null) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		}
		return priorityOrder;
	}

	private boolean isHoliday(MyDate proposedDate) {
		boolean result = false;
		for(MyDate holiday: MyDate.getHolidays()) {
			if(holiday.equals(proposedDate))
				result = true;
		}
		return result;
	}
}
