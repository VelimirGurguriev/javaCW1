package repository;

import java.util.ArrayList;
import java.util.List;

import model.Flight;

public class FlightRepository {

	private static final List<Flight> flightsArrList = new ArrayList<>();
	
	public static List<Flight> getFlightsArrList() { return flightsArrList;	}
	
	public static void addFlight(Flight flight) {
		flightsArrList.add(flight);
	}
}
