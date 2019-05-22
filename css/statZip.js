const fs = require('fs');
var css = require('css');
var Set = require("collections/set");

var savePath = "zipcss"
var sites = {};
function parseCSS(site, content){
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
    var name = name.replace("zip", "css");
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
     console.log(e);
  }
}

if(!fs.existsSync(savePath)){
    fs.mkdirSync(savePath);
}




var cssCount = 0;
function statDirCss(path, zipFile){
  var dirList = fs.readdirSync(path);
  for (var i = 0; i < dirList.length; i++) {
       var file = path + "/" + dirList[i];
       var zipName = zipFile;
       if(!zipName){
          zipName = dirList[i];
       }
       var stats = fs.statSync(file);
       if(stats.isDirectory()){
          statDirCss(file, zipName);
       }else if(file.endsWith(".css")){
           cssCount++;
           console.log("file " + file + " " + zipFile);
           var data = fs.readFileSync(file, "utf8");
           parseCSS(zipFile, data);
       }
  }
}

statDirCss("uzip");
var dirList = fs.readdirSync("uzip");
console.log(dirList.length + "  " + cssCount);
