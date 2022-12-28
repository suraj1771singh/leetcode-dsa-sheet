
import java.util.*;
/*
 * ----------ALGO
 * 1) It is saying cutt trees in ascending order
 * 2) So first store height of all trees with coordinates
 * 3) sort them according to heigth
 * 4) then find minimum length between two consecutive pairs
 */

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        List<List<Integer>> heights = new ArrayList<>();
        int n = forest.size();
        int m = forest.get(0).size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (forest.get(i).get(j) > 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(forest.get(i).get(j));
                    heights.add(temp);
                }
            }
        }

        Collections.sort(heights, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2) - o2.get(2);
            }
        });
        System.out.println(heights);
        // find shortest find between consective pairs
        int src_i = 0;
        int src_j = 0;
        int ans = 0;
        for (int i = 0; i < heights.size(); i++) {
            int dest_i = heights.get(i).get(0);
            int dest_j = heights.get(i).get(1);
            int mini_steps = bfs(forest, src_i, src_j, dest_i, dest_j);
            if (mini_steps == -1) {
                return -1;
            }
            ans += mini_steps;
            forest.get(dest_i).set(dest_j, 1);
            src_i = dest_i;
            src_j = dest_j;

        }
        return ans;
    }

    private int bfs(List<List<Integer>> forest, int src_i, int src_j, int dest_i, int dest_j) {
        int mini_steps = 0, n = forest.size(), m = forest.get(0).size();
        int[][] dirs = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src_i, src_j });
        visited[src_i][src_j] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr_cell = q.poll();
                int curr_x = curr_cell[0];
                int curr_y = curr_cell[1];
                if (curr_x == dest_i && curr_y == dest_j)
                    return mini_steps;
                for (int dir[] : dirs) {
                    int next_x = curr_x + dir[0];
                    int next_y = curr_y + dir[1];
                    if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m && forest.get(next_x).get(next_y) != 0
                            && !visited[next_x][next_y]) {
                        q.add(new int[] { next_x, next_y });
                        visited[next_x][next_y] = true;
                    }
                }
            }
            mini_steps++;
        }
        return -1;
    }
}