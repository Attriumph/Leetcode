# Leetcode709 To Lower Case

## 解题思路
  ASCII表，字符和int的对应，所以可以对大写字母进行运算可以将其转化为小写
  * A - 65  Z - 90  a - 97 z - 122

代码如下：
```java
class Solution {
    public String toLowerCase(String str) {
      if (str == null) {
          throw new IllegalArgumentException("the string is null");
      }

      char[] arr = str.toCharArray();
      for (int i = 0; i < arr.length; ++i) {
          char cur = arr[i];

          if (cur >= 'A' && cur <= 'Z') {
              arr[i] = (char)(cur - 'A' + 'a');
          }
      }

      return new String(arr);

    }
}
