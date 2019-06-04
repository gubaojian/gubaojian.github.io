var css = require('css');
var Set = require("collections/set");
const fetch = require('node-fetch');
var htmlparser = require("htmlparser2");
const fs = require('fs');



var detailsUrl = {};


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


function parseHtmlBody(site, html){
    var parser = new htmlparser.Parser({
        onopentag: function(name, attribs){
            styleStart = false;
            if(name == "a"){
                if(attribs.class = "app-info-icon"){
                    var href = attribs.href;
                    if(href.startsWith("detail.htm?apkName") > 0){
                       detailsUrl[attribs.href] = attribs.href;
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
  



function parseSiteGetDetail(url){
    fetchUrlContent(url, function(body){
        parseHtmlBody(url, body);
        fs.writeFileSync("detail.json", JSON.stringify(detailsUrl, null, 2));
        console.log(JSON.stringify(detailsUrl));
    });
 }


 var data = fs.readFileSync('site.txt', 'utf8');
var urls = data.split("\n");
for(var index in urls){
    var url = urls[index];
    if(url.length <= 0){
        continue;
    }
    parseSiteGetDetail(url);
}



