$(document).ready(function(){
    $('.header').height($(window).height());
    const urlParams = new URLSearchParams(window.location.search);
    const prodID = urlParams.get('prodID');
    axios.get("http://localhost:8081/productservice/products/" + prodID)
    .then(response => {
        document.getElementById("product-name").innerHTML = response.data.Product.productName;
        document.getElementById("product-details").innerHTML = response.data.Product.productDescription + " | $" + response.data.Product.productCost;
    });
        
    axios.get("http://localhost:8081/reviewservice/reviews?prodID=" + prodID)
    .then(response => {
        var data = Object.values(response.data.Review);
        
        var table = new Tabulator("#reviews", {        //load row data from array
            layout:"fitColumns",      //fit columns to width of table
            responsiveLayout:"hide",  //hide columns that dont fit on the table
            tooltips:true,            //show tool tips on cells
            addRowPos:"top",          //when adding a new row, add it to the top of the table
            history:true,             //allow undo and redo actions on the table
            pagination:"local",       //paginate the data
            paginationSize:7,         //allow column order to be changed
            resizableRows:true, 
            placeholder:"No Reviews Available",
            data:data,
            columns:[     
                {title:"Score", field:"reviewScore", width:100},
                {title:"Review", field:"reviewBody" },
                {title:"Reviewed by", field:"customer.firstName"}
            ],
         });
        
    });

    
    
});