package utils.ShowroomValidation;

import java.util.*;
import java.time.LocalDate;
import com.colors.Color;
import com.Vehicle.*;
import customException.InvalidInputException;

public class ShowroomValidation {
	public static Color validateColor(String col) throws IllegalArgumentException{
		/* IllegalArgumentException:
		 * Thrown to indicate that a method has been passed an illegal 
		 * or an inappropriate argument
		 * */		
		return Color.valueOf(col);
	}
	
	public static LocalDate validateDate(String date) throws InvalidInputException{
		LocalDate mdate = LocalDate.parse(date);
		LocalDate d = LocalDate.of(2022, 01, 01);
		if(mdate.isBefore(d)) {
			throw new InvalidInputException("Manufacturing date before 1st Jan 2022!");
		}
		return mdate;
	}
	
	public static void checkDup(String chasisNo, List<Vehicle> v) throws InvalidInputException{
		Vehicle nV = new Vehicle(chasisNo);
		if(v.contains(nV)) {
			throw new InvalidInputException("Duplicate Chasis no! Enter Correct Chasis no.");
		}
	}
	
	public static Vehicle validateAllInputs(String chasisNo, String company, String date, 
			String color, double price, List<Vehicle> v) throws IllegalArgumentException, InvalidInputException{
		Color col = validateColor(color.toUpperCase());
		LocalDate mdate = validateDate(date);
		checkDup(chasisNo, v);
		return new Vehicle(chasisNo, company, mdate, col, price);
	}
	
	
	
	
}
