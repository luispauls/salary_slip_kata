package salary_slip_kata;

import java.math.BigDecimal;

public class Employee {

	private String ID;
	private String name;
	private BigDecimal annualGrossSalary;
	
	public Employee(String id, String name, BigDecimal annualGrossSalary) {
		setID(id);
		setName(name);
		setAnnualGrossSalary(annualGrossSalary);
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAnnualGrossSalary() {
		return annualGrossSalary;
	}
	public void setAnnualGrossSalary(BigDecimal annualGrossSalary) {
		this.annualGrossSalary = annualGrossSalary;
	}
	
	
}
