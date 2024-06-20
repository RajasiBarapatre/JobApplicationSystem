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



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out =response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");
			String n = request.getParameter("loginemail");
			String p=request.getParameter("loginpassword");
			PreparedStatement ps = con.prepareStatement("Select * from jobpost_login where company_emailid=? and password=?");
			ps.setString(1, n);
			ps.setString(2, p);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				 String company_name = rs.getString("company_name");
	             request.setAttribute("company_name", company_name);
	             
				RequestDispatcher rd = request.getRequestDispatcher("company_details.jsp");
				rd.forward(request, response);
			}
			else {
				PrintWriter out1 = response.getWriter();
            	out1.println("<script>alert('Enter correct credentials!');</script>");
            	RequestDispatcher rd = request.getRequestDispatcher("JobPostLogin.jsp");
				rd.forward(request, response);
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