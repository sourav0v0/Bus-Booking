package pojo;

public class History {
private int bid,seat;
private String name;
public History(int bid, int seat, String name) {
	super();
	this.bid = bid;
	this.seat = seat;
	this.name = name;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public int getSeat() {
	return seat;
}
public void setSeat(int seat) {
	this.seat = seat;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



}