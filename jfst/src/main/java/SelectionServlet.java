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

@WebServlet("/SelectionServlet")
public class SelectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try 
        {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");

            // Get parameter values from the request
            int job_id = Integer.parseInt(request.getParameter("job_id"));
            System.out.println("Selection servlet job_id: " + job_id);
            int firstname = Integer.parseInt(request.getParameter("firstname"));
            System.out.println("Selection servlet firstname: " + firstname);
            int lastname = Integer.parseInt(request.getParameter("lastname"));
            int age = Integer.parseInt(request.getParameter("age"));
            int gender = Integer.parseInt(request.getParameter("gender"));
            int email = Integer.parseInt(request.getParameter("email"));
            int phone = Integer.parseInt(request.getParameter("phone"));
            int yearsofexp = Integer.parseInt(request.getParameter("yearsofexp"));
            int passoutyear = Integer.parseInt(request.getParameter("passoutyear"));
            int cgpa = Integer.parseInt(request.getParameter("cgpa"));
            int passoutclg = Integer.parseInt(request.getParameter("passoutclg"));
            int branch = Integer.parseInt(request.getParameter("branch"));
            int degree = Integer.parseInt(request.getParameter("degree"));
            int currWork = Integer.parseInt(request.getParameter("curr_work"));
            int companyname = Integer.parseInt(request.getParameter("company_name"));
            int resume = Integer.parseInt(request.getParameter("resume"));

            
            
            // Insert data into the 'form' table
            String sql = "INSERT INTO form (job_id, first_name, last_name, age, gender, phone_no, email_id, passout_year, college_name, cgpa, branch, degree, currently_working, company_name, years_of_experience, resume ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, job_id);
            ps.setInt(2, firstname);
            ps.setInt(3, lastname);
            ps.setInt(4, age);
            ps.setInt(5, gender);
            ps.setInt(6, phone);
            ps.setInt(7, email);
            ps.setInt(8, passoutyear);
            ps.setInt(9, passoutclg);
            ps.setInt(10, cgpa);
            ps.setInt(11, branch);
            ps.setInt(12, degree);
            ps.setInt(13, currWork);
            ps.setInt(14, companyname);
            ps.setInt(15, yearsofexp);
            ps.setInt(16, resume);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                PrintWriter out = response.getWriter();
                out.println("<script>alert('Form created!');</script>");
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
                dispatcher.forward(request, response);
                
            } else {
                // Insertion failed
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle database or other errors here
        }
    }
}
