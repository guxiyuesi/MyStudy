## K-Means
启发式算法, 遵循的原则: **每次聚类保证局部最优, 随后调整聚类, 利用局部最优聚类的上限来不断逼近全局最优**

### K-Means计算步骤
![](https://gitee.com/four_four/picgo/raw/master/img/20211214225833.png)

### K-Means计算示例
![](https://gitee.com/four_four/picgo/raw/master/img/20211214225851.png)

### K-Means优点
![](https://gitee.com/four_four/picgo/raw/master/img/20211214225945.png)

### K-Means缺点
![](https://gitee.com/four_four/picgo/raw/master/img/20211214230006.png)

## K-Modes
解决离散型数据问题
### K-Modes算法基本思想
![](https://gitee.com/four_four/picgo/raw/master/img/20211214230223.png)

初始随机选择簇中心, 之后的簇中心用众数来代替
### K-Modes示例
![](https://gitee.com/four_four/picgo/raw/master/img/20211214230332.png)


![](https://gitee.com/four_four/picgo/raw/master/img/20211214230404.png)

## K-Means++
解决初始点选择问题

![](https://gitee.com/four_four/picgo/raw/master/img/20211214230445.png)

## K-中心点
解决对离群点敏感的问题