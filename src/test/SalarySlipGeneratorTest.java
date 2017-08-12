package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import salary_slip_kata.Employee;
import salary_slip_kata.SalarySlip;
import salary_slip_kata.SalarySlipGenerator;

public class SalarySlipGeneratorTest {

	private SalarySlipGenerator generator;
	private Employee testEmployee;
	
	@Before
	public void setUp() {
		generator = new SalarySlipGenerator();
		testEmployee = new Employee("12345","John J Doe", new BigDecimal(5000.00));
	}
	
	@Test
	public void monthlyGrossSalaryShouldBeGrossSalaryDividedByTwelve() {
		SalarySlip testSlip = generator.generateFor(testEmployee);
		assertEquals(testSlip.getEmployeeID(), testEmployee.getID());
		assertEquals(testSlip.getEmployeeName(), testEmployee.getName());
		assertEquals(testSlip.getMonthlyGrossSalary(),BigDecimal.valueOf(416.67));
	}


}
