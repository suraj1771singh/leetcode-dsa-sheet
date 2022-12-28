import java.util.*;

// ------------PREFIX SUM
// IDEA : Keep track of len of continuos decreasing till index i
// keep track of len of continous increasing start at index i
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int n = security.length;
        int dec[] = new int[n];
        int inc[] = new int[n];
        Arrays.fill(dec, 1);
        Arrays.fill(inc, 1);
        // precomputing max len of continous decreasing till index i
        for (int i = 1; i < n; i++) {
            if (security[i - 1] >= security[i])
                dec[i] += dec[i - 1];
        }
        // precomputing max len of continous increasing start with index i
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1])
                inc[i] += inc[i + 1];
        }
        // check of time days before and time days after

        for (int i = time; i < n - time; i++) {
            if (dec[i] >= time + 1 && inc[i] >= time + 1)
                ans.add(i);
        }

        return ans;

    }
}
// Time complexity : O(n)
// Space complexity : O(n)