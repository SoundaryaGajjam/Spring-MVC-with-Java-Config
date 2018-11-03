/*package com.journaldev.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Product;

import io.restassured.RestAssured;
import io.restassured.response.Response;


//@Repository
public class ProductDAOImpl implements ProductDAO{

	@Override
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Product> listProduct() {
		
		System.out.println("In dao impl");
		Response response = RestAssured.get("http://localhost:8090/restws/rest/products");
		String responseString = response.asString();
		JSONArray jsonArray = null;
		List<Product> productList = new ArrayList<>();
		try {
			jsonArray = new JSONArray(responseString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json =null;
		
		for(int i=0;i<jsonArray.length();i++){
			 try {
				json = new JSONObject(jsonArray.get(i).toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				productList.add(new Product(json.getInt("productId"),  json.getString("productName"), json.getInt("productPrice"),json.getString("productCategory")));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Webservice json to Java Object---"+productList);
		
	
		return  productList;
	}

	
}
*/