import java.util.ArrayList;

public class Itinerary {

	private ArrayList<Flight> flightList;
	private String name;
	
	public Itinerary(String name) {
		this.name = new String(name);
		this.flightList = new ArrayList<Flight>();
	}

	public ArrayList<Flight> getFlightList() {
		if(this.flightList.isEmpty()) {
			return new ArrayList<Flight>();
		}
		
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		for(Flight flight : this.flightList) {
			flights.add(new Flight(flight));
		}
		
		return flights;
	}

	public String getName() {
		return name;
	}
	
	public void addFlight(Flight flight) {
		
		if(this.flightList.isEmpty()) {
			this.flightList.add(flight);
			
			return;
		}
		
		
		
		for(Flight existingFlight : this.flightList) {
			if(
					(flight.getDeparture().after(existingFlight.getDeparture()) && flight.getDeparture().before(existingFlight.getArrival())) ||
					(existingFlight.getDeparture().after(flight.getDeparture()) && existingFlight.getDeparture().before(flight.getArrival()))
			) {
				return;
			}
		}
		
		int index = 0;
		int length = this.flightList.size();
		
		this.flightList.add(flight);
	}

	public long getTotalLayover() {
		return 0;
	}
	
	
}
