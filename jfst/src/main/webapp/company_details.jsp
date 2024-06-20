<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Company Details</title>
      <link rel="stylesheet" type="text/css" href="css/company_details.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
   </head>
   <body>
   <div class="bkg">
      <div class="content" id="logincontent">
         <header id="LoginText">Company Details</header>
         <form id="LoginForm" action="CompanyServlet" method="post">
            <div class="field">
               <input type="text" placeholder="Company Name" id="companyname" name="companyname" value="<%= request.getAttribute("company_name") %>" readonly>
            </div>
            <div class="field">
               <select id="jobrole" class="field" name="jobrole" required>
                  <option value="" disabled selected>Job Role</option>
                  <option value="Software Developer">Software Developer</option>
                  <option value="Manager">Manager</option>
                  <option value="Engineer">Engineer</option>
               </select>
            </div>
            <div class="field">
               <select class="field" id="jobtype" name="jobtype" required> 
                  <option value="Full Time">Full Time</option>
                  <option value="Intern">Intern</option>
               </select>
            </div>
            <div class="field">
               <input type="number" placeholder="Stipend" id="stipend" name="stipend" required>
            </div>
            <div class="field">
               <input type="number" placeholder="Duration in months" id="duration" name="duration" required>
            </div>
            <div class="field">
               <input type="text" placeholder="Location" id="location" name="location" required>
            </div>
            <div class="field">
               <input type="text" placeholder="Website URL" id="website" name="website" required>
            </div>
            <div class="field">
               <input type="text" placeholder="Eligibility Criteria" id="criteria" name="criteria" required>
            </div>
            <div class="field">
               <input type="submit" value="Submit" onclick="validate()">
            </div>
         </form>
      </div>
      </div>
   </body>
   <script>
   function validate()
   {
	   const email = document.getElementById('companyname').value;
	   const jobrole = document.getElementById('jobrole').value;
	   const jobtype = document.getElementById('jobtype').value;
	   const stipend = document.getElementById('stipend').value;
	   const duration = document.getElementById('duration').value;
	   const location = document.getElementById('location').value;
	   const website = document.getElementById('website').value;
	   const criteria = document.getElementById('criteria').value;

	   if (companyname === "" || jobrole === "" || jobtype === "" || stipend === "" || duration === "" || location === "" || website === "" || criteria === "") {
	       alert("All fields must be filled out");
	       return false; 
	   }
   }
   </script>
</html>
