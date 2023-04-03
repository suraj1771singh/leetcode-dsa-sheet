import java.util.Arrays;

//-------BELLMAN FORD

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int dis[] = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[headID] = 0;
        for (int i = 0; i < n; i++) {
            boolean f = false;
            for (int j = 0; j < n; j++) {
                if (manager[j] == -1)
                    continue;
                if (dis[j] > dis[manager[j]] + informTime[manager[j]]) {
                    dis[j] = dis[manager[j]] + informTime[manager[j]];
                    f = true;
                }
            }
            if (!f)
                break;
        }
        int max = 0;
        for (int i : dis)
            max = Math.max(i, max);
        return max;
    }
}
// Time complexity : O(n^2)