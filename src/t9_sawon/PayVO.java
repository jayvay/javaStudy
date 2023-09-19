package t9_sawon;

public class PayVO {
	
	private int sabun;
	private String name;
	private String jikkub;
//	private String jikkubBong;
	private int night;
	private int bonbong;
	private double gongje;  
	private double silbong;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJikkub() {
		return jikkub;
	}
	public void setJikkub(String jikkub) {
		this.jikkub = jikkub;
	}
	public int getNight() {
		return night;
	}
	public void setNight(int night) {
		this.night = night;
	}
	public int getBonbong() {
		return bonbong;
	}
	public void setBonbong(int bonbong) {
		this.bonbong = bonbong;
	}
	public double getGongje() {
		return gongje;
	}
	public void setGongje(double gongje) {
		this.gongje = gongje;
	}
	public double getSilbong() {
		return silbong;
	}
	public void setSilbong(double silbong) {
		this.silbong = silbong;
	}
//	public String getJikkubBong() {
//		return jikkubBong;
//	}
//	public void setJikkubBong(String jikkubBong) {
//		this.jikkubBong = jikkubBong;
//	}
	@Override
	public String toString() {
		return "PayVO [sabun=" + sabun + ", name=" + name + ", jikkub=" + jikkub + ", night=" + night + ", bonbong="
				+ bonbong + ", gongje=" + gongje + ", silbong=" + silbong + "]";
	}
	
	
}
