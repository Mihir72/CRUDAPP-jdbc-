package in.IneuronUtil.ai;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//	}
	
	private JDBCUtil() {
		
	}
	
	
	public static Connection jdbc_Connection() throws FileNotFoundException, IOException,SQLException{
		HikariConfig config = new HikariConfig("F:\\CRUDE_OPEARATION_PROJECT\\src\\db.properties");
		HikariDataSource dataSource =  new HikariDataSource(config);
	    return dataSource.getConnection();
	}
	
	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException{
		if(resultSet != null)
			 resultSet.close();
		if(statement != null)
			statement.close();
		if(connection != null)
			connection.close();
	}

}
