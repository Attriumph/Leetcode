# Leetcode804 Unique Morse Code Words
```java
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String word: words) {
            char[] arr = word.toCharArray();
            String morse = "";

            for (int i = 0; i < word.length(); i++) {
              morse += table[(int)arr[i] - 'a'];
            }

            set.add(morse);
        }

        return set.size();
    }
}
