package entity;

import java.io.Serializable;
import java.util.List;

//作者:lhh 时间:2019年3月7日 下午9:21:57
public class PageResult implements Serializable {
	private long total;// 总记录数
	private List rows;// 当前页记录

	public PageResult() {
		super();
	}

	public PageResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageResult [total=" + total + ", rows=" + rows + "]";
	}

}
