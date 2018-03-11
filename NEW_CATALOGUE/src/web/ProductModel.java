package web;

import java.util.ArrayList;
import java.util.List;

import service.entities.Product;

public class ProductModel {
	private String keyWord;
	private List <Product> products = new ArrayList<Product>();
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
