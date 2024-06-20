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
import java.sql.SQLException;

@WebServlet("/FinalServlet")
public class FinalServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	// Create a dynamic SQL query
    	String sql = "INSERT INTO applied_details (job_id, first_name, last_name, age, gender, phone_no, email_id, passout_year, college_name, cgpa, branch, degree, currently_working, years_of_experience, company_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    	try 
    	{
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");
    		
    	    // Get values from the request
            System.out.println("hellooooooooooo");
            
            int job_id = Integer.parseInt(request.getParameter("job_id"));
    	    System.out.println(job_id);
    	    String first_name = request.getParameter("first_name") != null ? request.getParameter("first_name") : "";
    	    String last_name = request.getParameter("last_name") != null ? request.getParameter("last_name") : "";
    	    int age = request.getParameter("age") != null ? Integer.parseInt(request.getParameter("age")) : 0;
    	    String gender = request.getParameter("gender") != null ? request.getParameter("gender") : "";
    	    String phone_no = request.getParameter("phone_no") != null ? request.getParameter("phone_no") : "";
    	    String email_id = request.getParameter("email_id") != null ? request.getParameter("email_id") : "";
    	    int passout_year = request.getParameter("passout_year") != null ? Integer.parseInt(request.getParameter("passout_year")) : 0;
    	    String college_name = request.getParameter("college_name") != null ? request.getParameter("college_name") : "";
    	    double cgpa = request.getParameter("cgpa") != null ? Double.parseDouble(request.getParameter("cgpa")) : 0.0;
    	    String branch = request.getParameter("branch") != null ? request.getParameter("branch") : "";
    	    String degree = request.getParameter("degree") != null ? request.getParameter("degree") : "";
    	    int currently_working = request.getParameter("currently_working") != null ? Integer.parseInt(request.getParameter("currently_working")) : 0;
    	    int years_of_experience = request.getParameter("years_of_experience") != null ? Integer.parseInt(request.getParameter("years_of_experience")) : 0;
    	    String company_name = request.getParameter("company_name") != null ? request.getParameter("company_name") : "";


    	    
    	    // Prepare the statement with dynamic SQL
    	    PreparedStatement ps = con.prepareStatement(sql);
    	    ps.setInt(1, job_id);
    	    ps.setString(2, first_name);
    	    ps.setString(3, last_name);
    	    ps.setInt(4, age);
    	    ps.setString(5, gender);
    	    ps.setString(6, phone_no);
    	    ps.setString(7, email_id);
    	    ps.setInt(8, passout_year);
    	    ps.setString(9, college_name);
    	    ps.setDouble(10, cgpa);
    	    ps.setString(11, branch);
    	    ps.setString(12, degree);
    	    ps.setInt(13, currently_working);
    	    ps.setInt(14, years_of_experience);
    	    ps.setString(15, company_name);
    	    
    	    // Execute the query
    	    int rowsInserted = ps.executeUpdate();

    	    if (rowsInserted > 0) 
    	    {
    	    	
    	    	
    	    	PrintWriter out = response.getWriter();
                out.println("<script>alert('Application Successful');</script>");
                
                out.println("<script>setTimeout(function() { window.location.href = 'home.html'; }, 3000);</script>");
    	        
    	    } 
    	    else 
    	    {
    	    	PrintWriter out = response.getWriter();
                out.println("<script>alert('Try Again Later');</script>");
    	    }
    	} catch (ClassNotFoundException | SQLException e) {
    	    e.printStackTrace();
    	    // Handle database or other errors here
    	}

    }
}