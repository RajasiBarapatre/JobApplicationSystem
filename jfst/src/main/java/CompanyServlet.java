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



@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ResultSet rs = null;
		try {
			PrintWriter out =response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");
			
			String companyname = request.getParameter("companyname");
			String jobrole = request.getParameter("jobrole");
			String jobtype = request.getParameter("jobtype");
			int stipend = Integer.parseInt(request.getParameter("stipend"));
			int duration = Integer.parseInt(request.getParameter("duration"));
			String location = request.getParameter("location");
			String website = request.getParameter("website");
			String criteria = request.getParameter("criteria");
			PreparedStatement ps = con.prepareStatement("insert into job_details(company_name, job_role, job_type, salary, duration, location, company_website, eligibility_criteria) values (?, ?, ?, ?, ?, ?, ?, ?)", new String[]{"job_id"});
			
			ps.setString(1, companyname);
			ps.setString(2, jobrole);
			ps.setString(3, jobtype);
			ps.setInt(4, stipend);
			ps.setInt(5, duration);
			ps.setString(6, location);
			ps.setString(7, website);
			ps.setString(8, criteria);
			
			int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) 
            {
            	PreparedStatement selectLastId = con.prepareStatement("SELECT job_id from job_details where company_name = ? and job_type = ?");
            	selectLastId.setString(1, companyname);
            	selectLastId.setString(2, jobtype);
            	ResultSet resultSet = selectLastId.executeQuery();

                if (resultSet.next()) 
                {
                	int job_id = resultSet.getInt("job_id");
                	request.setAttribute("job_id", job_id);
	                RequestDispatcher rd = request.getRequestDispatcher("selection.jsp");
					rd.forward(request, response);
                }
                
            } else {
                out.println("<script>alert('Failed to insert user!');</script>");
                out.println("<script>setTimeout(function() { window.location.href = 'company_details.jsp'; }, 2000);</script>");
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