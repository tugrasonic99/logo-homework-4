package com.logo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.logo.model.Product;

@Repository
public class JDBCTemplateProductDAO implements ProductDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Product findProduct(int id) {
		System.out.println("JDBCTemplate Product Found");
		String q = "SELECT * from tutorials WHERE id ILIKE '%" + id + "%'";
	    return (Product) jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public List<Product> getAllProducts() {
		System.out.println("JDBCTemplate Products Listed");
		return jdbcTemplate.query("SELECT * from products", BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public void deleteProduct(int id) {
		jdbcTemplate.update("DELETE FROM products WHERE id=?", id);
		System.out.println("JDBCTemplate Product Deleted");

	}

	@Override
	public void saveProduct(Product p) {
		jdbcTemplate.update("INSERT INTO products (id,name,price) VALUES(?,?,?)",
		        new Object[] {p.getId(), p.getName(),p.getPrice()});
		System.out.println("JDBCTemplate Product Saved");
		
		  }
	     

	}


