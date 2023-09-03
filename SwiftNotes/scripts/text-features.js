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