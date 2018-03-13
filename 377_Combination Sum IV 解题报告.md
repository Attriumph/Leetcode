class Solution {

    public int combinationSum4(int[] nums, int target) {
       int[] count = new int[target + 1];
        Arrays.fill(count, -1);
        Arrays.sort(nums);
        count[0] = 1;
        return search(nums, target, count);

    }

    private int search(int[] nums, int remain,int[] count){
        if (remain < 0) return 0;

        if (count[remain] != -1) {
            return count[remain];
        }


        int cur = 0;
        for (int number:nums) {
            if (number > remain) break;

           cur += search(nums, remain - number,count);
        }
        return count[remain] = cur;

    }
}
