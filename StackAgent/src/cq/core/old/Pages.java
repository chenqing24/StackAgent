package cq.core.old;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 分页对象
 * @author chenqing24@163.com
 */
@SuppressWarnings("rawtypes")
public class Pages implements Serializable{
	private static final long serialVersionUID = 1L;
	private long totalRecord = -1;			// 记录总条数
	private int totalPage;					// 总页数
	protected Integer cpage = 1;			// 当前第几页
	protected int pageNum = 10;				// 每页数据条数，默认10
	protected int firstRecord = 0;			// 当前查询起始记录数
	protected List datalist;				// 数据集合
	protected HashMap hashMap;              // 传参hashmap      
	private String sidx;					// 排序字段
	private String sord;        			// 升降序

	public Pages(){}
	
	public Pages(long totalRecord){
		setTotalRecord(totalRecord);
	}
	
	public Pages(long totalRecord, int pageNum){
		setTotalRecord(totalRecord);
		this.pageNum = pageNum;
	}
	
	public Pages(long totalRecord, int pageNum , int cpage){
		setTotalRecord(totalRecord);
		this.pageNum = pageNum;
		this.cpage = cpage;
	}
		
	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
		countPage();
	}

	public HashMap getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap hashMap) {
		this.hashMap = hashMap;
	}

	public void countPage(){
		totalPage = (int)Math.ceil(totalRecord/(double)pageNum);
		
		if(cpage == null || cpage < 1){
			cpage = 1;
			
		}else if(cpage >totalPage){
			cpage = totalPage;
		}
		firstRecord = (cpage - 1) * pageNum;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCpage() {
		return cpage;
	}
	public void setCpage(Integer cpage) {
		this.cpage = cpage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public List getDatalist() {
		return datalist;
	}

	public void setDatalist(List datalist) {
		this.datalist = datalist;
	}

	public int getFirstRecord() {
		return firstRecord;
	}

	public void setFirstRecord(int firstRecord) {
		this.firstRecord = firstRecord;
	}
	
	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public void setCurrentPage(String pageMethod) {
		totalPage = (int)Math.ceil(totalRecord/(double)pageNum);
		if(pageMethod.equals("first")) {
			cpage = 1;
			
		}else if(pageMethod.equals("previous")) {
			cpage--;
			
		}else if(pageMethod.equals("next")) {
			cpage++;
			
		}else if(pageMethod.equals("last")) {
			cpage = totalPage;
		}
		if(cpage < 1){
			cpage = 1;
			
		}else if(cpage > totalPage) {
			cpage = totalPage;
		}
		firstRecord = (cpage - 1) * pageNum;
	}
	
	public void setCurrentPages() {
		totalPage = (int)Math.ceil(totalRecord/(double)pageNum);
		
		if(cpage < 1) {
			cpage = 1;
			
		}else if(cpage > totalPage) {
			cpage = totalPage;
		}
		firstRecord = (cpage - 1) * pageNum;
	}	
}
