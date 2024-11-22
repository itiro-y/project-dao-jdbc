package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: department insert ===");
        Department dep0 = new Department(null, "Mugs");
        //departmentDao.insert(dep);

        System.out.println("\n=== Test 2: department findById ===");
        Department dep1 = departmentDao.findById(10);
        System.out.println(dep1);

        System.out.println("\n=== Test 3: department findAll ===");
        List<Department> depList = departmentDao.findAll();
        for(Department dep : depList){
            System.out.println(dep);
        }

    }
}
