# XML

## 1. XML简介

### 1.1 什么是XML

+ XML 指的是 **可扩展的标记语言** 
+ XML 被发明的目的是 **传输和存储数据, ,而不是展示数据** 
+ XML 标签必须自定义, 自定义标签名时要有含义
+ 所有的XML标签必须在 **root** 标签下



### 1.2 XML引例

![image-20210709204835010](https://gitee.com/four_four/picgo/raw/master/img/20210709204842.png) 



### 1.3 XML与HTML比较

+ XML可以自定义标签, HTML不能自定义标签
+ XML语法要求严格, HTML语法相对宽松
+ XML用来传输和存储数据, HTML用来展示数据



## 2. XML的基本语法

### 2.1 语法规则

1. XML**必须有根节点**
   根节点是其他所有节点的父级节点
   `<root></root>` 

2. XML头声明:  **可有可无, 但是建议写**
   `<?xml version="1.0" encoding="utf-8" ?>` 

3.  所有XML元素都必须是**成对标签** 
   `<wv/>` error

4. 标签名**区分大小写** 
   `<A></a>` error 

5. 标签不能交叉
   `<A><b></A></b>` error

6.  注释  与HTML相同
   `<!--  -->` 

7. 特殊符号使用实体转义
   在xml中使用的转义字符:

   | 实体字符 | 转义的字符 | 含义           |
   | :------: | ---------- | -------------- |
   |  \&lt;   | <          | less than      |
   |  \&gt;   | >          | greater than   |
   |  \&amp;  | &          | ampersand      |
   | \&apos;  | ‘          | apostrophe     |
   | \&quot;  | “          | quotation mark |

   

### 2.2 元素属性

+ 属性就是表示标签自身的一些额外信息 
+ 一个标签可以有多个属性, 属性的值必须使用引号引起来
+ XML中属性并不重要(鸡肋)
+ 在解析XML数据时, 属性会带来额外的数据代码
+ 命名规则:
  + 数字, 字母, 下划线
  + 数字不能开头 

![image-20210709211926172](https://gitee.com/four_four/picgo/raw/master/img/20210709211926.png)  



### 2.3 CDATA

+ CDATA中的内容不解析
  格式:
  `<![ CDATA[......] ]>` 
+ 注意:
  特殊字符较少时, 使用实体替换;
  较多时使用CDATA

![image-20210709212817806](https://gitee.com/four_four/picgo/raw/master/img/20210709212817.png) 



## 3. 约束和验证XML —— DTD

### 3.1 DTD简介

+ DTD(Document Type Definition), 文档类型定义
+ DTD用于约束xml的文档格式, 保证xml是一个有效的xml(**相当于定义了xml的格式**) 
+ DTD可以分为 **内部DTD** 和 **外部DTD** 

### 3.2 内部DTD

> 定义

`<!DOCTYPE 根元素 [元素声明]>` 

> 元素声明语法

`<!ELEMENT 元素名(子元素[, 子元素...])>` 

+ 标签下只能有文本, 不能有子标签
  `<!ELEMENT 元素名 (#PCDATA)>`

> 数量词

+ \+ 出现至少一次
+ ? 出现0次或一次
+ \* 出现任意次

```xml
<!DOCTYPE scores [
    <!ELEMENT scores (student*)>
    <!ELEMENT student (id, name, course, score)>
    <!ELEMENT id (#PCDATA)>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT course (#PCDATA)>
    <!ELEMENT score (#PCDATA)>
]>
```

> 属性声明

`ATTLIST 元素名 属性名 默认类型 默认值` 

+ 默认值
  + \#REQUIRED 必须的
  + \#IMPLIED 不是必须的

```XML
<!ATTLIST student id CDATA #REQUIRED>
```

> 代码演示

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>

<!DOCTYPE scores [
    <!ELEMENT scores (student*)>
    <!ELEMENT student (id, name, course, score)>

    <!ELEMENT id (#PCDATA)>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT course (#PCDATA)>
    <!ELEMENT score (#PCDATA)>
]>

<scores>
    <student>
        <id>1</id>
        <name>张三</name>
        <course>java</course>
        <score>85</score>
    </student>

    <student>
        <id>2</id>
        <name>李四</name>
        <course>sql</course>
        <score>66</score>
    </student>

    <student>
        <id>3</id>
        <name>王五</name>
        <course>c语言</course>
        <score>58</score>
    </student> 
</scores>
```

### 3.3 外部DTD

> 定义

1. 创建一个外部的 `dtd` 文件
   `xxx.dtd`
2. 在文件中写入相应xml文件中的元素格式限制 

![image-20210709222751359](https://gitee.com/four_four/picgo/raw/master/img/20210709222751.png) 

> 引入

`<!DOCTYPE 标签名 SYSTEM "xxx.dtd">`

![image-20210709222844633](https://gitee.com/four_four/picgo/raw/master/img/20210709222844.png) 

