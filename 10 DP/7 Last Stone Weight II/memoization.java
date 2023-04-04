import java.util.*;

//IDEA : The idea is to first find the min and maxi range of possible ans
//      starting from lower range, using dp to check if it is possible to make that sum or not

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int max = 0;
        int n = stones.length;
        for (int i : stones)
            max = Math.max(max, i);
        Map<String, Boolean> dp = new HashMap<>();
        for (int i = 0; i <= max; i++) {
            if (isPossible(i, n - 1, stones, dp))
                return i;
        }
        return max;
    }

    boolean isPossible(int target, int ind, int[] stones, Map<String, Boolean> dp) {
        if (ind < 0)
            return target == 0 ? true : false;
        String s = target + "-" + ind;

        if (dp.containsKey(s))
            return dp.get(s);

        boolean p = isPossible(target - stones[ind], ind - 1, stones, dp);
        boolean np = isPossible(target + stones[ind], ind - 1, stones, dp);
        dp.put(s, p || np);
        return dp.get(s);
    }
}

// Time complexity : O(max(stones)^2*n)