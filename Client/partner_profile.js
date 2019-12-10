var initialResponse;
var partnerID;

$(document).ready(function(){
    $('.header').height($(window).height());

    var decodedCookie = decodeURIComponent(document.cookie);
    var cookie = decodedCookie.split(';');
    var partnerIDString = cookie[0].split("=");
    partnerID = partnerIDString[1];
    var url = "http://localhost:8081/customerservice/partners/" + partnerID;
    axios.get(url)
    .then(response =>{
        initialResponse = response;
        document.getElementById("thanks").innerHTML = "Thanks for signing up, " + response.data.Partner.partnerName;
        document.getElementById("parterName").innerHTML = "Partner name: " + response.data.Partner.partnerName;
        document.getElementById("partnerType").innerHTML = "Partner type: " + response.data.Partner.partnerType;
        document.getElementById("details").innerHTML = "Details: " + response.data.Partner.partnerDetails;
    })
    .catch(error =>{
        console.log(error);
    }); 
});

function performPartnerNameUpdate(){
    const partnerNameURL = initialResponse.data.Partner.link[1].url;
    console.log(partnerNameURL);
    axios.put(partnerNameURL, {
        'PartnerRequest': {
            'partnerID': partnerID,
            'partnerName': document.getElementById("partner-name").value
        }
    })
    .then(response =>{
        console.log(response.status);
        document.getElementById("partnerName").innerHTML = "Partner name: " + response.data.Partner.partnerName;
        $('#partner-name').val('')
    })
}

function performPartnerTypeUpdate(){
    const partnerTypeURL = initialResponse.data.Partner.link[2].url;
    console.log(partnerTypeURL);
    axios.put(partnerTypeURL, {
        'PartnerRequest': {
            'partnerID': partnerID,
            'partnerType': document.getElementById("partner-type").value
        }
    })
    .then(response =>{
        console.log(response.status);
        document.getElementById("partnerType").innerHTML = "Partner Type: " + response.data.Partner.partnerType;
        $('#partner-type').val('')
    })
}

function performPartnerDetailsUpdate(){
    const detailsURL = initialResponse.data.Partner.link[3].url;
    console.log(detailsURL);
    axios.put(detailsURL, {
        'PartnerRequest': {
            'partnerID': partnerID,
            'details': document.getElementById("details").value
        }
    })
    .then(response =>{
        console.log(response.status);
        document.getElementById("details").innerHTML = "Details: " + response.data.Partner.partnerDetails;
        $('#details').val('')
    })
}

function performPartnerDelete(){
    const deleteURL = initialResponse.data.Partner.link[0].url;
    axios.delete(deleteURL)
    .then(response =>{
        console.log("aaaah im deleted");
        console.log(response.status);
        window.location.href = "http://localhost:8082/index.html";
    })
}