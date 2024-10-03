//Promise
//function resolvedPromise
function resolvedPromise(){
    return new Promise((resolve) =>{
        setTimeout(()=>{
            resolve("Resolved after 500ms");
        }, 500);
    });
}

//function rejectedPromise

function rejectedPromise(){
    return new Promise((_,reject) => {
        setTimeout(()=>{
            reject(new Error("Rejected after 500ms"));
        }, 500);
    });
}

//Call resolvedPromise and output
resolvedPromise()
.then(result => console.log(result))
.catch(error => console.error(error));

//Call rejectedPromise and output
rejectedPromise()
.then(result => console.log(result))
.catch(error => console.error(error.message))