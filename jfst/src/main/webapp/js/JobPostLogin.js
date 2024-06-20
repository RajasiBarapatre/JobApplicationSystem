function toggleLoginPasswordVisibility() {
    const passField = document.getElementById('loginpassword')
    const showPassword = document.querySelector('.show-password1');

    if (passField.type === "password") {
        passField.type = "text";
        showPassword.innerHTML = '<i class="fas fa-eye-slash"></i>';
    } else {
        passField.type = "password";
        showPassword.innerHTML = '<i class="fas fa-eye"></i>';
    }
}

function toggleSignupPasswordVisibility() {
    const passField = document.getElementById('signuppassword')
    const showPassword = document.querySelector('.show-password2');

    if (passField.type === "password") {
        passField.type = "text";
        showPassword.innerHTML = '<i class="fas fa-eye-slash"></i>';
    } else {
        passField.type = "password";
        showPassword.innerHTML = '<i class="fas fa-eye"></i>';
    }
}
function toggleConfirmPasswordVisibility() {
    const passField = document.getElementById('confirmpassword')
    const showPassword = document.querySelector('.show-password3');

    if (passField.type === "password") {
        passField.type = "text";
        showPassword.innerHTML = '<i class="fas fa-eye-slash"></i>';
    } else {
        passField.type = "password";
        showPassword.innerHTML = '<i class="fas fa-eye"></i>';
    }
}


function validateLoginForm() 
{
    const email = document.getElementById('loginemail').value;
    const password = document.getElementById('loginpassword').value;

    if (email === "" || password === "") {
        alert("All fields must be filled out");
        return false; 
    }
}
function validateSignUpForm() {
    // Basic form validation
    const name = document.getElementById('signupname').value;
    const email = document.getElementById('signupemail').value;
    const password = document.getElementById('signuppassword').value;
    const confirmPassword = document.getElementById('confirmpassword').value;

    if (email === "" || name === "" || password === "" || confirmPassword === "") {
        alert("All fields must be filled out");
        return false; // Prevent form submission
    }
    else if (password !== confirmPassword){
        alert("Confirm password must be same.");
        return false; // Prevent form submission
    }
   /** else{
        alert("Sign Up successful");
        return true; // Allow form submission
    }**/
}

function showSignupForm() {
    const loginContent = document.getElementById("logincontent");
    const signupContent = document.getElementById("signupcontent");

    
    loginContent.style.display = "none";
    signupContent.style.display = "block";
}

function showLoginForm() {
    const loginContent = document.getElementById("logincontent");
    const signupContent = document.getElementById("signupcontent");

    
    loginContent.style.display = "block";
    signupContent.style.display = "none";
}

