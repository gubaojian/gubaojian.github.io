var css = require('css');
var Set = require("collections/set");
const fetch = require('node-fetch');
var htmlparser = require("htmlparser2");
const fs = require('fs');

var sites = {};
var savePath = "css";

function parseCSS(site, content, url){
  try{
    var cssNameValuesStats =  sites[site];
    if(!cssNameValuesStats){
       cssNameValuesStats = {};
       sites[site] = cssNameValuesStats;
    }
    var cssStyles = css.parse(content, {});
    var rules = cssStyles.stylesheet.rules;
    for(var index in rules){
      var rule = rules[index];
      var declarations  = rule.declarations;
      for(var dIndex in declarations){
         var declaration = declarations[dIndex];
         var itemStats = cssNameValuesStats[declaration.property];
         if(!itemStats){
           itemStats = {
             count: 0,
             property:declaration.property,
             values: new Set(),
           };
           cssNameValuesStats[declaration.property] = itemStats;
         }
         itemStats.count++;
         itemStats.values.add(declaration.value);
      }
    }
    var name = site.replace("://", "_");
    name = name.replace(/\//g, "_");
    name = savePath + "/" + name;


    var cssStats = [];
    for(var  key in cssNameValuesStats){
         var item = cssNameValuesStats[key];
         cssStats.push(item);
    }
    cssStats.sort(function(a,b){
      return  b.count -a.count;
    });
    fs.writeFileSync(name, JSON.stringify(cssStats));
  }catch(e){
     console.log("url " + site + " url " + url);
     console.log(e);
  }
}

function fetchSiteCSS(site, url){
  fetchUrlContent(url, function(body){
       parseCSS(site, body, url);
  });
}

function parseHtmlBody(site, html){
  var styleStart = false;
  var parser = new htmlparser.Parser({
      onopentag: function(name, attribs){
          styleStart = false;
          if(name == "link"){
            if(attribs.rel == "stylesheet"){
              if(attribs.href){
                fetchSiteCSS(site, attribs.href);
              }
            }
          }else if(name == 'style'){
               styleStart = true;
          }
      },
      ontext: function(text){
        if(styleStart){
            //parseCSS(site, text, site);
        }
      },
      onclosetag: function(tagname){
          styleStart = false;
      }
  }, {decodeEntities: true});
  parser.write(html);
  parser.end();
}

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

function parseSiteAndStatCss(url){
   fetchUrlContent(url, function(body){
       parseHtmlBody(url, body);
   });
}
if(!fs.existsSync(savePath)){
    fs.mkdirSync(savePath);
}

var data = fs.readFileSync('site.txt', 'utf8');
var urls = data.split("\n");
for(var index in urls){
    var url = urls[index];
    if(url.length <= 0){
        continue;
    }
    parseSiteAndStatCss(url);
}
