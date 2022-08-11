import java.util.Stack;
//---------------------------------MONOTONIC STACK

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int ind = stack.pop();
                ans[ind] = i - ind;
            }
            stack.push(i);
        }
        return ans;
    }
   
}
// Time complexity : O(n)
// Space complexity : O(n)