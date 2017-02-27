package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String action;//
	private ItemsDAO itemdao = new ItemsDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			if (action.equals("add")) {
				if (addToCart(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(
							request, response);
				} else {
					request.getRequestDispatcher("/failure.jsp").forward(
							request, response);
				}
			}
			if (action.equals("show")) {
				//showCart(request, response);
				request.getRequestDispatcher("/cart.jsp").forward(
						request, response);
			}
			if(action.equals("delete")){
				if(deleteFromCart(request, response)){
					request.getRequestDispatcher("/cart.jsp").forward(
							request, response);
				}
			}
		}

		out.close();
	}

	private boolean deleteFromCart(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Items item = itemdao.getItemsById(id);
		if(cart.removeGoodsFromCart(item)){
			return true;
		}
		return false;
	}

	private boolean addToCart(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		int number = Integer.parseInt(request.getParameter("num"));
		Items item = itemdao.getItemsById(id);

		// 
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart.addGoodsInCart(item, number)) {
			return true;
		} else {
			return false;
		}
	}

}
