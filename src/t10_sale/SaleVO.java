package t10_sale;

public class SaleVO {
	
	private int idx;
	private String pName;
	private int ea;
	private String pDate;		//날짜 타입으로 줘도 되긴 함
	
	private int salePrice;	//최종가(지금은 정찰제로 만들 것이기 때문에 price와 똑같이 씀) 
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	@Override
	public String toString() {
		return "SaleVO [idx=" + idx + ", pName=" + pName + ", ea=" + ea + ", pDate=" + pDate + ", salePrice=" + salePrice
				+ "]";
	}
}
