# 套路总结
* 1.lamda表达式的使用，如果-> 使用(),则不用return；
    如果使用{}，则要return；
* 2.comparator的三种方式： 经典款、内部类款、和lamda款
   ```java

   //内部类
   Arrays.sort(players, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return (s1.compareTo(s2));
      }
   });

   // lamda表达式的使用
   // 1.2 使用 lambda expression 排序 players
   Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
    Arrays.sort(players, sortByName);

     // 1.3 也可以采用如下形式:
   Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
   ```
* 3.当需要对map的频率进行排序时候，可以将value设置为一个类来，这样拍了序。我也知道这个频率对应谁；
* 4.使用stringBuilder比string节省时间

```java
class Solution {
    //1. construct a inner class
    class Pair {
        char character;
        int freq;

        Pair(char character) {
            this.character = character;
            this.freq =  0;
        }
    }
    public String frequencySort(String s) {
        //corner case
        if (s == null || s.length() == 0) {
            return s;
        }

        Map<Character, Pair> map = new HashMap<>();
        //2. count the freq
        for (int i = 0; i < s.length(); ++i) {
            Pair pair = map.getOrDefault(s.charAt(i),new Pair(s.charAt(i)));
            pair.freq++;
            map.put(s.charAt(i), pair);
        }

        //3.sort the freq
        List<Pair> list = new ArrayList<>(map.values());

        Collections.sort(list, (l1,l2) ->
            (l2.freq - l1.freq )
        );

        //4. print the res
        // String res = "";
        StringBuilder res = new StringBuilder();

        for (Pair pair : list) {
            for (int i = 0; i < pair.freq; i++){
                //res += pair.character;
                res.append(pair.character);
            }

        }

        return res.toString();
    }
}
```
