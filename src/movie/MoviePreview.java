package movie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

/**
 * Servlet implementation class YoutubeReview
 */
@WebServlet("/MoviePreview")

public class MoviePreview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoviePreview() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String vidCode = request.getParameter("c");
		System.out.println(vidCode);

		Document trailerDoc = Jsoup.connect("https://movie.naver.com/movie/bi/mi/media.nhn?code=" + vidCode).get();
		Elements trailer = trailerDoc.select(".ifr_trailer .ifr_area .video_thumb li");

		int i = 0;
		String[] videoLink = new String[trailer.size()];
		String[] videoTitle = new String[trailer.size()];
		String[] videoDate = new String[trailer.size()];
		String[] videoThumb = new String[trailer.size()];
		String[] videoPlayerSrc = new String[trailer.size()];
		for (Element traLi : trailer) {
			videoThumb[i] = traLi.select("a img").attr("src");
			videoLink[i] = traLi.select("a").attr("href");
			videoTitle[i] = traLi.select(".tx_video a").text();
			videoDate[i] = traLi.select(".video_date").text();
			Document videoPlayerDoc = Jsoup.connect("https://movie.naver.com" + videoLink[i]).get();
			Elements videoPlayer = videoPlayerDoc.select("._videoPlayer");
			videoPlayerSrc[i] = videoPlayer.attr("src");
			i++;
		}

		for (int j = 0; j < videoLink.length; j++) {

			System.out.println("영화 썸네일 주소 : " + videoThumb[j]);
			System.out.println("예고편 페이지 이동 href : " + videoLink[j]);
			System.out.println("예고편 제목 :" + videoTitle[j]);
			System.out.println("예고편 등록일 : " + videoDate[j]);
			System.out.println("예고편 영상 src : " + videoPlayerSrc[j]);

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("./review.jsp");
		request.setAttribute("videoThumb", videoThumb);
		request.setAttribute("videoLink", videoLink);
		request.setAttribute("videoTitle", videoTitle);
		request.setAttribute("videoDate", videoDate);
		request.setAttribute("videoPlayerSrc", videoPlayerSrc);
		request.setAttribute("size", videoThumb.length);
		dispatcher.forward(request, response);
	}
}
