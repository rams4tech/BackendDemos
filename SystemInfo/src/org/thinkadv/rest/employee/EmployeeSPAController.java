package org.thinkadv.rest.employee;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employeedetail")
public class EmployeeSPAController {
	private EmployeeDAO employeeDAO = new EmployeeDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Employee> getEmployeesList() {
		List<Employee> employeesList = null;
		try {
			employeesList = employeeDAO.getEntityList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeesList;
	}


	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee getEmployeeById(
			@PathParam(value = "id") Integer empId) {
		List<Employee> employeesList = null;
		Employee returnEmployee = null;
		try {
			employeesList = employeeDAO.getEntityList();

			for (Employee employee : employeesList) {
				if (empId.equals(employee.getEmpid())) {
					returnEmployee = employee;
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnEmployee;
	}

	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee saveEmployee(Employee employee) {
		
		try {
			employeeDAO.saveOrUpdate(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	
	@PUT @Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee updateEmployee(Employee employee) {
		
		try {
			employeeDAO.saveOrUpdate(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	
	
	@DELETE @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void deleteEmployee( @PathParam(value = "id") Integer empId) {
		try {
			employeeDAO.deleteEntity(empId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
