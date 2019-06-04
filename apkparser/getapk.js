var css = require('css');
var Set = require("collections/set");
const fetch = require('node-fetch');
var htmlparser = require("htmlparser2");
const fs = require('fs');



function fetchUrlContent(url, callback){
  if(url.startsWith("//")){
     url ="https:" + url;
  }
  fetch(url, {headers:{"user-agent": "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53"}})
      .then(res => res.text())
      .then(body => {
          callback(body);
      }, err => {
          console.log(err);
      });
}


var detailsData = fs.readFileSync('detail.json', 'utf8');
var details = JSON.parse(detailsData); //{"detail.htm?apkName=com.xhqb.app": "detail.htm?apkName=com.xhqb.app"}; //JSON.parse(detailsData);
var apkJsons = {};
for(var key in details){
   var url = "https://sj.qq.com/myapp/" + key;
   //console.log(url);
   fetchUrlContent(url, function(body){
       var startStr = "var appDetailData = ";
       var endStr = "if(typeof pgvSendClick=='function'){";
       var start = body.indexOf(startStr);
       var end = body.indexOf(endStr, start);
       var appDetail = body.substring(start, end);
       //console.log(appDetail);
       eval(appDetail);
       var apkJson = appDetailData;
       if(apkJson.downUrl){
            apkJsons[apkJson.apkName] = apkJson;
            //console.log(JSON.stringify(apkJson));
            fs.writeFileSync("apkdetail.json", JSON.stringify(apkJsons, null, 2));
            //console.log(JSON.stringify(apkJsons));
       }
   });
}
