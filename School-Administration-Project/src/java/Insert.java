 import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Insert extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		String s1  =request.getParameter("u1");
		 String s2 =request.getParameter("u2");
		 String s3 =request.getParameter("u3");
		 String s4 =request.getParameter("u4");
		 String s5 =request.getParameter("u5");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///trust?useSSL=false&allowPublicKeyRetrieval=true","root","root");
			Statement st= con.createStatement();
			st.executeUpdate("insert into insmarks values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
			out.println("data  inserted");
			response.sendRedirect("ShowAll");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body");
		out.println("</html>");
		out.close();
	}
}