$(document).ready(function(){
    $('.header').height($(window).height());
});



function performCustomerPost() {
    

    let signupForm = document.getElementById('customer-register');
        signupForm.addEventListener('submit', function(event) {
        
        
        const url = 'http://localhost:8081/customerservice/customers';
        const options = {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify({
            'CustomerRequest': {
                'firstName': 'bob',
                'lastName': 'johnson',
                'phoneNumber': '12345678'
            }
        })
        };
        console.log(options.body);
        fetch(url, options)
        .then(response => {
            console.log(response.status);
        })
        .catch(error => {
            console.log(error);
        });
    });
}