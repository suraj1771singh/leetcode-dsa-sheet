public class Solution2 {
    public int minFlips(String s) {
        int n = s.length(), ans = (int) 1e9;
        int start = 0, end = 0;
        int diff1 = 0, diff2 = 0;
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                s1.append(1);
                s2.append(0);
            } else {
                s1.append(0);
                s2.append(1);
            }
        }
        s += s;
        // creating inital window of size n
        start = 0;
        end = n - 1;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != s1.charAt(i))
                diff1++;
            if (s.charAt(i) != s2.charAt(i))
                diff2++;
        }
        ans = Math.min(diff1, diff2);

        // sliding window
        while (start < n) {

            // checking with s1 | 10101010
            if (s.charAt(start) != s1.charAt(start))
                diff1--;
            if (s.charAt(end + 1) != s1.charAt(end + 1))
                diff1++;
                
            // checking with s2 | 01010101
            if (s.charAt(start) != s2.charAt(start))
                diff2--;
            if (s.charAt(end + 1) != s2.charAt(end + 1))
                diff2++;
            start++;
            end++;
            ans = Math.min(ans, Math.min(diff1, diff2));
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)
