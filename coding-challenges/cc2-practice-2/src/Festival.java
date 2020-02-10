import java.util.ArrayList;

public class Festival {

	private String name;
	private ArrayList<Movie> movieList;
	
	public Festival(String name) {
		this.name = name;
		this.movieList = new ArrayList<Movie>();
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Movie> getMovieList() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		for(Movie movie : this.movieList) {
			movies.add(new Movie(movie));
		}
		
		return movies;
	}

	public void addMovie(Movie movie) {
		this.movieList.add(new Movie(movie));
	}
	
	public Movie getMovieWithLowestRating() {
		if(this.movieList.isEmpty()) {
			return null;
		}
		
		
		Movie movieWithLowestRating = new Movie(this.movieList.get(0));
		
		for(Movie movie : this.movieList) {
			if(movie.getRating() < movieWithLowestRating.getRating()) {
				movieWithLowestRating = new Movie(movie);
			}
		}
		
		return movieWithLowestRating;
	}
	
	
	
}
