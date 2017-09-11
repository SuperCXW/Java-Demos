package ccc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class httpdemo2
 */
@WebServlet(name="httpdemo2",   
urlPatterns={"/http2"},   
loadOnStartup=1 )
public class httpdemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public httpdemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String data = "abcdabcdabcdabcdabcdabcdab" +
				                 "cdabcdabcdabcdabcdabcdabcdabcdabc" +
				               "dabcdabcdabcdabcdabcdabcdabcdabc" +
			              "dabcdabcdabcdabcdabcdabcdabcdabcdab" +
		             "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
		          "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
		              "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
			           "cdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
		System.out.println("原始数据大小"+data.getBytes().length);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(data.getBytes());
		gout.close();
		
		byte g[] = bout.toByteArray();
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", g.length+"");
		response.getOutputStream().write(g);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
