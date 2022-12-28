import java.util.*;
//----ALGO
// similar  like Merge k List

class Solution1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        // first add all combination of nums[i] with nums2[0], because
        // that's the smallest possible pair of all i's
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i : nums1) {
            int a[] = { i, nums2[0], 0 };
            pq.add(a);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int a[] = pq.poll();
            ans.add(new ArrayList<>(Arrays.asList(a[0], a[1])));
            if (a[2] == nums2.length - 1)
                continue;
            pq.add(new int[] { a[0], nums2[a[2] + 1], a[2] + 1 });
        }
        return ans;
    }
}
// Time Complexity : O(k*logk)
// Space complexity : O(k)