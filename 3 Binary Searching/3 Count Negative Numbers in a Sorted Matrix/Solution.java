
//----ALGO
/*
 * 1) For each row, do binary search and try to find left most negative number
 * 2) to right of left most negative number , all will be negative , so add len-ind to the ans
 */

class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int[] a : grid) {
            int l = 0, h = a.length - 1;
            int ind = -1;
            while (l <= h) {
                int mid = (l + h) / 2;
                if (a[mid] >= 0)
                    l = mid + 1;
                else {
                    ind = mid;
                    h = mid - 1;
                }
            }
            ans = ind == -1 ? ans : ans + (a.length - ind);
        }
        return ans;
    }
}
// Time complexity : O(n * log m )
// Space complexity : O(1)