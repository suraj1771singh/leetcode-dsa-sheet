import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//----------------PREFIX SUM 
//IDEA : keep track of number of continous decreasing sequence from left to right
// and continous increasing sequence from left to right

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int dec[] = new int[n];
        int inc[] = new int[n];
        Arrays.fill(dec, 1);
        Arrays.fill(inc, 1);
        // precalculating continuos decreasing sequence

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i])
                dec[i] += dec[i - 1];
        }

        // precalculating continuos increasing sequence
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1])
                inc[i] += inc[i + 1];
        }

        for (int i = k; i < n - k; i++) {
            if (dec[i - 1] >= k && inc[i + 1] >= k)
                ans.add(i);
        }
        return ans;

    }
}
// Time complexity : O(n)
// Space complexity : O(n)