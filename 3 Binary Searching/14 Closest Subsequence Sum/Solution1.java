
import java.util.*;

//Meet in the middle approach
//NOTE : https://leetcode.com/problems/closest-subsequence-sum/discuss/1053751/Java-Detailed-Explanation-%2B-comments-or-Meet-In-the-Middle-or-O-(n-*-2(n2)-or
/*
1) divide array into two parts, and find all possible subset sums 
*/
class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        int n = nums.length, res = Integer.MAX_VALUE;
        generateSum(0, n / 2, nums, first, 0);
        generateSum(n / 2 + 1, n - 1, nums, second, 0);
        Collections.sort(second);
        // now take sum1 from first, and search target- sum1 in second list
        for (int sum1 : first) {
            int sum2 = goal - sum1;
            if (second.get(0) > sum2) {
                res = Math.min(res, Math.abs(sum1 + second.get(0) - goal));
                continue;
            }
            if (second.get(second.size() - 1) < sum2) {
                res = Math.min(res, Math.abs(sum1 + second.get(second.size() - 1) - goal));
                continue;
            }
            int pos = Collections.binarySearch(second, sum2);
            if (pos >= 0) {
                // exact match found means sum1+sum2==goal
                return 0;
            } else {
                // next greater value of sum2 ind is returned
                pos = -1 * (pos + 1); // (-(insertion)-1) in java default binary funct
                res = Math.min(res, Math.abs(sum1 + second.get(pos) - goal));
                res = Math.min(res, Math.abs(sum1 + second.get(pos - 1) - goal));// checking just lesser number
            }
        }
        return res;

    }

    private void generateSum(int start, int end, int[] nums, List<Integer> list, int sum) {
        if (start > end) {
            list.add(sum);
            return;
        }

        generateSum(start, end - 1, nums, list, sum + nums[end]);
        generateSum(start, end - 1, nums, list, sum);
    }
}
// Time complexity : O(n*2^(n/2))