import java.util.*;

class Solution {
    Map<Integer, Integer> map;

    public boolean canCross(int[] stones) {
        map = new HashMap<>();
        int n = stones.length;
        for (int i = 0; i < n; i++)
            map.put(stones[i], i);
        Boolean dp[][] = new Boolean[n][n + 1];
        return f(0, 1, stones, dp);
    }

    boolean f(int ind, int jump, int[] stones, Boolean dp[][]) {
        if (ind == stones.length - 1)
            return true;
        if (jump == 0)
            return false;

        if (dp[ind][jump] != null)
            return dp[ind][jump];

        int pos = stones[ind] + jump;
        int npos = map.getOrDefault(pos, -1);
        if (npos == -1)
            return false;
        boolean res = f(npos, jump - 1, stones, dp) | f(npos, jump, stones, dp) | f(npos, jump + 1, stones, dp);

        return dp[ind][jump] = res;
    }
}