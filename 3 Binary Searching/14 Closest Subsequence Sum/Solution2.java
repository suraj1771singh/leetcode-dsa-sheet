import java.util.*;

//-----------Optimized version of prevoius soltion
//used bit manipulation to generate subset sum instead of recursion
//optimsed binary search

class Solution {

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int left = n / 2;
        int right = n - left;

        // left sum
        int[] sumLeft = new int[1 << left];
        for (int i = 1; i < 1 << left; i++) {
            int index = 0;
            while ((i & (1 << index)) == 0)
                index++;
            sumLeft[i] = nums[index] + sumLeft[i ^ (1 << index)];
        }

        int[] sumRight = new int[1 << right];

        for (int i = 1; i < 1 << right; i++) {
            int index = 0;
            while ((i & (1 << index)) == 0)
                index++;
            sumRight[i] = nums[index + left] + sumRight[i ^ (1 << (index))];
        }

        Arrays.sort(sumLeft);
        Arrays.sort(sumRight);
        int result = Integer.MAX_VALUE;

        int i1 = 0;
        int i2 = sumRight.length - 1;
        int sum=0;

        while (i1 < sumLeft.length && i2 >= 0) {
            sum = sumRight[i2] + sumLeft[i1];
            result = Math.min(result, Math.abs(sum - goal));

            if (result == 0)
                return 0;
            if (sum > goal)
                --i2;
            else
                ++i1;
        }
        return result;
    }
}
// Time complexity : O(2^(n/2))