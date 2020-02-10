import java.util.Date;

public class Flight {

	private Date departure;
	private Date arrival;
	
	public Flight(Date departure, Date arrival) {
		this.setDeparture(departure);
		this.setArrival(arrival);
	}
	
	public Flight(Flight flight) {
		this(flight.departure, flight.arrival);
	}

	public Date getDeparture() {
		if(this.departure == null)
			return null;
		
		return (Date) this.departure.clone();
	}

	public void setDeparture(Date departure) {		
		if(departure == null) {
			this.departure = null;
			return;
		}
		
		if(this.arrival == null) {
			this.departure = new Date();
			this.departure.setTime(departure.getTime());
		}else if(departure != null && departure.before(this.arrival)){
			this.departure = new Date();
			this.departure.setTime(departure.getTime());
		}
	}

	public Date getArrival() {
		if(this.arrival == null)
			return null;
		
		return (Date) this.arrival.clone();
	}

	public void setArrival(Date arrival) {
		if(arrival == null) {
			this.arrival = null;
			return;
		}
		
		if(this.departure == null) {
			this.arrival = new Date();
			this.arrival.setTime(arrival.getTime());
		}else if(arrival != null && arrival.after(this.departure)){
			this.arrival = new Date();
			this.arrival.setTime(arrival.getTime());
		}
	}
	
	public long length() {
		if(this.arrival == null || this.departure == null) {
			return 0;
		}
	
		return ((this.getArrival().getTime() - this.getDeparture().getTime()) / 1000)/60;
	}
	
	
}
