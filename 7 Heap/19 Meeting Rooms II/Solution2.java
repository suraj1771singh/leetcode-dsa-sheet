import java.util.*;

class Solution {
    // find maximum number of overlapping
    public static int calculateMinPatforms(int at[], int dt[], int n) {

        int[] map = new int[2400];
        for (int i = 0; i < n; i++) {
            map[at[i]]++;
            map[dt[i] + 1]--;
        }
        int sum = 0;
        int ans = 0;
        for (int i : map) {
            sum += i;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
// Time complexity : O(n)