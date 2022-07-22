import java.util.Arrays;

//similar to 3sum problem 
class Solution1 {
    public int threeSumClosest(int[] num, int target) {
        int ans = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else
                    return sum;
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(1)