
// -------NAIVE SOLUTION(Backtracing )
class Solution {
    public boolean exist(char[][] board, String word) {
        int ind = 0, n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(ind)) {
                    if (find(i, j, ind + 1, board, word))
                        return true;
                }
            }
        }
        return false;

    }

    public boolean find(int i, int j, int ind, char[][] board, String word) {
        int n = board.length, m = board[0].length;

        int[] x = { i, i, i - 1, i + 1 };
        int[] y = { j - 1, j + 1, j, j };

        if (ind == word.length())
            return true;

        for (int k = 0; k < x.length; k++) {
            char temp = board[i][j];
            board[i][j] = '0';
            if (isValid(x[k], y[k], n, m, ind, board, word)) {

                boolean res = find(x[k], y[k], ind + 1, board, word);
                if (res)
                    return true;

            }
            board[i][j] = temp;
        }
        return false;

    }

    boolean isValid(int i, int j, int n, int m, int ind, char[][] board, String word) {
        if (i >= 0 && i < n && j >= 0 && j < m) {
            return board[i][j] == word.charAt(ind);
        }
        return false;
    }
}
// Time complexity : exponential
// Space complexity : O(word.lenth)