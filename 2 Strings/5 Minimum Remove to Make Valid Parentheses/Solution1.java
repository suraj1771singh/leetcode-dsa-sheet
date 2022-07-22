import java.util.*;

//-----------NAIVE APPROACH

class Solution1 {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')')
                continue;
            if (stack.isEmpty())
                stack.push(i);
            else if (s.charAt(stack.peek()) == '(' && c == ')')
                stack.pop();
            else
                stack.push(i);

        }
        StringBuilder ans = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(stack);
        for (int i = 0; i < s.length(); i++)
            if (!set.contains(i))
                ans.append(s.charAt(i));

        return ans.toString();
    }
}
// Time complexity : O(n)
// Spac complexity : O(n)