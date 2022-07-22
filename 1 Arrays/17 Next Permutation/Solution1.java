
//--------ALGO

// Traverse from back and find i such that a[i]>a[i+1], name it as ind1
// find just greater number of a[ind1], 
// swap (ind1, ind2)
// reverse right half reverse(ind1+1, n-1)

class Solution1 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind1 = -1, ind2 = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind1 = i;
                break;
            }
        }
        if (ind1 == -1) {
            reverse(0, n - 1, nums);
            return;
        }
        for (int i = n - 1; i >= -0; i--) {
            if (nums[i] > nums[ind1]) {
                ind2 = i;
                break;
            }
        }
        swap(ind1, ind2, nums);
        reverse(ind1 + 1, n - 1, nums);

    }

    public void reverse(int i, int j, int[] nums) {
        while (i < j)
            swap(i++, j--, nums);
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time complexity : O(n)
// Space complexity : O(1)