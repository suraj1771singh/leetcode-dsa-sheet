import java.util.*;
//--------------------MEMOIZATION SOLUTION

class Solution {
    int tg;
    List<List<Integer>> list;

    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        list = new ArrayList<>();
        // remove duplicates and sort each row
        for (int a[] : mat) {
            Set<Integer> set = new HashSet<>();
            for (int num : a)
                set.add(num);
            list.add(new ArrayList<>(set));
            Collections.sort(list.get(list.size() - 1));
        }
        Integer dp[][] = new Integer[n][n * n + 1];
        tg = target;
        return f(n - 1, 0, dp);

    }

    int f(int r, int sum, Integer dp[][]) {
        if (r < 0)
            return Math.abs(sum - tg);
        if (dp[r][sum] != null)
            return dp[r][sum];
        int min = (int) 1e9;
        for (int num : list.get(r)) {
            min = Math.min(min, f(r - 1, sum + num, dp));
            if (sum + num >= tg)
                break;
        }
        return dp[r][sum] = min;
    }
}
// Time complexity : O(n^4) + prunning
