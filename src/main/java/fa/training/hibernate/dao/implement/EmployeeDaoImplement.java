package fa.training.hibernate.dao.implement;

import java.io.Serializable;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.hibernate.model.Employee;
import fa.training.hibernate.utils.HibernateUtils;

public class EmployeeDaoImplement implements EmployeeDao{

	public boolean save(EmployeeDao emp) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(emp);
			transaction.commit();
			return (result!= null);
		} finally {
			if(session !=null);
			session.close();
		}
	}

	public Employee findEmployeeById(Integer empId) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Employee empl = (Employee) session.get(Employee.class, empId);
			return empl;
			
		} finally {
			if(session !=null);
			session.close();
		}
	}

	public int updateFirstName(Integer empId, String firstName) {
		Session session = null;
		Transaction transaction = null;
		
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		String hql = "UPDATE Employee set firstName = :firstName WHERE id = :id";
		
		Query query = session.createQuery(hql);
		query.setParameter("id", empId);
		query.setParameter("firstName", empId);
		query.executeUpdate();
		
		int result = query.executeUpdate();
		
		System.out.println(result + "Update!");
		transaction.commit();
		
		session.clear();
		session.close();
		
		System.out.println("Transaction Completed!");
		return result;
		
	}

	public boolean deleteEmployee(Integer empId) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			String hql = "DELETE FROM Employee WHERE ID = : id";
			Query query = session.createQuery(hql);
			query.setParameter("id", empId);
			
			int result = query.executeUpdate();
			
			System.out.println(result + "UPDATE!");
			transaction.commit();
			return true;
			
		} finally {
			if(session!=null) {
				session.clear();
				session.close();
				System.out.println("Transaction Completed!");
			}
		}
	}

	public boolean save(Employee emp) {
		return false;
	}
	
}
