#### [剑指 Offer 20. 表示数值的字符串](https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/)

难度中等209

请实现一个函数用来判断字符串是否表示**数值**（包括整数和小数）。

**数值**（按顺序）可以分成以下几个部分：

1.  若干空格
2.  一个 **小数** 或者 **整数**
3.  （可选）一个 `'e'` 或 `'E'` ，后面跟着一个 **整数**
4.  若干空格

**小数**（按顺序）可以分成以下几个部分：

1.  （可选）一个符号字符（`'+'` 或 `'-'`）
2.  下述格式之一：
    1.  至少一位数字，后面跟着一个点 `'.'`
    2.  至少一位数字，后面跟着一个点 `'.'` ，后面再跟着至少一位数字
    3.  一个点 `'.'` ，后面跟着至少一位数字

**整数**（按顺序）可以分成以下几个部分：

1.  （可选）一个符号字符（`'+'` 或 `'-'`）
2.  至少一位数字

部分**数值**列举如下：

-   `["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]`

部分**非数值**列举如下：

-   `["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]`

 

**示例 1：**

```
输入：s = "0"
输出：true
```

**示例 2：**

```
输入：s = "e"
输出：false
```

**示例 3：**

```
输入：s = "."
输出：false
```

**示例 4：**

```
输入：s = "    .1  "
输出：true
```

 

**提示：**

-   `1 <= s.length <= 20`
-   `s` 仅含英文字母（大写和小写），数字（`0-9`），加号 `'+'` ，减号 `'-'` ，空格 `' '` 或者点 `'.'` 。



## 题解

```java
public boolean isNumber(String s) {
        boolean hasSign = false;
        boolean hasE = false;
        boolean hasNumber = false;
        boolean hasPoint = false;
        int i = 0;
        int len = s.length();
        while(i < len && s.charAt(i) == ' '){
            i++;
        }
        while(i < len){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                hasNumber= true;
                i++;
            } else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if(!hasNumber || hasE){
                    return false;
                }
                hasE = true;
                hasSign = hasNumber = hasPoint = false;
                i++;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(hasSign || hasNumber || hasPoint){
                    return false;
                }
                i++;
            }else if(s.charAt(i) == '.'){
                if(hasPoint || hasE){
                    return false;
                }
                hasPoint = true;
                i++;
            } else {
                break;
            }
        }
        while(i < len && s.charAt(i) == ' '){
            i++;
        }
        return hasNumber && i == len;
    }
```

