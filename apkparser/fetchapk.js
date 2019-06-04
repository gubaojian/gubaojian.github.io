const fetch = require('node-fetch');
const fs = require('fs');
const urlparser = require('urlparser');


var savePath = "apk";
var synRequestControl = null; 

function saveFileName(fileName){
  var name = savePath + "/" + fileName;
  return name;
}


function fetchZipUrl(url, fileName){
  if(url.startsWith("//")){
     url ="https:" + url;
  }
  fetch(url, {headers:{"user-agent": "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53"}})
      .then(res => {
        if(res.ok){
            const dest = fs.createWriteStream(fileName);
            res.body.pipe(dest);
            console.log(fileName + " success ");
            synRequestControl.next();
        }else{
            synRequestControl.next();
        }
      }).catch(error => {
          console.log('There is some error ' + error);
          synRequestControl.next();
      });
}

if(!fs.existsSync(savePath)){
    fs.mkdirSync(savePath);
}

var apkDetailData = fs.readFileSync('apkdetail.json', 'utf8');
var apkDetails = JSON.parse(apkDetailData); 
function* synRequest(){
    for(var key in apkDetails){
        var apkDetail = apkDetails[key];
        if(!apkDetail.downUrl){
            continue;
        }
        var urlParams = urlparser.parse(apkDetail.downUrl);
        var fileName = apkDetail.apkName;
        if(urlParams && urlParams.query && urlParams.query.params && urlParams.query.params.fsname){
             fileName = urlParams.query.params.fsname;
        }else{
            console.log("-------------" + apkDetail.downUrl);
        }
        console.log("-------------");
        fileName = saveFileName(fileName);
        console.log(apkDetail.downUrl + " save to "  + fileName);
    
        if(!fs.existsSync(fileName)){
           fetchZipUrl(apkDetail.downUrl,  fileName);
           yield;
        }
    }
}

var synRequestControl = synRequest();

synRequestControl.next();