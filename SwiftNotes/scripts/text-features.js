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

//CHANGING TEXT WHEN BUTTON IS SELECTED

const timesNewRomanBtn = document.getElementById("Times-New-Roman-btn");
const arialBtn = document.getElementById("Arial-btn");
const pagesSelected = document.querySelector("page"); //could later change to a specific page

const toggleFontFamily = function(classL){
    pagesSelected.toggle.classList(classL);
}
timesNewRomanBtn.addEventListener("click",()=>{
    toggleFontFamily("add-Times-New-Roman ");
});
arialBtn.addEventListener("click",(e)=>{
    console.log("A");
    e.stopPropagation();
    toggleFontFamily("add-Arial");
    //console.log(pagesSelected.style.f)
});