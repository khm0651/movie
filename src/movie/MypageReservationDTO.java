package movie;

import java.util.ArrayList;

public class MypageReservationDTO {
	private ArrayList <String> movieName = new ArrayList<String>();
	private ArrayList <String> startTime = new ArrayList<String>();
	private ArrayList <String> endTime = new ArrayList<String>();
	private ArrayList <String> place = new ArrayList<String>();
	private ArrayList <String> sit = new ArrayList<String>();
	private ArrayList <String> adult = new ArrayList<String>();
	private ArrayList <String> teenAge = new ArrayList<String>();
	private ArrayList <String> price = new ArrayList<String>();
	private ArrayList <String> date = new ArrayList<String>();
	private ArrayList <String> buyDate = new ArrayList<String>();
	private ArrayList <String> poster = new ArrayList<String>();
	
	public MypageReservationDTO() {
		// TODO Auto-generated constructor stub
	}

	public String[] getMovieName() {
		return movieName.toArray(new String[movieName.size()]);
	}

	public void setMovieName(String movieName) {
		this.movieName.add(movieName);
	}

	public String[] getStartTime() {
		return startTime.toArray(new String[startTime.size()]);
	}

	public void setStartTime(String startTime) {
		this.startTime.add(startTime);
	}

	public String[] getPlace() {
		return place.toArray(new String[place.size()]);
	}

	public void setPlace(String place) {
		this.place.add(place);
	}

	public String[] getSit() {
		return sit.toArray(new String[sit.size()]);
	}

	public void setSit(String sit) {
		this.sit.add(sit);
	}

	public String[] getAdult() {
		return adult.toArray(new String[adult.size()]);
	}

	public void setAdult(String adult) {
		this.adult.add(adult);
	}

	public String[] getTeenAge() {
		return teenAge.toArray(new String[teenAge.size()]);
	}

	public void setTeenAge(String teenAge) {
		this.teenAge.add(teenAge);
	}

	public String[] getPrice() {
		return price.toArray(new String[price.size()]);
	}

	public void setPrice(String price) {
		this.price.add(price);
	}

	public String[] getDate() {
		return date.toArray(new String[date.size()]);
	}

	public void setDate(String date) {
		this.date.add(date);
	}

	public String[] getBuyDate() {
		return buyDate.toArray(new String[buyDate.size()]);
	}

	public void setBuyDate(String buyDate) {
		this.buyDate.add(buyDate);
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

	public String[] getPoster() {
		return poster.toArray(new String[poster.size()]);
	}

	public void setPoster(String poster) {
		this.poster.add(poster);
	}

}
