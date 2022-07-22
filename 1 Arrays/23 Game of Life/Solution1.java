
class Solution1 {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int[][] new_board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int live_cell = neighbours(i, j, board);
                // cases
                if (board[i][j] == 1 && live_cell < 2)
                    new_board[i][j] = 0;
                else if (board[i][j] == 1 && live_cell >= 2 && live_cell <= 3)
                    new_board[i][j] = 1;
                else if (board[i][j] == 1 && live_cell > 3)
                    new_board[i][j] = 0;
                else if (board[i][j] == 0 && live_cell == 3)
                    new_board[i][j] = 1;
            }
        }
        copyArray(board, new_board);
    }

    private void copyArray(int[][] a, int[][] b) {
        int n = a.length, m = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    private int neighbours(int i, int j, int[][] board) {
        int live_cell = 0, n = board.length, m = board[0].length;
        int x[] = { i, i - 1, i - 1, i - 1, i, i + 1, i + 1, i + 1 };
        int y[] = { j - 1, j - 1, j, j + 1, j + 1, j + 1, j, j - 1 };

        for (int k = 0; k < x.length; k++) {
            if (x[k] >= 0 && x[k] < n && y[k] >= 0 && y[k] < m && board[x[k]][y[k]] == 1)
                live_cell++;
        }
        return live_cell;

    }
}

// Time complexity : O(n*m)
// Space complexity : O(n*m)