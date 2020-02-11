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
		
		int indexToAdd = 0;
		
		for(int index = 0; index < this.flightList.size(); index++) {
			
			if(flight.getArrival().before(this.flightList.get(index).getDeparture())) {
				indexToAdd = index;
				break;
			} else if(index == this.flightList.size() - 1) {
				indexToAdd = this.flightList.size();
			}
		}

		this.flightList.add(indexToAdd, new Flight(flight));
	}

	public long getTotalLayover() {
		int TotalLayover = 0;
		
		ArrayList<Flight> flights = this.flightList;
		
		for(int index = 0; index < flights.size()-1; index++) {
			long layover = ((flights.get(index + 1).getDeparture().getTime() - flights.get(index).getArrival().getTime()) / 1000) / 60;
			
			TotalLayover += layover;
		}
		
		return TotalLayover;
	}
	
	
}
