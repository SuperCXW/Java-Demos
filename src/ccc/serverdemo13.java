package ccc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serverdemo13
 */
@WebServlet("/serverdemo13")
public class serverdemo13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serverdemo13() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=utf-8" );
		PrintWriter out = response.getWriter();
		Enumeration<String> reqHeadInfos = request.getHeaderNames();
		out.print("获取到的请求头为：<hr/>");
		while (reqHeadInfos.hasMoreElements()) {
			String headerName = reqHeadInfos.nextElement();
			String headerValue = request.getHeader(headerName);
			out.print(headerName+":"+headerValue+"<br/>");
		}
		String value = request.getHeader("Accept-Encoding");//获取Accept-Encoding请求头对应的值
		out.write("aaa:"+value+"<br/>");
		
		out.print("Accept-Encoding:");
		Enumeration<String> accEncodes = request.getHeaders("Accept-Encoding");
		while (accEncodes.hasMoreElements()) {
			String code = accEncodes.nextElement();
			out.print(code+";  "); 
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
