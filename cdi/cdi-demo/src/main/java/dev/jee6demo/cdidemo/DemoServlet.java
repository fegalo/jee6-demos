package dev.jee6demo.cdidemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	
	@Inject 
	private HelloBean helloBean;
	
	private static final long serialVersionUID = 1L;

	public DemoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+"<header><title>CDI-DEMO</title></header>"
				+"<body>");
		out.println("<h2>DemoServlet in cdi-demo</h2>");
		out.println(helloBean.getText());
		out.print("</body></html>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
