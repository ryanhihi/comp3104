//File module
const fs = require('fs');
const path = require('path');

const logsDir = path.join(__dirname, 'Logs');

//Remove files and the logs directiory
function removeLogs(){
    if(fs.existsSync(logsDir)){
        fs.readdirSync(logsDir).forEach(file =>{
            const filePath = path.join(logsDir,file);
            console.log(`Delete files...${file} `);
            fs.unlinkSync(filePath);
        });
        fs.rmdirSync(logsDir);
        console.log('Logs directory removed.');
    }else{
        console.log('Logs directory does not exist');
    }
}

removeLogs();