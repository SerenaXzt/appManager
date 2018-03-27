package cn.app.criteria;

public class CriteriaApp {

	private Integer id;
	private String softwarename;
	private Integer appStatus;
	private Integer flatFormId;
	private Integer categoryLevel1;
	private Integer categoryLevel2;
	private Integer categoryLevel3;

	public String getSoftwarename() {
		return softwarename;
	}

	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Integer appStatus) {
		this.appStatus = appStatus;
	}

	public Integer getFlatFormId() {
		return flatFormId;
	}

	public void setFlatFormId(Integer flatFormId) {
		this.flatFormId = flatFormId;
	}

	public Integer getCategoryLevel1() {
		return categoryLevel1;
	}

	public void setCategoryLevel1(Integer categoryLevel1) {
		if(categoryLevel1 == 10000){
			this.categoryLevel1 = null;
		}else{
			
			this.categoryLevel1 = categoryLevel1;
		}
	}

	public Integer getCategoryLevel2() {
		return categoryLevel2;
	}

	public void setCategoryLevel2(Integer categoryLevel2) {
		if(categoryLevel2 == 10000){
			this.categoryLevel2 = null;
		}else{
			
			this.categoryLevel2 = categoryLevel2;
		}
	}

	public Integer getCategoryLevel3() {
		return categoryLevel3;
	}

	public void setCategoryLevel3(Integer categoryLevel3) {
		if(categoryLevel3 == 10000){
			this.categoryLevel3 = null;
		}else{
			
			this.categoryLevel3 = categoryLevel3;
		}
	}

}
