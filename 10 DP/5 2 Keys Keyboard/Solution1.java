//-------------RECURSIVE SOLUTION

class Solution {
    public int minSteps(int n) {
        return f(0, 1, n);
    }

    int f(int ps, int cs, int n) {
        int p = (int) 1e9, np = (int) 1e9;

        if (cs == n)
            return 0;
        if (ps != cs)
            p = 1 + f(cs, cs, n); // copy
        if (ps != 0 && ps + cs <= n)
            np = 1 + f(ps, cs + ps, n); // paste

        return Math.min(p, np);
    }
}
// Time complexity : O(2^n)