const child_process = require('child_process');
const fs = require('fs');
const path = require("path");




function traverseDir(dir, suffix, callback){
  if(!fs.existsSync(dir)){
      return;
  }
  var dirList = fs.readdirSync(dir);
  for (var i = 0; i < dirList.length; i++) {
       var file = dir + "/" + dirList[i];
       var stats = fs.statSync(file);
       if(stats.isDirectory()){
          traverseDir(file, suffix, callback);
       }else if(file.endsWith(suffix)){
           var fullPath = path.resolve(file);
           if(callback){
               callback(fullPath);
           }
       }
  }
}

traverseDir("apk", ".apk", file => {
  console.log("file " + file + " ");
  var cmd = "node apktojar.js " + file;
  try{
    child_process.execSync(cmd);
  }catch(e){
    console.log(e);
  }
});