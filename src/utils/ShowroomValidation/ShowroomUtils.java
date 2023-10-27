package utils.ShowroomValidation;

import java.util.List;
import com.Vehicle.Vehicle;
import customException.InvalidInputException;

public class ShowroomUtils {
	public static Vehicle findByChasisNo(String chasisNo, List<Vehicle> v) throws InvalidInputException {
		Vehicle nv = new Vehicle(chasisNo);
		int index = v.indexOf(nv);
		if(index == -1) {
			throw new InvalidInputException("Vehicle does not exists. Given chasis no is wrong");
		}
		return v.get(index);
	}
}
