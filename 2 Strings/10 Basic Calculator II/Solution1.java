import java.util.*;

class Solution {
    public int calculate(String s) {
        int ans = 0, num = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            // char is digit
            if (Character.isDigit(s.charAt(i)))
                num = num * 10 + s.charAt(i) - '0';

            // char is not a digit
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(-num);
                else if (sign == '*')
                    stack.push(stack.pop() * num);
                else if (sign == '/')
                    stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        for (int i : stack)
            ans += i;
        return ans;
    }

}