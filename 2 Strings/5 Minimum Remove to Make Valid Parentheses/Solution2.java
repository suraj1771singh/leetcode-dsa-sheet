import java.util.*;

//-----------OPTMIZED VERSION

class Solution2 {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')')
                continue;
            if (c == '(')
                stack.push(i);
            else {
                if (stack.isEmpty())
                    str.setCharAt(i, ' ');
                else
                    stack.pop();
            }
        }
        for (int i : stack)
            str.setCharAt(i, ' ');

        String[] arr = str.toString().split(" ");
        String ans = String.join(" ", arr);
        return ans;
    }
}
// Time complexity : O(n)
// Spac complexity : O(n)