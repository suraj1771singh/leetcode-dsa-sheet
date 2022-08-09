import java.util.Stack;

class Solution1 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else
                stack.push(s.charAt(i));
        }
        for (Character c : stack)
            ans += c;
        return ans;

    }
}
// Time complexity : O(n)
// Space complexity : O(n)