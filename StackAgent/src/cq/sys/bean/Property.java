package cq.sys.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 属性bean
 * @author chenqing24@163.com
 */
public class Property implements Serializable {
	private static final long serialVersionUID = -6515593978202878729L;
	private Integer id;
	// 属性名
	private String name;
	// 修改日期
	private Date changeDate;
	// 使用的约束条件id
	private Integer constraintId;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the changeDate
	 */
	public Date getChangeDate() {
		return changeDate;
	}
	/**
	 * @param changeDate the changeDate to set
	 */
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	/**
	 * @return the constraintId
	 */
	public Integer getConstraintId() {
		return constraintId;
	}
	/**
	 * @param constraintId the constraintId to set
	 */
	public void setConstraintId(Integer constraintId) {
		this.constraintId = constraintId;
	}
	
}
