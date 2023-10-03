const fs = require("fs");
const words = require("./words.json")

function getInfo(file,dataType){

    let promise = new Promise((resolve,reject)=>
    {
     fs.readFile(file,dataType,(error,data)=>{
        if(data){
            resolve(data);
        }
        else{
            reject("error");
        }
     })   
    }
    );

    return promise;
}

let dataI = getInfo("Optimism_and_your_health.txt","utf8");

dataI.then((result)=>{
    let result2 = result.split(" ");
    let countS=0; let countR=0; let countNA=0; let countA=0; 
    for(let i=0;i<result2.length;i++){
        for(let j=0;j<result2.length;j++){
            if(result2[i].toLowerCase().includes(words["Synonyms"][j])){
                countS++;
            }
            if(result2[i].includes(words["Related"][j])){
                countR++;
            }
            if(result2[i].includes(words["Near Antonyms"][j])){
                countNA++;
            }
            if(result2[i].includes(words["Antonyms"][j])){
                countA++;
            }
        }
    }
        let object={};
        object.Synonyms=countS; object.Related=countR; object["Near Antonyms"]=countNA;
        object.Antonyms=countA;
        
        fs.writeFile("result.txt",JSON.stringify(object),()=>{});
    }

)
    .catch((result)=>{console.log(result)});


