//lowerCaseWords function

function lowerCaseWords(array){
    return new Promise((resolve, reject) => {
        if(!Array.isArray(array)){
            reject(new Error("Input is not an array")); //Raise an error if input is not an array
        } else{
            const lowerWords = array 
                                .filter(item => typeof item == "string")
                                .map(item => item.toLowerCase());
            resolve(lowerWords);
        }

    });
}

//Test 
const mixedArray = ['PIzZA', 10 , true, 25, false, "WinGs" ];
console.log(lowerCaseWords(mixedArray));


