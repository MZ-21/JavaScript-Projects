//DROPDOWM MENU JS

//creating variables to hold elements
const dropdownEllipsesContainer = document.getElementById("js-header-icon-ellipses");
const dropdownEllipses = document.getElementById("js-ellipsis-icon");
const dropdown = document.getElementById("js-dropdown-menu");

//creating function to toggle show class when dropdown is clicked, toggle adds that class

const toggleDropdown = function(){
    dropdown.classList.toggle("show-drop-down-menu-ellipses");
    dropdownEllipses.classList.toggle("ellipsis-icon-show-clicked");
};

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
const sideBarContainr = document.querySelector(".js-c-side-bar-container");
const pagesContainr = document.querySelector(".page-containers");


//creating function that uses toggle to add a class to show the menu bar 

const toggleMenuBar = function(){
    headerMenuBar.classList.toggle("show-header-menu-bar");
    downIcon.classList.toggle("down-icon-show-clicked");
    sideBarContainr.classList.toggle("adjust-sidebar-margin-top");
    pagesContainr.classList.toggle("adjust-sidebar-margin-top");
}

//adding event listener

downIconContainer.addEventListener("click",(e)=>{
    e.stopPropagation();
    toggleMenuBar();
});


/*---------------------DISPLAYING MOCK-PAGE TEXT--------------------------*/
var elementID; var pageNumber;


document.addEventListener("click",(e)=>{ //getting of what page the user clicked on so that we can get the correct mock-page
    elementID = e.target.id;
    const arraySplitID = elementID.split("-");
    pageNumber = arraySplitID[arraySplitID.length-1];

    //const pageContainer = document.getElementById("js-page-container-1");
    const mockPage = document.getElementById("mock-page-"+pageNumber);
    var page = document.getElementById(""+elementID);
    
    //creating variable to hold info
    var pageContent = "";

    //displaying text on one page in mock page 
    const displayOnMockPage = function(info){
        mockPage.value = info;
    }

    var addEllipses = false; //check to add ellipses if mock page full
    document.addEventListener("keyup",()=>{
        console.log(window.innerHeight + " height" + " " + window.innerWidth);

            var maxMockPage = 600;
            var areaOfText = document.querySelector('textarea.page');

            if(areaOfText.value.length >= maxMockPage){
                pageContent = pageContent;
                if(!addEllipses){
                    pageContent = pageContent + "...";
                    addEllipses=true;
                }
            }
            else {pageContent = page.value;}

            displayOnMockPage(pageContent);
    });

});

//fixing overflow of text in page container

//DOMContentLoaded event is for when browser has parsed the HTML & built
document.addEventListener("DOMContentLoaded",()=>{
    var max = 1536; //max number of characters
    var areaOfText = document.querySelector('textarea.page');

    //adding an event listener on the text area
    areaOfText.addEventListener("keypress",(e)=>{
        // mockPage.ariaReadOnly = false;

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



//-----------------------------------DISPLAYING PAGES-----------------------------------------------------------------------------------------------//

//creating variables
const pageIcon = document.getElementById("js-page-container-icon");
const sideBar = document.getElementById("js-side-bar-container");

//creating function and addEventListener 
pageIcon.addEventListener("click",function(){
    sideBar.classList.toggle("show-side-bar-container");
    pageIcon.classList.toggle("highlight-page-icon");
    
});

document.body.addEventListener("click",function(e){
    if(!sideBar.contains(e.target) && e.target !== pageIcon){
        sideBar.classList.remove("show-sidebar-container");
        pageIcon.classList.remove("highlight-page-icon");
    }
    // const sidebar2 = document.querySelector('.js-c-side-bar-container');
    // sidebar2.style.height = "100%";

});
//-------------------------------------------------------------------------------------------------------------------------------------------------//





//------------------------------------------------------------------CREATING PAGES-----------------------------------//

const addPageIconContainer = document.getElementById("js-header-icon-add-page");
console.log(addPageIconContainer);

var id=1;  

const toggleAddPage = function(){
    id +=1;


    //ADDING A PAGE
        const newPageDiv = document.createElement("div"); //creating a div
        newPageDiv.className = "page-container"; //adding appropriate class name
        newPageDiv.id = "js-page-container-"+ id; //adding appropriate class with id
        
        const newTextArea = document.createElement("textarea"); //creating a new textarea
        newTextArea.className = "page"; newTextArea.id = "base-page-"+id;

        //appending textArea to div

        newPageDiv.appendChild(newTextArea);

        document.querySelector('.page-containers').appendChild(newPageDiv);


    //ADDING A MOCKPAGE
        const newMockPageDiv = document.createElement("div");
        newMockPageDiv.className = "mock-page-container"; //creating mock page div

        const newMockTextArea = document.createElement("textarea"); //creating a new textarea
        newMockTextArea.className = "mock-page";
        newMockTextArea.readOnly = true; //making readOnlyTrue
        newMockTextArea.id = "mock-page-" + id;

        //appending mock text area to mock page div
        newMockPageDiv.appendChild(newMockTextArea);

        document.querySelector('.js-c-side-bar-container').appendChild(newMockPageDiv);

        const mockPageAtrributesContainerDiv = document.createElement("div");
        mockPageAtrributesContainerDiv.className = "mock-page-attributes-container";
        
        const numberContainerDiv = document.createElement("div");
        numberContainerDiv.className = "number-page-container";

        const pOfNumberContainer = document.createElement('p');
        pOfNumberContainer.className = "number-page";
        pOfNumberContainer.innerText = id;

        numberContainerDiv.appendChild(pOfNumberContainer); //appending p to it's container

        // const deleteIconContainerDiv = document.createElement("div");
        // deleteIconContainerDiv.className = "delete-icon-container";
        const originalDeleteIconDiv = document.querySelector(".delete-icon-container");
        // const svgX = document.createElementNS("http://www.w3.org/2000/svg", "svg");

        // const svgX = document.createElementNS("http://www.w3.org/2000/svg", "svg");

        const deleteIconContainerDiv = originalDeleteIconDiv.cloneNode(true);
        // svgX.setAttribute("class","color000000 svgShape delete-icon");
        // svgX.setAttribute("xmlns", "http://www.w3.org/2000/svg");
        // svgX.setAttribute("enable-background", "new 0 0 512 512");
        // svgX.setAttribute("viewBox", "0 0 512 512");

        // const polygonElement = document.createElementNS("http://www.w3.org/2000/svg", "polygon");
        // polygonElement.setAttribute("points", "500.899 1 406.611 1 256 195.209 105.389 1 11.101 1 208.856 256 11.101 511 105.389 511 256 316.791 406.611 511 500.899 511 303.144 256");
        // polygonElement.setAttribute("fill", "#ff0202");

        // Append the polygon element to the SVG element
        // svgX.appendChild(polygonElement);

        // Append the SVG element to the target element in your HTML
        // document.body.appendChild(svgX); // Change 'document.body'

        // deleteIconContainerDiv.appendChild(svgX);
        mockPageAtrributesContainerDiv.appendChild(numberContainerDiv); //appending number container to attributes container div
        mockPageAtrributesContainerDiv.appendChild(deleteIconContainerDiv);

        document.querySelector('.js-c-side-bar-container').appendChild(mockPageAtrributesContainerDiv);

       
};

addPageIconContainer.addEventListener("click",(e)=>{
    toggleAddPage();
});

//--------------------------------------------------------------------------------------------------------------------------------------------------//


//ALLOWING USER TO CHANGE FONT
const textContainer = document.getElementById("js-text-container");
const textDropDown = document.getElementById("js-text-options-menu");
const textIcon = document.getElementById("js-text");

const toggleTextOptions = function(){
    textDropDown.classList.toggle("show-drop-down-menu-text-icon");
    textIcon.classList.toggle("text-icon-show-clicked");
    console.log(textDropDown);
}
textContainer.addEventListener("click",(e)=>{
    e.stopPropagation();
    toggleTextOptions();
});

document.documentElement.addEventListener("click", ()=>{
    //checking if has been toggled
    if(textDropDown.classList.contains("show-drop-down-menu-text-icon")){
        toggleTextOptions();
    }
});

//CHANGING TEXT WHEN BUTTON IS SELECTED

const timesNewRomanBtn = document.getElementById("js-Times-New-Roman-btn");
const arialBtn = document.getElementById("js-Arial-btn");
const pagesSelected = document.getElementById("base-page-1"); //could later change to all pages

const boldContainer = document.getElementById("js-text-bold-container");
const italicContainer = document.getElementById("js-italic");



const toggleFunction = function(classL){
    pagesSelected.classList.toggle(classL);
}

timesNewRomanBtn.addEventListener("click",function(e){
    e.stopPropagation();
    toggleFunction("add-Times-New-Roman");
});

arialBtn.addEventListener("click",function(e){
    e.stopPropagation();
    toggleFunction("add-Arial");
});

//ADDING BOLD EVENT LISTENER
boldContainer.addEventListener("click",function(e){
    e.stopPropagation();
    toggleFunction("add-bold");
});


//ADDING ITALIC
italicContainer.addEventListener("click",function(e){
    e.stopPropagation();
    toggleFunction("add-italic");
});

//highglighting
// const highlightContainer = document.getElementById("js-text-highlight-container");
// const selectedText = window.getSelection().toString();
    
// highlightContainer.addEventListener("click",()=>{
//     if(selectedText.length >0){
//            //wrapping selected text in span
//            const span = document.createElement("span");
//            span.className = "add-highlight";
//            span.textContent = selectedText;
//            console.log(selectedText);

//            const text = pagesSelected.textContent;
//            const replace = text.replace(selectedText,span.outerHTML);
//            pagesSelected.innerHTML = replace; //replacing old with new
//     }
            
// });