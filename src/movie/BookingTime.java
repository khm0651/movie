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

/**
 * Servlet implementation class BookingTime
 */
@WebServlet("/BookingTime")
public class BookingTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingTime() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("./bookingTime.jsp");
		request.setAttribute("movieNameList", btli);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BookingTimeDTO bt = new BookingTimeDTO();
		BookingTimeListItemDTO btli = new BookingTimeListItemDTO();
		String movieName = request.getParameter("movieName");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println(movieName);
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			if(movieName!=null) {
				rs = stmt.executeQuery("select * from movieTimeLine where movieName='"+movieName+"'");
			}else {
				rs = stmt.executeQuery("select * from movieTimeLine");
			}
			
			while(rs.next()) {
				bt.setMovieName(rs.getString("movieName"));
				bt.setPlace(rs.getString("place"));
				bt.setDate(rs.getString("date"));
				bt.setStartTime(rs.getString("startTime"));
				bt.setEndTime(rs.getString("endTime"));
			}

			if(movieName!=null) {
				rs = stmt.executeQuery("select movieNm from boxOfficeList where movieNm = '"+movieName+"'");
			}else {
				rs = stmt.executeQuery("select movieNm from boxOfficeList");
			}
			
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./bookingTime.jsp");
		request.setAttribute("movieNameList", btli);
		request.setAttribute("timeLine", bt);
		request.setAttribute("back", true);
		dispatcher.forward(request, response);
	}

}
