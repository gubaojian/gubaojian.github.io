const child_process = require('child_process');
const fs = require('fs');
const LINE_SEPARATOR = "\n";


var dir = "topic/";
const topicUrlsFileName  = dir + 'topicUrls.txt';


var  topicData = fs.readFileSync(topicUrlsFileName, "utf-8");
var  topicUrls = topicData.split(LINE_SEPARATOR);


if(topicUrls.length <= 0){
    console.log("none site need fetched, please add site");
    return;
}

var url = topicUrls.shift();
if(!url){
    console.log("none site need fetched");
    return;
}

function startSpider(){

  var spider = child_process.exec('node topic/getTopicRepo.js ' + url);
  spider.stdout.on('data', (data) => {
      console.log(`stdout: ${data}`);
  });

  spider.on('exit', function (code) {
    if(topicUrls.length > 0){
        url = topicUrls.shift();
        if(!url){
           console.log("none site need fetched");
            return;
        }
        console.log("Start New Site " + url);
        setTimeout(function(){
          startSpider();
        }, 20000);
        return;
    }
    console.log("All Site Spider Done");
  });
}

startSpider(url);
