package movie;

import java.io.IOException;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("LOGIN_ID");
		MypageReservationDTO dto = new MypageReservationDTO();
		Connection conn =null;
		Statement stmt = null;
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
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
