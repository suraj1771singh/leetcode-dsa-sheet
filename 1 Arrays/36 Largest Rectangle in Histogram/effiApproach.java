import java.util.Stack;

//EFFECIENT APPROACH

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> p_stack = new Stack<>();
        Stack<Integer> h_stack = new Stack<>();
        int prev_start_index = 0;
        for (int i = 0; i < n; i++) {

            // if stack is empty
            if (h_stack.isEmpty()) {
                p_stack.push(prev_start_index);
                h_stack.push(heights[i]);
            }

            // case 1 : when curr heigth is greater than top of stack
            // add new rect of height h[i] to track
            else if (h_stack.peek() < heights[i]) {
                p_stack.push(i);
                h_stack.push(heights[i]);
            }
            // case 2 : when curr heigth is less than top of stack
            // stop tracking prevous rect, pop it out calc its area
            else if (h_stack.peek() > heights[i]) {

                while (!h_stack.isEmpty() && h_stack.peek() > heights[i]) {
                    prev_start_index = p_stack.peek();
                    int area = (i - p_stack.pop()) * h_stack.pop();
                    maxArea = Math.max(maxArea, area);
                }

                p_stack.push(prev_start_index);
                h_stack.push(heights[i]);

            }

        }
        // pop out tracking rect , untill stack is not empty
        // calc their area
        while (!h_stack.isEmpty()) {
            int area = (n - p_stack.pop()) * h_stack.pop();
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }
}