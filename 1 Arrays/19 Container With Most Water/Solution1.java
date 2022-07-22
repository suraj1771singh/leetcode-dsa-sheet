
//--------NAIVE APPROACH

class Solution1 {
    public int maxArea(int[] height) {
        int maxArea = 0, n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }
}

// Time complexity : O(n^2)
// Space complexity : O(1)