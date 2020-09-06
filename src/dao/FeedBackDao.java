package dao;

import java.util.ArrayList;
import java.util.List;

import pojo.FeedBack;

public interface FeedBackDao {
boolean addFeedback(String name,String email,String message);
boolean delete(String email);
ArrayList<FeedBack> listOfFeedback();
}
