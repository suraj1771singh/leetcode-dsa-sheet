//Similar to jump game II
//HINT : record the farthest point you can reach from left range of i

class Solution {
    public int minTaps(int n, int[] ranges) {
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (ranges[i] == 0)
                continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }
        int cnt = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            curFarthest = Math.max(curFarthest, arr[i]);
            if (i == curEnd) {
                cnt++;
                if (i == curFarthest)
                    // when current index is the only farthest position, we can't move
                    return -1;
                curEnd = curFarthest;
            }
        }
        return cnt;
    }
}
// Time complexity : O(n)