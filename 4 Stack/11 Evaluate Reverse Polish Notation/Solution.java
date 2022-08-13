import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> s = new Stack<Integer>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")) {
                int b = s.pop();
                int a = s.pop();
                if (str.equals("+"))
                    s.push(a + b);
                else if (str.equals("-"))
                    s.push(a - b);
                else if (str.equals("/"))
                    s.push(a / b);
                else if (str.equals("*"))
                    s.push(a * b);

            } else {
                int num = Integer.valueOf(str);
                s.push(num);
            }
        }
        return s.pop();
    }
}
// Time complexity : O(n)
// Space complexity : O(n)