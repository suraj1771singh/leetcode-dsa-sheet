class NumMatrix {
    int [][] mat;
    int [][] presum;
    int n;
    int m;

    // O(n*m)
    public NumMatrix(int[][] matrix) {
        mat= matrix;
        n=matrix.length;
        m=matrix[0].length;
        //calculate prefix sum grid
        presum= new int[n+1][m+1];
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                presum[i][j] = mat[i][j] + presum[i][j+1] + presum[i+1][j] -presum[i+1][j+1];
            }
        } 
        
    }
    //O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        

        return presum[row1][col1] - ( presum[row1][col2+1] + presum[row2+1][col1] - presum[row2+1][col2+1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */