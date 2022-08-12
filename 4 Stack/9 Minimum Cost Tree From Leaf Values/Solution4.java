import java.util.*;
//--------------------------MOST EFFICIENT APPROACH
//---USING STACK (MONOTONIC STACK )

public class Solution4 {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int a : arr) {
            while (stack.peek() < a)
                ans += stack.pop() * Math.min(stack.peek(), a);
            stack.push(a);
        }
        while (stack.size() > 2)
            ans += stack.pop() * stack.peek();

        return ans;
    }
}
// Time complexity : O(n)
// space complexity : O(n)