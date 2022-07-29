
// Time complexity : O( log (min(n,m)) )
// Space complexity :O(1)

class Solution2 {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length, m = b.length;

        // always do binary search for smaller size array
        if (m < n)
            return findMedianSortedArrays(b, a);

        int low = 0, high = n;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 < r1) {
                if ((n + m) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1, l2);
            } else if (l1 > r2)
                high = cut1 - 1;// move left on left part
            else
                low = cut1 + 1;// move right on part
        }
        return 0.0;
    }
}

// Time complexity : O( log (min(n,m)) )
// Space complexity :O(1)