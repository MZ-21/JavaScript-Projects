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
const pagesSelected = document.getElementById("base-page-1"); //could later change to a specific page


timesNewRomanBtn.addEventListener("click",function(){
    console.log("red");
    pagesSelected.style.color = "red";
    // const selectedText = window.getSelection().toString();
    
    // if(selectedText.length >0){
    //     //wrapping selected text in span
    //    const span = document.createElement("span");
    //    span.className = "add-Times-New-Roman";
    //    span.textContent = selectedText;
        
    //    const text = pagesSelected.textContent;
    //    const replace = text.replace(selectedText,span.outerHTML);

    //    pagesSelected.innerHTML = replace; //replacing old with new

    // }


});

// const toggleFontFamily = function(classL){
//     pagesSelected.toggle.classList(classL);
// }
// timesNewRomanBtn.addEventListener("click",(e)=>{
//     e.stopPropagation();
//     toggleFontFamily("add-Times-New-Roman");
// });
// arialBtn.addEventListener("click",(e)=>{
//     console.log("A");
//     e.stopPropagation();
//     toggleFontFamily("add-Arial");
//     //console.log(pagesSelected.style.f)
// });