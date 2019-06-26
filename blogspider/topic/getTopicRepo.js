const webutil = require("./webutil.js")
const htmlparser = require("htmlparser2");
const fs = require('fs');


var repoUrls = [];

function parseTopicRepo(html){

  var parser = new htmlparser.Parser({
      onopentag: function(name, attribs){
          if(name == "a"){
              var dataGaClick = attribs['data-ga-click'];
              if(dataGaClick && dataGaClick.indexOf('topic repositories') > 0
                 && attribs.href.indexOf('/stargazers') < 0){
                   var url = "https://github.com" + attribs.href;
                   console.log(url);
                   repoUrls.push(url);
              }
          }
      },
      ontext: function(text){

      },
      onclosetag: function(tagname){

      }
  }, {decodeEntities: true});
  parser.write(html);
  parser.end();
}


function fetchTopicRepo(url){
  webutil.fetchUrl(url,  function(body){
      parseTopicRepo(body);
      fs.writeFileSync(repoFileName, JSON.stringify(repoUrls, null, 2));
  }, function(error){
       fs.writeFileSync(repoFileName, JSON.stringify(repoUrls, null, 2));
       process.exit(-1);
  });
}



var args = process.argv.splice(2);

var site = args[0];
var paths = site.split("/");
var dataPath  =  "topic/data/" + paths[paths.length - 1] + "/";
var repoFileName = dataPath + "repo.json";
var url  = site  + "?o=desc&s=stars";

if(!fs.existsSync(dataPath)){
   fs.mkdirSync(dataPath);
}

console.log("get url " + url + " save to file " + repoFileName);
fetchTopicRepo(url);
