package ccc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serverdemo9
 * ÎÄ×ÖÑéÖ¤Âë
 */
@WebServlet("/serverdemo9")
public class serverdemo9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serverdemo9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Refresh", "2");
		BufferedImage img = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 20);
		g.setColor(Color.blue);
		g.setFont(new Font(null,Font.BOLD,20));
		g.drawString(makeNum(),0,20);
        response.setContentType("image/jpeg");
        response.setDateHeader("expries",-1);
        response.setHeader("Cache-Control", "no-cache");
        ImageIO.write(img, "jpg", response.getOutputStream());
	}
	private String makeNum(){
	       Random random = new Random();
	       String num = random.nextInt(9999999)+"";
	       StringBuffer sb = new StringBuffer();
	       for (int i = 0; i < 7-num.length(); i++) {
		       sb.append("0");
		   }
		       num = sb.toString()+num;
		       return num;
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
