package com.logo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.logo.model.Product;

@Repository
public class JDBCProductDAO implements ProductDAO {
	

	Connection con = null;

	@SuppressWarnings("finally")
	@Override
	public Product findProduct(int id) {
		String query = "SELECT * FROM products WHERE id=?";
		Product p=new Product();
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/isbasi", "postgres", "123");
			PreparedStatement statement;
			statement = con.prepareStatement(query);
			statement.setInt(1,id);
			ResultSet result=statement.executeQuery();
			
			while(result.next()) {
				
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setPrice(result.getDouble("price"));
				
			}
			
			System.out.println("JDBC Product Found");
			
			con.close();
			
		}
		catch(Exception e) {
			
		}
		finally {
			return p;
		}

	}

	@SuppressWarnings("finally")
	@Override
	public List<Product> getAllProducts() {
		String query = "SELECT * FROM products";
		List<Product> list=new ArrayList<Product>();
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/isbasi", "postgres", "123");
			Statement statement=con.createStatement();;
			ResultSet result=statement.executeQuery(query);
			
			while(result.next()) {
				Product p=new Product();
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setPrice(result.getDouble("price"));
				list.add(p);
				
			}
			
			
			con.close();
			System.out.println("JDBC Products Listed");
			
		}
		catch(Exception e) {
			
		}
		
		finally {
			return list;
		}
	}

	@Override
	public void deleteProduct(int id) {
		String query = "DELETE FROM products WHERE id=?";
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/isbasi", "postgres", "123");
			PreparedStatement statement;
			statement = con.prepareStatement(query);
			statement.setInt(1,id);
			statement.executeUpdate(); 
			con.close();
			System.out.println("JDBC Product Deleted");
			
		}
		catch(Exception e) {
			
		}

	}

	@Override
	public void saveProduct(Product p) {
		String query = "INSERT INTO products VALUES (?,?,?)";
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/isbasi", "postgres", "123");
			PreparedStatement statement;
			statement = con.prepareStatement(query);
			statement.setInt(1, p.getId());
			statement.setString(2, p.getName());
			statement.setDouble(3, p.getPrice());//
			statement.executeUpdate(); 
			con.close();
			System.out.println("JDBC Product Saved");
			
		}
		catch(Exception e) {
			
		}

	}

}
