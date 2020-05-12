package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;
import org.codehaus.jackson.map.ObjectMapper;
/**
 * Servlet implementation class BoxOffice
 */
@WebServlet("/BoxOffice")
public class BoxOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoxOffice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		String clientId = "oXl_uEHFXuIefS4Yojqz"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "NlwqtmPrzP"; //애플리케이션 클라이언트 시크릿값"
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -2);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		System.out.println(format.format(cal.getTime()));
		String targetDt = format.format(cal.getTime()); //조회일자
		String itemPerPage = "10"; //결과 row수
		String multiMovieYn = ""; //"Y" : 다양성영화 , "N" 상업영화 (default : 전체)
		String repNationCd = ""; //"K" : 한국영화 , "F" 외국영화 (default : 전체)
		String wideAreaCd = "";  // 조회된 지역코드
		String key = "cfd721a9bba28796aec1e5967b25c04a";
		
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        
        
		KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
		try {
			String dailyResponse = service.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String,Object> dailyResult = mapper.readValue(dailyResponse, HashMap.class);
			ArrayList<Object> list =  (ArrayList<Object>) ((HashMap<String,Object>) dailyResult.get("boxOfficeResult")).get("dailyBoxOfficeList");
			ArrayList<DailyBoxOfficeList> dList = new ArrayList<DailyBoxOfficeList>();
			
			for(int i=0; i<list.size(); i++) {
				DailyBoxOfficeList dbol = new DailyBoxOfficeList();
				
		        
				dbol.rnum = ((HashMap<String, Object>) list.get(i)).get("rnum").toString();
				dbol.rank =	((HashMap<String, Object>) list.get(i)).get("rank").toString();
				dbol.rankInten = ((HashMap<String, Object>) list.get(i)).get("rankInten").toString();
				dbol.rankOldAndNew = ((HashMap<String, Object>) list.get(i)).get("rankOldAndNew").toString();
				dbol.movieCd = ((HashMap<String, Object>) list.get(i)).get("movieCd").toString();
				dbol.movieNm = ((HashMap<String, Object>) list.get(i)).get("movieNm").toString();
				dbol.openDt = ((HashMap<String, Object>) list.get(i)).get("openDt").toString();
				dbol.salesAmt = ((HashMap<String, Object>) list.get(i)).get("salesAmt").toString();
				dbol.salesShare = ((HashMap<String, Object>) list.get(i)).get("salesShare").toString();
				dbol.salesInten = ((HashMap<String, Object>) list.get(i)).get("salesInten").toString();
				dbol.salesChange = ((HashMap<String, Object>) list.get(i)).get("salesChange").toString();
				dbol.salesAcc = ((HashMap<String, Object>) list.get(i)).get("salesAcc").toString();
				dbol.audiCnt = ((HashMap<String, Object>) list.get(i)).get("audiCnt").toString();
				dbol.audiInten = ((HashMap<String, Object>) list.get(i)).get("audiInten").toString();
				dbol.audiChange = ((HashMap<String, Object>) list.get(i)).get("audiChange").toString();
				dbol.audiAcc = ((HashMap<String, Object>) list.get(i)).get("audiAcc").toString();
				dbol.scrnCnt = ((HashMap<String, Object>) list.get(i)).get("scrnCnt").toString();
				dbol.showCnt = ((HashMap<String, Object>) list.get(i)).get("showCnt").toString();
				String text = null;
		        try {
		            text = URLEncoder.encode(dbol.movieNm, "UTF-8");
		        } catch (UnsupportedEncodingException e) {
		            throw new RuntimeException("검색어 인코딩 실패",e);
		        }
		        String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text;    // json 결과
		        dbol.poster= get(apiURL,requestHeaders);
				dList.add(dbol);
			}
			Connection conn =null;
			Statement stmt = null;
			try {
				String dburl = "jdbc:apache:commons:dbcp:wdbpool";
				conn = DriverManager.getConnection(dburl);
				stmt = conn.createStatement();
				stmt.executeUpdate("delete from boxOfficeList");
				for(int i =0; i<dList.size();i++) {
					String query = "insert into boxOfficeList values('"+dList.get(i).rnum+"','"+dList.get(i).rank+"','"+dList.get(i).rankInten+"','"+dList.get(i).rankOldAndNew+"','"+dList.get(i).movieCd+"','"+dList.get(i).movieNm+"','"+dList.get(i).openDt+"','"+dList.get(i).salesAmt+"','"+dList.get(i).salesShare+"','"+dList.get(i).salesInten+"','"+dList.get(i).salesChange+"','"+dList.get(i).salesAcc+"','"+dList.get(i).audiCnt+"','"+dList.get(i).audiInten+"','"+dList.get(i).audiChange+"','"+dList.get(i).audiAcc+"','"+dList.get(i).scrnCnt+"','"+dList.get(i).showCnt+"','"+dList.get(i).poster+"')";
					int rs = stmt.executeUpdate(query);
					if(rs>0) {
						System.out.println("성공");
					}else {
						System.out.println("실패");
					}
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
			
		} catch (OpenAPIFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
            	return readBody(con.getInputStream());
                
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }
	
	private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }
	
	private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
           
                if(line.contains("image")) {
                	String [] arr = new String[2];
                	arr = line.split(": ");
                    responseBody.append(arr[1].substring(1,arr[1].indexOf(".jpg")+4));
                    System.out.println(arr[1].substring(1,arr[1].indexOf(".jpg")+4));
                    break;
                }
                
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
	
	class DailyBoxOfficeList {
		String rnum;
		String rank;
		String rankInten;
		String rankOldAndNew;
		String movieCd;
		String movieNm;
		String openDt;
		String salesAmt;
		String salesShare;
		String salesInten;
		String salesChange;
		String salesAcc;
		String audiCnt;
		String audiInten;
		String audiChange;
		String audiAcc;
		String scrnCnt;
		String showCnt;
		String poster;
	}
}
