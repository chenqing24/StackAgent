package cq.core.orm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据库连接工具类
 * @author chenqing24@163.com
 */
public class DbTool {
	private static DataSource ds; // 连接池

	// 根据jdbc.properties初始化ds
	static {
		Properties props = new Properties();
		try {
			props.load(DbTool.class.getResourceAsStream("jdbc.properties"));
			ds = BasicDataSourceFactory.createDataSource(props);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取db连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException{
		return ds.getConnection();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Statement st = DbTool.getConn().createStatement();
	        ResultSet rs= st.executeQuery("SELECT * FROM TEST ORDER BY ID");
	        while(rs.next()){
	            System.out.println(rs.getString("NAME"));
	        }
	        
	        rs.close();
	        st.close();
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
