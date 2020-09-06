package pojo;

public class Cart {
	private int CartId;
	private int bid;
	private int bseat;
	private String custEmail;
	public Cart(int cartId, int bid, int bseat, String custEmail) {
		super();
		CartId = cartId;
		this.bid = bid;
		this.bseat = bseat;
		this.custEmail = custEmail;
	}
	public int getCartId() {
		return CartId;
	}
	public void setCartId(int cartId) {
		CartId = cartId;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getBseat() {
		return bseat;
	}
	public void setBseat(int bseat) {
		this.bseat = bseat;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

}
