package fa.training.hibernate.main;

import fa.training.hibernate.dao.implement.EmployeeDao;
import fa.training.hibernate.dao.implement.EmployeeDaoImplement;
import fa.training.hibernate.model.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
	EmployeeDao empDao = new EmployeeDaoImplement();
		
//		Insert employee
		Employee emp = new Employee(3, "Tran", "Cong");
		empDao.save(emp);

//		Find employee by id
//		System.out.println(empDao.findEmployeeById(3));
		
//		Update first name  of employee by id
//		empDao.updateFisrtName(1, "Nguyen");
		
//		Delete employee by id
//		empDao.deleteEmployee(3);
		
	
	}

}
