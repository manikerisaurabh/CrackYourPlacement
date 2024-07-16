import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queues {
    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            while (q1.size() > 1) {
                q2.add(q1.poll());
            }
            int rst = q1.poll();
            swap();
            return rst;
        }

        public int top() {
            while (q1.size() > 1) {
                q2.add(q1.poll());
            }
            int rst = q1.poll();
            q2.add(rst);
            swap();
            return rst;
        }

        public boolean empty() {
            return q1.isEmpty();
        }

        /** Swap the two queues. */
        private void swap() {
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
    }
}
