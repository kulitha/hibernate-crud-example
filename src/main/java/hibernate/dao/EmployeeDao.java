package hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.model.Employee;
import hibernate.utilities.HibernateUtilities;

public class EmployeeDao {
	//Save employee
	public void saveEmp(Employee employee) {
		Transaction transaction = null;
		try(Session session = HibernateUtilities.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			session.save(employee);
			
			transaction.commit();
		}
		catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	//Update an employee
	public void updateEmp(Employee employee) {
		Transaction transaction = null;
		try(Session session = HibernateUtilities.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(employee);
			
			transaction.commit();
		}
		catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	//Get employee by id
	public Employee getEmpById(int id) {
		Transaction transaction = null;
		Employee employee = null;
		try(Session session = HibernateUtilities.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			employee = session.get(Employee.class, id);
			
			transaction.commit();
		}
		catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return employee;
	}
	
	//Get all employees
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		Transaction transaction = null;
		List<Employee> employees = null;
		try(Session session = HibernateUtilities.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			employees = session.createQuery("from Employee").list();
			
			transaction.commit();
		}
		catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return employees;
	}
	
	//Delete an employee
	public void deleteEmp(int id) {
		Transaction transaction = null;
		Employee employee = null;
		try(Session session = HibernateUtilities.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			employee = session.get(Employee.class, id);
			session.delete(employee);
			
			transaction.commit();
		}
		catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
}
