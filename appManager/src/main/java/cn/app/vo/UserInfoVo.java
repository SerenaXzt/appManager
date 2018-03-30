package cn.app.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class UserInfoVo {
	private Long id;

    private String usercode;

    private String username;

    private String usertype1;

    private String createdby1;

    private int usertype;

    private int createdby;
    
    private Date creationdate;

    private Long modifyby;

    private Date modifydate;

    private String userpassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsertype1() {
        return usertype1;
    }

    public void setUsertype1(int usertype) {
    	this.usertype = usertype;
    	switch(usertype){
    	case 1:
    		this.usertype1 = "系统管理员";
    		break;
    	case 2:
    		this.usertype1 = "普通用户";
    	}
    }

    public String getCreatedby1() {
        return createdby1;
    }

    public void setCreatedby1(int createdby) {
    	this.createdby = createdby;
        switch(createdby) {
        case 1:
        	this.createdby1 = "系统管理员";
        	break;
        case 2:
    		this.createdby1 = "普通用户";
        }
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"usercode\":\"" + usercode + "\", \"username\":\"" + username
				+ "\", \"usertype1\":\"" + usertype1 + "\", \"createdby1\":\"" + createdby1 + "\", \"usertype\":\""
				+ usertype + "\", \"createdby\":\"" + createdby + "\", \"creationdate\":\"" + creationdate
				+ "\", \"modifyby\":\"" + modifyby + "\", \"modifydate\":\"" + modifydate + "\", \"userpassword\":\""
				+ userpassword + "\"}";
	}
    
}
