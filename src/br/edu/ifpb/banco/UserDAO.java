package br.edu.ifpb.banco;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.model.User;

public class UserDAO {
	
	public void insert(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException hex) {
			session.getTransaction().rollback();
			hex.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked", "finally" })
	public List<User> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> users = null;
		Query query;

		try {
			session.beginTransaction();
			query = session.getNamedQuery("User.getAll");
			users = query.list();
			session.getTransaction().commit();
		} catch (HibernateException hexp) {
			session.getTransaction().rollback();
			hexp.printStackTrace();
		} finally {
			session.close();
			return users;
		}
	}
}
