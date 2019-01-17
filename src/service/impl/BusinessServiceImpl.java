package service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.*;
import dao.impl.*;
import utils.DaoFactory;
import utils.WebUtils;
import domain.Book;
import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.Order;
import domain.OrderItem;
import domain.Page;
import domain.User;

public class BusinessServiceImpl implements BusinessService {

	private CategoryDao categoryDao = new CategoryDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	//private CategoryDao categoryDao = DaoFactory.getInstance().createDao("dao.impl.CategoryDaoImpl", CategoryDao.class);
	//private BookDao bookDao = DaoFactory.getInstance().createDao("dao.impl.BookDaoImpl", BookDao.class);
	//private UserDao userDao = DaoFactory.getInstance().createDao("dao.impl.UserDaoImpl", UserDao.class);
	//private OrderDao orderDao = DaoFactory.getInstance().createDao("dao.impl.OrderDaoImpl", OrderDao.class);

	//添加分类
	public void addCategory(Category category){
		categoryDao.add(category);
	}
	//根据id寻找分类
	public Category findCategory(String id){
		return categoryDao.find(id);
	}
	//获取所有分类结果
	public List<Category> getAllCategory(){
		return categoryDao.getAll();
	}

	@Override
	//order设置为不可见
	public void hiddenOrder(String order) {
		orderDao.hidden(order);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void deleteOrder(String orderid) {
		Order order = orderDao.find(orderid);
		Set<OrderItem> orderitems = order.getOrderitems();
	    for(OrderItem item: orderitems){
	    	orderItemDao.delete(item.getId());
		}
		orderDao.delete(orderid);
	}

	@Override
	public void updatebook(Book book) {
		bookDao.update(book);
	}

	//添加书
	public void addBook(Book book){
		bookDao.add(book);
	}
	//获得书
	public Book findBook(String id){
		return bookDao.find(id);
	}


	//获得分页数据
	public Page getBookPageData(String pagenum){
		int totalrecord = bookDao.getTotalRecord();

		Page page = null;
		if(pagenum == null){
			page = new Page(1,totalrecord);
		}else{
			page = new Page(Integer.parseInt(pagenum), totalrecord);
		}
		List<Book> list = bookDao.getPageData(page.getStartindex(), page.getPagesize());
		page.setList(list);

		return page;
	}
	
	public Page getBookPageData(String pagenum, String category_id){
		int totalrecord = bookDao.getTotalRecord(category_id);
		Page page = null;
		if(pagenum == null){
			page = new Page(1,totalrecord);
		}else{
			page = new Page(Integer.parseInt(pagenum), totalrecord);
		}
		List<Book> list = bookDao.getPageData(page.getStartindex(), page.getPagesize(), category_id);
		page.setList(list);
		return page;
	}

	public void buyBook(Cart cart, Book book) {
		cart.add(book);
	}
	
	//注册用户
	public void registerUser(User user) {
		userDao.add(user);
	}
	
	public User findUser(String id){
		return userDao.find(id);
	}

	public User userLogin(String username, String password){
		return userDao.find(username, password);
	}
	
	//生成订单
	public void createOrder(Cart cart, User user){
		if(cart == null){
			throw new RuntimeException("对不起，您还没有购买任何商品");
		}
		Order order = new Order();
		order.setId(WebUtils.makeID());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setView(true);
		order.setUser(user);
		for(Map.Entry<String, CartItem> me : cart.getMap().entrySet()){
			//得到一个购物项就生成一个订单项
			CartItem citem = me.getValue();
			OrderItem oitem = new OrderItem();
			oitem.setBook(citem.getBook());
			oitem.setPrice(citem.getPrice());
			oitem.setId(WebUtils.makeID());
			oitem.setQuantity(citem.getQuantity());
			order.getOrderitems().add(oitem);
		}	
		orderDao.add(order);
	}

	//后台获取所有state相同的订单信息,与order的view属性无关
	public List<Order> StatelistOrder(String state) {
		return orderDao.getAll(Boolean.parseBoolean(state));	
	}

	//获得某个用户的订单信息
	public List<Order> StatelistOrder(String state, String userid) {
		return orderDao.getAll(Boolean.parseBoolean(state), userid);
	}

	//获取某个用户的订单信息
	public List<Order> UserListOrder(String userid) {
		return orderDao.getAllOrder(userid);
	}

	//根据orderid列出订单明细
	public Order findOrder(String orderid) {		
		return orderDao.find(orderid);
	}

	//把订单置为发货状态
	public void confirmOrder(String orderid) {
		Order order = orderDao.find(orderid);
		order.setState(true);
		orderDao.update(order);
	}



}
