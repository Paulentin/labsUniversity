package dbtable;

import java.sql.SQLException;
import java.util.Collection;

public interface DBTable<T> {
	/**
	 * Add a object to table 
	 */
	public int insert(T item);

	/**
	 * Delete object from table 
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public T delete(int id) throws SQLException;

	public void delete(Object item, Filter filter);
	
	/**
	 * Add a object to table 
	 * 
	 * @param item
	 * @return
	 * @throws SQLException 
	 */
	boolean update(int id, T item) throws SQLException;
	
	/**
	 * Find object with patter in the table 
	 */
	Collection<T> filter(Object pattern, Filter filter);

	/**
	 * 
	 * @return All objects from table
	 */
	Collection<T> selectAll();

	T get(int id) throws SQLException;
	
	void clear();
	
	int size();

	int[] insert(T... item);

}
