package ccc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serverdemo12
 */
@WebServlet("/serverdemo12")
public class serverdemo12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serverdemo12() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<String> params = new ArrayList<String>();
		params.add(request.getRequestURL().toString());
		params.add(request.getRequestURI());
		params.add(request.getQueryString());
		params.add(request.getRemoteAddr());
		params.add(request.getRemoteHost());
		params.add(String.valueOf(request.getRemotePort()));
		params.add(request.getRemoteUser());
		params.add(request.getMethod());
		params.add(request.getPathInfo());
		params.add(request.getLocalAddr());
		params.add(request.getLocalName());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();;
		out.print("获取到的请求信息：");
		out.print("<hr/>请求的URL地址"+params.get(0));
        out.print("<br/>请求的URI"+params.get(1));
        out.print("<br/>请求的URL地址中附带的参数："+params.get(2));
        out.print("<br/>来访者的IP地址："+params.get(3));
        out.print("<br/>来访者的主机名："+params.get(4));
        out.print("<br/>使用的端口号："+params.get(5));
        out.print("<br/>remoteUser："+params.get(6));
        out.print("<br/>请求使用的方法："+params.get(7));
        out.print("<br/>Pathinfo:"+params.get(8));
        out.print("<br/>localAddr:"+params.get(9));
        out.print("<br/>localName:"+params.get(10));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
