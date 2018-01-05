class Solution {
    public int countBinarySubstrings(String s) {
        int itemNo_preRound = 0;  // record the number of previous item(0 or 1) 
        int itemNo_curRound = 1;
        int res = 0;
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)) itemNo_curRound++;                        
            else{
                itemNo_preRound = itemNo_curRound;
                itemNo_curRound = 1;
                
            }
            
            if(itemNo_preRound >= itemNo_curRound) res++; 
        }
        
        return res;
    }
}

Thanks to @compton_scatter and @Jin Zheng for their explaination and solution:

preRun record the same item happend before 
curRun recore the current number of items
Whenever item change, store the curRun number into PreRun, reset curRun)
Every time preRun >= curRun means there are more 0s before 1s,so could do count++ .
ex. 0011 when you hit the first ‘1’, curRun = 1, preRun = 2, means 0s number is
 larger than 1s number, so we could form “01” at this time, count++ .
 When you hit the second ‘1’, curRun = 2, preRun = 2, means 0s’ number equals 
 to 1s’ number, so we could form “0011” at this time, that is why count++)