class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        reverse(matrix);
        // swap symmetrically
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(i, j, matrix);
            }
        }
    }

    public void reverse(int[][] matrix) {
        int n = matrix.length;
        int top = 0, bottom = n - 1;
        while (top < bottom) {
            int temp[] = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
            top++;
            bottom--;
        }
    }

    public void swap(int i, int j, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}

// Time complexity : O(n^2);
// Space complexity : O(1)