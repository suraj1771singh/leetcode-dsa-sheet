
import java.util.*;

//------------OPTIMISED VERSION

public class Solution2 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double mini = Double.MAX_VALUE;
        List<Worker> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new Worker(((double) wage[i]) / quality[i], quality[i]));
        // O(n*logn)
        Collections.sort(list, (a, b) -> Double.compare(a.ratio, b.ratio));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sumHeap = 0;

        // O(k) building heap
        for (int i = 0; i < k; i++) {
            pq.add(list.get(i).quality);
            sumHeap += list.get(i).quality;
        }
        mini = list.get(k - 1).ratio * sumHeap;

        // O(n*logk)
        for (int capt = k; capt < n; capt++) {
            int capt_q = list.get(capt).quality;// find sum of k smallest number;
            if (!pq.isEmpty() && capt_q < pq.peek()) {
                sumHeap -= pq.poll();
                pq.add(capt_q);
                sumHeap += capt_q;
            }

            mini = Math.min(mini, list.get(capt).ratio * sumHeap);
        }
        return mini;
    }
}

class Worker {
    double ratio;
    int quality;

    Worker(double a, int b) {
        ratio = a;
        quality = b;
    }
}
// Time complexity : O(n*logn)
