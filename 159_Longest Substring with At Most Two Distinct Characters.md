# 滑动窗口问题
中间需要用hashmap去重，并且进行位置记录
```java
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() < 2) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] stringArr = s.toCharArray();
        int res = 0;
        int slow = 0;

        for (int fast = 0;fast < s.length(); ++fast ) {
            if (map.size() < 2 || map.size() == 2 && map.containsKey(stringArr[fast])) {
                map.put(stringArr[fast], fast);
            } else{
                int left = fast;
                for (int index: map.values()) {
                    left = Math.min(index, left);
                }

                slow = left + 1;
                map.remove(stringArr[left]);
                map.put(stringArr[fast], fast);
            }

            res = Math.max(res, fast - slow + 1);
        }

        return res;
    }
}
```
