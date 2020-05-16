package movie;

import java.util.ArrayList;

public class BookingTimeDTO {
	private ArrayList<String> movieName = new ArrayList<String>();
	private ArrayList<String> place = new ArrayList<String>();
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> startTime = new ArrayList<String>();
	private ArrayList<String> endTime = new ArrayList<String>();
	public BookingTimeDTO() {
		// TODO Auto-generated constructor stub
	}
	public String[] getMovieName() {
		return movieName.toArray(new String[movieName.size()]);
	}
	public void setMovieName(String movieName) {
		this.movieName.add(movieName);
	}
	public String[] getPlace() {
		return place.toArray(new String[place.size()]);
	}
	public void setPlace(String place) {
		this.place.add(place);
	}
	public String[] getDate() {
		return date.toArray(new String[date.size()]);
	}
	public void setDate(String date) {
		this.date.add(date);
	}
	public String[] getStartTime() {
		return startTime.toArray(new String[startTime.size()]);
	}
	public void setStartTime(String startTime) {
		this.startTime.add(startTime);
	}
	public String[] getEndTime() {
		return endTime.toArray(new String[endTime.size()]);
	}
	public void setEndTime(String endTime) {
		this.endTime.add(endTime);
	}
	public int getListSize() {
		return movieName.size();
	}

}
