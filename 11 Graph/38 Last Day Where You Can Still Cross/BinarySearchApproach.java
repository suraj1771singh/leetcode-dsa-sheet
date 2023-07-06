import java.util.*;

class Solution {

    public int latestDayToCross(int row, int col, int[][] cells) {
        int ans = 0;
        // 1 means water and 0 means land
        int n = cells.length;
        ans = binSearch(row, col, n, cells);
        return ans;
    }

    // TC : O(log(row*col))
    int binSearch(int row, int col, int n, int[][] cells) {
        int l = 0, h = n - 1, ans = 0;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (isPathExist(mid, row, col, n, cells)) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;
        }
        return ans;

    }

    // TC : O(row*col)
    private boolean isPathExist(int mid, int row, int col, int n, int[][] cells) {
        int a[][] = new int[row][col];

        // fill water in cells upto mid th day
        for (int i = 0; i < mid; i++)
            a[cells[i][0] - 1][cells[i][1] - 1] = 1;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };

        // add first row where land exist to queue
        for (int i = 0; i < col; i++)
            if (a[0][i] == 0) {
                q.add(new int[] { 0, i });
                a[0][i] = 1;// mark as visited
            }

        while (!q.isEmpty()) {
            int it[] = q.poll();
            for (int dir[] : dirs) {
                int x = dir[0] + it[0];
                int y = dir[1] + it[1];
                if (x >= 0 && x < row && y >= 0 && y < col && a[x][y] == 0) {
                    a[x][y] = 1;// mark as visited
                    if (x == row - 1)// reached at last row
                        return true;
                    q.add(new int[] { x, y });
                }
            }
        }

        return false;
    }

}
// Time complexity : O(row*col*log(row*col))