import java.util.*;

//-------Solution2 
//using hashmap for reducing third nested loop

public class Solution2 {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (binary_search(j + 1, n - 1, nums, -(nums[i] + nums[j]))) {
                    List<Integer> t = new ArrayList<Integer>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(-(nums[i] + nums[j]));
                    ans.add(t);
                }

                while (j + 1 < n && nums[j + 1] == nums[j])
                    j++;
            }

            while (i + 1 < n && nums[i + 1] == nums[i])
                i++;
        }

        return ans;
    }

    static boolean binary_search(int l, int r, int[] nums, int x) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == x)
                return true;
            else if (nums[mid] > x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }

}

// Time complexity : O(n^2* log n)
// Space complexity : O(1)
