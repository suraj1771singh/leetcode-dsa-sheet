import java.util.*;

//-------------------------SPACE OPTMIZATION
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int K) {
        int n = piles.size();
        int prev[] = new int[K + 1];

        for (int ind = 0; ind < n; ind++) {
            int cur[] = new int[K + 1];
            for (int k = 0; k <= K; k++) {
                int sum = 0;
                cur[k] = prev[k];
                for (int i = 0; i < Math.min(piles.get(ind).size(), k); i++) {
                    sum += piles.get(ind).get(i);
                    cur[k] = Math.max(cur[k], sum + prev[k - i - 1]);
                }
            }
            prev = cur;
        }
        return prev[K];
    }
}
// Time compelxity : O(n*avg(len(pile))*k);
// Space complexity : O(k)