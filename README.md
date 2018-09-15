# SimplePinyin
[![Travis](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](LICENSE)  

简单的、低内存占用的中文汉字转拼音库，支持多音字，基于[TinyPinyin](https://github.com/promeG/TinyPinyin)。  

## 使用

源代码和jar文件在[lib](lib)目录下。  

```java
 /**
  * 将输入字符串转为拼音，以字符为单位插入分隔符，多个拼音只取其中一个
  *
  * 例: "hello:中国！"  在separator为","时，输出： "H,E,L,L,O,:,Zhong,Guo,!"
  *
  * @param str        输入字符串
  * @param separator  分隔符
  * @return           中文转为拼音的字符串
  */
 Pinyin.toPinyin(String str, String separator):String
 
 /**
  * 将输入字符串转为拼音，以字符为单位插入分隔符，多个拼音只取其中一个
  *
  * @param str        输入字符串
  * @param separator  分隔符
  * @param caseType   大小写类型
  * @return           中文转为拼音的字符串
  */
 Pinyin.toPinyin(String str, String separator, int caseType):String
 
 // caseType取值:
  Pinyin.UP_CASE;        //全部大写
  Pinyin.FIRST_UP_CASE;  //首字母大写
  Pinyin.LOW_CASE;       //全部小写
 
 /**
  * 将输入字符转为拼音，支持多音字
  *
  * @param c  输入字符
  * @return   拼音字符串数组
  */
 Pinyin.toPinyin(char c):String[]
 
 /**
  * 将输入字符转为拼音，支持多音字
  *
  * @param c         输入字符
  * @param caseType  大小写类型
  * @return          拼音字符串数组
  */
 Pinyin.toPinyin(char c, int caseType):String[]
 
 /**
  * 判断输入字符是否为汉字
  *
  * @param c  输入字符
  * @return   是汉字返回非负数，反之返回负数
  */
 Pinyin.isChinese(char c):int
 
 /**
  * 删除小写字母
  *
  * @param firstUpCase  首字母大写的拼音
  * @return             拼音首字母
  */
 Pinyin.deleteLowerCase(String firstUpCase):String
 
```

## 说明

#### TinyPinyin的问题

1. 多音字处理基于词典，单字只能取得一个拼音；
2. 需要自定义大量词典，仅仅满足简单的需求的情况下中文汉字转拼音借助大量词典显得臃肿。  
   例如，使用T9或T26搜索方式来查找联系人时，搜索关键字只需匹配汉字的所有可能拼音即可，并不需要借助大量词典来确定该字的发音。

#### SimplePinyin的目的

1. 简化中文汉字转拼音的处理，单字直接返回所有可能的多个拼音；
2. 没有词典与分词，仅满足简单的需求。

#### 其他问题

1. 某些汉字的拼音并不被多数人所熟知，因此考虑加入多数人所熟知的拼音作为该字的多音来处理。  
   例如，汉字 `嗯` 的拼音是 `n` 和 `ng` ，但是一般拼音输入法是将 `en` 作为 `嗯` 的拼音，实际上 `嗯` 的拼音并不是 `en` ，但是如果输入法不这样做的话，将会有很大一部分人无法通过拼音输入得到 `嗯` 字。因此，考虑将 `en` 作为 `嗯` 的多音来处理。  
   目前暂未支持。如果大家发现了更多类似的字，欢迎在[issues](https://github.com/pansong291/SimplePinyin/issues)中向我告知。
2. 字库来源于TinyPinyin，估计最终来源应该是Pinyin4j，目前发现有部分字没有在字库里找到。  
   例如， `㘑` 字，其unicode为 `3611` 。如果大家发现了更多类似的字(unicode在 `4E00 ~ 9FA5` 范围之外)，欢迎在[issues](https://github.com/pansong291/SimplePinyin/issues)中向我告知。
