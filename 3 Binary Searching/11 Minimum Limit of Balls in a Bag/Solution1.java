
//-------------------------BINARY SEARCH

class Solution1 {
    public int minimumSize(int[] nums, int maxOperations) {
        int maxi = 0;
        for (int i : nums)
            maxi = Math.max(maxi, i);
        int l = 1, h = maxi, ans = maxi;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            // calculating required operations
            int req = 0;
            for (int i : nums)
                if (i > mid)
                    req += countOperations(i, mid);
            if (req <= maxOperations) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;

    }

    // naive way to calculate number of operations
    private int countOperations(int a, int limit) {
        if (a <= limit)
            return 0;
        return 1 + countOperations(limit, limit) + countOperations(a - limit, limit);
    }
}
// Time complexity : O(n*log(maxi))
