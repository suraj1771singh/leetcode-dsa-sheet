
public class Solution2 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int a = Math.abs(dividend), b = Math.abs(divisor);
        int ans = 0;
        while (a - b >= 0) {
            int x = 0;
            while (a - (b << 1 << x) >= 0)
                x++;
            a = a - b << x;
            ans += 1 << x;
        }
        // taking care of sign
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return ans;
        return -ans;
    }
}
//Time complexity : O(logN^2)
