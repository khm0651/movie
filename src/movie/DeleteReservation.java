package movie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteReservation
 */
@WebServlet("/DeleteReservation")
public class DeleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("LOGIN_ID");
		String movieName = request.getParameter("movieName");
		String place = request.getParameter("place");
		String sit = request.getParameter("sit");
		String buydate = request.getParameter("buydate");
		String startTime = request.getParameter("startTime");
		
		Connection conn =null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate("delete from reservation where id");
			if(!(rs>0)) {
				System.out.println("½ÇÆÐ");
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
		
	}

}
