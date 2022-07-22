
//Space optimzation with the help of bits manupulation
// https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation

public class Solution2 {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int live_cell = neighbours(i, j, board);
                // cases
                if (board[i][j] == 1 && live_cell < 2)
                    board[i][j] = 1;
                else if (board[i][j] == 1 && live_cell >= 2 && live_cell <= 3)
                    board[i][j] = 3;
                else if (board[i][j] == 1 && live_cell > 3)
                    board[i][j] = 1;
                else if (board[i][j] == 0 && live_cell == 3)
                    board[i][j] = 2;
            }
        }
        // shifting right to get next state
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int neighbours(int i, int j, int[][] board) {
        int live_cell = 0, n = board.length, m = board[0].length;
        int x[] = { i, i - 1, i - 1, i - 1, i, i + 1, i + 1, i + 1 };
        int y[] = { j - 1, j - 1, j, j + 1, j + 1, j + 1, j, j - 1 };

        for (int k = 0; k < x.length; k++) {
            if (x[k] >= 0 && x[k] < n && y[k] >= 0 && y[k] < m && (board[x[k]][y[k]] & 1) == 1)
                live_cell++;
        }
        return live_cell;

    }
}
// Time complexity : O(n*m)
// Space complexity : O(1)