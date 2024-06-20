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



@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out =response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");
			String name = request.getParameter("signupname");
			String email=request.getParameter("signupemail");
			String password=request.getParameter("signuppassword");
			PreparedStatement ps = con.prepareStatement("insert into jobpost_login(company_emailid, company_name,password) values (?, ?, ?)");
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, password);
			int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) 
            {
                out.println("<script>alert('Signup Successful! Login to continue');</script>");
                RequestDispatcher rd = request.getRequestDispatcher("JobPostLogin.jsp");
				rd.forward(request, response);
                // Optionally, you can redirect to a login page after signup
            } else {
                out.println("<script>alert('Failed to insert user!');</script>");
            }
			
		} 
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
	}

}