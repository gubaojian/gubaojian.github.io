const fetch = require('node-fetch');

function fetchUrl(url, callback){
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

var webutil = {};
webutil.fetchUrl = fetchUrl;

module.exports = webutil;
