import java.util.PriorityQueue;
// Interesting, somehow for me the max heap solution was the default idea:
// use bricks as long as it possible, and when the jump is too big, replace the maximum
// jump with a ladder. So basically use bricks and replace with ladder.

// The other way around also works with min heap, so use ladders as long as possible, when
// ladders are exhausted, replace it with the minimum brick. So basically
// use ladders and replace with bricks
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // min heap
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int d = heights[i + 1] - heights[i];
            if (d > 0)
                q.add(d);
            if (q.size() > ladders)
                bricks -= q.poll();
            if (bricks < 0)
                return i;
        }
        return heights.length - 1;
    }
}
// Time complexity : O(n*log k)
// Space complexity : O(k)