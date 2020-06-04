package movie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class RecoMovieAction
 */
@WebServlet("/RecoMovieAction")
public class RecoMovieAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecoMovieAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		boolean chkAction = false;
		try {
			
			String recoMovie[] = request.getParameterValues("checkbox");
			String recoMovieList[] = new String[40];
			
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			
			HttpSession session = request.getSession();
			String movieUserId = (String)session.getAttribute("LOGIN_ID"); 
			String thumbImgSrc = "";
			String movieAge = "";
			String movieDetailHref = "";
			String movieTitle = "";
			String movieScore = "";
			String movieScoreNum1 = "";
			String movieScoreNum2 = "";
			String movieRating = "";
			String movieOutline = "";
			String movieDirector = "";
			String movieActor = "";
			
			String sql = "insert into intermovietable values(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			
			if (request.getParameterValues("checkbox") != null) {
				chkAction = true;
				for (int i = 0; i < recoMovie.length; i++) {
					pstmt = conn.prepareStatement(sql);

					recoMovieList = recoMovie[i].split("\\^");
					thumbImgSrc = recoMovieList[0];
					movieAge = recoMovieList[1];
					movieDetailHref = recoMovieList[2];
					movieTitle = recoMovieList[3];
					movieScore = recoMovieList[4];
					movieScoreNum1 = recoMovieList[5];
					movieScoreNum2 = recoMovieList[6];
					movieRating = recoMovieList[7];
					movieOutline = recoMovieList[8];
					movieDirector = recoMovieList[9];
					movieActor = recoMovieList[10];
					
					pstmt.setString(1, movieUserId);
					pstmt.setString(2, thumbImgSrc);
					pstmt.setString(3, movieAge);
					pstmt.setString(4, movieDetailHref);
					pstmt.setString(5, movieTitle);
					pstmt.setString(6, movieScore);
					pstmt.setString(7, movieScoreNum1);
					pstmt.setString(8, movieScoreNum2);
					pstmt.setString(9, movieRating);
					pstmt.setString(10, movieOutline);
					pstmt.setString(11, movieDirector);
					pstmt.setString(12, movieActor);
					pstmt.executeUpdate();

					System.out.println(movieUserId);
					System.out.println(thumbImgSrc);
					System.out.println(movieAge);
					System.out.println(movieDetailHref);
					System.out.println(movieTitle);
					System.out.println(movieScore);
					System.out.println(movieScoreNum1);
					System.out.println(movieScoreNum2);
					System.out.println(movieRating);
					System.out.println(movieOutline);
					System.out.println(movieDirector);
					System.out.println(movieActor);

					System.out.println("============================================================");

				}
			}
			
			request.setAttribute("chkAction", chkAction);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./recoMovieAction.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("from BoxOfficeList : "+e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (SQLException e) {
				System.out.println("from BoxOfficeList : "+e.getMessage());
			}
		}
	}

}