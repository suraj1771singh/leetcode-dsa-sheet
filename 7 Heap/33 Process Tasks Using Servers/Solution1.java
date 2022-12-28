import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        Queue<Integer> task_q = new LinkedList<>();

        for (int i = 0; i < m; i++)
            task_q.add(i);

        Queue<Integer> ready = new LinkedList<>();
        PriorityQueue<Integer> availServer = new PriorityQueue<>(
                (a, b) -> servers[a] == servers[b] ? a - b : servers[a] - servers[b]);
        for (int i = 0; i < n; i++)
            availServer.add(i);

        PriorityQueue<int[]> occupServer = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? servers[a[0]] == servers[b[0]] ? a[0] - b[0] : servers[a[0]] - servers[b[0]]
                        : a[1] - b[1]);

        int res[] = new int[m];
        int time = 0;
        while (true) {
            // fill ready queue up to time
            while (!task_q.isEmpty() && task_q.peek() <= time)
                ready.add(task_q.poll());
            if (task_q.isEmpty() && ready.isEmpty())
                return res;
            if (ready.isEmpty()) {
                int b = task_q.poll();
                time = b;
                ready.add(b);
            }
            // free up occupied servers
            while (!occupServer.isEmpty() && occupServer.peek()[1] <= time)
                availServer.add(occupServer.poll()[0]);
            if (availServer.isEmpty()) {
                // no server is available
                int a[] = occupServer.poll(); // free lowest time occupied server
                time = a[1];// update time
                availServer.add(a[0]);// make it available
            }
            int task = ready.poll();
            int server = availServer.poll();
            occupServer.add(new int[] { server, time + tasks[task] });
            res[task] = server;

        }

    }
}
// Time complexity : O((m+n*logn))