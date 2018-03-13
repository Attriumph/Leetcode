class Solution {
    public List<List<Integer>> combinationSum3(int n, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        search(candidates,0, target, n, new Integer[n+1], 0, res);
        return res;
    }

    private void search(int[] candidates, int beg, int target, int n, Integer[] cur, int length, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (length > n) {
            return;
        }

        if (target == 0 && length == n) {
            Integer[] temp = new Integer[length];
            System.arraycopy(cur,0, temp, 0, length);
            res.add(Arrays.asList(temp));
            return;
        }

        for (int i = beg; i < 9; ++i ) {
            cur[length] = candidates[i];
            search(candidates, i + 1, target- candidates[i], n, cur, length + 1, res);
        }
    }
}
