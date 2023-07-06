//-------------MERGE SORT TECHNIQUE
class Solution {
    int ans;

    public int reversePairs(int[] nums) {
        ans = 0;
        mergesort(0, nums.length - 1, nums);
        return ans;
    }

    private void mergesort(int l, int h, int[] a) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergesort(l, mid, a);
            mergesort(mid + 1, h, a);
            merge(l, mid, h, a);
        }
    }

    private void merge(int l, int mid, int h, int[] a) {
        int n1 = mid - l + 1;
        int n2 = h - mid;
        int a1[] = new int[n1];
        int a2[] = new int[n2];

        for (int i = 0; i < n1; i++)
            a1[i] = a[l + i];
        for (int i = 0; i < n2; i++)
            a2[i] = a[mid + 1 + i];
        // -------count pairs
        int i = 0, j = 0;
        for (; i < n1; i++) {
            while (j < n2 && a1[i] > 2 * 1L * a2[j])
                j++;
            ans += j;
        }
        // -----------------
        int k = l;
        i = 0;
        j = 0;
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j])
                a[k++] = a1[i++];
            else
                a[k++] = a2[j++];
        }
        while (i < n1)
            a[k++] = a1[i++];
        while (j < n2)
            a[k++] = a2[j++];

    }
}
// Time complexity : O(n*logn)