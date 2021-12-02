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

## 4. maven仓库的配置

### 4.1 本地仓库

#### 4.1.1 maven自己配置的仓库地址

运行命令行 -> 输入`mvn`  

点击`C盘` -> `用户` -> `本地的用户名` -> `.m2` 就是生成的本地仓库

即:默认位置

```xml
<localRepository>${user.home}/.m2/repository</localRepository>
```



#### 4.1.2 自己配置仓库地址

找到maven的安装目录 -> `conf` -> `settings.xml` -> 加入以下语句:

```xml
<localRepository>E:\web_soft\maven\repository</localRepository>
```



### 4.2 远程仓库

### 4.2.1 查找远程仓库的位置

maven安装位置 -> `lib` -> `maven-model-builder-3.8.3.jar` -> `org` -> `apache` -> `maven` -> `model` -> `pom-4.0.0.xml` -> 打开该文件即可看到中央仓库位置

```xml
<repositories>
    <repository>
        <id>central</id>
        <name>Central Repository</name>
        <url>https://repo.maven.apache.org/maven2</url>
        <layout>default</layout>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```

#### 4.2.2 配置镜像仓库

`conf` -> `seeting.xml` -> 写入镜像文件配置

```xml
<mirrors>
    <!-- 配置具体的仓库的下载镜像 -->
    <mirror>
        <!-- 此镜像的唯一标识符, 用来区分不同的mirror元素 -->
        <id>aliyunmaven</id>
        <!-- 对哪种仓库进行镜像, 简单说就是替代哪个仓库 -->
        <mirrorOf>central</mirrorOf>
        <!-- 镜像名称  可以没有 -->
        <name>阿里云公共仓库</name>
        <!-- 镜像URL -->
        <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
</mirrors>
```

### 4.3 全局setting和用户setting

在本地的`repository` 粘贴一个`setting.xml` 

局部setting会**覆盖** 全局setting



## 5. 手工构建mvn

### 5.1 maven的目录结构

![maven文件目录](https://gitee.com/four_four/picgo/raw/master/img/20211014213400.png)



### 5.2 maven构建命令

使用命令行构建命令, 需要进入到`pom.xml` 所在的文件层级

1. `mvn compile` 编译
   这一步骤第一次运行会下载所需的插件
   然后使用编译插件来编译源文件
2. `mvn clean` 删除编译后的文件
   这一步骤第一次运行也会下载所需的插件

3. `mvn test` 测试
   生成的测试报告 `target` -> `surefire-reports`
   程序的源代码的字节码 `target` -> `classes` -> .class文件
   测试程序的源代码的字节码 `target` -> `test-classes` -> .class文件
4. `mvn package` 只打包源程序
5. `mvn install` 把打包的文件放入到本地仓库