
//------Recursive Approach

class Solution1 {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        ans = f(0, cardPoints.length - 1, k, cardPoints);
        return ans;
    }

    int f(int s, int e, int k, int[] points) {
        if (k == 0 || s > e)
            return 0;
        int pickFront = points[s] + f(s + 1, e, k - 1, points);
        int pickEnd = points[e] + f(s, e - 1, k - 1, points);
        return Math.max(pickFront, pickEnd);
    }
}

// Time complexity : O(2^n)
// Space complexity : O(k)