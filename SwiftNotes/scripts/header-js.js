//DROPDOWM MENU JS

//creating variables to hold elements
const dropdownEllipsesContainer = document.getElementById("js-header-icon-ellipses");
const dropdownEllipses = document.getElementById("js-ellipsis-icon");
const dropdown = document.getElementById("js-dropdown-menu");

//creating function to toggle show class when dropdown is clicked, toggle adds that class

const toggleDropdown = function(){
    dropdown.classList.toggle("show-drop-down-menu-ellipses");
    dropdownEllipses.classList.toggle("ellipsis-icon-show-clicked");
}

//adding an event listner to ellipses and calling the clickedDropdown function when user clicks on ellipses

dropdownEllipsesContainer.addEventListener("click",function (e) {
    e.stopPropagation();
    toggleDropdown();
});

//CLOSING THE DROP DOWN BAR WHEN IT IS CLICKED, IT'S CHILD IS CLICKED, OR CLICKING ANYWHERE ON THE PAGE

//documentElement is root element tag (HTML)
document.documentElement.addEventListener("click", ()=>{
    //checking if show has been toggled
    if(dropdown.classList.contains("show-drop-down-menu-ellipses")){
        toggleDropdown();
    }
});


//TOGGLING HEADER MENU BAR
const headerMenuBar = document.getElementById("js-header-menu-bar");
const downIconContainer = document.getElementById("js-header-icon-openDown");
const downIcon = document.getElementById("js-icon-down");


//creating function that uses toggle to add a class to show the menu bar 

const toggleMenuBar = function(){
    headerMenuBar.classList.toggle("show-header-menu-bar");
    downIcon.classList.toggle("down-icon-show-clicked");
}

//adding event listener

downIconContainer.addEventListener("click",(e)=>{
    e.stopPropagation();
    toggleMenuBar();
})













//variable to check whether user already clicked the drop down
// var userClickedDropDown = false;

// //variable to hold the classes by that name which is for the icon
// var dropDownBtn = document.getElementsByClassName("header-icon-openDown");
// console.log(dropDownBtn);

//creating an event listener for the drop down icon to see when someone clicks on it and to then exectue recordClick
// for(var i=0;i<dropDownBtn.length; i++){
//     dropDownBtn[i].addEventListener("click",()=>{
//         if(userClickedDropDown==false){

//             document.getElementById("js-header-note-functions").style.cssText = 
//             " height: 50px; "; 
//             userClickedDropDown = true;   
//         }
//         else {userClickedDropDown=false;
//             document.getElementById("js-header-note-functions").style.height = "0px"; 
//         }

//     });
// }

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


const page = document.getElementById("base-page");

page.addEventListener("keyup",event =>{
    if(event.code==="Space"){
        console.log(page.innerText);
}});