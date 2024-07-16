import java.util.Stack;

public class Implement_Queue_using_Stacks {
    class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
