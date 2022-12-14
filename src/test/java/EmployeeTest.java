import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fa.training.hibernate.dao.implement.EmployeeDao;
import fa.training.hibernate.dao.implement.EmployeeDaoImplement;
import fa.training.hibernate.model.Employee;

public class EmployeeTest {
	static EmployeeDao emplD;
	@Before
	public void setUpBeforeClass() throws Exception {
		emplD = new EmployeeDaoImplement();
	}
	
	@Test
	public void setUpAfterClass() throws Exception {
		Employee emp = new Employee(1, "Dai Ca", "Chau");
		assertEquals(true, emplD.save(emp));
	}
	
	@Test
	public void testFindEmployee() throws Exception{
		Employee emp = new Employee(1, "Lam", "Phuong");
		assertEquals(emp.toString(), emplD.findEmployeeById(1).toString());
	}
	
	@Test
	public void testUpdateFirstName() throws Exception{
		assertEquals(1, emplD.updateFirstName(1, "Lam"));
	}
	
	@Test
	public void testDeleteEmployee() throws Exception{
		assertEquals(true, emplD.deleteEmployee(2));
	}
	
}
