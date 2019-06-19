function validate(){
    var checkedYes = document.getElementById("radioY").checked;
    var checkedNo = document.getElementById("radioN").checked;
    var checkedMaybe = document.getElementById("radioM").checked;
    
    if(document.forms.signUp.user.value == ""){
        alert("You must provide a USER NAME!")
        return false;
    }
    else if(!document.forms.signUp.email.value.match(/.+@.+\.edu$/)){
        alert("You must provide a .EDU email address!")
        return false;
    }
    else if(document.forms.signUp.commentBox.value == ""){
        alert("Please enter a comment!")
        return false;
    }
    else if(!document.forms.signUp.signMe.checked){
        alert("You must AGREE to sign up for email alerts!")
        return false;
    }else if(checkedYes == false && checkedNo == false && checkedMaybe == false){
        alert("No radio button selected");
        return false;
    }
    return true;
}

function enableSubmit(val)
{
    var sbmt = document.getElementById("submit")

    if (val.checked == false)
    {
        sbmt.disabled = true;
    }
    else
    {
        sbmt.disabled = false;
    }
}                       