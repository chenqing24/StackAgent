package cq.core.orm;

import java.sql.SQLException;
import java.util.List;

/**
 * 通用DAO
 * @author chenqing24@163.com
 */
public interface BaseDao {
	
	/**
	 * 新增记录
	 * @param sql
	 * @return id
	 */
	public Long save(String sql) throws SQLException;
	
	/**
	 * 根据id删除记录
	 * @param id
	 * @return 影响记录数
	 * @throws SQLException
	 */
	public int delete(Long id) throws SQLException;
	
	/**
	 * 更新指定实体
	 * @param clazz
	 * @return 影响记录数
	 * @throws SQLException
	 */
	public int update(Class<?> clazz) throws SQLException;
	
	/**
	 * 根据id获取实体
	 * @param id
	 * @return
	 */
	public Object get(Long id);
	
	/**
	 * 根据sql获取实体一览
	 * @param sql
	 * @param params
	 * @return 
	 */
	public List<?> find(String sql, Object...params);
	
	/**
	 * 根据sql获取实体记录数
	 * @param sql
	 * @param params
	 * @return
	 */
	public long getTotal(String sql, Object...params);
	
	/**
	 * 分页查询
	 * @param first
	 * @param size
	 * @param sql
	 * @return
	 */
	public List<?> selectByPage(final int first, final int size, final String sql);
}
