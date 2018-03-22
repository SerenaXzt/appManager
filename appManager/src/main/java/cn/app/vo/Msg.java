package cn.app.vo;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	// 状态码 100-成功 200-失败
	private int code;

	// 返回操作成功与失败的提示消息
	private String message;

	private Map<String, Object> extend = new HashMap<>();

	// 操作成功的信息
	public static Msg success() {
		Msg msg = new Msg();
		msg.setCode(100);
		msg.setMessage("操作成功");
		return msg;
	}

	// 操作失败的信息
	public static Msg fail() {
		Msg msg = new Msg();
		msg.setCode(200);
		msg.setMessage("操作失败");
		return msg;
	}

	public Msg addExtend(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

}
