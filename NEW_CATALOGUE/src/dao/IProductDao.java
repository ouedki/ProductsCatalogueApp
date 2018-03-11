package dao;

import java.util.List;

import service.entities.Product;

public interface IProductDao {
	public Product add (Product p);
	public List<Product> getProducts();
	public Product findProduct (int id);
	public List <Product> findProductsByKeyWord (String kw);
	public Product updateProduct (Product p);
	public void deleteProduct (int id);
	
}
