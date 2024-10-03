const fs = require('fs');
const path = require('path');

const logsDir = path.join(__dirname, 'Logs');

function createLogs(){
    if(!fs.existsSync(logsDir)){
        fs.mkdirSync(logsDir);
        console.log('Logs created');
    }

    process.chdir(logsDir);

    for(let i=1; i<=10; i++){
        const fileName = `log${i}.txt`;
        fs.writeFileSync(fileName, `This is log file${i}`);
        console.log(`${fileName}`);
    }
}

createLogs();
