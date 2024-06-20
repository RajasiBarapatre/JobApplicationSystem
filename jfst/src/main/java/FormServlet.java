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


@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Idiot");
			PrintWriter out =response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");
			System.out.println("Hello");
		
			
			String company_name = request.getParameter("company_name"); 
			String job_type = request.getParameter("job_type"); 
			String job_role = request.getParameter("job_role"); 
			String location = request.getParameter("location");
			
			PreparedStatement ps = con.prepareStatement("Select * from job_details where company_name=? AND job_type=? AND job_role=? AND location=?");
			ps.setString(1, company_name);
			ps.setString(2, job_type);
			ps.setString(3, job_role);
			ps.setString(4, location);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{	 
				int job_id = (int)rs.getInt("job_id");
				request.setAttribute("job_id", job_id);
		        request.getRequestDispatcher("searchlogin.jsp").forward(request, response); 
				
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