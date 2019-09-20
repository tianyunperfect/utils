package com.github.tianyunperfect.entity;

/**
 * Class Result ...
 *
 * @author tianyunperfect
 * Created on 2019/9/11
 */
public class Result {

	
	private boolean flag;
	private Integer code;
	private String message;
	private Object data;
	
	
	
	public Result(boolean flag, Integer code, String message, Object data) {
		super();
		this.flag = flag;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public Result(boolean flag, Integer code, String message) {
		super();
		this.flag = flag;
		this.code = code;
		this.message = message;
	}

	/**
	 * success
	 * @return
	 */

	public static Result success() {
		return new Result(true, StatusCode.OK, "success");
	}

	public static Result success(Object data) {
		return new Result(true, StatusCode.OK, "success", data);
	}

	public static Result success(String message, Object data) {
		return new Result(true, StatusCode.OK, message, data);
	}

	public static Result success(Integer code, String message, Object data) {
		return new Result(true, code, message, data);
	}

	/**
	 * error
	 * @return
	 */
	public static Result error() {
		return new Result(false, StatusCode.ERROR, "success");
	}

	public static Result error(Object data) {
		return new Result(false, StatusCode.ERROR, "success", data);
	}

	public static Result error(String message, Object data) {
		return new Result(false, StatusCode.ERROR, message, data);
	}

	public static Result error(Integer code, String message, Object data) {
		return new Result(false, code, message, data);
	}

	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
