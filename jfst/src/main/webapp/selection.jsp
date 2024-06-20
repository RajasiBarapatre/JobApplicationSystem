<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/selection.css">
</head>
<body>
	<%
    int job_id = (int) request.getAttribute("job_id");
    System.out.println("Selection jsp job_id: " + job_id);
%>

	
	
    <figure class="bg">
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
    </figure>

    <form id="initial-form">	
        <h2>Choose Fields You Want in your Application Form</h2>
        <label>
            <input type="checkbox" name="firstname" value="firstname" id="firstname"> First Name
        </label>
        <label>
            <input type="checkbox" name="lastname" value="lastname" id="lastname"> Last Name
        </label>
        <label>
            <input type="checkbox" name="age" value="age" id="age"> Age
        </label>
        <label>
            <input type="checkbox" name="gender" value="gender" id="gender"> Gender
        </label>
        <label>
            <input type="checkbox" name="email" value="email" id="email"> Email
        </label>
        <label>
            <input type="checkbox" name="phone" value="phone" id="phone"> Phone
        </label>
        <label>
            <input type="checkbox" name="yearsofexp" value="yearsofexp" id="yearsofexp"> Years of Experience
        </label>
        <label>
            <input type="checkbox" name="passoutyear" value="passoutyear" id="passoutyear"> Pass Out Year
        </label>
        <label>
            <input type="checkbox" name="cgpa" value="cgpa" id="cgpa"> CGPA
        </label>
        <label>
            <input type="checkbox" name="passoutclg" value="passoutclg" id="passoutclg"> College Name
        </label>
        <label>
            <input type="checkbox" name="branch" value="branch" id="branch"> Branch
        </label>
        <label>
            <input type="checkbox" name="degree" value="degree" id="degree"> Degree
        </label>
        <label>
            <input type="checkbox" name="curr-work" value="curr-work" id="curr-work"> Currently Working?
        </label>
        <label>
            <input type="checkbox" name="company-name" value="company-name" id="company-name"> Company Name
        </label>
        <label>
            <input type="checkbox" name="resume" value="resume" id="resume"> Resume
        </label>
        <br>
        <input type="submit" value="Generate Form">
    </form>

    <form id="generated-form">
    
    	<input type="hidden" name="job_id" value="<%= job_id %>">        
        <h2>Generated Form</h2>
   
        <div id="firstname-field" style="display: none;">
            <label for="firstname">First Name:</label>
            <input type="text" id="firstname" name="firstname">
        </div>
        <div id="lastname-field" style="display: none;">
            <label for="lastname">Last Name:</label>
            <input type="text" id="lastname" name="lastname">
        </div>
        <div id="age-field" style="display: none;">
            <label for="age">Age:</label>
            <input type="text" id="age" name="age">
        </div>
        <div id="gender-field" style="display: none;">
            <label for="gender">Gender:</label>
            <select id="gender" name="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>
        <div id="email-field" style="display: none;">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email">
        </div>
        <div id="phone-field" style="display: none;">
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone">
        </div>
        <div id="yearsofexp-field" style="display: none;">
            <label for="yearsofexp">Years of Experience:</label>
            <input type="text" id="yearsofexp" name="yearsofexp">
        </div>
        <div id="passoutyear-field" style="display: none;">
            <label for="passoutyear">Pass Out Year:</label>
            <input type="text" id="passoutyear" name="passoutyear">
        </div>
        <div id="cgpa-field" style="display: none;">
            <label for="cgpa">CGPA:</label>
            <input type="text" id="cgpa" name="cgpa">
        </div>
        <div id="passoutclg-field" style="display: none;">
            <label for="passoutclg">College Name:</label>
            <input type="text" id="passoutclg" name="passoutclg">
        </div>
        <div id="branch-field" style="display: none;">
            <label for="branch">Branch:</label>
            <input type="text" id="branch" name="branch">
        </div>
        <div id="degree-field" style="display: none;">
            <label for="degree">Degree:</label>
            <input type="text" id="degree" name="degree">
        </div>
        <div id="curr-work-field" style="display: none;">
            <label for="curr-work">Currently Working?</label>
            <input type="checkbox" id="curr-work" name="curr-work" value="yes"> Yes
        </div>
        <br>
        <div id="company-name-field" style="display: none;">
            <label for="company-name">Company Name:</label>
            <input type="text" id="company-name" name="company-name">
        </div>
        <div id="resume-field" style="display: none;">
            <label for="resume">Resume:</label>
            <input type="file" id="resume" name="resume">
        </div>
        

        <br>
    </form>
    
    	<button id="done-button" style="display: none" onclick="nextPage()">Done</button>

    
    
     
</body>
<script>
    const initialForm = document.getElementById("initial-form");
    const generatedForm = document.getElementById("generated-form");
    const doneButton = document.getElementById("done-button");

    initialForm.addEventListener("submit", function (e) 
    {
        e.preventDefault();

        const checkboxes = initialForm.querySelectorAll('input[type="checkbox"]:checked');

        const fields = generatedForm.querySelectorAll("div");
        fields.forEach((field) => {
            field.style.display = "none";
        });

        // Show the selected fields
        checkboxes.forEach((checkbox) => {
            document.getElementById(checkbox.value + "-field").style.display = "block";
        });

        // Hide the initial form
        initialForm.style.display = "none";

        // Display the generated form
        generatedForm.style.display = "block";

        doneButton.style.display = "block";
    });
    </script>
    <script>
    	function nextPage() 
    	{
    	    var firstname = encodeURIComponent(document.getElementById("firstname").checked ? 1 : 0);
    	    var lastname = encodeURIComponent(document.getElementById("lastname").checked ? 1 : 0);
    	    var age = encodeURIComponent(document.getElementById("age").checked ? 1 : 0);
    	    var gender = encodeURIComponent(document.getElementById("gender").checked ? 1 : 0);
    	    var email = encodeURIComponent(document.getElementById("email").checked ? 1 : 0);
    	    var phone = encodeURIComponent(document.getElementById("phone").checked ? 1 : 0);
    	    var yearsofexp = encodeURIComponent(document.getElementById("yearsofexp").checked ? 1 : 0);
    	    var passoutyear = encodeURIComponent(document.getElementById("passoutyear").checked ? 1 : 0);
    	    var cgpa = encodeURIComponent(document.getElementById("cgpa").checked ? 1 : 0);
    	    var passoutclg = encodeURIComponent(document.getElementById("passoutclg").checked ? 1 : 0);
    	    var branch = encodeURIComponent(document.getElementById("branch").checked ? 1 : 0);
    	    var degree = encodeURIComponent(document.getElementById("degree").checked ? 1 : 0);
    	    var curr_work = encodeURIComponent(document.getElementById("curr-work").checked ? 1 : 0);
    	    var companyname = encodeURIComponent(document.getElementById("company-name").checked ? 1 : 0);
    	    var resume = encodeURIComponent(document.getElementById("resume").checked ? 1 : 0);
    	    var job_id = <%= job_id %>;
    	    
    	    var url = "SelectionServlet?job_id=" + job_id + "&firstname=" + firstname + "&lastname=" + lastname + "&age=" + age + "&gender=" + gender + "&email=" + email + "&phone=" + phone + "&yearsofexp=" + yearsofexp + "&passoutyear=" + passoutyear + "&cgpa=" + cgpa + "&passoutclg=" + passoutclg + "&branch=" + branch + "&degree=" + degree + "&curr_work=" + curr_work + "&company_name=" + companyname + "&resume=" + resume;

    	    window.location.href = url;
    	}

     
</script>


</html>
