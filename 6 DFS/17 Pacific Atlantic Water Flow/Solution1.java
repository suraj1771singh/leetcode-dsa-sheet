import java.util.*;
/*
 * IDEA : traverse from borders
 * Traverse from top left border, mark them 1 
 * Then traverse from bottom right ,if cells are already marked with 1, this means 
 * it is already traversed by pacific ocean, add it to ans
 */

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int[][] color = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        res = new ArrayList<>();
        // traverse from top left border, pacific ocean
        for (int i = 0; i < m; i++)
            dfs(0, i, heights, visited, color);

        for (int i = 0; i < n; i++)
            dfs(i, 0, heights, visited, color);

        // traverse from bottom right border, atlantic ocean
        visited = new boolean[n][m];
        for (int i = 0; i < m; i++)
            dfs2(n - 1, i, heights, visited, color);

        for (int i = 0; i < n; i++)
            dfs2(i, m - 1, heights, visited, color);

        return res;

    }

    private void dfs2(int i, int j, int[][] heights, boolean[][] visited, int[][] color) {
        int n = heights.length;
        int m = heights[0].length;
        if (visited[i][j])
            return;
        visited[i][j] = true;
        if (color[i][j] == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(j);
            res.add(temp);
        }
        if (isValid(i + 1, j, n, m) && heights[i][j] <= heights[i + 1][j])
            dfs2(i + 1, j, heights, visited, color);
        if (isValid(i, j + 1, n, m) && heights[i][j] <= heights[i][j + 1])
            dfs2(i, j + 1, heights, visited, color);
        if (isValid(i - 1, j, n, m) && heights[i][j] <= heights[i - 1][j])
            dfs2(i - 1, j, heights, visited, color);
        if (isValid(i, j - 1, n, m) && heights[i][j] <= heights[i][j - 1])
            dfs2(i, j - 1, heights, visited, color);
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] visited, int[][] color) {
        int n = heights.length;
        int m = heights[0].length;
        if (visited[i][j])
            return;
        visited[i][j] = true;
        color[i][j] = 1;
        if (isValid(i + 1, j, n, m) && heights[i][j] <= heights[i + 1][j])
            dfs(i + 1, j, heights, visited, color);
        if (isValid(i, j + 1, n, m) && heights[i][j] <= heights[i][j + 1])
            dfs(i, j + 1, heights, visited, color);
        if (isValid(i - 1, j, n, m) && heights[i][j] <= heights[i - 1][j])
            dfs(i - 1, j, heights, visited, color);
        if (isValid(i, j - 1, n, m) && heights[i][j] <= heights[i][j - 1])
            dfs(i, j - 1, heights, visited, color);

    }

    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return false;
        return true;
    }
}