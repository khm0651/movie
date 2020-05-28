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

/**
 * Servlet implementation class BoxOfficeTop
 */
@WebServlet("/BoxOfficeTop")
public class BoxOfficeTop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoxOfficeTop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			ResultSet rs = stmt.executeQuery("select * from boxOfficeList");
			int i=0;
			while(rs.next()) {
				System.out.println(rs.getString("movieNm"));
				System.out.println(rs.getString("poster"));
				bol.setMovieName(i, rs.getString("movieNm"));
				bol.setMovieImg(i, rs.getString("poster"));
				i++;
			}
			
			request.setAttribute("bol", bol);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./boxOffice.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
