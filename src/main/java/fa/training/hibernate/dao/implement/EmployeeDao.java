package fa.training.hibernate.dao.implement;

import fa.training.hibernate.model.Employee;

public interface EmployeeDao {
	public boolean save (Employee emp);
	public Employee findEmployeeById (Integer empId);
	public int updateFirstName (Integer empId, String firstName);
	public boolean deleteEmployee(Integer empId);

}
