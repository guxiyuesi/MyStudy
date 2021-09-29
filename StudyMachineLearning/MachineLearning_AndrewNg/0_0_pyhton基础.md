# Python 基础回顾

## 1. 组合数据类型

### 1.1 列表

```python
'''
list 简介:
    list 是有序的, 可以通过下标访问
    列表中支持多种类型, 包括基础数据类型, 组合数据类型等
    数据操作支持: 增删改查
    可以看作是加强版的数组
'''
# 创建list
# 1. 直接定义list
ls = []
# 2. 通过list(可跌倒对象)
ls = list("hello")  # ['h', 'e', 'l', 'l', 'o']
ls = list((1, 2, 3))  # [1, 2, 3]
ls = list({"a": 3, "b": 2})  # ['a', 'b']
ls = list(range(1, 5, 2))  # [1, 3]
# 3. 通过其他对象的方法将该对象转成list
ls = "hello world".split(" ")  # ['hello', 'world']

ls = ['a', 'b', 'c', 'd']
# list访问, 正向从0开始, 反向从-1开始
ls[0]  # 'a'
ls[-1]  # 'd'

# list切片
# 起始位置:终止位置:步长
# 包含起始位置, 不包含终止位置
t = ls[1:3:1]  # [b, c]

# 对list的操作
# 1 增
# 1.1 append(待增数据) 增加到list末尾
# 1.2 index(下标, 待增数据) 增加到list的指定位置前
ls.append('e')  # ['a', 'b', 'c', 'd', 'e']
ls.insert(-1, 1)  # ['a', 'b', 'c', 'd', 1, 'e']
# 1.3 将一个列表中的数据逐个添加到另一个列表末尾使用extend()函数
ls2 = [2, 3]
ls.extend(ls2)  # ['a', 'b', 'c', 'd', 1, 'e', 2, 3]

# 2 删
# 2.1 pop(下标) 根据下标删除
# 2.2 remove(元素) 根据内容删除, 删除第一次出现该内容的元素
ls.pop(-2)  # ['a', 'b', 'c', 'd', 1, 'e', 3]
ls.remove('d')  # ['a', 'b', 'c', 1, 'e', 3]
# 3 查
# index(元素) 根据元素查找下标
ls.index('a')  # 0

# 4 改 与java中数组的更改方式相同, 不多赘述

# 5 复制 浅拷贝 列表.copy()
t = ls.copy()
# 6 排序
# 6.1 永久排序, ls的顺序改变 列表.sort() 默认递增排序
ls.sort(reverse=True)   # 递减排序
# 6.2 临时排序, ls的顺序不变 sorted()函数 默认递增排序
t = sorted(ls, reverse=True)

# 7 列表翻转 列表永久翻转
ls.reverse()
```



### 1.2 元组

==不可变 的列表, 不支持增删改== , 其他与列表无异 

元组常用于==打包和解包== 

```python
# 返回多个值时自动打包为元组
def test(a, b):
    return a**2, b**2


# 解包元组
a, b = test(2, 3)   # 4, 9


# 对应打包
num = [1913100111, 1913100112, 1913100113]
name = ['张三', '李四', '王五']
stu = list(zip(num, name))
# [(1913100111, '张三'), (1913100112, '李四'), (1913100113, '王五')]

```



### 1.3 字典

==key-value的集合== 

```python
# 字典
# 无序, 通过key访问value
# key不能重复, 且key为不可变类型(数字, 字符串, 元组)

# 创建字典
dic = {"a": 1, "b": 2, "c": 3}
# 获取字典长度 len()函数
len(dic)        # 3
# 访问字典元素
dic["a"]        # 1
# 增加键值对
dic["d"] = 4
# 删除键值对
del dic["a"]    # 这里也可以使用 del(dic["a"])
# 删除键值对并获取删除的值
val = dic.pop("c")
# 随机删除一个键值对, 并以元组的方式返回键值对
val = dic.popitem()
# 获取指定键的值; 如果字典中无该键, 返回指定值
print(dic.get('a', 'no this key'))      # no this key
print(dic.get('b', 'no this key'))      # 2

# 获取字典中的键列表和值列表
key_ls = dic.keys()
value_ls = dic.values()
# 获取字典中的 key-value 元组
tup = dic.items()
```



### 1.4 集合

==只有键的字典== , 等同于数学上的集合

适用的操作: `&` 交, `|` 并, `^` 对称差, `-` 差

移除元素适用 `remove(元素)` 方法

其他与字典类似



## 2. 函数



```python
# 函数的定义 与java相比
# 参数: 参数不需要指定类型, 参数的类别更多样
# 返回值: 不需要指定返回值, 直接使用def
# 函数名, 函数体: 与java无差别


# 参数
# 1. 位置参数
# 严格按照参数顺序, 用实参对形参进行赋值
# 实参与形参一一对应
def f(a, b, c):
    return a+b+c
f(1, 2, 3)

# 2. 关键词参数
# 通过调用时指定参数的名称来赋值
# 实参与形参的顺序不必一一对应
# 但传递的参数数量必须相等, 且位置参数在关键词参数前
# 同一形参不能重复赋值
f(b=2, c=1, a=3)
f(1, c=3, b=2)

# 3. 默认参数
# 调用时可以不传参
# 默认参数必须在非默认参数后
# 位置参数必须在默认参数的前面
# 默认参数应当设置为不可变类型
def ff(a, b, c, d=3):
    return a+b+c+d
ff(1, c=3, b=2)

# 让参数变成可选的
def fff(a, b, c, d=None):
    if d:
        return a+b+c+d
    else:
        return a+b+c
    
fff(1, 2, 3, 4)
fff(1, 2, 3)

# 4. 可边长参数
# 当不知道参数有多少个时, 对于多出来的参数, 使用*args
# *args 必须放在所有参数的最后
def ffff(a, b, c, *args):
    print(a, b, c)
    print(args)

ffff(1, 2, 3, 4, 5, 6, 7)
ffff(1, 2, 3, *[4, 5, 6])  # 实参打散, 打散的是列表, 字符串, 元组, 集合


# **kwargs 多余的参数以字典的形式打包传递给函数
def ts(a, b, c, **kwargs):
    print(a, b, c)
    print(kwargs)

ts(1, 2, 3, x=5, y=3, z=8)
ts(1, 2, 3, **{'x': 5, 'y': 3, 'z': 8})   # 字典实参打散


# 函数体内定义全局变量 global
global a


# 匿名函数, 常与key搭配
ls = [(1, 3), (5, 2), (3, 8), (2, 1)]
ls.sort(key=lambda x: x[1])  # 对列表中的元组, 以第二个值为标准排序

```



## 3. 类

### 3.1 类的创建与实例化

```python
'''
与java不同, python定义类时, 类名后要跟 ()
使用 : 标识类定义的开始
没有 {}, 缩近标识类的结束
'''


class Cat():
    # 类属性 相当于java中类的静态属性
    # 被类的多个实例共享, 可以使用类.属性的形式访问
    sex = 'male'

    # 在 __init__ 中定义并初始化实例属性
    # 实例属性只有某一个实例能使用, 其他实例不能使用, 相当于java的类属性
    # 与java不同的是, python并没有单列出属性
    # 定义时self必须有, 其他的按需求, 相当于属性和构造器的集合
    # 只能有一个__init__ 函数, 当部分参数允许不传递时, 则设定默认值
    def __init__(self, name, height, weight=2):
        self.name = name  # 共有实例属性, 可以使用 实例对象.name 访问, 相当于java中的public
        self._height = height  # 私有实例属性,但是依然可以用 实例对象._height 访问
        self.__weight = 2  # 私有实例属性, 不能使用 实例对象.__weight访问,  相当于java中的private

    # 定义方法, 类中的方法必须传递self参数, 其他按需传
    # 其他与定义函数方法无差
    def jump(self):
        # python中的格式化输出是在字符串中需要传递参数的位置写成 {}
        # 然后字符串调用 format() 方法, format()方法中传递的值就是字符串中需要的参数
        print("{} is jumping".format(self.name))

    # 可以返回任意类型
    def getWeight(self):
        return self.__weight


# 相当于main函数入口
if __name__ == '__main__':
    # 创建类的实例, 不需要new, 只需要传递对应参数即可
    # 某个参数如果有默认值, 则可以不传入参数
    my_cat = Cat("a", 3)
    my_cat.jump()
    # 这里如果用my_cat.__weight 会报错
    print("{}'s weight is {}".format(my_cat.name, my_cat.getWeight()))

    print(Cat.sex)
```

### 3.2 类的继承

```python
# 父类
class Car():
    def __init__(self, name, money, size=4):
        self.name = name
        self._money = money
        self.__size = size

    def get_money(self):
        print("{}:{}".format(self.name, self._money))

    def get_size(self):
        print(self.__size)


# 子类继承父类的格式:
# class 子类名(父类名):
# __init__() 函数中 第一行是 super().__init__(父类的参数)
# 继承时自动继承父类所有的属性和方法
# 私有属性也可以继承, 但是不能通过子类的方法访问
# 只有父类的方法才可以访问
# 子类独有属性/方法的添加, 父类方法的重写与java无异
# 如果子类重写父类方法, 则子类对象调用子类重写的方法
# python本身就是弱类型语言, 不存在父类引用指向子类对象
class EleCar(Car):
    def __init__(self, name, money, size=4):
        super().__init__(name, money, size=size)

    '''
    def get_size(self):
        print(self.__size)
    如果重写这个方法, 则会报错, 因为子类不能访问父类的私有属性
    '''


if __name__ == "__main__":
    ec = EleCar("a", 10000, 5)
    ec.get_money()
    ec.get_size()
```



## 4. 文件

### 4.1 通用文件操作

```python
# 文件操作
# 1. 文件的打开
# 1.1 通用格式: 使用with 好处: 结束后自动close
# with open("文件路径", "打开模式", encoding="编码方式") as 变量名:
#     对文件的操作
with open("../test.txt", "a+", encoding="utf-8") as fi:
    text = fi.readline()
    print(text)

'''
文件路径:
    如果文件和程序在同一目录下, 则可以直接使用文件名
    在其他路径时, 最好使用相对路径
    ./ 当前目录
    ../ 上一级目录
'''

# 对文件的读取
# readline()  每次只读取一行
# readlines()  读取所有行形成一个列表
# 也可以通过对 fi 的迭代读取每一行
#   for i in fi:    这样每一次读取的也是一行

# 写入文件
# 使用的方法 write() 方法
# 写入的方式依据打开模式而决定
# w  覆盖写, a 追加写
# writelines() 将一个列表一次性写入文件

# 既读又写
'''
r+ 
    如果文件名不存在, 则报错
    文件指针指在最开始
    写入时写到文件指针所指向的位置
    f.seek(偏移字节数, 位置) 来调整文件指针
    位置可选的值: 0 开头; 1 当前位置; 2 结尾

w+
    如果文件不存在, 创建文件
    如果文件存在, 清空文件内容

a+ 
    如果指针不存在, 创建文件
    如果指针存在, 文件指针在最后
'''
```



### 4.2 csv文件

```python
# csv文件的读写

# 读
# 重点: 1. 去掉\n符号   2. 将 "," 替换成 ""
with open("grade.csv", "r", encoding="utf-8") as f:
    ls = []
    for line in f:
        ls.append(line.replace("\n", "").split(","))

    print(ls)

# 写
# 重点: 每一个列表中的元素之间需要加逗号, 末尾加 \n
ls = [["无花果", "78"], ["水蜜桃", "88"]]
with open("grade.csv", "a", encoding="utf-8") as f:
    for row in ls:
        f.write(",".join(row) + "\n")
```



### 4.3 json文件

```python
import json

# 写入: 使用json模块中的dump方法
score = {"张三": {"chinese": 78, "math": 80},
         "李四": {"chinese": 80, "math": 66},
         "王五": {"chinese": 58, "math": 59}}
with open("grade.json", "w", encoding="utf-8") as f:
    # score 要写入的字典
    # f 文件指针
    # indent 缩近
    # ensure_ascii 是否显示中文
    json.dump(score, f, indent=4, ensure_ascii=False)

# 读取: 使用json模块中的load方法
with open("grade.json", "r", encoding="utf-8") as f:
    score = json.load(f)    # 读取整个对象
    for k, v in score.items():
        print(k, v)

```





## 5. 异常

```python
# 异常
# python中的异常与java差别不大, 只是catch换成了except
# 抛出的异常名不同, 但是可以使用万能异常Exception
# 使用Exception时可以使用as捕捉异常, 使异常实例化为对象, 可输出
x = 10
y = 0
try:
    z = x / y
# 也可以使用 except Exception:
except ZeroDivisionError:
    print("除数不能为0!")
except Exception as e:
    print(e)
finally:
    print("hello world!")

```





## 6. 标准库

### 6.1 time库

#### 6.1.1 导入time库

```python
import time as ti
```

####6.1.2 获取现在时间

```python
time.localtime()  # 本地事件
time.gmtime()	# UTC世界同一时间
time.ctime()	# 返回本地时间的字符串
```

#### 6.1.3 时间戳

```python
time.time()		# 返回自计院以来的秒数, 记录sleep
time.perf_counter()		# 随意选取一个时间点, 记录现在时间到该时间的间隔秒数, 记录sleep
time.process_time()		# 同 time.perf_counter() 类似, 但是不记录sleep
```

#### 6.1.4 格式化输出

```python
lctime = time.localtime()
time.strftime("%Y-%m-%d %A %H:%M:%S", lctime)
```

#### 6.1.5 线程休眠

```python
time.sleep()    # 单位是秒, java是毫秒
```



### 6.2 Random库

随机数的产生取决于随机种子

#### 6.2.1 设置随机种子

种子相同, 随机数相同; 如果不设置种子, 默认以系统当前时间作为种子

```python
import random as rm
rm.seed(1)
```

#### 6.2.2 产生随机整数

```python
# 产生1 - 10 之间的随机数
ls = [rm.randint(1, 10) for i in range(10)]
# [2, 5, 2, 8, 8, 8, 7, 4, 2, 8]

# 产生0-10之间的随机数
ls = [rm.randrange(10) for i in range(10)]
# [8, 7, 6, 2, 6, 1, 0, 0, 1, 8]

# 产生1-10之间步长为2的随机数
ls = [rm.randrange(1, 10, 2) for i in range(10)]
# [1, 7, 5, 1, 3, 9, 7, 5, 7, 5]
```

#### 6.2.3 产生随机浮点数

```python
# 产生(0.0 , 1.0) 之间的随机浮点数
ls = [rm.random() for i in range(10)]
# 产生[a, b]之间的随机浮点数
ls = [rm.uniform(2.1, 3.5) for i in range(10)]
```



#### 6.2.4 序列用函数

```python
# 从列表中随机选取一个
rm.choice(['hello', 'world', '!'])
# choices(seq, weights=None, k)
# 对列表类型进行k次采样, 可以设置权重
rm.choices(['hello', 'world', '!'], [4, 4, 2], k = 10)
# shuffle(seq) 将序列随机打乱, 返回打乱后的序列
ls = rm.shuffle(['hello', 'world', '!'])
# sample(seq, k) 从序列中选取k个不重复元素元素, k <= 元素长度
```

#### 6.4.5 概率分布

```python
# gauss(mean, std) 产生一个符合高斯分布的随机数
num = gauss(0, 1)
```



### 6.3 Collections库

容器数据类型

#### 6.3.1 namedtuple 具名元组

可以看成是给元组一个有意义的名字

```python
# 点的坐标
# typename 元组名, field_names 域名
# collections.namedtuple(typename, field_names)
Point = collections.namedtuple("Point", ["x", "y"])
p = Point(1, y=2)
print(p)		 # Point(x=1, y=2)
# 可以调用属性
print(p.x)
# 有元组的属性
x, y = p		# 解包
print(p[0])		# 下标访问
```

```python
import collections as col
import random as rm

# 生成扑克牌
# 具有元组 元组名: Card  元组属性: rank 数   suit 花色
C = col.namedtuple("Card", ["rank", "suit"])
ls_rank = [str(i) for i in range(2, 11)] + list("JQKA")     # 生成扑克牌中的数
ls_suit = "spades diamonds clubs hearts".split(" ")         # 生成扑克牌中的花色
cards = [C(rank, suit) for rank in ls_rank                  # 对应生成不同花色的扑克牌
         for suit in ls_suit]                                             # 打印扑克牌

# 随机抽取一张牌
rm.choice(cards)
# 打乱扑克牌
rm.shuffle(cards)
# 随机抽取k张牌
ls_selected = rm.sample(cards, 5)
```

#### 6.3.2 计数器

计数器是字典的一个子类

```python
# 计数
s = "The world is beautiful"
s_counter = collections.Counter(s)
# Counter({' ': 3, 'e': 2, 'l': 2, 'i': 2, 'u': 2, 'T': 1, 'h': 1, 'w': 1, 'o': 1, 'r': 1, 'd': 1, 's': 1, 'b': 1, 'a': 1, 't': 1, 'f': 1})

ls = ["blue", "blue", "red"]
ls_counter = collections.Counter(ls)
# Counter({'blue': 2, 'red': 1})

# 常见统计 most_common(n) 最常出现的前n个
ls_counter.most_commin(3)
# [(' ', 3), ('e', 2), ('l', 2)]

# 元素展开
list(ls_counter.elements())

# 加减操作
c1 = collections.Counter(a=3, b=4)
c2 = collections.Counter(a=1, b=1)
print(c1+c2)
# Counter({'b': 5, 'a': 4})
```



#### 6.3.3 deque 双向队列

可以很方便的在队列的两端高效快速的增加和删除

 ```python
import collections as col

d = col.deque("e")    # ['e']
d.appendleft("d")     # ['d', 'e']
d.extendleft(list(reversed("abc")))  # ['a', 'b', 'c', 'd', 'e']
d.append("f")  # ['a', 'b', 'c', 'd', 'e', 'f']
d.extend(list("ghi"))  # ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i']
d.pop()  # ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
d.popleft()  # ['b', 'c', 'd', 'e', 'f', 'g', 'h']
d.remove("d")  # ['b', 'c', 'e', 'f', 'g', 'h']
d.insert(2, "d")  # ['b', 'c', 'd', 'e', 'f', 'g', 'h']

 ```



### 6.4 itertools 库 迭代器

#### 6.4.1 排列组合迭代器

1. `product`   笛卡尔积

   ```python
   ls = list(itertools.product("ab", "01"))
   print(ls)
   ls = list(itertools.product("ab", repeat=2))
   print(ls)
   # [('a', '0'), ('a', '1'), ('b', '0'), ('b', '1')]
   # [('a', 'a'), ('a', 'b'), ('b', 'a'), ('b', 'b')]
   ```

2. `permutations` 排列

   ```python
   # 三个选2个排列
   ls = list(itertools.permutations("ABC", 2))
   print(ls)
   # 全排列
   ls = list(itertools.permutations(range(3)))
   print(ls)
   # [('A', 'B'), ('A', 'C'), ('B', 'A'), ('B', 'C'), ('C', 'A'), ('C', 'B')]
   # [(0, 1, 2), (0, 2, 1), (1, 0, 2), (1, 2, 0), (2, 0, 1), (2, 1, 0)]
   ```

3. `combinations` 组合

   ```python
   ls = list(itertools.combinations("ABC", 2))
   print(ls)
   ls = list(itertools.combinations(range(3), 2))
   print(ls)
   # [('A', 'B'), ('A', 'C'), ('B', 'C')]
   # [(0, 1), (0, 2), (1, 2)]
   ```

4. `combinations_with_replacement` 可重复组合

   ```python
   ls=list(itertools.combinations_with_replacement("ABC", 2))
   print(ls)
   ls=list(itertools.combinations_with_replacement(range(3), 2))
   print(ls)
   # [('A', 'A'), ('A', 'B'), ('A', 'C'), ('B', 'B'), ('B', 'C'), ('C', 'C')]
   # [(0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2)]
   ```

   

#### 6.4.2 拉链

1. 短拉链
   组合多个可迭代对象的元素, 将相同位置放入同一元组中; 长度不一时, 执行到最短的对象处停止

   ```python
   ls = list(zip("ABC", "xyz", ['1', '2', '3', '4']))
   print(ls)
   # [('A', 'x', '1'), ('B', 'y', '2'), ('C', 'z', '3')]
   ```

2. zip_longest 长拉链      长度不一时, 执行到最长的对象处停止, 缺省元素用`None` 或指定字符替代

   ```python
   ls = list(itertools.zip_longest("ABC", "xyz", ['1', '2', '3', '4'], fillvalue="?"))
   print(ls)
   # [('A', 'x', '1'), ('B', 'y', '2'), ('C', 'z', '3'), ('?', '?', '4')]
   ```

   

#### 6.4.3 无穷迭代器

1. 计数  `count(start, step)` 
   从start开始, 不断以step长度迭代

   ```python
   for i in itertools.count(5, 2):
       print(i)
       time.sleep(1)
   ```

2. 循环 `cycle(iterable)` 
   创建一个迭代器, 返回iterable中所有元素, 无限循环

   ```python
   for i in itertools.cycle("abc"):
       print(i)
       time.sleep(1)
   ```

3. 重复 `repeat(object, [times])` 
   不断迭代返回object直到次数达到times, 否则无限重复

   ```python
   for i in itertools.repeat("abc", 10):
       print(i)
       time.sleep(1)
   ```

   

#### 6.4.4 其他

1. `chain(iterables)` 锁链
   将多个迭代器==串联== 起来, 形成一个更大的迭代器 

   ```python
   ls = list(itertools.chain("abc", [1, 2, 3]))
   print(ls)
   # ['a', 'b', 'c', 1, 2, 3]
   ```

2. `enumerate(iterable, start=0)` 枚举(Python内置)
   产出由==两个元素== 组成的 ==元组== , 结构: ==(index, item)== , 其中`index` 从 `start` 开始, `item` 从 `itertable` 中不断迭代取出

   ```python
   ls = list(enumerate("abcd", start=1))
   print(ls)
   # [(1, 'a'), (2, 'b'), (3, 'c'), (4, 'd')]
   ```

3. `groupby(iterable, key=None)` 分组
   创建一个迭代器, 按照key指定的方式, 返回 iterable 中连续的==键和组== 
   一般来说, 要预先对数据进行排序
   key为None时默认吧连续重复元素分组

   ```python
   for key, group in itertools.groupby("AAABBBBBBBCCCCCCCC"):
       print(key, list(group))
   '''
   A ['A', 'A', 'A']
   B ['B', 'B', 'B', 'B', 'B', 'B', 'B']
   C ['C', 'C', 'C', 'C', 'C', 'C', 'C', 'C']
   '''
   ```

   ```python
   ls = ["hello", "world", "first", "second", "one", "two", "four"]
   ls.sort(key=len, reverse=False)	# 按照每个元素的长度排序
   for key, group in itertools.groupby(ls, key=len):	# 按照每个元素的长度来分组, 长度一样为一组
       print(key, list(group))
   '''
   3 ['one', 'two']
   4 ['four']
   5 ['hello', 'world', 'first']
   6 ['second']
   '''
   ```
   
   ```python
   # 按首字母分组
   ls = ["hello", "world", "first", "second", "one", "two", "four"]
   ls.sort(key=lambda x: x[1], reverse=False)
   for key, group in itertools.groupby(ls, key=lambda x: x[1]):
       print(key, list(group))
   '''
   e ['hello', 'second']
   i ['first']
   n ['one']
   o ['world', 'four']
   w ['two']
   '''
   ```
   
   