//-------------------------OPTIMZED BINARY SEARCH
//---ALGO
/*
 * Here we optimzed the way to calculate the number of operations required 
 * req=(a-1)/lmit;
 */

class Solution2 {
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
                    req += (i - 1) / mid;
            if (req <= maxOperations) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;

    }

}
// Time complexity : O(n*log(maxi))
