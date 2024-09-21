  import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyMenuDemo  extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();
                HttpSession session=request.getSession();
                String s = (String)session.getAttribute("uname");
                if(s!=null)
                {
		out.println("<html>");
		out.println("<body>");
                out.println("<head>" +"<link rel=\"stylesheet\" href=\"look.css\"/>\n" +"</head>\n" +"");
                out.println("<div id='mymenu'><ul><li><a href='insert.html'> Insert Marks</a></li><li><a href='Search.html'>Search</a></li> <li><a href='update.html'>Update</a></li>  <li><a href='delete.html'>Delete</a></li><li><a href=\"ShowAll\">ShowAll</a></li><li><a href='LogOut'>LogOut</a></li>  </ul></div>");
               out.println("</body>");
		 out.println("</html>");
                 out.println("Welcome -  "+s);
                }
                else
                {
                    response.sendRedirect("login.html");
                }
                 out.close();
		
        }
}