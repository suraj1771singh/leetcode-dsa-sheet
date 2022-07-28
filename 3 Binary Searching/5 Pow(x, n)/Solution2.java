
//-------------------BINARY EXPOENETIATION

public class Solution2 {
    public double myPow(double x, int n) {
        double ans = f(x, Math.abs(n));
        if (n < 0)
            return 1 / ans;
        return ans;
    }

    public double f(double x, long n) {

        if (n == 0)
            return 1;
        if (n % 2 == 0)
            return f(x * x, n / 2);
        else
            return x * f(x * x, n / 2);
    }
}
// Time complexity : O(log n)
// Space complexity : O(log n)
