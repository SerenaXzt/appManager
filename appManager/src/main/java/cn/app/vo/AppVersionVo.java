package cn.app.vo;

import java.util.Date;

public class AppVersionVo {
	private String softwareName;

	private String versionNo;
	
	private double versionSize;
	
	private String publishStatus;
	
	private String apkFileName;
	
	private Date modifyDate;
	
	private Long id;

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public double getVersionSize() {
		return versionSize;
	}

	public void setVersionSize(double versionSize) {
		this.versionSize = versionSize;
	}

	public String getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(int publishStatus) {
		switch(publishStatus) {
		case 1:
			this.publishStatus = "������";
			break;
		case 2:
			this.publishStatus = "�ѷ���";
			break;
		case 3:
			this.publishStatus = "Ԥ����";
			break;
		}
	}

	public String getApkFileName() {
		return apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
}
