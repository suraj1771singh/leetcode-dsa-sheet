class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(i, isConnected, visited);
            }
        }
        return res;

    }

    public void dfs(int s, int[][] isConnected, boolean[] visited) {
        visited[s] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[s][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }
}