package org.thinkadv.rest.employee;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empid;
	
	private String firstName;

	private String lastName;

	private String emailId;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Temporal(TemporalType.DATE)
	private Date doj;

	private String phoneNum;


	public Employee() {
	}
	
	

	


	public Employee(int empid, Date dob, Date doj, String emailId,
			String firstName, String lastName, String phoneNum) {
		super();
		this.empid = empid;
		this.dob = dob;
		this.doj = doj;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
	}



	public int getEmpid() {
		return this.empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return this.doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/*@Override
	public String toString() {
		return "Employee [empid=" + empid + ", dob=" + dob + ", doj=" + doj
				+ ", emailId=" + emailId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNum=" + phoneNum + "]";
	}*/
	
	

}