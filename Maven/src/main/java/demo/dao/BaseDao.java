package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("basedao")
public class BaseDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void add(Object obj){
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try {
			 session.save(obj);
			 tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public Object load(Class clazz, Integer id){
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Object obj = null;
		try {
			 obj = session.get(clazz, id);
			 tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return obj;
	}
	
	public void update(Object obj){
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try {
			 session.update(obj);
			 tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void delete(Object obj){
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try {
			 session.delete(obj);
			 tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public List find(String hql){
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		List result = new ArrayList();
		try {
			 result = session.createQuery(hql).list();
			 tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return result;
	}
	
	
}
