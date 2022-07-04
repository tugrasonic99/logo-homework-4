package com.logo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.logo.model.Product;

import org.hibernate.Session;
import org.hibernate.query.Query;

@Repository
public class HibernateProductDAO implements ProductDAO {
	
	
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateProductDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public Product findProduct(int id) {
		
		
		System.out.println("Hibernate Product Found");
		
		Session currentSession = entityManager.unwrap(Session.class);
		Product found=currentSession.get(Product.class, id);
		
		return found;
	}

	@Override
	public List<Product> getAllProducts() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from Product", Product.class);
		List productList=query.getResultList();
		
		System.out.println("Hibernate Product Listed");
		
		return productList;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from product where id=:pid");
		query.setParameter("pid", id);
		
		query.executeUpdate();
		System.out.println("Hibernate Product Deleted");

	}

	@Override
	public void saveProduct(Product p) {
		// TODO Auto-generated method stub
        Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(p);
		System.out.println("Hibernate Product Saved");
		

	}

}
