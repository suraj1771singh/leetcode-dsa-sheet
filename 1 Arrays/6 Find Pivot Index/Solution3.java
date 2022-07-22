
//-----EFFICIENT APPROACH (Space optmization of prevoius methode)

//-----ALGO
// while traversing, keep track of left sum (just keep adding) 
// right_sum=sum of array - left sum + a[i]

class Solution3 {
    public int pivotIndex(int[] nums) {
        int ans = -1, n = nums.length, sum = 0;
        int l_sum = 0, r_sum = 0;
        for (int i : nums)
            sum += i;
        for (int i = 0; i < n; i++) {
            l_sum += nums[i];
            r_sum = nums[i] + sum - l_sum;
            if (l_sum == r_sum)
                return i;
        }
        return ans;
    }
}

// Time complexity : O(n)
// Space complexity : O(1)