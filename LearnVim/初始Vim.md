# 初始Vim
## 插入的几种模式
+ i **insert** 在光标位置前插入
+ a **append** 在光标位置后插入
+ o **open a line below** 在光标的下一行插入
+ I **insert before line** 在光标所在行的开头插入
+ O **open a line above** 在光标的上一行插入
+ A **append after line** 在光标所在行的末尾插入

## Vim 的几种模式
> normal模式

+ normal 模式下可以进行各种命令的操作和移动
+ 大部分情况下是在浏览而不是编辑, 因此Vim初始为normal模式

> insert模式

+ 与通用编辑器相同, 需要区分不同的插入模式
+ ESC  ->   normal模式

> command模式

+ normal模式下输入**:命令**即可执行命令
+ 常用命令:
	+ :set nu										设置行号
	+ :wq(written and quit)              保存并退出
	+ :vs(vertical split)	               	竖屏分割
	+ :sp(split)			                        横屏分割
	+ :d(delete)		                      	删除一整行
	+ d	                                		 	删除当前行和下一行
	+ u(undo)		                         	撤销
	+ ctrl+u                                        恢复撤销
	+ :syntax on			                   临时打开语法高亮
	+ :% s/hello/world/g    
	  %                                              表示整个文件
	  s    	                                       执行替换
	  /hello		                               \hello会被替换掉
	  /world		                             被替换成world
	  /g(global)	                           全局替换

> visual模式

1. normal模式下使用 ==v== 进入visual选择
2. 使用 ==v== 选择行
3. 使用  ==ctrl+v== 进行方块选择
4. 可以进行批量操作，如d删除选中字符，y复制选中字符

## 编辑小技巧

### 如何快速纠错

+ ==ctrl + h(char)==             删除光标前的一个字符
+ ==ctrl + w(word)==             删除光标所在位置前的一个单词
+ ==ctrl + u==       	     删除在当前行，光标位置前的所有字符

### 快速切换 normal 和 insert 模式

+ 使用 ==ctrl+[== 可以从insert模式快速退出到normal模式
+ 在normal模式下，可以使用 ==gi== 快速跳转到最后一次编辑的地方并进入插入模式

###  如何快速移动

> 普通移动

+ ==hjkl==   左 下 上 右

> 单词间移动

+ ==w/W==  移动到下一个word/WORD开头
+ ==e/E== 移动到下一个word/WORD结尾
+ word 以==非空白符==分割的单词，WORD 以==空白符==分割的单词

+ ==b/B==回到上一个word/WORD开头，可以理解为backword

> 行间搜索移动

+ 同一行快速移动的方式其实就是：==搜索一个字符并移动到该字符==
  + ==0== 快速移动到当前行的行首           
  + ==^==  移动到第一个非空白字符
  + =="number + \$"==    跳转到光标下number-1行的行尾    
    ==$==     移动到当前行的行尾     
    ==g_==    移动到行尾非空白字符
  + ==f+字符(find)/t+字符(until)==    找到光标后第一个该字符，移动到该字符前
    ;/,  移动到下一个 / 上一个该字符前
  + ==F+字符==	反过来搜索前面的字符

> vim垂直移动 

+ ==()== 在句子和段落之间移动

> vim页面移动

+ ==gg/G== 移动到文件开头/结尾     
  ==ctrl+o== 快速返回	Ss
+ ==H/M/L== 跳转到屏幕的开头 (Head), 中间(Middle), 末尾(Lower)
+ ==ctrl+u ctrl+f==  上下翻页 upword/forward			
  ==zz==把当前行置为屏幕中间

### 快速增删改查
#### 增
+ 通过不同的方式进入insert模式, 增加字符
#### 删
> insert模式下删除
+ ==ctrl+h== 回退一个字符
+ ==ctrl+w== 回退一个单词
> normal模式下删除
+ ==x== 删除一个字符
+ ==dw== (delete word)删除当前字符直到空格
+ ==daw== (delete around word)删除当前单词及后的一个空格
+ ==diw== 删除当前单词 
+ ==d$== 删除当前光标直到行末
+ ==d0== 删除当前光标直到行首
+ ==dt+字符== 删除当前光标直到字符
	+ dt) 删除括号内的内容
	+ dt" 删除引号内的内容
+ ==dd== 删除当前行
+ x dd前都可以加数字
	+ 4x 删除连续的4个字符
	+ 4dd 删除4行
> visual模式下删除
+ 选中后 ==d== 删除

#### 改
+ ==r(replace)==                将光标所在位置的字符替换掉
+ ==s(substidute)==             删除当前光标所在字符并进入插入模式	s可以配合数字使用
+ ==c(change)==			        文本对象替换
	+ ==cw==			        删除当前单词并进入插入模式
	+ ==ct+字符==(change to)    删除到字符
+ ==S==					        删除一整行并进入插入模式
+ ==R==                         持续替换下一位的字符	
+ ==C==                         删除一整行并进入插入模式


