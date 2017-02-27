package org.com.cay.first.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsynServlet
 */
@WebServlet(urlPatterns = {"/AsynServlet"})
public class AsynServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsynServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet开始时间：" + new Date());
		AsyncContext context = request.startAsync();//启用异步
//		context.getRequest()
		new Thread(new Executor(context)).start();
		System.out.println("Servlet结束时间：" + new Date());
	}
	
	public class Executor implements Runnable{
		private AsyncContext context;
		public Executor(AsyncContext context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				context.getRequest();
				context.getResponse();
				Thread.sleep(10000);
				System.out.println("业务执行完成时间：" + new Date());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
