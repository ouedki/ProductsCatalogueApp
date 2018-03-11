package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProductDao;
import dao.ProductDaoImpl;
import service.entities.Product;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDao service;
	
	@Override
	public void init () throws ServletException{
		service = new ProductDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/index.yo")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else if (path.equals("/search.yo")) {
			String keyWord = request.getParameter("key");
			ProductModel model = new ProductModel();
			model.setKeyWord(keyWord);
			List <Product> list = service.findProductsByKeyWord("%" + keyWord + "%");
			model.setProducts(list);
			request.setAttribute("model", model);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else if(path.equals("/addProduct.yo")) {
			request.setAttribute("product", new Product());
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}else if (path.equals("/saveProduct.yo") && request.getMethod().equalsIgnoreCase("post")) {
			String des = request.getParameter("inputDes");
			double price = Double.parseDouble(request.getParameter("inputPrice"));
			int quantity = Integer.parseInt(request.getParameter("inputQuantity"));
			Product p = service.add(new Product(des, price, quantity));
			request.setAttribute("product", p);
			request.getRequestDispatcher("addConfirmation.jsp").forward(request, response);
		}else if(path.equals("/delete.yo")) {
			int id = Integer.parseInt(request.getParameter("id"));
			service.deleteProduct(id);
			response.sendRedirect("search.yo?key=");
		}else if(path.equals("/edit.yo")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = service.findProduct(id);
			request.setAttribute("product", p);
			request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
		}else if (path.equals("/updateProduct.yo") && request.getMethod().equalsIgnoreCase("post")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String des = request.getParameter("inputDes");
			double price = Double.parseDouble(request.getParameter("inputPrice"));
			int quantity = Integer.parseInt(request.getParameter("inputQuantity"));
			Product p = new Product(des, price, quantity);
			p.setId(id);
			service.updateProduct(p);
			request.setAttribute("product", p);
			request.getRequestDispatcher("addConfirmation.jsp").forward(request, response);
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
