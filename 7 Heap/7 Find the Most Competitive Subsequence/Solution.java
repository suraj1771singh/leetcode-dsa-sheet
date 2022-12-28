import java.util.PriorityQueue;

//---------ALGO
//Using Min heap 

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int start = 0, end = 0, n = nums.length;
        int ans[] = new int[k];
        System.out.println(n);
        for (int i = 0; i < k; i++) {
            // put everything in range (start, end) in heap
            end = n - k + i;
            q.clear();

            for (int ind = start; ind <= end; ind++) {
                q.add(new int[] { nums[ind], ind });
            }
            int min[] = q.poll();
            start = min[1] + 1;
            ans[i] = min[0];
        }
        return ans;
    }
}
// Time complexity : O( k*logn)