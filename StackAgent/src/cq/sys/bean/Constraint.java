package cq.sys.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 约束条件bean
 * @author chenqing24@163.com
 */
public class Constraint implements Serializable {
	private static final long serialVersionUID = 8358764604001407661L;
	private Integer id;
	// 约束名
	private String name;
	// 修改日期
	private Date changeDate;
	// 数据类型
	private String dateType;
	// 最大数据长度
	private Integer maxLength;
	// 验证的正则表达式
	private String verifiedRegex;
	// 关联定义
	private String relDefine;
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
	 * @return the dateType
	 */
	public String getDateType() {
		return dateType;
	}
	/**
	 * @param dateType the dateType to set
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	/**
	 * @return the maxLength
	 */
	public Integer getMaxLength() {
		return maxLength;
	}
	/**
	 * @param maxLength the maxLength to set
	 */
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	/**
	 * @return the verifiedRegex
	 */
	public String getVerifiedRegex() {
		return verifiedRegex;
	}
	/**
	 * @param verifiedRegex the verifiedRegex to set
	 */
	public void setVerifiedRegex(String verifiedRegex) {
		this.verifiedRegex = verifiedRegex;
	}
	/**
	 * @return the relDefine
	 */
	public String getRelDefine() {
		return relDefine;
	}
	/**
	 * @param relDefine the relDefine to set
	 */
	public void setRelDefine(String relDefine) {
		this.relDefine = relDefine;
	}
		
}
