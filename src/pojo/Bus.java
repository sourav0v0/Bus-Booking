package pojo;


public class Bus {
	private int bid;

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	private String bsource,image;
	private String bdestination;
	private int bseat;
	private String day;
	private String time;
	private String type;
	private int amount;
	public Bus(String bsource, String bdestination, int bseat, String day, String time, int amount,String type,String image) {
		super();
		this.bid = bid;
		this.image=image;
		this.bsource = bsource;
		this.bdestination = bdestination;
		this.bseat = bseat;
		this.day = day;
		this.time = time;
		this.amount = amount;
		this.type=type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Bus(String time) {
		super();
		this.time = time;
	}
	@Override
	public String toString() {
		return "Bus [bid=" + bid + ", bsource=" + bsource + ", bdestination=" + bdestination + ", bseat=" + bseat
				+ ", day=" + day + ", time=" + time + ", type=" + type + ", amount=" + amount + "]";
	}
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}

	
	public String getBsource() {
		return bsource;
	}
	public void setBsource(String bsource) {
		this.bsource = bsource;
	}
	public String getBdestination() {
		return bdestination;
	}
	public void setBdestination(String bdestination) {
		this.bdestination = bdestination;
	}
	public int getBseat() {
		return bseat;
	}
	public void setBseat(int bseat) {
		this.bseat = bseat;
	}
	public Bus(int bseat) {
		super();
		this.bseat = bseat;
	}
	
}
