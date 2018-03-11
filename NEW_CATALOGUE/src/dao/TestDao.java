package dao;

import java.util.List;

import service.entities.Product;

public class TestDao {

	public static void main(String[] args) {
//		ProductDaoImpl dao = new ProductDaoImpl();
//		Product p1 = dao.add(new Product("HP Ink Jet Laser", 450.0, 3));
//		Product p2 = dao.add(new Product("Dell proHp Ink", 335.0, 14));
//		Product p3 = dao.add(new Product("MalcomHP Laser Jet", 98.0, 12));
//		ProductDaoImpl pr = new ProductDaoImpl();
//		List <Product> list = pr.getProducts();
//		for (Product p : list) {
//			System.out.println(p);
//		}
//		Product p = pr.findProduct(12);
//		System.out.println(p);
		ProductDaoImpl dao = new ProductDaoImpl();
		List <Product> list = dao.findProductsByKeyWord("dell");
		System.out.println("Number of items found: " + (list.size()));
		for (Product p : list) {
			System.out.println(p);
		}
			
	}

}
