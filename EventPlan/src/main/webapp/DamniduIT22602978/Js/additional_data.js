



document.getElementById('prev').onclick = function(){
    let lists = document.querySelectorAll('.item');
    document.getElementById('slide').appendChild(lists[0]);
}
document.getElementById('next').onclick = function(){
    let lists = document.querySelectorAll('.item');
    document.getElementById('slide').prepend(lists[lists.length - 1]);
}


document.getElementById('form1Form').addEventListener('submit', function() {
 let lists = document.querySelectorAll('.item');
    document.getElementById('slide').prepend(lists[lists.length - 1]);
});




function validateForm() {
    var cxName = document.forms["stripe-login"]["Cxname"].value;
    var cxPnumber = document.forms["stripe-login"]["Cxpnumber"].value;
    var cxEmail = document.forms["stripe-login"]["Cxemail"].value;

    // Check if Full Name is not empty
    if (cxName == "") {
        alert("Full Name must be filled out");
        return false;
    }

    // Check if Phone Number is valid
    var phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(cxPnumber)) {
        alert("Phone Number must be 10 digits");
        return false;
    }

    // Check if Email is valid
    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(cxEmail)) {
        alert("Invalid Email Address");
        return false;
    }

    // Additional validation checks for other fields can be added here.

    return true; // Form is valid and can be submitted
}

