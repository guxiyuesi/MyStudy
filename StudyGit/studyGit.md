# 1. studyGit

## 1.1 初始Git

> git分区

==工作区==    \=\=\=>    ==暂缓区==      \=\=\=>     ==本地库==  

+ 工作区:
  平时存放项目的地方
+ 暂存区:
  .git/index文件, 临时保存改动, 保存即将提交到文件列表信息
+ 本地库:
  ./git文件夹, 安全存放数据的位置, 保存所以提交的数据, 其中HEAD指向最新放入仓库的版本

## 1.2 基本命令

### 1.2.1 初始化

+ git init
  将对应文件夹初始化为本地git库(目录下添加.git文件夹)

### 1.2.2 查看状态

+ git status
  查看工作区, 暂缓区的状态

### 1.2.3 添加操作

+ git add [file name]         /     git add [folder name/]
  将工作区的内容添加到暂缓区
  + file name  添加单个文件
  + folder name/  将整个文件夹及目录下的文件全部添加到暂缓区
+ git add .
  将该目录下的所有文件全部提交

### 1.2.4 提交到本地库操作

+ git commit -m “commit message” [file name] / [folder name/]
  commit message部分不能为空, 否则会提交失败
+ git commit -a
  直接添加并提交到本地库

### 1.2.5 从暂缓区中撤销add

+ git rm --cached [file name]	

### 1.2.6 查看历史记录

> 打印全部信息

+ git log
  信息全面但过多

  ![image-20210630232500720](https://gitee.com/four_four/picgo/raw/master/img/20210630232507.png) 



> 1.2.7 打印简介信息

+ git log  --pretty=oneline 
  打印在一行

  ![image-20210630232855336](https://gitee.com/four_four/picgo/raw/master/img/20210630232855.png) 

+ git log --oneline
  更加简洁的打印历史
  ![image-20210630233131060](https://gitee.com/four_four/picgo/raw/master/img/20210630233131.png) 

> 1.2.8 打印HEAD&{num}信息

+ git reflog
  打印出 的`HEAD@{number}`   number为距离最新一次提交的距离  `HEAD@{0}` 指向最新一次提交

  最前面的 `fe198b1` 等十六进制为索引值
  ![image-20210630234523808](https://gitee.com/four_four/picgo/raw/master/img/20210630234523.png)  



### 1.2.9 前进/回退版本

> 基于索引值

+ git reset –hard [索引值]

  前进
  ![image-20210701000156091](https://gitee.com/four_four/picgo/raw/master/img/20210701000156.png) 

  后退
   ![image-20210701000423643](https://gitee.com/four_four/picgo/raw/master/img/20210701000423.png) 

> 基于 ^ 符号

+ git reset  --hard HEAD^
  ^可以有多个, 有几个^就代表后退几个版本
  只能后退不能前进
  ![image-20210701001055824](https://gitee.com/four_four/picgo/raw/master/img/20210701001055.png) 
  ![image-20210701001128744](https://gitee.com/four_four/picgo/raw/master/img/20210701001128.png) 

> 基于 ~ 符号

+ git reset --hard HEAD~\<number>
  number 指后退几步
  只能后退不能前进 

#### reset的三个参数

> \-\-soft

+ 只更改本地库, 暂缓区和工作区不发生更改
  ![image-20210701002602299](https://gitee.com/four_four/picgo/raw/master/img/20210701002602.png) 

> \-\-mixed

+ 更改本地库和暂缓区, 工作区不发生更改
  ![image-20210701002716481](https://gitee.com/four_four/picgo/raw/master/img/20210701002716.png) 

> \-\-hard

+ 全部都更改, 可以保证本地库, 暂缓区, 工作区版本的一致性
  ![image-20210701002812850](https://gitee.com/four_four/picgo/raw/master/img/20210701002812.png) 



### 1.2.10 删除后找回

> 工作区删除后找回

1. 先将工作区文件提交到本地库
2. 将工作区文件删除
3. 将删除记录添加到本地库中
4. 此后可以通过本地库回退版本来找回删除的文件

> 暂存区删除后找回

+ 删除记录只提交到暂缓区, 未提交到本地库时, 可以直接使用 `git reset --hard HEAD` 找回

> 小结

1. 前提: 删除前, 文件存在时的状态必须提交到本地库
2. 操作: git reset --hard [指针位置]



### 1.2.11 比较文件

+ git diff [file name]
  比较工作区中的file 和 本地库中的HEAD@{0}版本的不同
+ git diff [本地库中的历史版本] [filename]
  比较工作区中的file 和本地库中对应的历史版本的不同
+ git diff
  比较当前目录下所有file 和 HEAD@{0}版本的不同



### 1.2.12 分支

> 什么是分支

+ 在版本控制的过程中, 使用多条线同时推进多个任务

> 分支的好处

+ 同时并行推进多个功能开发, 提高开发效率
+ 各个分支在开发过程中, 如果某一个分支开发失败, 不会对其他分支有任何影响, 失败的分支删除重新开始即可

> 分支操作

+ git branch -v
  查看已有分支
  ![image-20210702235547939](https://gitee.com/four_four/picgo/raw/master/img/20210703113604.png)  

+ git branch [branch name]
  创建新分支
  ![image-20210703000008997](https://gitee.com/four_four/picgo/raw/master/img/20210703113604.png) 

  ![image-20210703000039103](https://gitee.com/four_four/picgo/raw/master/img/20210703113609.png) 

+ git checkout [branch name]

  切换分支名
  ![image-20210703000130852](https://gitee.com/four_four/picgo/raw/master/img/20210703113613.png) 

+ 合并分支

  1. 先切换到被合并的分支(即合并后会被修改的分支)
     git checkout [branch name]
     ![image-20210703000424779](https://gitee.com/four_four/picgo/raw/master/img/20210703113616.png) 
  2. 执行merge命令
     git merge [branch name]
     ![image-20210703000455109](https://gitee.com/four_four/picgo/raw/master/img/20210703113626.png) 

+ 解决冲突

  + 冲突的产生:
    ==合并的文件== 与 ==被合并的文件== 修改了同一个文件的相同的位置, 但是修改的内容不同

  + 冲突的表现:
    ![image-20210703002019942](https://gitee.com/four_four/picgo/raw/master/img/20210703002019.png) 

    ![image-20210703002234405](https://gitee.com/four_four/picgo/raw/master/img/20210703002234.png) 

  + 冲突解决
    删掉 ==特殊符号== 然后 将文件编辑到满意的程度
    然后重新add , commit 即可

> 注意

1. 新增/合并时, 本地库, 暂缓区, 工作区的文件状态会一并被复制新增/合并
2. 解决冲突时, 提交commit不能加文件名



## 1.3 git连接远程库

### 1.3.1 git在本地创建远程库地址别名

+ `git remote add [别名] [远程库地址]` 

### 1.3.2 查看已有的远程库地址别名

+ `git remote -v` 