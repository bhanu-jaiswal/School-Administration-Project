import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

 public class  ShowAll extends  HttpServlet
 {
	 public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	 {
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head> <link rel='stylesheet' href='look.css'/></head>");
		 out.println("<body>");
		 out.println("<div id='mymenu'><ul><li><a href='insert.html'> Insert Marks</a></li><li><a href='Search.html'>Search</a></li> <li><a href='update.html'>Update</a></li>  <li><a href='delete.html'>Delete</a></li><li><a href=\"ShowAll\">ShowAll</a></li>  </ul></div>");
		 
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql:///trust?useSSL=false&allowPublicKeyRetrieval=true","root","root");
			 Statement st=con.createStatement();
			ResultSet rs= st.executeQuery("select * from insmarks");
			
			out.println("<table cellpadding='12' border='1'>");
			out.println("<tr>");
			out.println("<td> Roll No. </td>");
			out.println("<td> Name </td>");
			out.println("<td> Physcs </td>");
			out.println("<td>Chemstry </td>");
			out.println("<td>maths </td>");
			out.println("</tr>");
			
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr>");
				
			}
			con.close();
		 out.println("</table>");
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 out.println("</body>");
		 out.println("</html>");
		 out.close();
	 }
 }