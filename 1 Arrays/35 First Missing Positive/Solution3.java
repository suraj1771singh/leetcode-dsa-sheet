
//-------MORE OPTIMZED version
// place each positive number in range [1,n] at correct pos
// correct pos of 5 is 4
// correct pos of 6 is 5
// correct pos of 1 is 0

// in this way we dont have to count <1 number then iteration reduced to 2

public class Solution3 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // place each +ve at its actual_pos
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(i, nums[i] - 1, nums);
            } else
                i++;
        }

        // check if +ve num is placed correctly or not
        for (i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return n + 1;

    }

    public void swap(int i, int j, int a[]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// Time complexity : O(n) ,2 iterations
// Space complexity : O(1)
