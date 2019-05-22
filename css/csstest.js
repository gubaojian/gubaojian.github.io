var css = require('css');
var Set = require("collections/set");
const fetch = require('node-fetch');
var htmlparser = require("htmlparser2");
const fs = require('fs');

var cssNameValuesStats = {};
var namePrefixs  = ["--moz-box-", "--moz-box-", "--o-", "--mdc-", "-webkit-", "-ms-", "-moz-"];
var savePath = "css";

function parseCSS(site, content){
  var cssStyles = css.parse(content, {});
  var rules = cssStyles.stylesheet.rules;
  for(var index in rules){
    var rule = rules[index];
    var declarations  = rule.declarations;
    for(var dIndex in declarations){
       var declaration = declarations[dIndex];
       for(var prefixIndex in namePrefixs){
            var prefix = namePrefixs[prefixIndex];
            if(!declaration.property){
                continue;
            }
            if(declaration.property.startsWith(prefix)){
                 declaration.property = declaration.property.substr(prefix.length);
            }
       }

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
   console.log(JSON.stringify(cssStats));
}


function fetchSiteCSS(site, url){
  fetchUrlContent(url, function(body){
       parseCSS(site, body);
  });
}


function fetchUrlContent(url, callback){
  if(url.startsWith("//")){
     url ="https:" + url;
  }
  fetch(url, {headers:{"user-agent": "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53"}})
      .then(res => res.text())
      .then(body => {
          callback(body);
      });
}

fetchSiteCSS("test.html","https://g.alicdn.com/trip/h5-visa-customization/0.1.25/??widgets/css/build/reset-min.css,h5-visa-customization-commons.css,pages/taiwan/index.css?v=3432826336_182736");
