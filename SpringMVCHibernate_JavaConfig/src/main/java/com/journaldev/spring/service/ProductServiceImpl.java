/*package com.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ProductDAO;
import com.journaldev.spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
		
	

	@Override
	@Transactional
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		List<Product>p=this.productDAO.listProduct();
		return p;
	}

	

}
*/