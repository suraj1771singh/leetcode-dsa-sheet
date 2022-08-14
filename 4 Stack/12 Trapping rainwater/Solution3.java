//-----------------------USING TWO POINTER

class Solution3 {
    public int trap(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxleft)
                    maxleft = arr[left];
                else
                    res += maxleft - arr[left];
                left++;
            } else {
                if (arr[right] >= maxright)
                    maxright = arr[right];
                else
                    res += maxright - arr[right];
                right--;
            }
        }
        return res;

    }
}
// Time complexity : O(n)
// Space complexity : O(1)
