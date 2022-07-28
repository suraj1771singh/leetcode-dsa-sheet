class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        int top=0,bottom=n-1;
        while(top<=bottom){
            int mid_row=top+(bottom-top)/2;
            if(matrix[mid_row][0]>target) bottom=mid_row-1;
            else if(matrix[mid_row][m-1]<target) top=mid_row+1;
            else{
                //we found potential row
                int l=0, h=m-1;
                while(l<=h){
                    int mid=l+(h-l)/2;
                    if(matrix[mid_row][mid]>target) h=mid-1;
                    else if (matrix[mid_row][mid]<target) l=mid+1;
                    else return true;
                }return false;
            }
        }
        return false;
        
    }
}
//Time complexity : O( log n + log m )
//Time complexity : O(1)