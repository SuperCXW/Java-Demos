package ccc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serverdemo7
 * Êä³ö×Ö·û´®
 */
@WebServlet("/serverdemo7")
public class serverdemo7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serverdemo7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		outputOneByOutputStream(response);
	}
    public void outputOneByOutputStream(HttpServletResponse response) throws IOException{
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
//    	response.getOutputStream().write("Êä³ö1£º".getBytes("utf-8"));
//    	response.getOutputStream().write((1+"").getBytes());
    	PrintWriter out = response.getWriter();
    	out.write(1+"");
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
