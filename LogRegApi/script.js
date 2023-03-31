var regForm = document.getElementById('register-form');
var loginForm = document.getElementById('login-form');

regForm.addEventListener('submit', function(e) {
    e.preventDefault();
    var data = new FormData(regForm);
    if (!validateRegister(data)) {
        return;
    }
    var username = data.get('username');
    var email = data.get('email');
    var password = data.get('password');
    var confirm = data.get('confirm');
    var user = {"username": username, "email": email, "password": password, "confirm": confirm};
    fetch("http://localhost:8080/api/register",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    .then( res => res.json())
    .then( data => console.log(data))
    .catch( err => console.log(err))
});

function validateRegister(formData){
    if (formData.get('username').length < 3) {
        // alert('Username must be at least 3 characters long');
        var errorTarget = document.getElementById("username").parentElement;
        // console.log(errorTarget);
        errorTarget.innerHTML += "<p class='text-danger'>Username must be at least 3 characters long</p>";
        return false;
    }
    if (formData.get('password').length < 8) {
        alert('Password must be at least 8 characters long');
        return false;
    }
    return true
}