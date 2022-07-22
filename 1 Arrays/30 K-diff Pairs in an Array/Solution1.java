import java.util.*;

//-----NAIVE APPROACH 

class Solution1 {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Set<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j]));
                    Collections.sort(list);
                    set.add(list);
                }
            }
        }
        System.out.println(set);
        return set.size();

    }
}

// Time complexity : O(n^2)
// Space complexity : O(n)