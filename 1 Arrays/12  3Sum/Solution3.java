import java.util.*;

//-----------ALGO
//=> Sort array
//=> traverse through array and skip duplicates (let say each ele as a)
//=> now find pairs such that b+c=-a
//=> while finding pairs skip duplicates pair 

public class Solution3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length, last_ind = -1, i = -1;

        while (++i < n) {
            if (last_ind != -1 && nums[i] == nums[last_ind])
                continue;
            last_ind = i;
            pairSum(i + 1, n - 1, -nums[i], nums, ans);
        }

        return ans;
    }

    // This is O(n)

    public static void pairSum(int i, int j, int target, int[] a, List<List<Integer>> ans) {
        int last_low = -1;
        while (i < j) {
            if (a[i] + a[j] < target)
                i++;
            else if (a[i] + a[j] > target)
                j--;
            else {
                if (last_low == -1 || a[i] != a[last_low]) {
                    ans.add(new ArrayList<>(Arrays.asList(-target, a[i], a[j])));
                    last_low = i;
                }
                i++;
                j--;
            }
        }

    }
}

// Time complexity : O(n^2)
// Space complexity : O(1)
