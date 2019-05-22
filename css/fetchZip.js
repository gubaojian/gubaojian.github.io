const fetch = require('node-fetch');
const fs = require('fs');

var savePath = "zip";

function toFileName(site){
  var name = site.replace("://", "_");
  name = name.replace(/\//g, "_");
  name = savePath + "/" + name;
  return name;
}


function fetchZipUrl(url, index, fileName){
  if(url.startsWith("//")){
     url ="https:" + url;
  }
  fetch(url, {headers:{"user-agent": "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53"}})
      .then(res => {
        const dest = fs.createWriteStream(fileName);
        res.body.pipe(dest);
        console.log(fileName + " success " + index);
      });
}

if(!fs.existsSync(savePath)){
    fs.mkdirSync(savePath);
}

var data = fs.readFileSync('zip.txt', 'utf8');
var urls = data.split("\n");
for(var index in urls){
    var url = urls[index];
    if(url.length <= 0){
        continue;
    }
    var position = url.indexOf(',');
    url = url.substr(0, position);
    var fileName = toFileName(url);
    if(fs.existsSync(fileName)){
        continue;
    }
    fetchZipUrl(url, index, fileName);
}
