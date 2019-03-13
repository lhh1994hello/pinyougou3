package entity;

import java.io.Serializable;

/**
 * 封装返回结果
 * 
 * @author lhh
 *
 */
// 作者:lhh 时间:2019年3月7日 下午10:08:25
public class Result implements Serializable {
	private boolean success;
	private String message;

	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", message=" + message + "]";
	}

}
