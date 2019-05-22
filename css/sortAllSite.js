const fs = require('fs');
var path = "css"
var dirList = fs.readdirSync(path);

var namePrefixs  = [];
var cssNameValuesStats = {};

for (var i = 0; i < dirList.length; i++) {
        var file = dirList[i];
        var data = fs.readFileSync(path + "/" + file, 'utf8');
        console.log(i + "  file " + file);
        var itemStats = JSON.parse(data);
        for(var itemIndex in itemStats){
            var item = itemStats[itemIndex];
            var property = item.property;
            if(!property){
                continue;
            }
            for(var prefixIndex in namePrefixs){
                 var prefix = namePrefixs[prefixIndex];
                 if(property.startsWith(prefix)){
                      property = property.substr(prefix.length);
                 }
            }

            var totalItem = cssNameValuesStats[property];
            if(!totalItem){
                totalItem = {
                  count : 0,
                  property:item.property
                };
                cssNameValuesStats[property] = totalItem;
            }
            if(totalItem.hasCount){
              continue;
            }
            totalItem.count +=1;
            totalItem.hasCount = true;
        }
        for(var index in cssNameValuesStats){
            var cssNameValuesStat = cssNameValuesStats[index];
             cssNameValuesStat.hasCount = false;
        }
}

var cssStats = [];
for(var  key in cssNameValuesStats){
     var item = cssNameValuesStats[key];
     cssStats.push(item);
}
cssStats.sort(function(a,b){
  return  b.count -a.count;
});

console.log(cssStats);
fs.writeFileSync("stats.txt", JSON.stringify(cssStats));
