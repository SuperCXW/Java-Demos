package bookbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.getSession();
		out.println("本站有这些书：<br/>");
		Set<Map.Entry<String,Book>> set = DB.getAll().entrySet();
		for (Map.Entry<String, Book> me : set) {
			Book book = me.getValue();
			String url = request.getContextPath()+"/BuyServlet?id="+book.getId();
			url = response.encodeURL(url);
			out.println(book.getName()+"<a href='"+url+"'>购买</a><br/>");
			System.out.println(url);
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
class DB{
	private static Map<String,Book> map = new LinkedHashMap<String,Book>();	
	static{
		map.put("1", new Book("1","Think in java"));
		map.put("2", new Book("2","Think in C++"));
		map.put("3", new Book("3","实战sturst2"));
		map.put("4", new Book("4","action in spring"));
		map.put("5", new Book("5","从删库都跑路"));
	}
	
	public static Map<String,Book> getAll(){
		return map;
	}
	}

class Book{
	private String id;
	private String name;
	
	public Book(){
		super();
	}
	
	public Book(String id,String name){
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
