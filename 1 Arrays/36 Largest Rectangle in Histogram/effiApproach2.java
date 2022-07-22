//using array 

//for each height hi
//   find left limit and righ limit 
//   we have to optimize the calculating left limit and right limit 

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        int[] lessFromLeft = new int[n];
        int[] lessFromRight = new int[n];
        lessFromLeft[0] = -1;
        lessFromRight[n - 1] = n;

        // for (int i = 1; i < n; i++) {
        // int left = i - 1;
        // while (left >= 0 && heights[left] >= heights[i]) {
        // left = lessFromLeft[left];
        // }
        // lessFromLeft[i] = left;
        // }

        // for (int i = n - 2; i >= 0; i--) {
        // int right = i + 1;
        // while (right < n && heights[right] >= heights[i]) {
        // right = lessFromRight[right];
        // }
        // lessFromRight[i] = right;
        // }

        // intead we doing separate loop , we can do same thing under one loop

        for (int i = 1; i < n; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left = lessFromLeft[left];
            }
            lessFromLeft[i] = left;

            int right = n - i;
            while (right < n && heights[right] >= heights[n - i - 1]) {
                right = lessFromRight[right];
            }
            lessFromRight[n - i - 1] = right;

        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i]);
        }
        return res;
    }
}

// Time Complexity : O(n)
// Space Complexity :O(n)