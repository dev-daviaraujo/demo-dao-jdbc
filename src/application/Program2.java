package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		/*System.out.println("--- TEST 1: insert department ---");
		departmentDao.insert(new Department(1, "Comercial"));*/
		
		/*System.out.println("--- TEST 2: update department ---");
		departmentDao.update(new Department(6, "New dept"));*/
		
		System.out.println("--- TEST 3: deleteById department ---");
		departmentDao.deleteById(6);
		
		/*System.out.println("--- TEST 4: findById department ---");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);*/
		
		/*System.out.println("--- TEST 5: findAll department ---");
		List<Department> listDept = departmentDao.findAll();
		listDept.forEach(System.out::println);*/
		

	}

}
