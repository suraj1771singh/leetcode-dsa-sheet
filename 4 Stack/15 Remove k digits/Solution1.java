import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int n = num.length();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && stack.size() + n - i > n - k) {
                stack.pop();
            }
            if (stack.size() < n - k) {
                stack.add(num.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        for (char c : stack) {
            if (str.length() == 0 && c == '0')
                continue;
            str.append(c);
        }
        if (str.length() == 0)
            str.append('0');
        return str.toString();

    }
}