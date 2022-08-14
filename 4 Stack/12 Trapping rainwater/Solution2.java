import java.util.Stack;

//--------------------------USIGN MONOTONIC STACK (decreasing stack)
//HINT : https://www.youtube.com/watch?v=lhzrp3Nbj-w

class Solution2 {
    public int trap(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = arr.length, ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int dist = i - stack.peek() - 1;
                ans += dist * (Math.min(arr[stack.peek()], arr[i]) - arr[top]);
            }
            stack.push(i);
        }
        return ans;
    }
}
// TIme complexity : O(n)
// Space complexity : O(n)
