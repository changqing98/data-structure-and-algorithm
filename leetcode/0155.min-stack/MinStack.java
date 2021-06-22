import java.util.Stack;

public class MinStack {
    Stack<Integer> min;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else if (min.peek() <= x) {
            min.push(min.peek());
        } else {
            min.push(x);
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
