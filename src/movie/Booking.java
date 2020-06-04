package movie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Booking
 */
@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String movieName = request.getParameter("movieName");
		String movieImg = null;
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String place = request.getParameter("place");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		Connection conn = null;
		Statement stmt =null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select poster from boxOfficeList where movieNm = '"+movieName+"'");
			while(rs.next()) {
				movieImg = rs.getString("poster");
			}
		}catch (SQLException e){
			System.out.println("from Booking : "+e.getMessage());
		}finally {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("./booking.jsp");
		request.setAttribute("movieName", movieName);
		request.setAttribute("movieImg", movieImg);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("place", place);
		request.setAttribute("date", format.format(date));
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
