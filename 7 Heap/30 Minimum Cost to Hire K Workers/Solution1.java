import java.util.*;

// https://www.youtube.com/watch?v=o8emK4ehhq0
// NOTE : Done in dsa copy

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double mini = Double.MAX_VALUE;
        for (int capt = 0; capt < n; capt++) {
            List<Double> acceptedOffer = new ArrayList<>();
            for (int wrk = 0; wrk < n; wrk++) {
                double offer = ((double) (quality[wrk] * wage[capt])) / quality[capt];
                if (offer >= (double) wage[wrk])
                    acceptedOffer.add(offer);
            }
            if (acceptedOffer.size() < k)
                continue;
            // find sum of k smallest number;
            mini = Math.min(mini, sumK(acceptedOffer, k));
        }
        return mini;
    }

    public double sumK(List<Double> acceptedOffer, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sumHeap = 0;
        for (int i = 0; i < k; i++) {
            pq.add(acceptedOffer.get(i));
            sumHeap += acceptedOffer.get(i);
        }
        for (int i = k; i < acceptedOffer.size(); i++) {
            if (!pq.isEmpty() && acceptedOffer.get(i) < pq.peek()) {
                sumHeap -= pq.poll();
                pq.add(acceptedOffer.get(i));
                sumHeap += acceptedOffer.get(i);
            }
        }
        return sumHeap;
    }
}
// Time complexity : O(n*max(n, k*logk))
// Space complexity : O(k)