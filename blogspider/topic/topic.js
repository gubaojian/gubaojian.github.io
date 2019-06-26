var tags = document.getElementsByTagName('a');
var topicUrls = [];
for(var i=0; i<tags.length; i++){
  var tag = tags[i];
  if(tag.className == 'd-flex no-underline'){
     topicUrls.push(tag.href);
     console.log(tag.className + "  " + tag.href);
  }
}

topicUrls.join("\n");






var tags = document.getElementsByTagName('a');
var repoUrls = [];
console.log(tags.length);
for(var i=0; i<tags.length; i++){
  var tag = tags[i];
  console.log(tag.parentElement.innerText);
}



repoUrls.join("\n");
