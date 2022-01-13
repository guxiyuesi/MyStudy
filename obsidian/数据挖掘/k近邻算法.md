## K近邻算法
### 算法思路
通过最近的K个数据对象的类别确定未知数据对象的类别

重点: 样例之间的距离度量

### 距离度量
明可夫斯基距离:
![](https://gitee.com/four_four/picgo/raw/master/img/20211214212412.png)

q=1时, 为**曼哈顿距离**
![](https://gitee.com/four_four/picgo/raw/master/img/20211214212438.png)

q=2时, 为 **欧几里得距离**
![](https://gitee.com/four_four/picgo/raw/master/img/20211214212500.png)

### 举例
![](https://gitee.com/four_four/picgo/raw/master/img/20211214212612.png)

![](https://gitee.com/four_four/picgo/raw/master/img/20211214212626.png)

![](https://gitee.com/four_four/picgo/raw/master/img/20211214212640.png)


### KNN算法注意的问题
1. K值的选择<br>k太小, 对噪声点敏感<br>k太大, 领域可能有很多其他类的点
2. 定标问题<br>属性需要进行规范化, 防止距离度量被具有很大值域的属性所左右
3. k值的选取
	+ 尽量选奇数
	+ 一般从k=1开始, 使用测试集估计分类的误差率, 重复该过程, 每次k+1, 最后选取产生最小误差率的k值
	+ k<=20
	+ k值最大值不超过数据集大小n的开方

### KNN的特点
![](https://gitee.com/four_four/picgo/raw/master/img/20211214213134.png)

### KNN算法与其他分类算法的区别
![](https://gitee.com/four_four/picgo/raw/master/img/20211214213156.png)
