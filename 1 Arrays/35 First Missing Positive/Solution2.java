
//---------EFFICIENT APPROACH
//------ALGO
/*
  1) count a[i]<1 , let it be k
  2) now for a[i]>0 , actual_pos= a[i]-1+k
  3) swap positive with their actual position if possible 
  4) run loop and check if positive is at its actual_pos or not
  5) return first number which is not at its actual_pos
 */

public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, k = 0;
        // count non +ve
        for (int i : nums)
            if (i < 1)
                k++;

        // place each +ve at its actual_pos
        int i = 0;
        while (i < n) {
            if (nums[i] > 0) {
                int actual_ind = nums[i] + k - 1;
                if (actual_ind >= 0 && actual_ind < n && nums[actual_ind] != Integer.MIN_VALUE) {
                    swap(i, actual_ind, nums);
                    nums[actual_ind] = Integer.MIN_VALUE;
                    continue;
                }
            }
            i++;
        }

        // check if +ve num is placed correctly or not
        int j = k;
        for (j = k; j < n; j++)
            if (nums[j] != Integer.MIN_VALUE)
                return j - k + 1;
        return j - k + 1;
    }

    public void swap(int i, int j, int a[]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

// Time complexity : O(n), 3 iterations
// Space complexity : O(1)
