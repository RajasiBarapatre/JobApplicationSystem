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
import java.util.ArrayList;
import java.util.List;


@WebServlet("/LastServlet")
public class LastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			PrintWriter out =response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jfstdb", "root", "Jfst@1515");
			
			List<String> columnNames = new ArrayList<>();
			List<Object> columnValues = new ArrayList<>();

			// Define an array of column names
			
			int job_id = Integer.parseInt(request.getParameter("job_id"));
			System.out.println(job_id);
			String[] allColumnNames = {"first_name", "last_name", "age", "gender", "phone_no", "email_id", "passout_year", "college_name", "cgpa", "branch", "degree", "currently_working", "company_name", "years_of_experience"};

			// Iterate through the columns
			for (String columnName : allColumnNames) {
			    // Check if the request parameter is not null
			    String parameterValue = request.getParameter(columnName);
			    if (parameterValue != null && !parameterValue.isEmpty()) {
			        // Add the column name and value to the lists
			        columnNames.add(columnName);
			        columnValues.add(parameterValue);
			    }
			}

			// Build the dynamic SQL query
			StringBuilder insertSQL = new StringBuilder("INSERT INTO applied_details (job_id");
			for (String columnName : columnNames) {
			    insertSQL.append(", ").append(columnName);
			}
			insertSQL.append(") VALUES (?,");
			for (int i = 0; i < columnNames.size(); i++) {
			    insertSQL.append("?");
			    if (i < columnNames.size() - 1) {
			        insertSQL.append(",");
			    }
			}
			insertSQL.append(")");

			// Create a PreparedStatement
			PreparedStatement preparedStatement = con.prepareStatement(insertSQL.toString());

			// Set parameters for the PreparedStatement
			preparedStatement.setInt(1, job_id);
			for (int i = 0; i < columnNames.size(); i++) {
			    preparedStatement.setObject(i + 2, columnValues.get(i));
			}

			// Execute the insert statement
			preparedStatement.executeUpdate();
			
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


















