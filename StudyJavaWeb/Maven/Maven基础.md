# Maven入门

## 1. Maven简介

### 1.1 什么是Maven

+ Maven本质上是一款**项目管理工具** , 将项目开发和管理过程抽象成一个项目对象模型(**POM**)
+ **POM**(Project Object Model), 项目对象模型

### 1.2 Maven的工作方式

![maven工作方式](https://gitee.com/four_four/picgo/raw/master/img/20211013223332.png)

### 1.3 maven能做什么

1. ==依赖管理== : 方便快捷的管理项目依赖的资源(jar包), 避免资源间的**版本冲突**
2. ==项目创建== : 提供**标准的**, **跨平台的**自动化项目构建方式
3. ==统一开发结构== : 提供标准的, 统一的项目结构



## 2. maven的安装

### 2.1 maven的文件结构

1. bin文件夹
   maven所有的可运行指令
   指令中:
   REM   注释

2. boot文件夹
   maven的类加载器
3. conf 文件夹
   maven的配置管理
4. lib 文件夹
   maven运行时需要的jar包

### 2.2 maven的安装

maven解压既可以使用, 但运行需要配置`JAVA_HOME` 和 `MAVEN_HOME` 

配置`MAVEN_HOME` 的方法和配置`JAVA_HOME` 的方法完全相同

配置maven成功的标志: 命令行输入 `mvn -v` , 可以显示内容

![image-20211013224837043](https://gitee.com/four_four/picgo/raw/master/img/20211013224837.png) 



## 3. maven 的基本概念

### 3.1 仓库

仓库用于存储资源, 包含各种jar包

#### 3.1.1 仓库的分类

1. ==中央仓库==  : maven的开发团队维护的仓库, 包含世界绝大多数的jar包
2. ==本地仓库== : 保存本地的jar包
3. ==私服== : 私服是中央仓库的一个子集, 本地仓库可以从私服下载jar包, 也可以从中央仓库下载
   从私服下载jar包**更快更方便** , 同时可以**保存具有产权的资源**, 包含购买或自主研发的jar包

#### 3.1.2 maven中央仓库地址

https://mvnrepository.com/

### 3.2 坐标

1. 什么是坐标
   + maven中的坐标用于秒速仓库中资源的位置, 方便maven查找资源
   + 坐标是给maven看的, 而不是给人看的
2. maven坐标的组成部分
   + `groupId` : 定义当前maven目录**隶属组织名称**(通常是域名反写, 如:`org.mybatis`) 
   + `artifactId` : 定义当前maven的**项目名称** (通常是模块名称)
   + `version` : 定义当前项目版本号

![image-20211013230528365](https://gitee.com/four_four/picgo/raw/master/img/20211013230528.png) 

3. maven坐标的作用
   使用唯一标识, **唯一性定位资源位置**, 通过该标识可以将**资源的识别和下载**工作交由**机器**完成

