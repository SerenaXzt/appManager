package cn.app.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.app.pojo.DataDictionary;

public class AppInfoVo {

	private Long id;

	private String softwarename;

	private String apkname;

	private BigDecimal softwaresize;

	private String appinfo;

	private String status;

	private String flatformid;

	private String categorylevel1;

	private String categorylevel2;
	private String categorylevel3;

	private Long downloads;

	private String versionNo;

	private static Map<Integer, String> categoryMap = new HashMap<>();
	
	private static Map<String, Object> statusMap = new HashMap<>();
	
	public static void setStatusMap(List<DataDictionary> dataList){
		
		List<DataDictionary> status = new ArrayList<>();
		List<DataDictionary> flatform = new ArrayList<>();
		for(DataDictionary data : dataList){
			switch (data.getTypecode()) {
			case "APP_STATUS":
				status.add(data);
				break;
			case "APP_FLATFORM":
				flatform.add(data);
			}
		}
		statusMap.put("APP_STATUS", status);
		statusMap.put("APP_FLATFORM", flatform);
		
	}
	
	public Map<String, Object> getStatusMap(){
		return statusMap;
	}
	
	public static void setCategoryMap(List<AppCategoryVo> list) {
		for (AppCategoryVo acv : list) {
			categoryMap.put(acv.getId(), acv.getCategoryName());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSoftwarename() {
		return softwarename;
	}

	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}

	public String getApkname() {
		return apkname;
	}

	public void setApkname(String apkname) {
		this.apkname = apkname;
	}

	public BigDecimal getSoftwaresize() {
		return softwaresize;
	}

	public void setSoftwaresize(BigDecimal softwaresize) {
		this.softwaresize = softwaresize;
	}

	public String getAppinfo() {
		return appinfo;
	}

	public void setAppinfo(String appinfo) {
		this.appinfo = appinfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		switch (status) {
		case 1:
			this.status = "待审核";
			break;
		case 2:
			this.status = "审核通过";
			break;
		case 3:
			this.status = "审核未通过";
			break;
		case 4:
			this.status = "已上架";
			break;
		case 5:
			this.status = "已下架";
			break;
		}
	}

	public String getFlatformid() {
		return flatformid;
	}

	public void setFlatformid(Integer flatformid) {
		switch(flatformid){
			case 1:
				this.flatformid = "手机";
				break;
			case 2:
				this.flatformid = "平板";
				break;
			case 3:
				this.flatformid = "通用";
		}
	}

	public Long getDownloads() {
		return downloads;
	}

	public void setDownloads(Long downloads) {
		this.downloads = downloads;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getCategorylevel1() {
		return categorylevel1;
	}

	public void setCategorylevel1(Integer categorylevel1) {
		for (Integer mapKeys : categoryMap.keySet()) {
			if (mapKeys == categorylevel1) {
				this.categorylevel1 = categoryMap.get(mapKeys);
				break;
			}
		}
	}

	public String getCategorylevel2() {
		return categorylevel2;
	}

	public void setCategorylevel2(Integer categorylevel2) {
		for (Integer mapKeys : categoryMap.keySet()) {
			if (mapKeys == categorylevel2) {
				this.categorylevel2 = categoryMap.get(mapKeys);
				break;
			}
		}
	}

	public String getCategorylevel3() {
		return categorylevel3;
	}

	public void setCategorylevel3(Integer categorylevel3) {
		for (Integer mapKeys : categoryMap.keySet()) {
			if (mapKeys == categorylevel3) {
				this.categorylevel3 = categoryMap.get(mapKeys);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "AppInfoVo [id=" + id + ", softwarename=" + softwarename + ", apkname=" + apkname + ", softwaresize="
				+ softwaresize + ", appinfo=" + appinfo + ", status=" + status + ", flatformid=" + flatformid
				+ ", categorylevel1=" + categorylevel1 + ", categorylevel2=" + categorylevel2 + ", categorylevel3="
				+ categorylevel3 + ", downloads=" + downloads + ", versionNo=" + versionNo + "]";
	}

}
