# Tomcat

## 1. 什么是Tomcat

一种Web应用服务器

## 2. 安装Tomcat

1. 下载
   https://tomcat.apache.org
2. 将压缩文件解压到一个固定文件夹中

## 3. Tomcat文件夹解析

1. ==bin== 目录
   存放打开, 关闭等操作服务器的脚本文件
2. ==backup== 目录
   使用后的Tomcat配置文件
3. ==conf== 目录
   存放各种Tomcat服务器的配置文件      如端口, 使用的协议版本
4. ==lib== 目录
   存放Tomcat服务器需要的jar包
5. ==logs== 目录
   存放Tomcat运行的一些日志
6. ==temp== 目录
   存放Tomcat运行时的临时文件
7. ==webapps== 目录
   存放允许客户端访问的资源(java程序)
8. ==work== 目录
   存放 Tomcat将JSP转换之后的Servlet文件

## 4. IDEA集成Tomcat

### 4.1 使用IDEA创建web程序

1. `create new project` -> `javaEnterprise` -> 配置`Application Server`, 选择解压后的`bin` 的上一级->勾选`Web Application`

   ![image-20210927212812109](https://gitee.com/four_four/picgo/raw/master/img/20210927212819.png)  

2. 配置Tomcat
   ![image-20210927213513727](https://gitee.com/four_four/picgo/raw/master/img/20210927213513.png) 

### 4.2 各文件(夹)的作用

1. `index.jsp` 存放前端代码, html的升级版
2. `web.xml` 配置当前工程的配置信息
3. `.idea`文件夹 使用IDEA时自动生成的文件夹, 用于存放项目的配置信息. 如版本控制, 历史记录等
4. `*.iml` 存放模块开发的相关信息

### 4.3 访问文件

部署在Tomcat服务器中的文件实际上是`web` 下的文件(这里是`index.jsp`文件. `index.jsp` 文件就在根目录, 所以可以直接访问), `src` 中的文件放在`WEB-INF` 中, `WEB-INF`文件夹中的文件浏览器==不能直接访问== 

![image-20210929204154180](https://gitee.com/four_four/picgo/raw/master/img/20210929204201.png) 

访问`web` 下的文件

打包后的文件目录:

![image-20210929205805203](https://gitee.com/four_four/picgo/raw/master/img/20210929205805.png) 

默认访问`index.jsp` 文件

![image-20210929205427556](https://gitee.com/four_four/picgo/raw/master/img/20210929205427.png) 

也可以直接访问web下的其他文件

![image-20210929205536230](https://gitee.com/four_four/picgo/raw/master/img/20210929205536.png) 

访问src中的文件

![image-20210929205730845](https://gitee.com/four_four/picgo/raw/master/img/20210929205730.png) 

如果想要从浏览器中直接访问, 必须在`web.xml` 中做映射

![image-20210929211027750](https://gitee.com/four_four/picgo/raw/master/img/20210929211027.png) 

测试: 

程序: 

![image-20210929223721343](https://gitee.com/four_four/picgo/raw/master/img/20210929223721.png) 

访问src文件夹中的文件时的访问界面:

![image-20210929223615817](https://gitee.com/four_four/picgo/raw/master/img/20210929223616.png) 

访问src文件夹中的文件时的控制台输出:

![image-20210929223811808](https://gitee.com/four_four/picgo/raw/master/img/20210929223811.png) 

访问成功!



+ 注: 如果配置好servlet映射以后依然不能访问, 可检查以下几个地方:
  1. 检查`web.xml` 是否加载正确
     `project structure` -> `Modules` -> `Web` -> `Deployment Description` -> 配置到`web.xml`
  2. 检查默认访问路径
     `Edit Configurations` -> `Deplopment` -> `Application context` 配置成 `/` 