# 1. Introduction

## 1.1 What is Machine Learning?

A computer program is said to learn from experience E with respect to some class of tasks T and performance measure P, if its performance at tasks in T, as measured by P, improves with experience E.

```
Example: playing checkers.

E = the experience of playing many games of checkers

T = the task of playing checkers.

P = the probability that the program will win the next game.
```

### 1.1.1 Type

1. Supervised Learning
2. UnSupervised Learning



## 1.2 Supervised Learning

In supervised learning, we are given a data set and **already know what our correct output shold look like** , having the idea that there is a relationship between the input and the output.

In supervised learning, we know **the features of the data set**, and based on the existing features of the data sets, the result of the new input can be obtained.

### 1.2.1 Type

1. regression
2. classification

### 1.2.2 Regression

In a regression problem, we are trying to predict results within a contionous output, meaning that we are trying to map input variables to some continuous function.

the number of inputs is large, the output values are **continuous**, we use **polynomial** to process the data set.



Example: 

Given data about the size of houses on the real estate market, try to predict their price. Price as a function of size is a continuous output, so this is a regression problem.

![image-20210911093203573](https://gitee.com/four_four/picgo/raw/master/img/20210911093203.png) 

###1.2.3 Classification

In a classification problem, we are trying to predict results within a discrete output, meaning that we are trying to map input variables into discrete categories. 

the number of input is large, but the output values are **discrete**, we use  **monomail** to process the data set.



Example:

Given a patient with a tumor, we have to predict whether the tumor is malignant or benign.

![image-20210911093420766](https://gitee.com/four_four/picgo/raw/master/img/20210911093420.png) 





## 1.3 Unsupervised Learning

Unsupervised Learning allows us to approach problems **with little or no idea** what our results should look like. We can derive structure from data where we don’t necessarily know the effort of the variables.

We can derive this structure by clustering the data **based on relationships** among the variables in the data.

With unsupervised learning there is on feedback based on the prediction results.

### 1.3.1 Type

1. Clustering
2. Non-Clustering:
   Cocktail Party Algorithm



### 1.3.2 Clustering

Given a data set, find a way to automatically group these genes into groups that are somehow similar or related by different variables.

![image-20210911121158089](https://gitee.com/four_four/picgo/raw/master/img/20210911121158.png)

### 1.3.3 Cocktail Party Algorithm

Cocktail Party Algorithm allows you to find structure in a chaotic environment.

use SVG algorithm.

SVG algorithm:

$[W, s, v]=svd((repmat(sum(x.^*x, 1), size(x, 1), 1).^*x)^*x')$



## 1.4 Difference from Supervised Learning and Unsupervised Learning

+ Supervised learning: Data sets are **labeled** and predictions have **correct answers**
+ Unsupervised learning: data sets have **no labels**, and algorithms automatically classify data sets

