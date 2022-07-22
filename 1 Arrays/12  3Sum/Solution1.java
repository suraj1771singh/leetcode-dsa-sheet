import java.util.*;

//-------NAIVE APPROACH

public class Solution1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    ArrayList<Integer> temp = new ArrayList<>();
                    if (sum == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

}

// Time complexity : O(n^3)
// Space complexity : O(1)