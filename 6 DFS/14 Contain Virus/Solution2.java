import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int n = nums.length, i = 0, cnt = 0, a = 1, ans = 0;
        // preprocessing
        while (cnt != k && i < n) {
            if (nums[i] % 2 == 1)
                cnt++;
            q.add(nums[i]);
            i++;
        }
        if (cnt != k)
            return 0;
        while (!q.isEmpty() && q.poll() % 2 != 1)
            a++;
        ans += a;

        for (; i < n; i++) {
            q.add(nums[i]);
            if (nums[i] % 2 == 1 && !q.isEmpty()) {
                // odd
                a = 1;
                // keep poping till we are not getting odd number
                while (!q.isEmpty() && q.poll() % 2 != 1)
                    a++;
            }
            ans += a;
        }
        return ans;

    }
}