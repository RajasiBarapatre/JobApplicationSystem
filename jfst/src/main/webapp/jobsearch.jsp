<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.ResultSet" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/jobsearch.css">
    <title>Job Application</title>

</head>


<body>
    <div class="container">

        <div class="nav">
            <div>
                <h1>UNSTOP</h1>
               
            </div>
    
            <div class="navitems">
                <div class="navitem">Home</div>
                <div class="navitem">About</div>
                <div class="navitem">Contact</div>
            </div>
        </div>
    
    <div class="filter-bar">
        <label for="job-role">Job Role:</label>
        <select id="job-role">
            <option value="all">All</option>
            <option value="data-analyst">Data Analyst</option>
            <option value="software-developer">Software Developer</option>
            <!-- Add more job roles as needed -->
        </select>

        <label for="job-type">Job Type:</label>
        <select id="job-type">
            <option value="all">All</option>
            <option value="full-time">Full Time</option>
            <option value="internship">Internship</option>
        </select>
    </div>
    <div class="job">
                <%
                    ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");

                    while (resultSet.next()) {

                        String company_name = resultSet.getString("company_name");
                        String job_type= resultSet.getString("job_type");
                        String job_role= resultSet.getString("job_role");
                        String location= resultSet.getString("location");

                %>
      <div class="job-card">
          <div class="company-details">
              <div class="company-name"><%= company_name %></div>
              <div class="job-info">
              	<div class="text-and-button">
              	<span class="job-role"><%= job_role %>  |  </span>
      			<span class="job-type"><%= job_type %>   |   </span>
      			<span class="location"> <img src="./images/location_icon.jpg" > <%= location %> </span>                                        
              </div>
			  <button class="apply-button" onclick="nextpage('<%= company_name %>', '<%= job_type %>', '<%= job_role %>', '<%= location %>')">Apply</button>
       	</div>
       	</div>
	</div>
                <%

                    }

                %>
            </div>
        </div>
</body>
<script>
function nextpage(companyName, jobType, jobRole, jobLocation) 
{
    var encodedCompanyName = encodeURIComponent(companyName);
    var encodedJobType = encodeURIComponent(jobType);
    var encodedJobRole = encodeURIComponent(jobRole);
    var encodedJobLocation = encodeURIComponent(jobLocation);

    var url = "FormServlet?company_name=" + encodedCompanyName + "&job_type=" + encodedJobType + "&job_role=" + encodedJobRole + "&location=" + encodedJobLocation;

    window.location.href = url;
}
</script>

</html>