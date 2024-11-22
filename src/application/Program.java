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
		List<Seller> sellerList = sellerDao.findByDepartment(new Department(2, "Electronics"));
		for(Seller s : sellerList) {
			System.out.println(s);
		}

		System.out.println("\n=== TEST 3: seller findAll ===");
		List<Seller> sellerList2 = sellerDao.findAll();
		for(Seller s : sellerList2) {
			System.out.println(s);
		}
	}
}
