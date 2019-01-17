package dao;

import java.util.List;

import domain.Book;

public interface BookDao {

	void add(Book book);

	Book find(String id);
	//获取分页书籍容器
	public List<Book> getPageData(int startindex, int pagesize);
	
	public int getTotalRecord();

	public List<Book> getPageData(int startindex, int pagesize, String category_id);
	
	public int getTotalRecord(String category_id);

	void update(Book book);
}