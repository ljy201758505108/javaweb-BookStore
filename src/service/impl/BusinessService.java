package service.impl;

import java.util.List;

import domain.Book;
import domain.Category;
import domain.Order;

public interface BusinessService {

	/**添加分类**/
	void addCategory(Category category);

	/**查找分类**/
	Category findCategory(String id);

	/**得到所有分类**/
	List<Category> getAllCategory();
	//前台操作，删除order
	void hiddenOrder(String orderid);
	//后台操作，修改分类
	void updateCategory(Category category);

	//后台操作，删除对应orderid订单
	void deleteOrder(String orderid);

	//后台操作，修改图书
	void updatebook(Book book);
}