```java
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
       if( s == null || s.length() == 0 || k == 0) {
           return 0;
       }
       if (s.length() <= k) {
           return s.length();
       }

       int res = 0;
       int beg = 0;
       Map<Character, Integer> map = new HashMap<>();
       char[] arr = s.toCharArray();

      for (int i = 0; i < s.length(); ++i) {
          if (map.size() < k || map.size() == k && map.containsKey(arr[i])) {
              map.put(arr[i], i);
          } else {
              int left = i;
              for (int index: map.values()) {
                  left = Math.min(index, left);
              }
              beg = left + 1;
              map.remove(arr[left]);
              map.put(arr[i], i);
          }
          res = Math.max(res, i - beg + 1);
      }

    return res;
    }
}
