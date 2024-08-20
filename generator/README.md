Freemarker 基本数据类型
## 一 数据类型简介

freemarker 模板中的数据类型由如下几种：

1. 布尔型：等价于java中的boolean类型， 不同的是不能直接输出，可以转换成字符串再输出
2. 日期型：等价于java中的Date类型， 不同之处在于不能直接输出，需要转换成字符串再输出
3. 数值型：等价于java 中的int, float, double 等数值类型，有三种显示形式：数值型(默认) 、货币型、百分比型
4. 字符串型：等价于java 中的字符串，有很多内置函数
5. sequence 类型：等价于java中的数组，list，set 等集合类型
6. hash 类型：等价于java 中的Map 类型

## 二、 数据类型示例
### 【1. 布尔型】：
1. 不能直接输出布尔型的值， 必须转换为string：${b?string}
2. 在if标签中可以直接使用
```
<#if b>
b 的值为 true
</#if>
```

### 【2. 日期型】
1. 输出日期：${currentDate?date}
2. 只输出时间：${currentDate?time}
3. 输出日期时间：${currentDate?datetime}
4. 格式化日期： ${currentDate?string('yyyy-MM-dd HH:mm:ss:S')}


### 【3. 数值型】：
- 2.1 Freemarker 中预定义了三种数字格式，货币，百分比，数字，默认为数字格式
  - 货币：：${0.3?string.currency}
  - 百分比：${0.3?string.percent}
  - 数字（默认）：${0.3?string.number}
- 2.2 取整
  - 1. 向上取整
``` 
3.4     --> ${3.4?ceiling}
3.5     --> ${3.5?ceiling}
  ```
  - 2. 向下取整
```
3.4     --> ${3.4?floor}
3.5     --> ${3.5?floor}
```

  - 3. 四舍五入
```
3.4     --> ${3.4?round}
3.5     --> ${3.5?round}
```

- 2.3 数字格式化， 使用0 表示不够 由0 补齐， 用# 表示不够不补齐
    - 1. 保留两位小数: 必须两位，不够补0, 当前一位为偶数时，五舍六入， 当前一位为基数时，四舍五入
    ```
    0.135   -- > ${0.135?string('.00')}
    0.125   -- > ${0.125?string('.00')}
    0.1     -- > ${0.1?string('.00')}
     ```
    - 2. 保留两位小数: 最多两位，不够不补0, 当前一位为偶数时，五舍六入， 当前一位为基数时，四舍五入
```
0.135   -- > ${0.135?string('#.##')}
0.125   -- > ${0.125?string('#.##')}
0.1     -- > ${0.1?string('#.##')}
```

  - 3. 格式化整数， 用0 表示必须三位整数，不够由0 补齐
```
12.1   -- > ${12.1?string('000.00')}
12.125 -- > ${12.125?string('000.00')}
12.135 -- > ${12.135?string('000.00')}
 ```

  - 4. 格式化整数， 用0 表示必须三位整数，不够由0 补齐, 一个# 和 多个# 是一样的
```
12.1   -- > ${12.1?string('#.00')}
12.125 -- > ${12.125?string('#.00')}
12.135 -- > ${12.135?string('#.00')}
```

  5. 千位分割
``` 
123456789 --> ${123456789?string(',###')}
123456789 --> ${123456789?string(',####')}
```

  - 2.4 数字转换成字符串：
  数字转换成字符串后，就可以直接用字符串的内置函数了
``` 
1234     -- > ${123?string}
1234    -- > ${123?string[0]}
<#--  ${123[2]} 报错 -->
```

- 【4. 字符串型】
  - 4.1  截取字符串subString(start,end):"hello,wold"
    - 1. 截取6~end: ${"hello,wold"?substring(6)}
    - 2. 截取0~5: ${"Hello,World"?substring(0,5)}

  - 4.2  字母大小写转换
    - 1. 首个单词的首字母大写: ${"hello world"?cap_first}
    - 2. 首个单词的首个字母母小写: ${"Hello World"?uncap_first}
    - 3. 所有单词首字母大写：${"hello world"?capitalize}
    - 4. 字符串大写： ${"hello,world"?upper_case}
    - 5. 字符串小写：${"hello,world"?lower_case}
        
  - 4.3 判断是否以xxx 结尾
``` 
${"hello,world"?ends_with("world")?string}    

- <#if "hello,world"?ends_with("world")>
  hello,world 以字符串 world 结尾
</#if>
```
  - 4.4 判断是否以xxx 开头
```
${"hello,world"?starts_with("hello")?string}

<#if "hello,world"?starts_with("hello")>
 hello,world 以字符串 hello 开头
</#if>
```
           
 - 4.5  返回字符串长度
```
${"hello,world"?length}
```
    
 - 4.6 是否包含子串
        1. 返回为布尔值，布尔值不能直接输出，必须转换为string
            ${"hello,world"?contains("llo")?string};
        2. <#if "hello,world"?contains("llo")>
                "hello,world" 包含子串 "llo"
           </#if>
           
 - 4.7 去除首尾空格
        字符串：${"   hello,world   "?trim}
        
 - 4.8 替换字符串
        ${"hello,world"?replace("o","0")}
    
 - 4.9 查询字符串第一次出现的索引位置，如果不存在返回0
        ${"hello,world"?index_of("o")}
        ${"hello,world"?index_of("aaa")}
    
 - 4.10  字符串分割数组
``` 
<#assign citys="beijing,tianjin,shanghai"?split(",")/>
<#list citys as city>
    ${city_index} --> ${city}
</#list>
```

 - 4.11 输出单个字母
``` 
 ${"hello"[0]}
```

- 【5. sequence】

    1. 获取第一个元素:sequence?first
           array: ${cityArray?first}
           list: ${cityList?first}
           set: ${citySet?first}
          
       2. 获取最后一个元素：sequence?last
           array: ${cityArray?last}
           list: ${cityList?last}
           set: ${citySet?last}
           
       3. 返回sequence 的大小sequence?size
           array: ${cityArray?size}
           list: ${cityList?size}
           set: ${citySet?size}
           
       4. 排序：sequence?sort
           4.1 sequence 元素为基本元素时（能转换为String的元素，非sequence 和  hash 元素）
               array:sort,reverse
                       正    序：<#list cityArray as city>${city},</#list>
                       倒    序：<#list cityArray?reverse as city>${city},</#list>
                       升    序：<#list cityArray?sort as city>${city},</#list>
                       降    序：<#list cityArray?sort?reverse as city>${city},</#list>
               list:sort,reverse
                       正    序：<#list cityList as city>${city},</#list>
                       倒    序：<#list cityList?reverse as city>${city},</#list>
                       升    序：<#list cityList?sort as city>${city},</#list>
                       降    序：<#list cityList?sort?reverse as city>${city},</#list>
               set:sort,reverse
                       正    序：<#list citySet as city>${city},</#list>
                       倒    序：<#list citySet?reverse as city>${city},</#list>
                       升    序：<#list citySet?sort as city>${city},</#list>

                       降    序：<#list citySet?sort?reverse as city>${city},</#list>

           4.2 sequence 元素为JavaBean时
               正    序：
                   <#list department.employees as employee>
                    ${employee_index} --> ${employee.name} --> ${employee.age}  --> ${employee.sex}
                </#list>
            逆    序：
                   <#list department.employees?reverse as employee>
                    ${employee_index} --> ${employee.name} --> ${employee.age}  --> ${employee.sex}
                </#list>
               按name属性升序：
                   <#list department.employees?sort_by("name") as employee>
                    ${employee_index} --> ${employee.name} --> ${employee.age}  --> ${employee.sex}
                </#list>
            按name属性降序:
                <#list department.employees?sort_by("name")?reverse as employee>
                    ${employee_index} --> ${employee.name} --> ${employee.age}  --> ${employee.sex}
                </#list>
           
- 5. 遍历sequence, 包含索引值
           array:    <#list cityArray as city>
                       ${city_index} --> ${city}
                   </#list>
           list:    <#list cityList as city>
                       ${city_index} --> ${city}
                   </#list>
           set:    <#list citySet as city>
                       ${city_index} --> ${city}

                   </#list>

- 6. 根据索引获取sequence 元素
           array: ${cityArray[0]}
           list: ${cityList[0]}
           set:  ${citySet[0]}

【6. map 类型】

    1. map长度：${cityMap?size};

 

    2. map的keys:cityMap.keys 返回的是一个sequence,类似于数组，所以不能直接输出，需要遍历
        <#assign mapKeys=cityMap?keys/>
        <#list mapKeys as mapKey>
            ${mapKey}

        </#list>

    3. map的values: cityMap.values 返回的是一个sequence,类似于数组，所以不能直接输出，需要遍历
        <#assign mapValues=cityMap?values/>
        <#list mapValues as mapValue>
            ${mapValue}

        </#list>

    4. 遍历map 元素： map 通过key获取value的方法用[]
        <#list cityMap?keys as  key>
            ${key_index} --> ${key} --> ${cityMap[key]}
        </#list>

【7. JavaBean 类型】
1. 获取属性：
``` 
${department.id} --> ${department.name}
```
2. 级联属性：
```
${department.employees[0].name} --> ${department.employees[0].age} --> ${department.employees[0].sex}
```
3. 遍历数组：
``` 
<#list department.employees as employee>
${employee_index} --> ${employee.name} --> ${employee.age}  --> ${employee.sex}
</#list>
```
4. 排序
``` 
<#list department.employees?sort_by("name") as employee>
${employee_index} --> ${employee.name} --> ${employee.age}  --> ${employee.sex}
</#list>
```