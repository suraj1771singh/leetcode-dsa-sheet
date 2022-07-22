import java.util.ArrayList;
import java.util.*;
//--------NAIVE APPROACH (Recursion)
// go for all possible cases 2^n

class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        f(0, new ArrayList<>(), nums);
        return ans;
    }

    public void f(int ind, ArrayList<Integer> ds, int[] nums) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[ind]);
        f(ind + 1, ds, nums);
        ds.remove(ds.size() - 1);
        f(ind + 1, ds, nums);
    }
}
// Time complexity : O(2^n)
// A S : O(n)