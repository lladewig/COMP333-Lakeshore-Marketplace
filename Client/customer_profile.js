$(document).ready(function(){
    $('.header').height($(window).height());

    var decodedCookie = decodeURIComponent(document.cookie);
    var cookie = decodedCookie.split(';');
    var customerIDString = cookie[0].split("=");
    var customerID = customerIDString[1];
    var url = "http://localhost:8081/customerservice/customers/" + customerID;
    axios.get(url)
    .then(response =>{
        document.getElementById("thanks").innerHTML = "Thanks for signing up, " + response.data.Customer.firstName;
        document.getElementById("firstName").innerHTML = "First name: " + response.data.Customer.firstName;
        document.getElementById("lastName").innerHTML = "Last name: " + response.data.Customer.lastName;
        document.getElementById("phoneNumber").innerHTML = "Phone number: " + response.data.Customer.phoneNumber;
    })
    .catch(error =>{
        console.log(error);
    }); 
});