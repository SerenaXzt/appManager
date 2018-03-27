package cn.app.pojo;

public class App {

	private int id;
	private String softwareName;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", softwareName=" + softwareName + "]";
	}


}
