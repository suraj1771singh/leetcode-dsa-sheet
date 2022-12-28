import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] nums) {
        // sort by increasing end point
        // if end point are equal sort by len
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int n = nums.length;
        // [endPoint, len]
        pq.add(new int[] { nums[0], 1 });
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            // case 1 : when num>pq.peek()[0]+1 => pop and check len till its come under
            // case 2 or case 3
            // return false if len is less then 3
            while (!pq.isEmpty() && num > pq.peek()[0] + 1) {
                if (pq.poll()[1] < 3)
                    return false;
            }
            // case 2 : when num==pq.peek()[0]=>form new interval (num,1)
            if (pq.isEmpty() || num == pq.peek()[0]) {
                pq.add(new int[] { num, 1 });
            }
            // case 3 : when num==pq.peek()[0]+1 => add it to exiting interval
            else if (num == pq.peek()[0] + 1) {
                int prev[] = pq.poll();
                pq.add(new int[] { num, prev[1] + 1 });
            }
        }
        while (!pq.isEmpty()) {
            if (pq.poll()[1] < 3)
                return false;
        }
        return true;

    }
}
// Time complexity : O(n*logn)