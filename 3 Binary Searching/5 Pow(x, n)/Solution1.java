//--------------NAIVE SOLUTION 

public class Solution1 {
    public double myPow(double x, int n) {
        double ans = f(x, Math.abs(n));
        if (n < 0)
            return 1 / ans;
        return ans;
    }

    public double f(double x, long n) {
        if (n == 0)
            return 1;
        return x * f(x, n - 1);
    }
}

// Time complexity : O(n)
// Space complexity : O(n)