package com.Vehicle;


import java.time.LocalDate;
import com.colors.*;

public class Vehicle implements Comparable<Vehicle> {
	private String chasisNo;
	private Color vcolor;
	private LocalDate mdate;
	private double price;
	private String company;
	private boolean isAvailable;	
	
	public Vehicle(String chasisNo) {
		super();
		this.chasisNo = chasisNo;
	}

	public Vehicle(String chasisNo, String company, LocalDate mdate, Color color, double price) {
		super();
		this.chasisNo = chasisNo;
		this.vcolor = color;
		this.mdate = mdate;
		this.price = price;
		this.company = company;
		this.isAvailable = true;
	}

	public String getChasisNo() {
		return chasisNo;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Color getVcolor() {
		return vcolor;
	}

	public LocalDate getMdate() {
		return mdate;
	}

	public String getCompany() {
		return company;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	@Override
	public int compareTo(Vehicle anotherObj) {
		//Comparing the chasisNo to two different obj(s) of Vehicle class for sorting the list
		return this.chasisNo.compareTo(anotherObj.chasisNo);
	}

	@Override
	public boolean equals(Object obj) {
		//checking duplicate chasisNo
		if (obj instanceof Vehicle) {
			Vehicle v = (Vehicle) obj;
			return this.chasisNo.equals(v.chasisNo);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Vehicle: [Chasis no.: " + chasisNo + " | Company: " + company 
				+ " | Manufacturing date: " + mdate + " | Color: " + vcolor 
				+ " |Price: " + (price + vcolor.getAddCharge())
				+ " | Availability: " + isAvailable + "]";
	}
}
