import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		String s1  =request.getParameter("u1");
		String s2 =request.getParameter("u2");
 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///trust?useSSL=false&allowPublicKeyRetrieval=true","root","root");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select * from login where UName='"+s1+"' and UPass='"+s2+"'");
			if (rs.next())
			{ 
                                HttpSession session = request.getSession();
                                session.setAttribute("uname",s1);
				response.sendRedirect("MyMenuDemo");
				
			}
			else 
			{
				out.println("Invalid User-name And Password");
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body");
		out.println("</html>");
	}
}