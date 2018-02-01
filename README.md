# CyLang
A language for json parse which contains params or expression

# Introduce
###### Now when we start develop a RESTful api or JsonRpc,we often use json as a data type,because it's easy to unstand and simple to right! 
###### When we post or get from a url,we also use json to package params!So I think we need a language to parse params or express in json param.
###### If that ,we can use params to get value from system or databases,or others.

# 1、Main idea
#### This frame contains flows:
##### core: This is the frame core code ,it's main function is to design the langage
##### utils:This is the util that often use ,such get system time,user profile,etc. 
##### parse: This is the internal language parser,also provide interface to implement by user.
##### grammar: This is the internal grammer in this frame,also provide interface to implement new grammer by user.



## language rules flows:
### ${name}:like jsp's el expression,name is the param's name
###\##1+1##:it's a expression,we will evaluate it as js expression.for example,##1+1##的值为2
### {if ${name}}aaaaaa{/if}:this is if expression,name is the param key,${name} will be evalute boolean value through javascript programm

### Release Note 
#### 2018-02-01
* **增加parser.properties**:
    * 通过配置grammar可以动态设置grammar启用的列表
    * 增加sortType:可以通过排序方式，如果为true则启用配置文件grammar中的配置顺序，否则启用每个grammar注解文件下的seq从小到大的排序方式启动
* **增加parser.properties**:增加包扫描方法ClassScanUtils.getAllClass(扫描classpath下的文件)和ClassScanUtils.getAllClassIncludeJar(扫描jar中的class文件和classpath下的文件)

```Java
    String content = "${a}${b}##${cd}+${dd}##{if ${cd}}${ed}{/if}";
    Map<String,String> map = new HashMap<String,String>();
    map.put("a","a");
    map.put("b","b");
    map.put("cd","1");
    map.put("dd","2");
    map.put("ed","3");
    String result = new Handler().execute(content,map);
    System.out.println(result);
    
    >> ab33
```

## To be continued!!!!!!