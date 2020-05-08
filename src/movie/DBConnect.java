package movie;

 import java.sql.DriverManager;



 import javax.servlet.ServletException;

 import javax.servlet.http.HttpServlet;



 import org.apache.commons.dbcp2.ConnectionFactory;

 import org.apache.commons.dbcp2.DriverManagerConnectionFactory;

 import org.apache.commons.dbcp2.PoolableConnection;

 import org.apache.commons.dbcp2.PoolableConnectionFactory;

 import org.apache.commons.dbcp2.PoolingDriver;

 import org.apache.commons.pool2.impl.GenericObjectPool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;



public class DBConnect extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    public DBConnect() {

        super();

    }

    

    @Override

    public void init() throws ServletException {

    	loadJDBCDriver();

    	initConnectionPool();

    }



    private void loadJDBCDriver() {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {

			e.printStackTrace();

		}



		System.out.println("after connection.....");

    }



	private void initConnectionPool() {

		try {

			String jdbcUrl = 

					"jdbc:mysql://jnoodle4560.cafe24.com:3306/jnoodle4560?" + 

					"useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

			String username = "jnoodle4560";

			String password = "jsp_i_team00";

			

			//ConnectionFactory 생성

			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, password);

			

			//PoolableConnection을 생성하는 Factory 생성

			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);

			poolableConnFactory.setValidationQuery("select 1");

			

			//커넥션 풀의 설정 정보

			GenericObjectPoolConfig<PoolableConnection> poolConfig = new GenericObjectPoolConfig<PoolableConnection>();

			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);

			poolConfig.setTestWhileIdle(true);

			poolConfig.setMinIdle(4);

			poolConfig.setMaxTotal(50);

			

			//커넥션 풀 생성 및 연결

			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory, poolConfig);

			poolableConnFactory.setPool(connectionPool);

			

			//커넥션 풀을 제공하는 JDBC 드라이버를 등록

			Class.forName("org.apache.commons.dbcp2.PoolingDriver");

			

			//커넥션 풀 드라이버에 생성한 커넥션 풀을 등록

			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");

			driver.registerPool("wdbpool", connectionPool);

					

		} catch(Exception e) {

			System.out.println(e.getMessage());

		}

	}

}



