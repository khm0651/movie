package movie;

import java.util.ArrayList;

public class BoxOfficeListDTO {
	
	private ArrayList<String> movieName = new ArrayList<String>();
	private ArrayList<String> movieImg = new ArrayList<String>();
	
	public BoxOfficeListDTO() {
		// TODO Auto-generated constructor stub
	}

	public String[] getMovieName() {
		return movieName.toArray(new String[movieName.size()]);
	}

	public void setMovieName(int index , String s) {
		movieName.add(index, s);
	}

	public String[] getMovieImg() {
		return movieImg.toArray(new String[movieImg.size()]);
	}

	public void setMovieImg(int index, String s) {
		movieImg.add(index, s);
	}
	
	public int getListSize() {
		return movieName.size();
	}

}
