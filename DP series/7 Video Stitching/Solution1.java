import java.util.*;

//-----similar to jump game II 
class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);// sort by starting time
        int arr[] = new int[time + 1];

        for (int clip[] : clips) {
            arr[Math.min(time, clip[0])] = Math.max(arr[Math.min(time, clip[0])], clip[1]);
        }
        int currfarthest = 0, currend = 0, cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            currfarthest = Math.max(currfarthest, arr[i]);
            if (currend == i) {
                cnt++;
                if (currfarthest == i)
                    return -1;
                currend = currfarthest;
            }
        }
        return cnt;

    }
}
// Time complexity : O(time)