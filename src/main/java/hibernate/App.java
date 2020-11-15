package hibernate;

import java.util.List;

import hibernate.dao.EmployeeDao;
import hibernate.model.Employee;

public class App {
	
	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		//Save employee
		Employee employee = new Employee("John", "Doe", "johndoe@abc.com");
		employeeDao.saveEmp(employee);
		
		//Update employee
		employee.setFirstName("Joseph");
		employeeDao.updateEmp(employee);
				
		//Get employee by ID
		@SuppressWarnings("unused")
		Employee employee2 = employeeDao.getEmpById(employee.getId());
		
		//Get all employees
		List<Employee> employees = employeeDao.getAllEmployees();
		employees.forEach(employee1 -> System.out.println(employee1.getId()));
		
		//Delete employee
		employeeDao.deleteEmp(employee.getId());
	}
}
