$(document).ready(function(){
    $('.header').height($(window).height());
    var table = document.getElementById("product-table");
    var div = document.getElementById("product-display");

    axios.get("http://localhost:8081/productservice/products?limit=20")
    .then(response => {
  
    })
    .catch(error => {
        console.log(error);
    });

    
});