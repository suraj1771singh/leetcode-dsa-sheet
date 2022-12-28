import java.util.ArrayList;
import java.util.*;


//giving TLE 

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < times.length; i++)
            list.add(new int[] { i, times[i][0], times[i][1] });
        Collections.sort(list, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int frnd[] : list) {
            int id = frnd[0];
            int arvl = frnd[1];
            int lev = frnd[2];
            boolean flag = false;

            while (!pq1.isEmpty()) {
                int seat[] = pq1.poll();
                if (seat[1] <= arvl) {
                    flag = true;
                    if (id == targetFriend)
                        return seat[0];
                    pq2.add(new int[] { seat[0], lev });
                    break;
                } else
                    pq2.add(seat);
            }
            if (id == targetFriend)
                return pq2.size();
            if (!flag) {
                pq2.add(new int[] { pq2.size(), lev });
            }
            while (!pq1.isEmpty())
                pq2.add(pq1.poll());

            pq1.addAll(pq2);
            pq2.clear();
        }
        return -1;
    }
}
//Time complexity : O(nlogn)
//Space complexiyt : O(n)