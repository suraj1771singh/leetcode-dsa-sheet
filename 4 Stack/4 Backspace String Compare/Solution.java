import java.util.*;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack1.isEmpty())
                    stack1.pop();
            } else
                stack1.push(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!stack2.isEmpty())
                    stack2.pop();
            } else
                stack2.push(t.charAt(i));
        }
        String a = "", b = "";
        while (!stack1.isEmpty()) a += stack1.pop();
        while (!stack2.isEmpty()) b += stack2.pop();
        
       
        return a.equals(b);

    }
}
//Time complexity : O(n)
//space complexity : O(n)