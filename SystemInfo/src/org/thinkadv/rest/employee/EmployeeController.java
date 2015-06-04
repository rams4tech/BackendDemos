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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

@Path("employee")
public class EmployeeController {
	private EmployeeDAO employeeDAO = new EmployeeDAO();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeesList(@QueryParam("callback") String callback) {
		List<Employee> employeesList = null;
		String output = null;
		try {
			employeesList = employeeDAO.getEntityList();
			ObjectMapper responseMapper = new ObjectMapper();
			output = responseMapper.writeValueAsString(employeesList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processOutput(callback, output);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(
			@PathParam(value = "id") Integer empId) {
		/*
		 * String output = null; try { output = employeeDAO.getJSONById(empId);
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } return processOutput(callback, output);
		 */
		List<Employee> employeesList = null;
		String output = null;
		try {
			employeesList = employeeDAO.getEntityList();

			for (Employee employee : employeesList) {
				if (empId.equals(employee.getEmpid())) {
					ObjectMapper responseMapper = new ObjectMapper();
					output = responseMapper.writeValueAsString(employee);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processOutput(null, output);
	}

	private Response processOutput(String callback, String output) {
		if (callback != null) {
			output = callback + "(" + output + ");";
		}
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response saveEmployee(String employeeString) {
		
		String output = null;
		Employee employee = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
			employee = objectMapper.readValue(employeeString, Employee.class);
			employeeDAO.saveOrUpdate(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output = ""+employee.getEmpid();
		
		return processOutput(null, output );
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateEmployee(String employeeString) {
		
		String output = null;
		Employee employee = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
			employee = objectMapper.readValue(employeeString, Employee.class);
			employeeDAO.saveOrUpdate(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output = ""+employee.getEmpid();
		
		return processOutput(null, output );
	}
	
	@GET
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addEmployee(@QueryParam("callback") String callback, @QueryParam(value="input") String employeeString) {
		
		String output = null;
		Employee employee = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			employee = objectMapper.readValue(employeeString, Employee.class);
			employeeDAO.saveOrUpdate(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output = e.getMessage();
		}
		output = ""+employee.getEmpid();
		
		return processOutput(callback, output );
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteEmployee( @PathParam(value = "id") Integer empId) {
		String output = null;
		try {
			employeeDAO.deleteEntity(empId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		output = "employee deleted";
		
		return processOutput(null, output );
		
	}
}
