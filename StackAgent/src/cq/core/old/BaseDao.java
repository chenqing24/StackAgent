package cq.core.old;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * DAO模板
 * @author chenqing24@163.com
 */
public interface BaseDao {

	public List<?> find(String querys, Object...params);	

	public List<?> find(Class<?> clazz);

	public Object getById(Class<?> clazz, Serializable id);

	public Object getBySql(String sql, Object...params);
	
	public void saveOrUpdate(Class<?> clazz);
	
	public void saveOrUpdateAll(Collection<?> collection);

	public void delete(Class<?> clazz, Serializable id);
	
	public void deleteAll(Collection<?> collection);
	
	public int execSql(String query, Object...params);

	public long getTotal(String query);

	public List<?> selectByPage(final int first, final int size, final String sql);
}