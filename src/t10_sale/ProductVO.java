package t10_sale;

public class ProductVO {

	private int idx;
	private String pName;
	private int price;	//본사 정가
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProuductVO [idx=" + idx + ", pName=" + pName + ", price=" + price + "]";
	}
}
