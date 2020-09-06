package dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import pojo.Bus;

public interface BusDao {
	boolean addBus(Bus b);
	boolean updateBus(Bus b);
	boolean deleteBus(int id);
	List<Bus> listBus();
	boolean updateBusList(String date,String time);
	Bus searchBusById(int id);
	List<Bus> searchBusBySD(String source,String Destination);
	List<Bus> searchBusByType(String type);
}
