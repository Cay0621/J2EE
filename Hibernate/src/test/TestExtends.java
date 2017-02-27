package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateUtil;
import entity.Book;
import entity.Car;

public class TestExtends {

	@Test
	public void testFindBook(){
		Session session = HibernateUtil.openSession();
		
		Book book = session.load(Book.class, 1);
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		System.out.println(book.getPulisher());
		System.out.println(book.getAuthor());
		session.close();
	}
	
	@Test
	public void testAddBook() {
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		
		Book book = new Book();
		//����product����
		book.setName("C++�����������");
		book.setPrice(50.0);
		book.setProduct_pic("CPP.jpg");
		
		//����book����
		book.setAuthor("������");
		book.setPulisher("ͼ�������");
		book.setWordNumber("20000");
		book.setTotalPage("1034");
		
		session.save(book);
		ta.commit();
		session.close();
	}

	@Test
	public void testAddCar(){
		Session session = HibernateUtil.openSession();
		Transaction ta = session.beginTransaction();
		
		Car car = new Car();
		car.setName("Q7");
		car.setPrice(700000);
		car.setProduct_pic("x6.jpg");
		
		car.setBrand("�µ�");
		car.setType("�γ�");
		car.setColor("��ɫ");
		car.setDisplacement("3.0L");
		
		session.save(car);
		ta.commit();
		session.close();
	}
	
	@Test
	public void testFindAllBook(){
		Session session = HibernateUtil.openSession();
		String hql = "from Book";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Book> bookList = query.list();
		for (Book book : bookList) {
			System.out.println(book.getName());
		}
		session.close();
	}
}
