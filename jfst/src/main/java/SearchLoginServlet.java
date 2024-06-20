import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



@WebServlet("/SearchLoginServlet")
public class SearchLoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int job_id = Integer.parseInt(request.getParameter("job_id"));
            System.out.println("Selection servlet job_id: " + job_id);
			
			PrintWriter out =response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");
			String n = request.getParameter("loginemail");
			String p=request.getParameter("loginpassword");
			PreparedStatement ps = con.prepareStatement("Select * from jobsearch_login where user_emailid=? and password=?");
			ps.setString(1, n);
			ps.setString(2, p);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				 String user_name = rs.getString("user_name");
	             request.setAttribute("user_name", user_name);
	             
	             PreparedStatement ps1 = con.prepareStatement("Select * from form where job_id=?");
	 			 ps1.setInt(1, job_id);
	 			 
	 			 ResultSet rs1=ps1.executeQuery();
	 			 if(rs1.next())
	 			 {
	 				request.setAttribute("result", rs1);
	 				RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
					rd.forward(request, response);
	 			 }
				
			}
			else 
			{
				PrintWriter out1 = response.getWriter();
            	out1.println("<script>alert('Enter correct credentials!');</script>");
            	
            	out1.println("<script>setTimeout(function() { window.location.href = 'searchlogin.jsp'; }, 4000);</script>");
            	
            }
			
		} 
		 catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
	}

}