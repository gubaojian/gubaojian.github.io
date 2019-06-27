const fs = require('fs');



var dataFileName = "/Users/furture/code/gubaojianblog/blogspider/user/data/user.json";
var data = fs.readFileSync(dataFileName, "utf-8");
var users = JSON.parse(data);
var keys = Object.keys(users);
var blogs = [];
for(var index in keys){
    var key = keys[index];
    var user = users[key];
    if(user.blog){
       console.log(user.blog);
       blogs.push(user.blog);
    }
}

console.log(blogs.length);
