package movie;


import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id.equals("") || pw.equals("")) {
			out.println("<script>alert('���̵� �Ǵ� ��й�ȣ�� �Է����ּ���.');history.back()</script>");
		}
		if(check(id,pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_ID", id);
			response.sendRedirect("./index.jsp");
		}else {
			out.println("<script>alert('���̵� �Ǵ� ��й�ȣ�� ��ġ�����ʽ��ϴ�.');history.back()</script>");
		}
		
	}

	private boolean check(String id, String pw) {
		Connection conn =null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from member where id = '"+id+"';");
			if(rs.next()) {
				if(rs.getString("pw").equals(pw)) {
					System.out.println("�α��� ����");
					return true;
				}else {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					return false;
				}
			}else {
				System.out.println("���̵� ���� ���� �ʽ��ϴ�.");
				return false;
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
			e.getStackTrace();
		}finally {
			try {
				if(stmt != null ) stmt.close();
				if(conn != null) conn.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		return false;
	}

}
