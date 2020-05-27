package movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
import org.jsoup.select.Elements;

/**
 * Servlet implementation class BoxOfficeList
 */
@WebServlet("/BoxOfficeList")
public class BoxOfficeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoxOfficeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoxOfficeListDTO bol = new BoxOfficeListDTO();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		Connection conn =null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from boxOfficeList limit 4");
			int i=0;
			while(rs.next()) {
				System.out.println(rs.getString("movieNm"));
				System.out.println(rs.getString("poster"));
				bol.setMovieName(i, rs.getString("movieNm"));
				bol.setMovieImg(i, rs.getString("poster"));
				i++;
			}
			
			String[] movieName = new String[4];
			String sql = "select * from boxOfficeList limit 4;";
			rs = stmt.executeQuery(sql);
			i=0;
			while (rs.next()) {
				movieName[i] = rs.getString("movieNm");
				System.out.println(movieName[i]);
				i++;
			}

			String[] youtubeSrc = new String[4]; // youtube 주소
			String[] youtubeTitle = new String[4]; // youtube 제목

			for (int j = 0; j < movieName.length; j++) {
				Document doc1 = Jsoup.connect("https://www.google.com/search?q=youtube: " + movieName[j] + " 영화 리뷰&source=lnms&tbm=vid").get();
				Elements vidItems1 = doc1.select(".rc .rGhul");
				String[] vidCode1 = vidItems1.get(0).attr("href").split("=");
				
				String vid1 = "https://www.youtube.com/embed/" + vidCode1[1]+ "?autoplay=1&mute=1";
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
			
			request.setAttribute("bol", bol);
			request.setAttribute("vidio", youtubeSrc);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./main.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException e) {
			System.out.println("from BoxOfficeList : "+e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
			}catch (SQLException e) {
				System.out.println("from BoxOfficeList : "+e.getMessage());
			}
		}
	}

}
