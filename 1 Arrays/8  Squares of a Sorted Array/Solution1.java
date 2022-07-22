
//-----ALGO

/*The crux over here is that the array is already sorted.
We are comparing the first and last elements because after 
square these have the possibility of being the highest element.
Both the extremes contain the max element (after square ofc), so 
we are inserting these elements to the last of the new array to make it sorted.*/

class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[p] = nums[i] * nums[i];
                i++;
            } else {                             
                result[p] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
}

// Time complexity : O(n)
// Space complexity : O(n)