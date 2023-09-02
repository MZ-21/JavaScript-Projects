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
    if(pageTitle.classList.contains("select-title")){
        editTitle();
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

//-----------------------------------DISPLAYING PAGES-----------------------------------------------------------------------------------------------//

//creating variables
const pageIcon = document.getElementById("js-page-container-icon");
const sideBar = document.getElementById("js-side-bar-container");

//creating function and addEventListener 

const toggleSideBar = function(){
    sideBar.classList.toggle("show-side-bar-container");
    pageIcon.classList.toggle("highlight-page-icon");
}

pageIcon.addEventListener("click",(e)=>{
    e.stopPropagation();
    toggleSideBar();
})
//-------------------------------------------------------------------------------------------------------------------------------------------------//


const page = document.getElementById("base-page");
const pageContainer = document.getElementById("js-page-container");
const mockPage = document.getElementById("mock-page");
//creating array to hold info
var pageContent = "";

const displayOnMockPage = function(info){
    mockPage.value = info;
}
var addEllipses = false;
page.addEventListener("keyup",()=>{
        var maxMockPage = 600;
        var areaOfText = document.querySelector('textarea.page');

        if(areaOfText.value.length >= maxMockPage){
            pageContent = pageContent;
            if(!addEllipses){
                pageContent = pageContent + "...";
                addEllipses=true;
            }
            console.log("hello");
        }

        else {pageContent = page.value;}

        displayOnMockPage(pageContent);
});




//fixing overflow of text in page container

//DOMContentLoaded event is for when browser has parsed the HTML & built
document.addEventListener("DOMContentLoaded",()=>{
    var max = 1536; //max number of characters
    

    var areaOfText = document.querySelector('textarea.page');
    var areaofTextMockPage = document.querySelector('textarea.mock-page');
    //adding an event listener on the text area
    areaOfText.addEventListener("keypress",(e)=>{
        mockPage.ariaReadOnly = false;

        if(e.which < 0x20){
            //e.which < 0x20 means the hex repre of 32 which is checking if unicode value is less than 32, which are non-printable characters
            return; //do nothing
        }
        //check if length of textarea content (.value) is == max
        if (areaOfText.value.length == max){
            e.preventDefault(); //prevent the default from occuring so won't allow user to type
        } else if(areaOfText.value.length>max){
            //content in text area will be trimmed down to just the max characters
            areaOfText.value = areaOfText.value.substring(0,max);
        }
        
    });

});


//---------------------------------------------------------CHANGING PAGE TITLE-----------------------------------------------------------------//

//creating variables 
const pageTitle = document.getElementById("js-name-page");
const pageTitleContainer = document.getElementById("js-name-page-container");

//adding event listener and creating function to edit title once it is selected


const editTitle = function(){
    pageTitle.classList.toggle("select-title");
    pageTitle.contentEditable = true;
}

pageTitle.addEventListener("click",(e)=>{
    e.stopPropagation();
    editTitle();
});


//---------------------------------------------------------------------------------------------------------------------------------------------------//



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

// var pageName = document.getElementById("js-name-page");

// //adding event listener for when user clicks on title
// pageName.addEventListener("click",()=>{
//     pageName.contentEditable = "true";
//     pageName.style.cssText =
//     "background-color: white; color: black; box-shadow: 2px 2px 10px 0px rgba(0,0,0,0.8); "
// });

