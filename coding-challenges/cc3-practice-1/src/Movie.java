import java.util.Date;

public class Movie extends Theatre {
	
	private String director;
	private Date releaseDate;

	public Movie(String title, int rating, String director, Date releaseDate) {
		super(title, rating);
		this.setDirector(director);
		this.setReleaseDate(releaseDate);
	}
	
	public Movie(Movie movie) {
		this(
				movie.getTitle(), 
				movie.getRating(), 
				movie.getDirector(), 
				movie.getReleaseDate()
			);
	}

	public String getDirector() {
		return new String(this.director);
	}

	public void setDirector(String director) {
		this.director = new String(director);
	}

	public Date getReleaseDate() {
		return (Date) releaseDate.clone();
	}

	public void setReleaseDate(Date releaseDate) {
		Date today = new Date();
		
		long oneYearLater = today.getTime() + (
					60*60*60*24*365*1000
				); 
		
		
		if(releaseDate.before(new Date(oneYearLater))) {
			this.releaseDate = (Date) releaseDate.clone();
		}else {
			this.releaseDate = today;
		}
	}
	
	@Override
	public String getCategory() {
		return this.getReleaseDate() + "-" + super.getCategory();
	}

}
