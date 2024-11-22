package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import db.DB;
import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {
		Department department = new Department(1, "Books");
		Seller seller = new Seller(21, "Bob", "Bob@gmail.com", new Date(), 3000.0, department);
		System.out.println(seller);

		SellerDao sellerDao = DaoFactory.createSellerDao();

	}
}
