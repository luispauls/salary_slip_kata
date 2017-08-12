package salary_slip_kata;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;

public class SalarySlip {

    private static final int DECIMAL_CASES = 2;
    private static final BigDecimal TWELVE_MONTHS = new BigDecimal(12);
	
	private Employee employee;

	
	
	public SalarySlip(Employee employee) {
		setEmployee(employee);
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Object getEmployeeID() {
		return employee.getID();
	}

	public Object getEmployeeName() {
		return employee.getName();
	}
	
	public BigDecimal getMonthlyGrossSalary() {
		return employee.getAnnualGrossSalary().divide(TWELVE_MONTHS, DECIMAL_CASES, ROUND_HALF_UP);
	}


	
	
}
