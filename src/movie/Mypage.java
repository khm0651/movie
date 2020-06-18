package movie;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Mypage
 */
@WebServlet("/Mypage")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mypage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String[] interMovieId = null;
    String[] thumbImgSrc = null;
	String[] movieAge = null;
	String[] movieDetailHref = null;
	String[] movieTitle = null;
	String[] movieScore = null;
	String[] movieScoreNum1 = null;
	String[] movieScoreNum2 = null;
	String[] movieRating = null;
	String[] movieOutline = null;
	String[] movieDirector = null;
	String[] movieActor = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("LOGIN_ID");
		MypageReservationDTO dto = new MypageReservationDTO();
		Connection conn =null;
		Statement stmt = null;
		
		Statement stmtInterMovieList = null;
		ResultSet rsInterMovieList = null;
		
		Statement stmtCnt = null;
		ResultSet rsCnt = null;
		PrintWriter out = response.getWriter();
		
		if(session.getAttribute("LOGIN_ID") !=null) {
			try {
				String dburl = "jdbc:apache:commons:dbcp:wdbpool";
				conn = DriverManager.getConnection(dburl);
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select movieName ,room,date,startTime,endTime,price,adult,teenage,sit,buydate,poster from reservation as r join boxOfficeList as b on r.movieName =b.movieNm where id = '"+user+"'");
				while(rs.next()) {
					dto.setMovieName(rs.getString("movieName"));
					dto.setPlace(rs.getString("room"));
					dto.setDate(rs.getString("date"));
					dto.setStartTime(rs.getString("startTime"));
					dto.setEndTime(rs.getString("endTime"));
					dto.setPrice(rs.getString("price"));
					dto.setAdult(rs.getString("adult"));
					dto.setTeenAge(rs.getString("teenage"));
					dto.setSit(rs.getString("sit"));
					dto.setBuyDate(rs.getString("buydate"));
					dto.setPoster(rs.getString("poster"));
				}
				
				stmtInterMovieList = conn.createStatement();
				String sqlInterMovieList = "select * from intermovietable where movieUserId = '" + user + "'";
				rsInterMovieList = stmtInterMovieList.executeQuery(sqlInterMovieList);
				
				
				stmtCnt = conn.createStatement();
				String sqlCnt = "select count(*) from intermovietable where movieUserId = '" + user + "'";
				rsCnt = stmtCnt.executeQuery(sqlCnt);
				
				int rsCntResult = 0;
				if(rsCnt.next()) {
					rsCntResult = rsCnt.getInt(1);
				}
				
				interMovieId = new String[rsCntResult];
				thumbImgSrc = new String[rsCntResult];
				movieAge = new String[rsCntResult];
				movieDetailHref = new String[rsCntResult];
				movieTitle = new String[rsCntResult];
				movieScore = new String[rsCntResult];
				movieScoreNum1 = new String[rsCntResult];
				movieScoreNum2 = new String[rsCntResult];
				movieRating = new String[rsCntResult];
				movieOutline = new String[rsCntResult];
				movieDirector = new String[rsCntResult];
				movieActor = new String[rsCntResult];
				
				int i = 0;
				while(rsInterMovieList.next()) {
					interMovieId[i] = rsInterMovieList.getString("interMovieId");
					thumbImgSrc[i] = rsInterMovieList.getString("thumbImgSrc");
					movieAge[i] = rsInterMovieList.getString("movieAge");
					movieDetailHref[i] = rsInterMovieList.getString("movieDetailHref");
					movieTitle[i] = rsInterMovieList.getString("movieTitle");
					movieScore[i] = rsInterMovieList.getString("movieScore");
					movieScoreNum1[i] = rsInterMovieList.getString("movieScoreNum1");
					movieScoreNum2[i] = rsInterMovieList.getString("movieScoreNum2");
					movieRating[i] = rsInterMovieList.getString("movieRating");
					movieOutline[i] = rsInterMovieList.getString("movieOutline");
					movieDirector[i] = rsInterMovieList.getString("movieDirector");
					movieActor[i] = rsInterMovieList.getString("movieActor");
					i++;
				}
				// }
				
			}catch(SQLException e) {
				System.out.println("from Mypage : "+e.getMessage());
			}finally {
				try {
					if(conn!=null)conn.close();
					if(stmt!=null)stmt.close();
				}catch(SQLException e){
					System.out.println("from Mypage : "+e.getMessage());
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("./mypage.jsp");
			
			request.setAttribute("reservation", dto);
			
			request.setAttribute("interMovieSize", interMovieId.length);
			request.setAttribute("interMovieId", interMovieId);
			request.setAttribute("thumbImgSrc", thumbImgSrc);
			request.setAttribute("movieAge", movieAge);
			request.setAttribute("movieDetailHref", movieDetailHref);
			request.setAttribute("movieTitle", movieTitle);
			request.setAttribute("movieScore", movieScore);
			request.setAttribute("movieScoreNum1", movieScoreNum1);
			request.setAttribute("movieScoreNum2", movieScoreNum2);
			request.setAttribute("movieRating", movieRating);
			request.setAttribute("movieOutline", movieOutline);
			request.setAttribute("movieDirector", movieDirector);
			request.setAttribute("movieActor", movieActor);
			
			dispatcher.forward(request, response);
		}else {
			out.println("<script>alert('잘못된 접근입니다.');history.back();</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
