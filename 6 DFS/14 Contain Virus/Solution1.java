
import java.util.*;

class Solution {
    public int containVirus(int[][] isInfected) {
        Queue<ArrayList<int[]>> q = new LinkedList<>();
        int n = isInfected.length;
        int m = isInfected[0].length;
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isInfected[i][j] == 1 && !visited[i][j]) {
                    ArrayList<int[]> list = new ArrayList<>();
                    grouping(i, j, visited, isInfected, list);
                    q.add(list);
                }

            }
        }
        PriorityQueue<Set<int[]>> pq = new PriorityQueue<>((a, b) -> a.size() - b.size());
        // pq will contains future affected cells
        for (ArrayList<int[]> list : q) {
            Set<int[]> newList = new HashSet<>();
            System.out.println(list.toString());
            for (int[] cord : list) {
                findAffected(newList, cord[0], cord[1], n, m, isInfected);

            }
            pq.add(newList);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                System.out.print(isInfected[i][j] + " ");
        System.out.println();
        for (Set<int[]> list : pq) {
            for (int[] cord : list) {
                System.out.print("{" + cord[0] + " " + cord[1] + "}");
            }
            System.out.println();
        }
        return 0;

    }

    private void findAffected(Set<int[]> newList, int i, int j, int n, int m, int[][] isInfected) {
        int dirs[][] = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        for (int dir[] : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (isValid(x, y, n, m, isInfected))
                newList.add(new int[] { x, y });
        }

    }

    private boolean isValid(int x, int y, int n, int m, int[][] isInfected) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return false;
        if (isInfected[x][y] == 0)
            return true;
        return false;
    }

    private void grouping(int i, int j, boolean[][] visited, int[][] isInfected, ArrayList<int[]> list) {
        if (i < 0 || j < 0 || i >= isInfected.length || j >= isInfected[0].length || isInfected[i][j] != 1
                || visited[i][j])
            return;
        visited[i][j] = true;
        list.add(new int[] { i, j });
        grouping(i - 1, j, visited, isInfected, list);
        grouping(i + 1, j, visited, isInfected, list);
        grouping(i, j - 1, visited, isInfected, list);
        grouping(i, j + 1, visited, isInfected, list);

    }
}