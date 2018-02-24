# Introduction

Cross platform fast layout engine for mobile platform, native and front friend, bring web layout and native layout together.

supported  flex box.
https://www.w3.org/TR/css-flexbox-1/
support percent and vm, default display flex
support vw vh

## guide start

```html
<page class="page">
    <text class="title"></text>
    <text class="desc">描述描述</text>
    <img class="img"></img>
    <div class="horizontal">
        <div class="love"></div>
    </div>
    <list class="list"></list>
    <component src=""></component>
</page>
<style screenUnit="750">
.page{
   width:750;
   height:100%;
}

.title{
    color: rgb(255, 153, 119);
}

.img{
    align:center;
    width:100;
    height:100;
}

.horizontal{
   flex-flow: column;
}

.list{
   flex:1
}
<style>
<script>
</script>
```
## supported selector
```css
#id{

}

#className{

}
tag{


}
```

## supported component

```
{
display:flex;
display:frame;
display:linear;
}
```

```
https://github.com/servo/servo/issues/18837
```


list
dialog

模块的连接器：
1、连接器



