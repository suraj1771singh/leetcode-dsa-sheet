import java.util.*;

//--------------USING DIJKSTRA
// Just little bit modify dijstra, and keep on relaxing edges according to new formula

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int edge[] = edges[i];
            adj.get(edge[0]).add(new int[] { edge[1], i });// [node, ind]
            adj.get(edge[1]).add(new int[] { edge[0], i });
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.prob, b.prob));
        pq.add(new Pair(start, 1.0));

        double prob[] = new double[n];
        prob[start] = 1.0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for (int next[] : adj.get(curr.node)) {
                double edge_prob = succProb[next[1]];
                if (prob[next[0]] < curr.prob * edge_prob) {
                    prob[next[0]] = curr.prob * edge_prob;
                    pq.add(new Pair(next[0], prob[next[0]]));
                }
            }
        }
        return prob[end];

    }
}

class Pair {
    int node;
    double prob;

    Pair(int a, double b) {
        node = a;
        prob = b;
    }
}
// Time complexiy : O(V + ElogV)