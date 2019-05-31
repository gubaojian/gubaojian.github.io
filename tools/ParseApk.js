const child_process = require('child_process');
const fs = require('fs');


var dexToJarPath = " /Users/furture/tools/dex2jar-2.0/d2j-dex2jar.sh";

function execCmd(cmd){
    console.log(cmd);
    child_process.execSync(cmd); 
}

function parseApk(fileName){
    var pos = fileName.indexOf(".apk");
    if(pos <= 0 ){
       return;
    }
    var dir = fileName.substr(0, pos);
    execCmd("rm -rf " + dir);
    execCmd("unzip " + fileName  + " -d " + dir);
    execCmd("cd " + dir + " && " + dexToJarPath + " *.dex --force");
    execCmd("cd " + dir + " && rm -rf classes");
    execCmd("cd " + dir + " && mkdir classes");
    files = fs.readdirSync(dir);
    files.forEach(function(file,index){
        if(file.indexOf(".jar") > 0){
            var jarFile = dir + "/" + file;
            execCmd("cd " + dir + " && unzip -o " + jarFile + " -d classes/ ");
        }
    });
    execCmd("cd " + dir + " &&  jar cvf all_classes.jar -C classes/  . ");
}
if(process.argv.length <= 2){
    console.log("Please Input APK FileName");
    return;
}
var args = process.argv.splice(2);
parseApk(args[0]);