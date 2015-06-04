package org.thinkadv.rest.employee;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Transaction;

public class EmployeeDAO {

	public boolean saveOrUpdate(Employee employee) throws Exception {

		Transaction tx = HibernateUtil.getTransaction();
		HibernateUtil.getSession().saveOrUpdate(employee);
		tx.commit();
		HibernateUtil.close();

		return false;
	}
	
	

	public Employee getEntityById(int id) throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		Employee employee = (Employee) HibernateUtil.getSession().load(
				Employee.class, new Integer(id));
		tx.commit();
		HibernateUtil.close();
		return employee;
	}
	
	public String getJSONById(int id) throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		Employee employee = (Employee) HibernateUtil.getSession().load(
				Employee.class, new Integer(id));
		ObjectMapper responseMapper = new ObjectMapper();
		String empString = responseMapper.writeValueAsString(employee);
		tx.commit();
		HibernateUtil.close();
		return empString;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEntityList() throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		List<Employee> employeeList = HibernateUtil.getSession()
				.createCriteria(Employee.class).list();
		tx.commit();
		HibernateUtil.close();
		return employeeList;
	}

	public boolean deleteEntity(int id) throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		Object o = HibernateUtil.getSession().load(Employee.class, id);
		HibernateUtil.getSession().delete(o);
		tx.commit();
		HibernateUtil.close();
		return false;
	}

}
