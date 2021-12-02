---
tags: idea 数据库
---
### 时区冲突
测试时出现以下状况
Server returns invalid timezone. Go to 'Advanced' tab and set 'serverTimezone' property manually.
![](https://gitee.com/four_four/picgo/raw/master/img/20211121142239.png)

暂时性解决方案(只对当前项目有效):
Advanced -> serverTimezone 设置为 Asia/Shanghai


