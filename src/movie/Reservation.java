package movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		String movieName = request.getParameter("movieName");
		String room = request.getParameter("room");
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String[] sit = request.getParameterValues("sit");
		String price = request.getParameter("price");
		String adult = request.getParameter("adult");
		String teenage = request.getParameter("teenage");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String buyTime = format.format(time);

		if(session.getAttribute("LOGIN_ID")==null) {
			out.println("<script>alert('로그인 후 이용해주시기 바랍니다.');history.go(-1);</script>");
		}else {
			String id = session.getAttribute("LOGIN_ID").toString();

			
			Connection conn =null;
			PreparedStatement reservationStmt = null;
			String query1 = "insert into reservation(id,movieName,room,date,startTime,endTime,price,adult,teenage,sit,buydate) values(?,?,?,?,?,?,?,?,?,?,?)";
			try {
				String dburl = "jdbc:apache:commons:dbcp:wdbpool";
				conn = DriverManager.getConnection(dburl);
				reservationStmt = conn.prepareStatement(query1);
				for(int i=0; i<sit.length; i++) {
					reservationStmt.setString(1, id);
					reservationStmt.setString(2, movieName);
					reservationStmt.setString(3, room);
					reservationStmt.setString(4, date);
					reservationStmt.setString(5, startTime);
					reservationStmt.setString(6, endTime);
					reservationStmt.setString(7, price);
					reservationStmt.setString(8, adult);
					reservationStmt.setString(9, teenage);
					reservationStmt.setString(10, sit[i]);
					reservationStmt.setString(11, buyTime);
					int result = reservationStmt.executeUpdate();
					if(result>0) {
						System.out.println("성공");
					}else {
						System.out.println("실패");
					}
				}

			}catch(SQLException e) {
				System.out.println("from Reservation : "+e.getMessage());
			}finally {
				try {
					if(conn!=null)conn.close();
					if(reservationStmt!= null) reservationStmt.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			response.sendRedirect("./index.jsp");
		}
		
	}

}
