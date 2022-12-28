import java.util.Arrays;
import java.util.PriorityQueue;

//-----------ALGO
/*
 * 1) sort events by starting time
 * 2) iterate through it and find the max possible  values till i 
 * 3) along with maintain ans pointer , to keep track of maximum pair sum Max(ans, maximum till now + events[i].value) till i ;
 */
class Solution {
    public int maxTwoEvents(int[][] events) {
        // [start, end, val]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // sort by starting points
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int max_i = 0, ans = 0;

        for (int i = 0; i < events.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < events[i][0])
                max_i = Math.max(max_i, pq.poll()[2]);

            pq.add(events[i]);
            int val = events[i][2];
            ans = Math.max(ans, val + max_i);
        }
        return ans;

    }
}
// Time complexity : O(n*logn)