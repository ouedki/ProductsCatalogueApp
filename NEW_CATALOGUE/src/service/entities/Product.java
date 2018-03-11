package service.entities;
import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String des;
	private Double price;
	private int quantity;
	public Product(String des, Double price, int quantity) {
		super();
		this.des = des;
		this.price = price;
		this.quantity = quantity;
	}
	public Product() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", des=" + des + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
