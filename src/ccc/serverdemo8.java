package ccc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class server8
 * 下载文件
 */
@WebServlet("/serverdemo8")
public class serverdemo8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serverdemo8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,FileNotFoundException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String realPath = this.getServletContext().getRealPath("/img/我的.jpg");
		String filename = realPath.substring(realPath.lastIndexOf("\\")+1);
		response.setHeader("content-disposition", "attachment;filename="+(URLEncoder.encode(filename, "utf-8")));
		
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		
		byte[] buffer = new byte[1024];
		OutputStream out = response.getOutputStream();
		
		while ((len = in.read(buffer))>0) {
			out.write(buffer,0,len);
		}
		
		in.close();
		
        //1.获取要下载的文件的绝对路径
//		String realPath = this.getServletContext().getRealPath("/img/aaa.jpg");
////         String realPath = this.getServletContext().getRealPath("/img/aaa.JPG");
//         response.getWriter().print(realPath);
         //2.获取要下载的文件名
//         OutputStream out = response.getOutputStream();
         
//         String fileName = realPath.substring(realPath.lastIndexOf("/")+1);
         
//         out.write(realPath.getBytes());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
