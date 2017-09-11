package ccc;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serverdemo14
 */
@WebServlet("/serverdemo14")
public class serverdemo14 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serverdemo14() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		String userPass = request.getParameter("userpass");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		String[] insts = request.getParameterValues("inst");
		String note = request.getParameter("note");
		String hiddenField = request.getParameter("hiddenField");
		
		String instsStr = "";
		
		for (int i = 0; insts!=null && i < insts.length; i++) {
			if (i == insts.length-1) {
				instsStr = insts[i];				
			}else{
				instsStr += insts[i] + ",";
			}
		}
		
		String htmlStr = "<table>" +
				                             "<tr><td>填写的编号：</td><td>{0}</td></tr>" +
				                             "<tr><td>填写的用户名：</td><td>{1}</td></tr>" +
				                             "<tr><td>填写的密码：</td><td>{2}</td></tr>" +
				                             "<tr><td>选中的性别：</td><td>{3}</td></tr>" +
				                             "<tr><td>选中的部门：</td><td>{4}</td></tr>" +
				                             "<tr><td>选中的兴趣：</td><td>{5}</td></tr>" +
				                             "<tr><td>填写的说明：</td><td>{6}</td></tr>" +
				                             "<tr><td>隐藏域的内容：</td><td>{7}</td></tr>" +
				                         "</table>";
		htmlStr = MessageFormat.format(htmlStr, userId,userName,userPass,sex,dept,instsStr,note,hiddenField);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(htmlStr);
		
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getParameter(name);
			response.getWriter().println(MessageFormat.format("{0} is {1}", name,value));
		}
		Map<String,String[]> paramMap = request.getParameterMap();
		for(Entry<String, String[]> entry : paramMap.entrySet()){
			String paramName = entry.getKey();
			String paramValue ="";
			String[] paramValueArr = entry.getValue();
			for (int i = 0; paramValueArr!=null && i<paramValueArr.length; i++) {
				if (i == paramValueArr.length-1){
					paramValue += paramValueArr[i];
				}else {
					paramValue += paramValueArr[i]+",";
				}
			}
			response.getWriter().println(MessageFormat.format("{0} is {1}<br/>", paramName,paramValue));	
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
