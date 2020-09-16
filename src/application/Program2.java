package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("==== TEST 1: Department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n==== TEST 2: Department findAll ====");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		/*
		System.out.println("\n==== TEST 3: Departmanet insert ====");
		Department newDepartment = new Department(null, "Treasury");
		departmentDao.insert(newDepartment);
		System.out.println("Insert! New id = " + newDepartment.getId());
		*/
		System.out.println("\n==== TEST 4: Department update ====");
		department = departmentDao.findById(1);
		department.setName("Computers");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n==== TEST 5: Department delete ====");
		//department = departmentDao.findById(7);
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);;
		System.out.println("Delete completed!");
		
		sc.close();
		
	}

}
