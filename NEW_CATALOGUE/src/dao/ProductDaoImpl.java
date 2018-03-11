package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.entities.Product;

public class ProductDaoImpl implements IProductDao {

	@Override
	public Product add(Product p) {
		Connection conn = SingletonConnexion.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO products (description, price, quantity) VALUES (?,?,?)");
			ps.setString(1, p.getDes());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement("select max(id) as maxId from products");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt("maxId"));
			}
			ps.close();
			ps2.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> getProducts() {
		List <Product> products = new ArrayList<Product>();
		Connection conn = SingletonConnexion.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from products");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setDes(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantity(rs.getInt("quantity"));
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product findProduct(int id) {
		Connection conn = SingletonConnexion.getConn();
		Product p = new Product();
			try {
				PreparedStatement ps = conn.prepareStatement("select * from products where id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					p = new Product();
					p.setId(rs.getInt("id"));
					p.setDes(rs.getString("description"));
					p.setPrice(rs.getDouble("price"));
					p.setQuantity(rs.getInt("quantity"));
			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return p;
	}

	@Override
	public Product updateProduct(Product p) {
		Connection conn = SingletonConnexion.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement
					("UPDATE PRODUCTS SET description = ?, price = ?, quantity = ? WHERE id = ?");
			ps.setString(1, p.getDes());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
			
			ps.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduct(int id) {
		Connection conn = SingletonConnexion.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE from products where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> findProductsByKeyWord(String kw) {
		List <Product> products = new ArrayList<Product>();
		Connection conn = SingletonConnexion.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from products where description like ?");
			ps.setString(1, kw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setDes(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantity(rs.getInt("quantity"));
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

}
