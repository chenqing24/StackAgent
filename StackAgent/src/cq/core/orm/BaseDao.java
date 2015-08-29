package cq.core.orm;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author chenqing24@163.com
 */
public abstract class BaseDao implements Dao {

	/* (non-Javadoc)
	 * @see cq.core.orm.Dao#save(java.lang.String)
	 */
	@Override
	public Long save(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cq.core.orm.Dao#delete(java.lang.Long)
	 */
	@Override
	public int delete(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see cq.core.orm.Dao#update(java.lang.Class)
	 */
	@Override
	public int update(Class<?> clazz) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see cq.core.orm.Dao#get(java.lang.Long)
	 */
	@Override
	public Object get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cq.core.orm.Dao#find(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<?> find(String sql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cq.core.orm.Dao#getTotal(java.lang.String, java.lang.Object[])
	 */
	@Override
	public long getTotal(String sql, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see cq.core.orm.Dao#selectByPage(int, int, java.lang.String)
	 */
	@Override
	public List<?> selectByPage(int first, int size, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
