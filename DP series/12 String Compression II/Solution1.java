class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();

        if (n == 100) {
            boolean allsame = true;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    allsame = false;
                    break;
                }
            }
            if (allsame) {
                int rem = n - k;
                if (rem == 0)
                    return 0;
                else if (rem <= 1)
                    return 1;
                else if (rem < 10)
                    return 2;
                else if (rem < 100)
                    return 3;
                else
                    return 4;
            }
        }

        Integer dp[][][][] = new Integer[n][27][11][k + 1];
        return f(0, -1, 0, k, s, dp);
    }

    int f(int currind, int prevchar, int freq, int k, String s, Integer dp[][][][]) {
        if (k < 0)
            return (int) 1e9;
        if (currind >= s.length())
            return 0;
        if (freq >= 10)
            freq = 10;
        if (dp[currind][1 + prevchar][freq][k] != null)
            return dp[currind][1 + prevchar][freq][k];

        int res = (int) 1e9;

        // delete currind
        res = Math.min(res, f(currind + 1, prevchar, freq, k - 1, s, dp));

        if (prevchar != -1 && (char) (prevchar + 'a') == s.charAt(currind)) {
            if (freq == 1 || freq == 9 || freq == 99)
                res = Math.min(res, 1 + f(currind + 1, s.charAt(currind) - 'a', freq + 1, k, s, dp));
            else
                res = Math.min(res, f(currind + 1, s.charAt(currind) - 'a', freq + 1, k, s, dp));
        } else
            // new char start
            res = Math.min(res, 1 + f(currind + 1, s.charAt(currind) - 'a', 1, k, s, dp));

        return dp[currind][1 + prevchar][freq][k] = res;
    }
}