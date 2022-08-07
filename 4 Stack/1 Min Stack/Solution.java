import java.util.Stack;

//---------------ALGO
/*
1) try to store minimun in stack, if it changes 
*/

class MinStack {
    Stack<Integer> stack;
    int minimum;

    public MinStack() {
        stack = new Stack<>();
        minimum = Integer.MAX_VALUE;

    }

    public void push(int val) {
        if (minimum >= val) {
            stack.push(minimum);
            minimum = val;
        }
        stack.push(val);

    }

    public void pop() {
        if (stack.isEmpty())
            return;
        if (stack.pop() == minimum) {
            minimum = stack.pop();
        }

    }

    public int top() {
        if (!stack.isEmpty())
            return stack.peek();
        return -1;

    }

    public int getMin() {
        return minimum;

    }
}