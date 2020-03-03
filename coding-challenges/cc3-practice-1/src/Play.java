import java.util.Calendar;
import java.util.Date;

public class Play extends Theatre {

	private String writer;
	private int yearWritten;
	
	public Play(String title, int rating, String writer, int yearWritten) {
		super(title, rating);
		this.setWriter(writer);
		this.setYearWritten(yearWritten);
		
	}
	
	public Play(Play play) {
		this(
				play.getTitle(), 
				play.getRating(), 
				play.getWriter(), 
				play.getYearWritten()
			);
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getYearWritten() {
		return yearWritten;
	}

	public void setYearWritten(int yearWritten) {
		if(yearWritten < 2019) {
			this.yearWritten = yearWritten;
		}else {
			this.yearWritten = 2018;
		}
	}
	
	@Override
	public String getCategory() {
		Date today = new Date();
		
		int thisYear = today.getYear() + 1900;
		
		System.out.println(thisYear);
		
		if(this.getYearWritten() < thisYear-200) {
			return "Classic";
		}else if (this.getYearWritten() < thisYear-51) {
			return "Contemporary";
		}
		
		return "Modern";
	}
	
	
	
}
