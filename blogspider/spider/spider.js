const child_process = require('child_process');
const fs = require('fs');
const LINE_SEPARATOR = "\n";


var dir = "site/";
const sitesFileName  = dir + 'siteUrls.txt';
const finishedFileName  = dir + 'finishedUrls.txt';


var  sitesData = fs.readFileSync(sitesFileName, "utf-8");
var  sites = sitesData.split(LINE_SEPARATOR);


var  finishedUrls = [];
if(fs.existsSync(finishedFileName)){
   var  finishedData = fs.readFileSync(finishedFileName, "utf-8");
   finishedUrls = finishedData.split(LINE_SEPARATOR);;
}

if(sites.length <= 0){
    console.log("none site need fetched, please add site");
    return;
}

const MAX_TRY_TIMES = 6;
var url = sites.shift();
if(!url){
    console.log("none site need fetched");
    return;
}
var tryTimes = 0;
var startStateUrl = url;
console.log( url );
function getFinishedUrl(){
  var paths = url.split("/");
  var dataPath  =  "data/" + paths[paths.length - 1] + "/";
  var stateFile = dataPath + "stateFile.dat";
  if(fs.existsSync(stateFile)){
    var currentUrl = fs.readFileSync(stateFile, "utf-8");
    return currentUrl;
  } 
  return undefined;
}

function startSpider(){

  var spider = child_process.exec('node spider/stargazers.js ' + url);
  
  spider.stdout.on('data', (data) => {
      console.log(`stdout: ${data}`);
  });

  spider.on('exit', function (code) {
    var finishedUrl = getFinishedUrl();

    if(startStateUrl != finishedUrl){
      startStateUrl = finishedUrl;
      tryTimes = 0;
      setTimeout(function(){
        startSpider();
      }, 20000);
      return;
    }
    tryTimes++;
    if(tryTimes < MAX_TRY_TIMES){
      setTimeout(function(){
        startSpider();
      }, 20000);
      return;
    }
    finishedUrls.push(url);
    fs.writeFileSync(finishedFileName, finishedUrls.join(LINE_SEPARATOR));

    if(sites.length > 0){
        url = sites.shift();
        fs.writeFileSync(sitesFileName,  sites.join(LINE_SEPARATOR));
        if(!url){
           console.log("none site need fetched");
            return;
        }
        console.log("Start New Site " + url);
        tryTimes = 0;
        startStateUrl = url;
        setTimeout(function(){
          startSpider();
        }, 20000);
        return;
    }

    fs.writeFileSync(sitesFileName,  sites.join(LINE_SEPARATOR));
    console.log("All Site Spider Done");
  });
}

startSpider(url);
