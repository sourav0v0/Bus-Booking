package test;

import java.util.Iterator;
import java.util.List;

import controller.BusController;
import dao.BusDaoImpl;
import pojo.Bus;

public class BusTest {
public static void main(String[] args) {
 Bus b=new Bus("seawood", "nerul", 5, "13/5/2020", "20:44", 500, "AC", "");
 System.out.println(new BusDaoImpl().addBus(b));
}

}
