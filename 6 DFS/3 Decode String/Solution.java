import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<String> s2 = new Stack<String>();
        int n = s.length();
        int currNum = 0;
        String currString = "";
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                // push
                s1.push(currNum);
                s2.push(currString);
                currString = "";
                currNum = 0;
            } else if (c == ']') {
                // pop
                int prevNum = s1.pop();
                String prevString = s2.pop();
                String temp = "";
                while (prevNum-- > 0)
                    temp += currString;
                prevString += temp;
                currString = prevString;

            } else if (Character.isDigit(c))
                currNum = currNum * 10 + Character.getNumericValue(c);
            else
                currString += c;
        }
        return currString;
    }
}
