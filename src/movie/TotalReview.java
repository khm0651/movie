package movie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class TotalReview
 */
@WebServlet("/TotalReview")
public class TotalReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingTimeListItemDTO btli = new BookingTimeListItemDTO();
		Connection conn = null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select movieNm from boxOfficeList");
			while(rs.next()) {
				btli.setMovieName(rs.getString("movieNm"));
			}
			
		}catch (SQLException e){
			System.out.println("from BookignTime : "+e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
				if(stmt!=null)stmt.close();
			}catch(SQLException e){
				System.out.println("from BookingTime : "+ e.getMessage());
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("./totalReview.jsp");
		request.setAttribute("movieNameList", btli);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String movieName = request.getParameter("movieName");
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String youtubeSrc = null; // youtube 주소
		String youtubeTitle = null; // youtube 제목
		BookingTimeListItemDTO btli = new BookingTimeListItemDTO();
		String[] videoLink = null;
		String[] videoTitle = null;
		String[] videoDate = null;
		String[] videoThumb = null;
		String[] videoPlayerSrc = null;
		String dburl = "jdbc:apache:commons:dbcp:wdbpool";
		btli.setMovieName(movieName);
		
		try {
			conn = DriverManager.getConnection(dburl);
			String sql = "select * from boxOfficeList where movieNm = '"+movieName+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			String vidCode = rs.getString("poster").split("[/]")[7].split("_")[0];
			
			Document trailerDoc = Jsoup.connect("https://movie.naver.com/movie/bi/mi/media.nhn?code=" + vidCode).get();
			Elements trailer = trailerDoc.select(".ifr_trailer .ifr_area .video_thumb li");
			videoLink = new String[trailer.size()];
			videoTitle = new String[trailer.size()];
			videoDate = new String[trailer.size()];
			videoThumb = new String[trailer.size()];
			videoPlayerSrc = new String[trailer.size()];
			
			
			
			int i = 0;
			for (Element traLi : trailer) {
				videoThumb[i] = traLi.select("a img").attr("src");
				videoLink[i] = traLi.select("a").attr("href");
				videoTitle[i] = traLi.select(".tx_video a").text();
				videoDate[i] = traLi.select(".video_date").text();
				Document videoPlayerDoc = Jsoup.connect("https://movie.naver.com" + videoLink[i]).get();
				Elements videoPlayer = videoPlayerDoc.select("._videoPlayer");
				videoPlayerSrc[i] = videoPlayer.attr("src");
				i++;
			}
				
			
			Document doc1 = Jsoup.connect("https://www.google.com/search?q=youtube: " + movieName + " 영화 리뷰&source=lnms&tbm=vid").get();
			Elements vidItems1 = doc1.select(".rc .rGhul");
			String[] vidCode1 = vidItems1.get(0).attr("href").split("=");
			String vid1 = "https://www.youtube.com/embed/" + vidCode1[1] + "?autoplay=1";
			Elements vidTitleEl1 = doc1.select(".rc .r .LC20lb");
			String vidTitle1 = vidTitleEl1.get(0).text();
			if(vidTitle1.contains(movieName)) {
				youtubeSrc = vid1;
				youtubeTitle = vidTitle1;
					
			} else {
				youtubeSrc = "notSearch";
				System.out.println("영화 리뷰 없음");
				System.out.println();
			}
			
			
			
			
			
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			}catch (SQLException e){
				
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("./totalReview.jsp");
		request.setAttribute("movieNameList", btli);
		request.setAttribute("youtubeVidio", youtubeSrc);
		request.setAttribute("youtubeTitle", youtubeTitle);
		request.setAttribute("naverVideoThumb", videoThumb);
		request.setAttribute("naverVideoLink", videoLink);
		request.setAttribute("naverVideoTitle", videoTitle);
		request.setAttribute("naverVideoDate", videoDate);
		request.setAttribute("naverVideoPlayerSrc", videoPlayerSrc);
		request.setAttribute("naverSize", videoThumb.length);
		request.setAttribute("back", true);
		dispatcher.forward(request, response);
		
	}

}
