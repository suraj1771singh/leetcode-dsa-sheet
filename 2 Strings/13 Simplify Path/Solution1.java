import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            if (stack.isEmpty())
                stack.push('/');

            char peek = stack.peek(), c = path.charAt(i);

            if (Character.isAlphabetic(c) || (c == '/' && peek != '/'))
                stack.push(c);

            if (c == '.') {
                int dot_cnt = 0;
                while (c == '.' && i < path.length()) {
                    dot_cnt++;
                    i++;
                    if (i < path.length())
                        c = path.charAt(i);
                }
                if (dot_cnt > 2) {
                    while (dot_cnt-- > 0)
                        stack.push('.');
                } else {
                    while (dot_cnt > 0 && !stack.isEmpty())
                        dot_cnt = stack.pop() == '/' ? dot_cnt - 1 : dot_cnt;
                }
                continue;
            }
            i++;
        }
        if (stack.isEmpty())
            stack.push('/');
        if (stack.size() > 1 && stack.peek() == '/')
            stack.pop();
        for (char c : stack)
            ans.append(c);
        return ans.toString();
    }
}

// "/..hidden"