<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ page import="java.sql.ResultSet" %>


<%@ page import="java.util.HashMap" %>


<!DOCTYPE html>


<html>


<head>


    <link rel="stylesheet" href="css/form.css">


</head>


<body>


    <form enctype="multipart/form-data" method="post" >


        <h2>Generated Form</h2>


        	


        <%


            ResultSet resultSet = (ResultSet) request.getAttribute("result");


            HashMap<String, String> columnDisplayNames = new HashMap<String, String>();


            // Add mappings of database column names to display names


            columnDisplayNames.put("first_name", "First Name");


            columnDisplayNames.put("last_name", "Last Name");


            columnDisplayNames.put("age", "Age");


            columnDisplayNames.put("gender", "Gender");


            columnDisplayNames.put("phone_no", "Phone number");


            columnDisplayNames.put("email_id", "Email Id");


            columnDisplayNames.put("passout_year", "Passout Year");


            columnDisplayNames.put("college_name", "Passout College");


            columnDisplayNames.put("cgpa", "CGPA");


            columnDisplayNames.put("branch", "Branch");


            columnDisplayNames.put("degree", "Degree");


            columnDisplayNames.put("currently_working", "Currently Working ?");


            columnDisplayNames.put("company_name", "Company Name");


            columnDisplayNames.put("years_of_experience", "Years Of Experience");


            columnDisplayNames.put("resume", "Resume");


            


            


            String[] columnNames = {"first_name", "last_name", "age", "gender", "phone_no", "email_id", "passout_year", "college_name", "cgpa", "branch", "degree", "currently_working", "company_name", "years_of_experience", "resume"};

            int job_id = resultSet.getInt("job_id");

            //StringBuilder urlBuilder = new StringBuilder("FinalServlet?job_id=" + job_id+"&");


            


            for (String columnName : columnNames) 


            {


                int fieldValue = resultSet.getInt(columnName);


                if (fieldValue == 1) 


                {


                    if ("resume".equals(columnName)) {


        %>


        


        <div>


            <label for="<%= columnName %>"><%= columnDisplayNames.get(columnName) %>:</label>


            <input type="file" id="<%= columnName %>" name="<%= columnName %>" required>


        </div>


        <%


                    } 


                    else 


                    {


                    	//urlBuilder.append(columnName).append("=").append(resultSet.getString(columnName)).append("&");


        %>


        <div>


            <label for="<%= columnName %>"><%= columnDisplayNames.get(columnName) %>:</label>


            <input type="text" id="<%= columnName %>" name="<%= columnName %>" required>


        </div>


        <%


                    }


                }


            }


           // String url = urlBuilder.toString();


            //if (url.endsWith("&")) 


            //{


              //  url = url.substring(0, url.length() - 1);


            //}


        %>


         <div>


        	<input type="hidden" id="job_id" name="job_id" value="<%= resultSet.getInt("job_id") %>">


    	</div>


        <%


			System.out.println("Final :" + job_id);


		%>


        


        <br>


        <input type="button" value="Submit" onclick="final()">


    </form>


</body>


<script>


function final(){


	var finalURL = "FinalServlet?";
    var job_id = document.getElementById("job_id").value;
    finalURL += "job_id=" + job_id;

    var columnNames = ["first_name", "last_name", "age", "gender", "phone_no", "email_id", "passout_year", "college_name", "cgpa", "branch", "degree", "currently_working", "company_name", "years_of_experience", "resume"];

    for (var i = 0; i < columnNames.length; i++) {
        var columnName = columnNames[i];
        var inputField = document.getElementById(columnName);
        if (inputField) {
            var value = inputField.value;
            finalURL += "&" + columnName + "=" + encodeURIComponent(value);
        }
    }

    window.location.href = finalURL;


}


	


</script>


</html>