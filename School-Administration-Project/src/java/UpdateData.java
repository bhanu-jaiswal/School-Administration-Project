import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateData extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		String s1  =request.getParameter("n1");
		 String s2 =request.getParameter("n2");
		 String s3 =request.getParameter("n3");
		 String s4 =request.getParameter("n4");
		 String s5 =request.getParameter("n5");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///trust?useSSL=false&allowPublicKeyRetrieval=true","root","root");
			Statement st= con.createStatement();
			st.executeUpdate("update insmarks set Name='"+s2+"',Phy='"+s3+"',Chem='"+s4+"',Maths='"+s5+"' where RNO='"+s1+"'");
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