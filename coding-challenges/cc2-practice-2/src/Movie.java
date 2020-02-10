
public class Movie {
	
	private String title;
	private int rating;

	public Movie(String title, int rating) {
		this.setTitle(title);
		this.setRating(rating);
	}

	public Movie(Movie c) {
		this(c.title, c.rating);
	}

	public String getTitle() {
		return new String(this.title);
	}

	public void setTitle(String title) {
		this.title = new String(title.toUpperCase());
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		if(rating >= 0 && rating <= 10) {
			this.rating = rating;
		}
	}
	
	public char getCategory()
	{
		if(this.rating == 9 || this.rating == 10) {
			return 'A';
		}else if(this.rating == 7 || this.rating == 8) {
			return 'B';
		}else if(this.rating == 5 || this.rating == 6) {
			return 'C';
		}else if(this.rating == 3 || this.rating == 4) {
			return 'D';
		}else {
			return 'F';
		}
	}

}
