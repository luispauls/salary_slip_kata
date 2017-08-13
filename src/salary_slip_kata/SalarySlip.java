package salary_slip_kata;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;

public class SalarySlip {

    private static final int DECIMAL_CASES = 2;
    private static final BigDecimal TWELVE_MONTHS = new BigDecimal("12");
    private static final BigDecimal ZERO = new BigDecimal("0.00");
    private static final BigDecimal NATIONAL_INSURANCE_BAND = new BigDecimal("8060.00");
    private static final BigDecimal NATIONAL_INSURANCE_RATE = new BigDecimal("0.12");
	
	private Employee employee;
	private BigDecimal monthlyGrossSalary;
	private BigDecimal nationalInsuranceContribution;
	
	public SalarySlip(Employee employee) {
		this.employee = employee;
		this.monthlyGrossSalary = calculateMonthlyGrossSalary(employee);
		this.nationalInsuranceContribution = calculateNationalInsuranceContribution(employee);
	}
	
	public BigDecimal getMonthlyGrossSalary() {
		return monthlyGrossSalary;
	}

	public BigDecimal getNationalInsuranceContribution() {
		return nationalInsuranceContribution;
	}

	public String getEmployeeID() {
		return employee.getID();
	}

	public String getEmployeeName() {
		return employee.getName();
	}
	
	private BigDecimal calculateMonthlyGrossSalary(Employee employee) {
		return divideBy12Months(employee.getAnnualGrossSalary());
	}

	private BigDecimal calculateNationalInsuranceContribution(Employee employee) {
		
		BigDecimal differenceFromLowerLimit =  employee.getAnnualGrossSalary().subtract(NATIONAL_INSURANCE_BAND);
		if (differenceFromLowerLimit.compareTo(ZERO) > 0) {
			return divideBy12Months(differenceFromLowerLimit.multiply(NATIONAL_INSURANCE_RATE));
		}
		return ZERO;
	}

	private BigDecimal divideBy12Months(BigDecimal dividend) {		
		return dividend.divide(TWELVE_MONTHS, DECIMAL_CASES, ROUND_HALF_UP);		
	}
	
	
	
}
