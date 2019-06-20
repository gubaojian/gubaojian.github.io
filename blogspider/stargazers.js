const webutil = require("./webutil.js")
const htmlparser = require("htmlparser2");


var stargazers  = [];
var urls = [];
function parseStargazers(html){
  var start = false;
  var item = {};
  var nextPage = false;
  var parser = new htmlparser.Parser({
      onopentag: function(name, attribs){
          styleStart = false;
          if(name == "a"){
              if(attribs["data-hovercard-type"] = "user"
                 && attribs["data-octo-click"] == "hovercard-link-click"){
                  var href = attribs.href;
                  item.link = "https://github.com/" + href;
                  start  = true;
              }else if(attribs["rel"] == "nofollow" && attribs["class"] == "btn btn-outline BtnGroup-item"){
                  urls.push(attribs.href);
                  nextPage = true;
              }
          }
      },
      ontext: function(text){
        if(start){
           item.name = text;
           stargazers.push(item);
           item = {};
        }
        if(nextPage && text != 'Next'){
           urls.pop();
        }
      },
      onclosetag: function(tagname){
         start  = false;
         nextPage = false;
      }
  }, {decodeEntities: true});
  parser.write(html);
  parser.end();
}


function fetchStargazers(url){
  webutil.fetchUrl(url,  function(body){
      parseStargazers(body);
      if(urls.length > 0){
        setTimeout(function(){
          var nextUrl = urls.pop();
          console.log(nextUrl);
          fetchStargazers(nextUrl);
        },1000);
      }else{
        console.log(stargazers.length);
      }
  });
}


//fetchStargazers("https://github.com/apache/incubator-weex/stargazers");


fetchStargazers("https://github.com/apache/incubator-weex/stargazers?after=Y3Vyc29yOnYyOpO5MjAxNy0wMi0xNlQxMDoyMDo1OCswODowMADOBMJY8Q%3D%3D");
