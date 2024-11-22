package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department dp0 = new Department(2, "Electronics");
		List<Seller> sellerList = sellerDao.findByDepartment(dp0);
		for(Seller s : sellerList) {
			System.out.println(s);
		}

		System.out.println("\n=== TEST 3: seller findAll ===");
		List<Seller> sellerList2 = sellerDao.findAll();
		for(Seller s : sellerList2) {
			System.out.println(s);
		}

		System.out.println("\n=== TEST 4: seller insert ===");
		Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dp0);
		sellerDao.insert(seller1);
		System.out.println("Inserted! New id = " + seller1.getId());

		System.out.println("\n=== TEST 5: seller update ===");
		Seller seller2 = sellerDao.findById(1);
		seller2.setName("Bob Marley");
		sellerDao.update(seller2);
		System.out.println("Updated! New seller name = " + seller2.getName());

		System.out.println("\n=== TEST 6: seller delete ===");
		sellerDao.deleteById(12);
		System.out.println("Deleted! " + sellerDao.findById(20));

	}
}
