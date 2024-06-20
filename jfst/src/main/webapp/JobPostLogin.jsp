<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Login Form</title>
    <script src="js/JobPostLogin.js"></script>
    <link rel="stylesheet" type="text/css" href="css/JobPostLogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
</head>
<body>
    <div class="bg-img">
        <!-- Login -->
        <div class="content" id="logincontent">
            <header id="LoginText">Login Form</header>

            <!-- Login Form -->
            <form action="LoginServlet" method="post" id="LoginForm" onsubmit="return validateLoginForm()">
                <div class="field">
                    <span class="fa fa-envelope"></span>
                    <input type="email" placeholder="Email*" id="loginemail" name="loginemail" required>
                </div>
                <div class="field space">
                    <span class="fa fa-lock"></span>
                    <input type="password" class="pass-key" placeholder="Password*" id="loginpassword" name="loginpassword" required>
                    <span class="show-password1" onclick="toggleLoginPasswordVisibility()"><i class="fas fa-eye"></i></span>
                </div>
                <div class="field">
                    <input type="submit" value="login">
                </div>
            </form>

            <div class="signup">
                Don't have an account?
                <a href="#" onclick="showSignupForm()">Signup Now</a>
            </div>
            <div class="pass">
                <a href="#">Forgot Password?</a>
            </div>
        </div>
        <!-- Sign Up -->
        <div class="content" id="signupcontent" style="display: none;">
            <header id="SignupText">Sign-up Form</header>

            <form action="SignupServlet" method="post" id="SignupForm" onsubmit="return validateSignUpForm()">
                <div class="field">
                    <span class="fa fa-user"></span>
                    <input type="text" placeholder="Company name*" id="signupname" name="signupname" required>
                </div>
                <div class="field">
                    <span class="fa fa-envelope"></span>
                    <input type="email" placeholder="Email*" id="signupemail" name="signupemail" required>
                </div>
                
                <div class="field space">
                    <span class="fa fa-lock"></span>
                    <input type="password" class="pass-key" placeholder="Password*" id="signuppassword" name="signuppassword" required>
                    <span class="show-password2" onclick="toggleSignupPasswordVisibility()"><i class="fas fa-eye"></i></span>
                </div>
                <div class="field space">
                    <span class="fa fa-lock"></span>
                    <input type="password" class="pass-key" placeholder="Confirm Password*" id="confirmpassword" required>
                    <span class="show-password3" onclick="toggleConfirmPasswordVisibility()"><i class="fas fa-eye"></i></span>
                </div>
                <div class="field">
                    <input type="submit" value="signup">
                </div>
            </form>

            <div class="login">
                Already have an account?
                <a href="#" onclick="showLoginForm()">Login Now</a>
            </div>
        </div>
    </div>
</body>

</html>
