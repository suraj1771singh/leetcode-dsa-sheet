
//---- Recursive Solution

class Solution1 {
    public int fib(int n) {
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);

    }
}
// Time complexity : O(2^n)
// Auxiallary SC : O(n)