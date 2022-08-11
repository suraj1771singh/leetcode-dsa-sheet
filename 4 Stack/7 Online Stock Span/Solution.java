import java.util.Stack;

//--------------------------------MONOTONIC STACK

class Pair {
    int price;
    int span;

    Pair(int a, int b) {
        price = a;
        span = b;
    }
}

class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();

    }

    public int next(int price) {
        int span = 1;
        if (stack.isEmpty()) {
            stack.push(new Pair(price, span));
            return span;
        }
        while (!stack.isEmpty() && stack.peek().price <= price)
            span += stack.pop().span;
        stack.push(new Pair(price, span));
        return span;

    }
}
// Time complexity : O(n)
// Space complexity : O(n)