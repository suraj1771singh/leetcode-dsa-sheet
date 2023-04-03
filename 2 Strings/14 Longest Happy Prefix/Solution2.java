
//------------EFFICIENT APPROACH (KMP ,LPS)
//HINT : https://leetcode.com/problems/longest-happy-prefix/solutions/547446/c-java-with-picture-incremental-hash-and-kmp/?orderBy=most_votes
class Solution {
    public String longestPrefix(String s) {
        int i = 0, j = 1, n = s.length();
        if (n == 1)
            return "";
        int[] lps = new int[n];
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[j] = ++i;
                j++;
            } else // (s[j] != s[i])
            {
                if (i != 0) {
                    i = lps[i - 1];// do not incre j
                } else {
                    lps[j] = i;
                    j++;
                }
            }
        }
        return s.substring(0, i);

    }
}
// Time complexity : O(n)