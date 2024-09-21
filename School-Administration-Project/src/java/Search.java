import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Search extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
                out.println("<head>" +"<link rel=\"stylesheet\" href=\"look.css\"/>\n" +"</head>\n" +"");
		
		String s1  =request.getParameter("u1");
	
 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///trust?useSSL=false&allowPublicKeyRetrieval=true","root","root");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select * from insmarks where RNO='"+s1+"'");
			if (rs.next())
			{
                        
                        out.println("<table cellpadding='12' border='1'>");
			out.println("<tr>");
			out.println("<td> Roll No. </td>");
			out.println("<td> Name </td>");
			out.println("<td> Physcs </td>");
			out.println("<td>Chemstry </td>");
			out.println("<td>maths </td>");
			out.println("</tr>");
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr>");
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
                out.println("</table>");
                
		out.println("</body");
		out.println("</html>");
	}
}