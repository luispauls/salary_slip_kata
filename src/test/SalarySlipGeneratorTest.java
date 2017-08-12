package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import salary_slip_kata.Employee;
import salary_slip_kata.SalarySlip;
import salary_slip_kata.SalarySlipGenerator;

@RunWith(value = Parameterized.class)
public class SalarySlipGeneratorTest {

	private SalarySlipGenerator generator;
	private Employee employee;
	private SalarySlip salarySlip;
	
	@Parameter(value = 0)
	public BigDecimal annualGrossSalary;
	@Parameter(value = 1) 
	public BigDecimal monthlyGrossSalary;
	
	@Parameters(name = "annualGrossSalary: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new BigDecimal("5000.00"), new BigDecimal("416.67")},
                {new BigDecimal("9060.00"), new BigDecimal("755.00")}
        });
    }
	
	@Before
	public void setUp() {
		generator = new SalarySlipGenerator();
		employee = new Employee("12345","John J Doe", new BigDecimal(5000.00));
	}
	
	@Test
	public void monthlyGrossSalaryShouldBeGrossSalaryDividedByTwelve() {
		employee = new Employee("12345","John J Doe",annualGrossSalary);
		salarySlip = generator.generateFor(employee);
		assertEquals(salarySlip.getEmployeeID(), employee.getID());
		assertEquals(salarySlip.getEmployeeName(), employee.getName());
		assertEquals(salarySlip.getMonthlyGrossSalary(),monthlyGrossSalary);
	}


}
