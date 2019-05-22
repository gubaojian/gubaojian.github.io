const fs = require('fs');
const unzipper= require('unzipper');

var path = "zip"
var dirList = fs.readdirSync(path);


console.log(dirList.length);

for (var i = 0; i < dirList.length; i++) {
   var file = dirList[i];
   fs.createReadStream(path + "/" + file)
   .pipe(unzipper.Extract({ path: 'uzip/' + file }));

   console.log(i + "  " + file);
}
