
public class Theatre {

	private String title;
	private int rating;
	
	public Theatre(String title, int rating) {
		this.setTitle(title);
		this.setRating(rating);
	}
	
	public Theatre(Theatre theatre) {
		this(theatre.getTitle(), theatre.getRating());
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		if(rating >= 0 && rating <= 10) {
			this.rating = rating;
		}
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = new String(title.toUpperCase());
	}
	
	public String getCategory() {
		String category = "F";
		
		if(this.rating == 9 || this.rating == 10) {
			category = "A";
		}else if (this.rating == 7 || this.rating == 8) {
			category = "B";
		}else if (this.rating == 5 || this.rating == 6) {
			category = "C";
		}else if (this.rating == 3 || this.rating == 4) {
			category = "D";
		}
		
		return category;
	}
	
	
}
