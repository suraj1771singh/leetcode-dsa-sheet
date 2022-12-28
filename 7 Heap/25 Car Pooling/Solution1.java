import java.util.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        // [passengerNo,dest]
        // min heap accrd to dest
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < trips.length; i++) {
            int passengerNo = trips[i][0];
            int dest = trips[i][2];
            int src = trips[i][1];
            while (!pq.isEmpty() && pq.peek()[1] <= src) {
                capacity += pq.poll()[0];
            }
            if (capacity >= passengerNo) {
                pq.add(new int[] { passengerNo, dest });
                capacity -= passengerNo;
            } else
                return false;
        }
        return true;

    }
}
// Time complexity : O(n*logn)