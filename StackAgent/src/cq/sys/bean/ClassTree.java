package cq.sys.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 分类树bean
 * @author chenqing24@163.com
 */
public class ClassTree implements Serializable {
	private static final long serialVersionUID = -2016566491758635886L;
	private Integer id;
	// 类名
	private String name;
	// 修改日期
	private Date changeDate;
	// 父id
	private Integer parentId;
	// 完整路径
	private String path;
	
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
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
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
}
