
//variable to check whether user already clicked the drop down
var userClickedDropDown = false;

//variable to hold the classes by that name which is for the icon
var dropDownBtn = document.getElementsByClassName("header-icon-openDown");
console.log(dropDownBtn);

//creating an event listener for the drop down icon to see when someone clicks on it and to then exectue recordClick
for(var i=0;i<dropDownBtn.length; i++){
    dropDownBtn[i].addEventListener("click",()=>{
        if(userClickedDropDown==false){

            document.getElementById("js-header-note-functions").style.cssText = 
            " height: 50px; "; 
            userClickedDropDown = true;   
        }
        else {userClickedDropDown=false;
            document.getElementById("js-header-note-functions").style.height = "0px"; 
        }

    });
}

//JS FOR TITLE 

//Creating drop down when user clicks on name of page

var pageName = document.getElementById("js-name-page");

//adding event listener for when user clicks on title
pageName.addEventListener("click",()=>{
    pageName.contentEditable = "true";
    pageName.style.cssText =
    "background-color: white; color: black; box-shadow: 2px 2px 10px 0px rgba(0,0,0,0.8); "
});


//-------------------------------------------------------------------------------------------------------------------------------------------------//


