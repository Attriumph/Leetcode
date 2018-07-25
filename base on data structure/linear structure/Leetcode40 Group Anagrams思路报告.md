## Leetcode49 Group Anagrams

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

## 思路报告：
把每一种anagram转化为一种标准，使它作为map的key
## 注意点：
* ArryList<List<String>>, 而不是 ArrayList<ArrayList<String>>
* new ArrayList<>(collections) 可以通过collection创建arraylsit
代码如下：
`java`
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String strKey = String.valueOf(arr);
            if (!map.containsKey(strKey)) {
                map.put(strKey, new ArrayList<String>());
            }
            map.get(strKey).add(str);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
