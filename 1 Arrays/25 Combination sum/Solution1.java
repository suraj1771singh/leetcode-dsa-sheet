import java.util.*;

//------BACKTRACKING------//

class Solution1 {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        f(0, candidates, target, new ArrayList<>());
        return ans;
    }

    private void f(int ind, int[] a, int target, ArrayList<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (ind == a.length)
            return;
        if (target >= a[ind]) {
            ds.add(a[ind]);
            f(ind, a, target - a[ind], ds);
            ds.remove(ds.size() - 1);
        }
        f(ind + 1, a, target, ds);

    }
}
// Time complexity : O(2^n) : exponential time complexity.
// Space complexity : O(n)