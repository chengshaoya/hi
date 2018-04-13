package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gg
 */
public class gg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	public void init() throws ServletException {
		// 初始化一个变量count的值为0.
		int count = 0;
		// 将这个值存入到ServletContext中.
		this.getServletContext().setAttribute("count", count);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count=(Integer)this.getServletContext().getAttribute("count");
		count++;
		this.getServletContext().setAttribute("count", count);
		response.getWriter().println(count);
		System.out.println(count);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
