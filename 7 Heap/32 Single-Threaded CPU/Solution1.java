import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] { i, tasks[i][0], tasks[i][1] };
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);// sort by arrival time

        int time = 0, ind = 0;
        ArrayList<Integer> res = new ArrayList<>();
        // brust time
        PriorityQueue<int[]> ready = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);

        while (res.size() != n) {
            if (!ready.isEmpty()) {
                int process[] = ready.poll();
                time += process[2];
                res.add(process[0]);
            } else
                time = arr[ind][1];

            while (ind < n && arr[ind][1] <= time)
                ready.add(arr[ind++]);
        }
        int ans[] = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = res.get(i);
        return ans;
    }
}
// Time complexity : O(n*logn)