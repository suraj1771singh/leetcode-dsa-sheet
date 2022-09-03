import java.util.*;
//------------------------BFS
// using BFS to find the target index,
// first value indicate the idx, second value indicate the direction(0: back, 1:
// forward)

// MOST important: for the visited set , we need to save the direction and idx,
// or we will lose the answer
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        Queue<int[]> q = new LinkedList<>();
        Set<List<Integer>> visitedIdx = new HashSet<>();
        int steps = 0;

        for (int f : forbidden) {
            visitedIdx.add(Arrays.asList(f, 1));
            visitedIdx.add(Arrays.asList(f, 0));
        }

        q.offer(new int[] { 0, 1 });

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] cur = q.poll();
                int value = cur[0];
                int direction = cur[1];

                List<Integer> node = Arrays.asList(value, direction);

                // the reason why 6000 is becase: target x is max 2000, and a max 2000,
                // that means, x + a with max value to x + a + a
                if (!visitedIdx.contains(node) && value <= 6000) {
                    visitedIdx.add(node);

                    if (value == x) {
                        return steps;
                    }

                    if (value + a > 0 && !visitedIdx.contains(Arrays.asList(value + a, 1))) {
                        q.offer(new int[] { value + a, 1 });
                    }

                    if (value - b > 0 && !visitedIdx.contains(Arrays.asList(value - b, 0)) && direction != 0) {
                        q.offer(new int[] { value - b, 0 });
                    }

                }
            }
            steps++;
        }

        return -1;
    }
}
