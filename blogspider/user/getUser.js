const webutil = require("./webutil.js")
const htmlparser = require("htmlparser2");
const fs = require('fs');
const MAX_SAVE_FILE_COUNT = 32;

var repoUrls = [];

function parseUserEmail(html, user){
  if(user && user.email){
      console.log("has email " + user.email + " " + user.link);
  }
  var parser = new htmlparser.Parser({
      onopentag: function(name, attribs){
          if(name == "a"){
            if(attribs['class'] == 'u-email '){
              var href = attribs.href;
              href  = href.replace("mailto:", "");
              if(user && !user.email){
                  console.log(href);
                  user.email = href;
              }
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


function fetchNextUser(){
    item = repos.shift();
    fetchUserInfo(item);
}

var saveCount = 0;
//const token = "4a7e33c2dcbb904222b07b3b058251333ef391de";
const token = "686431d6c8d53091df3ea59d9e87b23a23a6fd03 ";
//const token = "4519425f5d6d7063bdd331ce61339f41564f42dd";
function fetchUserInfo(item){
  var apiInfoUrl = "https://api.github.com/users/" + item.name + "?access_token=" + token;
  if(users[item.name]){
     console.log("skip user " + item.name);
     fetchNextUser();
     return;
  }
  console.log("fetch " + item.link + " remain " + repos.length);
  var startFetch = new Date().getTime();
  webutil.fetchUrl(apiInfoUrl,  function(body){
      var userInfo = JSON.parse(body);
      if(userInfo.message && userInfo.message != "Not Found"){
          console.log(body  + " " + JSON.stringify(item));
          return;
      }
      var endFetch = new Date().getTime();
      console.log("fetch used " + (endFetch - startFetch));
      /**
      webutil.fetchUrl(item.link,  function(body){
          parseUserEmail(body, userInfo);
          users[item.name] = userInfo;
          fs.writeFileSync(userFileName, JSON.stringify(users, null, 2));
          fetchNextUser();
      }, function(error){
          console.log(error);
          fs.writeFileSync(userFileName, JSON.stringify(users, null, 2));
          fetchNextUser();
      });*/
      users[item.name] = userInfo;
      saveCount++;
      if(saveCount >= MAX_SAVE_FILE_COUNT || repos.length == 0){
        var start = new Date().getTime();
        fs.writeFileSync(userFileName, JSON.stringify(users, null, 2));
        var end = new Date().getTime();
        console.log("save used " + (end - start));
        saveCount = 0;
      }
      fetchNextUser();
  }, function(error){
      console.log(error);
      fetchUserInfo(item);
  });
}


//
//var dataFileName = "/Users/furture/code/gubaojianblog/blogspider/data/dubbo/stargazers.json";

var args = process.argv.splice(2);
var dataFileName = "/Users/furture/code/gubaojianblog/blogspider/data/ant-design/stargazers.json";
var dataPath  =  "user/data/";
var userFileName = dataPath + "user.json";
var data = fs.readFileSync(dataFileName, "utf-8");
var repos = JSON.parse(data);
var users = {};
if(fs.existsSync(userFileName)){
   var userFileData = fs.readFileSync(userFileName, "utf-8");
   users = JSON.parse(userFileData) || {};
}
while(true && repos.length > 0){
  var item = repos.shift();
  if(users[item.name]){
      console.log('skip ' + item.name);
      continue;
  }
  fetchUserInfo(item);
  if(repos.length > 0){
     fetchUserInfo(repos.shift());
  }
  if(repos.length > 0){
     fetchUserInfo(repos.shift());
  }
  break;
}
