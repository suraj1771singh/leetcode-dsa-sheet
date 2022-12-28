import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> pq1 = new TreeSet<>(comparator.reversed());
        // max heap
        TreeSet<Integer> pq2 = new TreeSet<>(comparator);
        // min heap
        double ans[] = new double[nums.length - k + 1];
        int ind = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                pq1.remove(i - k);
                pq2.remove(i - k);
            }
            addNum(nums, i, pq1, pq2);
            if (i >= k - 1)
                ans[ind++] = findMedian(nums, pq1, pq2);
        }
        return ans;

    }
    //O(k*logk)
    public void addNum(int[] nums, int ind, TreeSet<Integer> pq1, TreeSet<Integer> pq2) {
        int a = pq1.size();
        int b = pq2.size();
        if (b == 0) {
            pq1.add(ind);
            balance(pq1, pq2);
            return;
        } else if (a == 0) {
            pq2.add(ind);
            balance(pq1, pq2);
            return;
        }
        if (nums[ind] <= nums[pq1.first()])
            pq1.add(ind);
        else if (nums[ind] >= nums[pq2.first()])
            pq2.add(ind);
        else
            pq1.add(ind);

        balance(pq1, pq2);

    }
    //O(1)
    public double findMedian(int nums[], TreeSet<Integer> pq1, TreeSet<Integer> pq2) {
        int a = pq1.size();
        int b = pq2.size();
        if (a == b)
            return ((double)nums[pq1.first()] + nums[pq2.first()]) / 2 ;
        else if (a > b)
            return (double) nums[pq1.first()];
        else
            return (double) nums[pq2.first()];

    }
    // O(k*logk)
    public void balance(TreeSet<Integer> pq1, TreeSet<Integer> pq2) {
        int a = pq1.size();
        int b = pq2.size();
        if (a - b > 1)
            while (pq1.size() - pq2.size() > 1)
                pq2.add(pq1.pollFirst());
        else if (b - a > 1)
            while (pq2.size() - pq1.size() > 1)
                pq1.add(pq2.pollFirst());

    }
}

//Time complexity : O(n*logk)