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


@WebServlet("/JobSearchServlet")
public class JobSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Idiot");
			PrintWriter out =response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");
			System.out.println("Hello");
		
			PreparedStatement ps = con.prepareStatement("Select * from job_details");
		
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{	 
				System.out.println("Hello query exe");
	             request.setAttribute("resultSet", rs);
	             request.getRequestDispatcher("jobsearch.jsp").forward(request, response);
			}
			else 
			{
				
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