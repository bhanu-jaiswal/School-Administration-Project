 import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Updatesrc extends HttpServlet
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
                        out.println("<form action='UpdateData'>");
                        out.println("<table cellpadding='12' border='1'>");
			out.println("<tr>");
			out.println("<td> Roll No. </td>");
                       out.println("<td><input type='text' value='"+rs.getString(1)+"'name='n1'></td>");     
                        out.println("</tr>");
                       
                        out.println("<tr>");
			out.println("<td> Student Name </td>");
                       out.println("<td><input type='text' value='"+rs.getString(2)+"'name='n2'></td>");     
                        out.println("</tr>");
                        
                        out.println("<tr>");
			out.println("<td> Physcs Marks </td>");
                       out.println("<td><input type='text' value='"+rs.getString(3)+"'name='n3'></td>");     
                        out.println("</tr>");
                       
                       out.println("<tr>");
			out.println("<td> Chemestry Marks</td>");
                       out.println("<td><input type='text' value='"+rs.getString(4)+"'name='n4'></td>");     
                        out.println("</tr>");
                       
                        out.println("<tr>");
			out.println("<td> Maths marks </td>");
                       out.println("<td><input type='text' value='"+rs.getString(5)+"'name='n5'></td>");     
                        out.println("</tr>");
                        out.println("<tr>" + " <th colspan='2'>"+ "<input type='submit' value='Update' class='B'></th>" + "</tr>");
                       
                        }
			else 
			{
				out.println("Invalid Roll No.");
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
                out.println("</table>");
                out.println("</form>");
		out.println("</body");
		out.println("</html>");
	}
}