import java.util.*;

//--------ALGO
/*
 * 1) Color all connected island with diff color using DFS ( from 2 ,3,4....)
 * 2)  not find common such that grid[i][j]=0, such that it is connected to produce maximum area
 */
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int color = 2;
        boolean visited[][] = new boolean[n][m];
        HashMap<Integer, Integer> map = new HashMap<>();
        // coloring diff connected islands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = colourDFS(i, j, color, grid, visited);
                    map.put(color, area);
                    color++;
                }
            }
        }
        // now find a 0's who is connected to area's of diff color to give max larger
        // area
        int max_area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> set = new HashSet<>();
                    // check left
                    if (j - 1 >= 0 && grid[i][j - 1] != 0)
                        set.add(grid[i][j - 1]);

                    // check right
                    if (j + 1 < m && grid[i][j + 1] != 0)
                        set.add(grid[i][j + 1]);

                    // check up
                    if (i - 1 >= 0 && grid[i - 1][j] != 0)
                        set.add(grid[i - 1][j]);

                    // check down
                    if (i + 1 < n && grid[i + 1][j] != 0)
                        set.add(grid[i + 1][j]);

                    for (int item : set)
                        area += map.get(item);
                    max_area = Math.max(max_area, area);
                }
            }
        }
        if (max_area == 0)
            return map.get(2);
        return max_area;
    }

    private int colourDFS(int i, int j, int color, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1 || visited[i][j])
            return 0;
        grid[i][j] = color;
        visited[i][j] = true;
        int left = colourDFS(i, j - 1, color, grid, visited);
        int right = colourDFS(i, j + 1, color, grid, visited);
        int up = colourDFS(i - 1, j, color, grid, visited);
        int down = colourDFS(i + 1, j, color, grid, visited);
        return 1 + left + right + up + down;

    }
}