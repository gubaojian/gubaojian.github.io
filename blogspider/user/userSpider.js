const child_process = require('child_process');
const fs = require('fs');

var dir = "data";
var filesList = [];
var dirList = fs.readdirSync(dir);
for (var i = 0; i < dirList.length; i++) {
    var file = dir + "/" + dirList[i] + "/stargazers.json";
    if(fs.existsSync(file)){
      filesList.push(file);
      console.log(file);
    }
}

var currentFile = filesList.shift();
function startSpider(){
  console.log('Spider File ' + currentFile);
  var spider = child_process.exec('node user/getUser.js ' + currentFile);
  spider.stdout.on('data', (data) => {
     console.log(`stdout: ${data}`);
  });

  spider.on('exit', function (code) {
    console.log('App Has Quit, Restart ' + code);
    if(code == 8){
        setTimeout(function(){
          startSpider();
        }, 1000*60*30)
        return;
    }
    console.log('App Has Quit, Start Next Url ' + code);
   
    if(filesList.length > 0){
       currentFile = filesList.shift();
       setTimeout(function(){
        startSpider();
       }, 60000);
    }
  });
}

startSpider();
