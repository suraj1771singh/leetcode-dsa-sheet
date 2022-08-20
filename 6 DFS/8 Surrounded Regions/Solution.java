// Let's analyze when an 'O' cannot be flipped,
// if it has atleast one 'O' in it's adjacent, AND ultimately this chain of adjacent 'O's is connected to some 'O' which lies on boundary of board

//Steps to Solve :
//1. Move over the boundary of board, and find O's 
//2. Every time we find an O, perform DFS from it's position
//3. In DFS convert all 'O' to '#'      (why?? so that we can differentiate which 'O' can be flipped and which cannot be)   
//4. After all DFSs have been performed, board contains three elements,#,O and X
//5. 'O' are left over elements which are not connected to any boundary O, so flip them to 'X'
//6. '#' are elements which cannot be flipped to 'X', so flip them back to 'O'

class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        // move over first and last row
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O')
                dfs(0, i, board);
            if (board[n - 1][i] == 'O')
                dfs(n - 1, i, board);
        }
        // move over first and last col
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board);
            if (board[i][m - 1] == 'O')
                dfs(i, m - 1, board);
        }
        // now flip remaining O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
        }

    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = '#';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);
    }
}