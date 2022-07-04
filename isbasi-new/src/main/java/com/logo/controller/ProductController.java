package com.logo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logo.model.Product;

import com.logo.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/hibernate/allproducts")
	public List<Product> getProductsH() {
		return productService.getAllProductsHib();
	}
	
	@PostMapping(value = "/hibernate/saveproduct")
	public void saveProductH(@RequestBody Product productRequest) {
		productService.saveProductHib(productRequest);
		System.out.println(productRequest);
	}
	
	@PostMapping(value = "/hibernate/deleteproduct")
	public void deleteProductH(Integer id) {
		int i=Integer.parseInt(id.toString());
		productService.deleteProductHib(i);
	}
	
	@GetMapping(value = "/hibernate/findProduct")
	public Product findProductH(Integer id) {
		int i=Integer.parseInt(id.toString());
		return productService.findProductHib(i);
	}
	
	
	@GetMapping(value = "/jdbctemplate/allproducts")
	public List<Product> getProductsJ() {
		return productService.getAllProductsJdbcT();
	}
	
	@PostMapping(value = "/jdbctemplate/saveproduct")
	public void saveProductJ(@RequestBody Product productRequest) {
		productService.saveProductJdbcT(productRequest);
		System.out.println(productRequest);
	}
	
	@PostMapping(value = "/jdbctemplate/deleteproduct")
	public void deleteProductJ(Integer id) {
		int i=Integer.parseInt(id.toString());
		productService.deleteProductJdbcT(i);
	}
	
	@GetMapping(value = "/jdbctemplate/findProduct")
	public Product findProductJ(Integer id) {
		int i=Integer.parseInt(id.toString());
		return productService.findProductJdbcT(i);
	}
	
	
	@GetMapping(value = "/jdbc/allproducts")
	public List<Product> getProductsJb() {
		return productService.getAllProductsJdbc();
	}
	
	@PostMapping(value = "/jdbc/saveproduct")
	public void saveProductJb(@RequestBody Product productRequest) {
		productService.saveProductJdbc(productRequest);
		System.out.println(productRequest);
	}
	
	@PostMapping(value = "/jdbc/deleteproduct")
	public void deleteProductJb(Integer id) {
		int i=Integer.parseInt(id.toString());
		productService.deleteProductJdbc(i);
	}
	
	@GetMapping(value = "/jdbc/findProduct")
	public Product findProductJb(Integer id) {
		int i=Integer.parseInt(id.toString());
		return productService.findProductJdbc(id);
	}

}
