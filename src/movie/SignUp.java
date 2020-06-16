package movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
		String addr = request.getParameter("addr");
		
		PrintWriter out = response.getWriter();
		if(checkInfo(name,id,pw,tel,addr)) {
			out.println("<script>"
					+ "alert('회원가입 완료');"
					+ "location.href='./';"
					+ "</script>");
		
			
		}else {
			out.println("<script>"
					+ "alert('회원가입 실패');"
					+ "history.back();"
					+ "</script>");
			
		}
	}
	
	private boolean checkInfo(String name, String id, String pw, String tel, String addr) throws ServletException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {

			String jdbcUrl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(jdbcUrl);
			stmt = conn.createStatement();
			if(name == "" || id == "" || pw == "" || tel == "" || addr == "") {
				return false;
			}
			int rs = stmt.executeUpdate("insert into member values ('"+id+"','"+pw+"','"+addr+"','"+tel+"','"+name+"')");
			if(rs==0) {
				return false;
			}else {
				return true;
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			//커넥션을 풀에 반환함
			try { 
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch(SQLException ex) {}

		}
		return false;
		


		
	}

}
