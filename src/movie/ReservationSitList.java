package movie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationSitList
 */
@WebServlet("/ReservationSitList")
public class ReservationSitList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationSitList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String movieName= request.getParameter("movieName");
		System.out.println(movieName);
		Connection conn =null;
		Statement stmt = null;
		String sitList ="";
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			String query = "select sit from reservation where movieName = '"+movieName+"'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				sitList += rs.getString("sit")+",";
			}
			response.getWriter().write(sitList);
		}catch(SQLException e) {
			System.out.println("FROM ReservationSitList : " + e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
				if(stmt!=null)stmt.close();
			}catch(SQLException e) {
				System.out.println("FROM ReservationSitList : "+e.getMessage());
			}
		}
	}

}
