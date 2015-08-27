package cq.core.orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * @author chenqing24@163.com
 */
public class BasicDbcp {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:h2:~/test";
        String dr="org.h2.Driver";
        //实例化数据源对象
        BasicDataSource ds=new BasicDataSource();
        //设置属性
        ds.setDriverClassName(dr);
        ds.setUrl(url);
        ds.setUsername("sa");
        ds.setPassword("");
        System.err.println("被包裹的数据连接(内部私有类)："+ds.getConnection().getClass());
        Statement sta= ds.getConnection().createStatement();
        ResultSet rs= sta.executeQuery("SELECT * FROM TEST ORDER BY ID");
        while(rs.next()){
            System.out.println(rs.getString("NAME"));
        }
        rs.close();
        sta.close();
        ds.close();
	}

}
