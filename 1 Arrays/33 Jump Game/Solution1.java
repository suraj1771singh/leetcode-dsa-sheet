//-------GREDDY APPROACH

class Solution {
    public boolean canJump(int[] A) {
        int maxi = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > maxi)
                return false;
            maxi = Math.max(maxi, A[i] + i);
        }
        return true;
    }
}

// Time complexity : O(n)
// Space complexity : O(1)