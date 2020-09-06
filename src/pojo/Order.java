package pojo;

public class Order {
	private int orderId;
	private String custEmail;
	private double totalBill;

	public Order(int orderId, String custEmail, double totalBill) {
		super();
		this.orderId = orderId;
		this.custEmail = custEmail;
		this.totalBill = totalBill;
		
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custEmail=" + custEmail + ", totalBill=" + totalBill +  "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
}
