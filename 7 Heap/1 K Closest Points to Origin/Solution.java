import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < points.length; i++) {
            int point[] = points[i];
            int dist = (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2);

            q.add(new int[] { i, dist });
        }
        int ans[][] = new int[k][2];
        int cnt = 0;
        while (cnt < k && !q.isEmpty())
            ans[cnt++] = points[q.poll()[0]];

        return ans;
    }
}