package domain;

public class OrderItem {
	private String id;
	private int quantity;
	private double price;
	private Book book;//book对象，对应book_id
	//不需要order对象对应order_id，因为实在orderDao中对orderitem表进行插入操作
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
