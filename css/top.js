const fs = require('fs');

var data = fs.readFileSync("stats.txt", 'utf8');


var dirList = fs.readdirSync("css/");


console.log(dirList.length);

// marign  anose-1
var items = JSON.parse(data);
var maxCount =  dirList.length;
for(var i in items){
    var item = items[i];
    if(!item.property){
      continue;
    }
    if(item.property.startsWith("_")
       || item.property.startsWith("-")
       || item.property.startsWith("//")
       || item.property.startsWith("\*")
       || item.property.startsWith("#")
       || item.property == "HEIGHT"
       || item.property == "background-sizE"
       || item.property == "wodth"){
       continue;
    }
    console.log(item.property + ",  " + item.count + ",  " + item.count/maxCount);
}
var dirList = fs.readdirSync("zip/");
console.log(dirList.length);
