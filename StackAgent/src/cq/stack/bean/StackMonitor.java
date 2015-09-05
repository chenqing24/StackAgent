package cq.stack.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author chenqing24@163.com
 */
public class StackMonitor implements Serializable {
	private static final long serialVersionUID = 1193123789954450804L;

	private Integer id;
	private Date changeTime;
	private String stackCode;
	private Double price;
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
	 * @return the changeTime
	 */
	public Date getChangeTime() {
		return changeTime;
	}
	/**
	 * @param changeTime the changeTime to set
	 */
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	/**
	 * @return the stackCode
	 */
	public String getStackCode() {
		return stackCode;
	}
	/**
	 * @param stackCode the stackCode to set
	 */
	public void setStackCode(String stackCode) {
		this.stackCode = stackCode;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
