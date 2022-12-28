import java.util.Arrays;

//-----RECURSIVE SOLUTION

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        return f(events, n, 0, k);
    }

    public int f(int events[][], int n, int pos, int k) {
        int i;

        if (pos >= n || k == 0)
            return 0;

        // finding the next event which we can attend
        for (i = pos + 1; i < n; i++)
            if (events[i][0] > events[pos][1])
                break;

        return Math.max(f(events, n, pos + 1, k), events[pos][2] + f(events, n, i, k - 1));
    }

}

// Time complexity : O(n*logn) + O(n*k)
// Space complexity : O(k)