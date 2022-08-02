import java.util.*;

//----------------------USING STACK

class BrowserHistory {
    Stack<String> history;
    Stack<String> future;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        history.push(homepage);
        future = new Stack<>();
    }

    public void visit(String url) {
        history.push(url);
        future.clear();

    }

    public String back(int steps) {
        while (steps > 0 && history.size() > 1) {
            future.push(history.pop());
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && future.size() > 0) {
            history.push(future.pop());
            steps--;
        }
        return history.peek();
    }
}
// Time complexity : O(n+m)
// n= size of history stack
// m= size of future stack