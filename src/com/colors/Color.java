package com.colors;

public enum Color {
	WHITE(8000), BLACK(10000), BLUE(7500), SILVER(8000), BURGANDY(12000);
	private double addCharge;
	
	private Color(double addCharge) {
		this.addCharge = addCharge;
	}

	public double getAddCharge() {
		return addCharge;
	}
	
	public void setAddCharge(double addCharge) {
		this.addCharge = addCharge;
	}
}
