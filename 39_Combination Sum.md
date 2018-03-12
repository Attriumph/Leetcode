class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(candidates,target, 0, new Integer[target],0, result);
        return result;
    }

    private void helper(int[] candidates, int target, int pos, Integer[] cur, int length, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            Integer[] temp = new Integer[length];
            System.arraycopy(cur,0, temp, 0,length);
            result.add(Arrays.asList(temp));
            return;
        }

        if (pos >= candidates.length){
            return;
        }

        cur[length] = candidates[pos];
        helper(candidates, target - candidates[pos], pos, cur, length + 1, result);
        helper(candidates, target, pos + 1, cur, length, result);
    }
}
