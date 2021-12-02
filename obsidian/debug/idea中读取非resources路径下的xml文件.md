---
tags: idea xml
---
### idea中读取非resources路径下的xml文件
idea中默认只能读取resources路径下的xml文件, 因此如果想要读取java路径下的xml文件, 需要在pom.xml中进行配置
```xml
<build>
	<resources>  
	 	<resource>  
			<directory>src/main/java</directory>  
	 		<includes>  
	 			<include>**/*.xml</include>  
	 		</includes>  
		 </resource>  
	</resources>
</build>
```