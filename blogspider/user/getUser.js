const webutil = require("./webutil.js")
const htmlparser = require("htmlparser2");
const fs = require('fs');


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

function fetchUserInfo(item){
  var apiInfoUrl = "https://api.github.com/users/" + item.name + "?access_token=0ac51c183e8d28db645d9bf4e738e8bbf0d30729";
  if(users[item.name]){
     fetchNextUser();
     return;
  }
  console.log("fetch " + item.link);
  webutil.fetchUrl(apiInfoUrl,  function(body){
      var userInfo = JSON.parse(body);
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
      fs.writeFileSync(userFileName, JSON.stringify(users, null, 2));
      fetchNextUser();
  }, function(error){
      console.log(error);
  });
}


var args = process.argv.splice(2);
var dataFileName = "/Users/furture/code/gubaojianblog/blogspider/data/WxJava/stargazers.json";
var dataPath  =  "user/data/";
var userFileName = dataPath + "user.json";
var data = fs.readFileSync(dataFileName, "utf-8");
var repos = JSON.parse(data);
var users = {};
if(fs.existsSync(userFileName)){
   var userFileData = fs.readFileSync(userFileName, "utf-8");
   users = JSON.parse(userFileData) || {};
}
var item = repos.shift();
fetchUserInfo(item);
