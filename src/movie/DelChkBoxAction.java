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

/**
 * Servlet implementation class DelChkBoxAction
 */
@WebServlet("/DelChkBoxAction")
public class DelChkBoxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelChkBoxAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			String delChkBox[] = request.getParameterValues("delChkBox");

			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);

			if (delChkBox.length > 0) {
				for (int i = 0; i < delChkBox.length; i++) {
					String sql = "delete from intermovietable where interMovieId = " + delChkBox[i];
					pstmt = conn.prepareStatement(sql);
					pstmt.executeUpdate();
				}
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("./mypage");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("from BoxOfficeList : " + e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				System.out.println("from BoxOfficeList : " + e.getMessage());
			}
		}
	}

}
