import java.util.Stack;

//---------------MONOTONIC STACK
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<Character>();
        int[] count = new int[150];
        boolean[] visited = new boolean[150];

        for (int i = 0; i < n; i++)
            count[s.charAt(i)]++;

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]--;
            if (visited[s.charAt(i)])
                continue;
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && count[stack.peek()] > 0) {

                visited[stack.pop()] = false;
            }

            visited[s.charAt(i)] = true;
            stack.push(s.charAt(i));

        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty())
            str.append(stack.pop());

        return str.reverse().toString();
    }
}
// Time complexity : O(n)
// Space complexity : O(n)