$(document).ready(function(){
    $('.header').height($(window).height());
});

function performCustomerPost() {
    const url = 'http://localhost:8081/customerservice/customers';
    const config = {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    };
    axios.post(url, (
        {
            'CustomerRequest': {
                'firstName': document.getElementById("first-name").value,
                'lastName': document.getElementById("last-name").value,
                'phoneNumber': document.getElementById("phone-number").value
            }
        }))
        .then(response => {
            console.log('response status', response.status);
            console.log(response);
            document.cookie = "customerID=" + response.data.Customer.customerID;
            console.log(document.cookie);
            window.location.href = "http://localhost:8082/customer_profile.html";
        })
        .catch(error => {
            console.log('error', error);
        }); 
}