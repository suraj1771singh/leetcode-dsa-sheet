//------ALGO

// On little bit observation 
// this problem will turn down into finding minimum sum subarray of length n-k
// find sum of array and s1 is the sum of first n-k elements 
// then from [0,n-k] window remove left most and add right most
// keep track of maxi sum (sum - minimum sum)

class Solution2 {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0, n = cardPoints.length;
        int s1 = 0;// subarraySum
        int sum = 0;// array sum
        for (int i = 0; i < n; i++) {
            if (i < n - k)
                s1 += cardPoints[i];
            sum += cardPoints[i];
        }
        ans = sum - s1;
        int l = 0, r = n - k;
        while (r < n) {
            s1 -= cardPoints[l++];
            s1 += cardPoints[r++];
            ans = Math.min(ans, sum - s1);
        }
        return ans;
    }

}

// Time complexity : O(n)
// Space complexity : O(1)