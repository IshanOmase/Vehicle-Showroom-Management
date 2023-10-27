package test;

import java.time.LocalDate;
import java.util.*;
import com.Vehicle.Vehicle;
import com.colors.Color;
import customException.InvalidInputException;
import static utils.ShowroomValidation.ShowroomUtils.*;
import static utils.ShowroomValidation.ShowroomValidation.*;

public class ShowroomManagement {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			List<Vehicle> sList = new ArrayList<>();
			boolean exit = false;
			while(!exit) {
				System.out.println("Options:"
						+ "1. Add a vehicle\n"+ "\t2. Display all\n"
						+ "\t3. Get Vehicle Details\n " + "\t4. Apply discount\n" 
						+ "\t5. Apply discount on old vehicles\n " + "\t6. Remove specific vehicle\n"
						+ "\t7. Remove vehicles by color\n" + "\t8. Sort vehicles as per ch no\n"
						+ "\t0. Exit");
					try {
						//taken parseInt method from Wrapper Class: Integer; to stop the scary Infinite loop due InputMismatch loop
						//it also helps the user to reenter the proper input instead of running the program again
						switch(Integer.parseInt(sc.next())) {
						
						case 1:
							System.out.println("Enter chasisNo, company, mdate(yyyy-mm-dd),"
									+ " color, price");
						//String chasisNo, String company, String date,String color, 
						//double price, List<Vehicle> v
							Vehicle vehicle = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), 
									sc.nextDouble(), sList);
							sList.add(vehicle);
							break;
					
						case 2:
							System.out.println("\tShowroom Details");
							for(Vehicle v: sList) {
								System.out.println(v);
							}
							break;
					
						case 3:
							System.out.println("Enter the chasis no, to get the Vehicle details: ");
						
							System.out.println(findByChasisNo(sc.next(),sList));
						
							break;
					
						case 4:
							System.out.println("Enter chasis no and discount: ");
						
							vehicle = findByChasisNo(sc.next(), sList);
							vehicle.setPrice(vehicle.getPrice()-sc.nextDouble());
						
							break;
					
						case 5:
							System.out.println("Enter the date and discount: ");
						
							LocalDate date = validateDate(sc.next());
							double discount = sc.nextDouble();
						
							for(Vehicle v: sList) {
								if(v.getMdate().isBefore(date)) {
									v.setPrice(v.getPrice()-discount);
								}
							}	
						
							System.out.println("Discount applied...");
						
							break;
						case 6:
							System.out.println("Enter the chasis no: ");
							boolean removed = sList.remove(new Vehicle(sc.next()));
						
							if(removed) {
								System.out.println("The vehicle removed from the list");
							}else {
								throw new InvalidInputException("Invalid Given Chasis No. Enter the correct Chasis No.");
							}
						
							break;
						
						case 7:
							
							System.out.println("Enter a color: ");
						
							Color col = validateColor(sc.next());
						
							for(Vehicle v: sList) {
								if(v.getVcolor() == col) {
									sList.remove(v);
								}
							}
						
							System.out.println("Vehicles of the given color removed...");
							
							break;
						
						case 8:
							Collections.sort(sList);
						
							break;
					
						case 0:
							exit = true;
							break;
						
						default:
							System.out.println("Invalid Options chosen!");
							break;
						}
						
					
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	
}
