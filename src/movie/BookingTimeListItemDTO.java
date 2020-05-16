package movie;

import java.util.ArrayList;

public class BookingTimeListItemDTO {
	private ArrayList<String> movieName = new ArrayList<String>();
	public BookingTimeListItemDTO() {
		// TODO Auto-generated constructor stub
	}
	public String[] getMovieName() {
		return movieName.toArray(new String[movieName.size()]);
	}
	public void setMovieName(String movieName) {
		this.movieName.add(movieName);
	}
	public int getListSize() {
		return movieName.size();
	}

}
