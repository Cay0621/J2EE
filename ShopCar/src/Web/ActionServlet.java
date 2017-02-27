package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.CartItem;
import dao.ProductDAO;
import entity.Product;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/") + 1,
				uri.lastIndexOf("."));
		if (action.equals("list")) {
			ProductDAO dao = new ProductDAO();
			try {
				List<Product> products = dao.findAll();
				request.setAttribute("products", products);
				request.getRequestDispatcher("productList.jsp").forward(
						request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (action.equals("buy")) {
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
				session.setAttribute("cart", cart);
			}

			int id = Integer.parseInt(request.getParameter("id"));
			ProductDAO dao = new ProductDAO();
			try {
				Product pro = dao.findById(id);
				CartItem item = new CartItem();
				item.setPro(pro);
				item.setCount(1);
				boolean flag = cart.add(item);
				// 如果返回值为true，则提示用户购买成功
				// 如果返回值为false，则提示用户已经购买过该商品
				if (flag) {
					request.setAttribute("buy_msg_" + pro.getId(), "购买成功");
				} else {
					request.setAttribute("buy_msg_" + pro.getId(), "已经购买过该商品");
				}
				request.getRequestDispatcher("list.do").forward(request,
						response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if(action.equals("modify")){
			int id = Integer.parseInt(request.getParameter("id"));
			String value = request.getParameter("value");
			if(value.isEmpty()){
				return;
			}
			int count = Integer.parseInt(value);
			//System.out.println(count);
			
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			cart.modify(id, count);
			
			session.setAttribute("cart", cart);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		else if(action.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			cart.del(id);
			
			session.setAttribute("cart", cart);
			//request.getRequestDispatcher("cart.jsp").forward(request, response);
			response.sendRedirect("cart.jsp");
		}
		else if(action.equals("clear")){
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			cart.clear();
			
			session.setAttribute("cart", cart);
			response.sendRedirect("cart.jsp");
		}
	}

}
