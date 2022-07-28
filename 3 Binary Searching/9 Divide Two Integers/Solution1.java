
//---------------NAIVE SOLUTION 
//----ALGO
/*
 * keep on subtraction divisor from dividend untill it's not negative
 */

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int a = Math.abs(dividend), b = Math.abs(divisor);
        int ans = 0;
        while (a - b >= 0) {
            ans++;
            a -= b;
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return ans;
        return -ans;
    }
}