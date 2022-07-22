
//------ALGO
//Keep track of left product and right product 

class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int l_prod[] = new int[n];
        int r_prod[] = new int[n];
        l_prod[0] = nums[0];
        r_prod[n - 1] = nums[n - 1];
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            l_prod[i] = l_prod[i - 1] * nums[i];
            r_prod[j] = r_prod[j + 1] * nums[j];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left_prod = i < 1 ? 1 : l_prod[i - 1];
            int right_prod = i > n - 2 ? 1 : r_prod[i + 1];
            ans[i] = left_prod * right_prod;
        }
        return ans;
    }
}

// Time complexity : O(n)
// Space complexity : O(n)