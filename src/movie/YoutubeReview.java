package movie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class YoutubeReview
 */
@WebServlet("/YoutubeReview")
public class YoutubeReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutubeReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String[] movieName = new String[10];
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dburl = "jdbc:apache:commons:dbcp:wdbpool";
		try {
			conn = DriverManager.getConnection(dburl);
			String sql = "select * from boxOfficeList;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;

			while (rs.next()) {
				movieName[i] = rs.getString("movieNm");
				System.out.println(movieName[i]);
				i++;
			}

			String[] youtubeSrc = new String[10]; // youtube 주소
			String[] youtubeTitle = new String[10]; // youtube 제목

			for (int j = 0; j < movieName.length; j++) {
				Document doc1 = Jsoup.connect("https://www.google.com/search?q=youtube: " + movieName[j] + " 영화 리뷰&source=lnms&tbm=vid").get();
				Elements vidItems1 = doc1.select(".rc .rGhul");
				String[] vidCode1 = vidItems1.get(0).attr("href").split("=");
				
				String vid1 = "https://www.youtube.com/embed/" + vidCode1[1];
				Elements vidTitleEl1 = doc1.select(".rc .r .LC20lb");
				String vidTitle1 = vidTitleEl1.get(0).text();
				if(vidTitle1.contains(movieName[j])) {
					youtubeSrc[j] = vid1;
					youtubeTitle[j] = vidTitle1;
					
				} else {
					youtubeSrc[j] = "notSearch";
					System.out.println("영화 리뷰 없음");
					System.out.println();
				}
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("./youtubeReview.jsp");
			request.setAttribute("vidio", youtubeSrc);
			request.setAttribute("size", youtubeSrc.length);
			dispatcher.forward(request, response);
				
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
		
	}

}
