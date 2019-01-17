package dao;

import java.util.List;

import domain.Order;
import org.apache.commons.dbutils.QueryRunner;

public interface OrderDao {
	//order和orderitem数据表同时增加记录
	void add(Order order);

	void update(Order order);
	//返回订单order对象，需要对不完整的order对象实例进行赋值
	Order find(String id);

	void fill(Order order, QueryRunner runner);//填充order中的orderitem变量

	List<Order> getAll(boolean state);//后台得到所有状态为state的订单

	List<Order> getAll(boolean state, String userid);//前台得到指定用户所有状态为state的订单，,view为true

	List<Order> getAllOrder(String userid);//前台得到指定用户的所有订单，view为true

	void hidden(String orderid);//将指定订单view置为false，对前台不可见

	void delete(String orderid);//将指定订单从数据库中删除
}