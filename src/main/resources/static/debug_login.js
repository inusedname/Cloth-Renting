// Get the form element
const form = document.getElementById('loginForm');

// Add event listener to "Login as user" link
document.getElementById('loginAsUser').addEventListener('click', function(event) {
    // Simulate form submission with user credentials
    form.querySelector('[name="email"]').value = 'user@gmail.com';
    form.querySelector('[name="password"]').value = 'user';
    form.submit(); // Trigger form submission
});

// Add event listener to "Login as admin" link
document.getElementById('loginAsAdmin').addEventListener('click', function(event) {
    // Simulate form submission with admin credentials
    form.querySelector('[name="email"]').value = 'admin@gmail.com';
    form.querySelector('[name="password"]').value = 'admin';
    form.submit(); // Trigger form submission
});