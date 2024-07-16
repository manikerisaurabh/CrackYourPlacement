import java.util.Arrays;

public class Implement_two_stacks_in_an_array {

    class twoStacks {

        public int arr[] = new int[100];
        public int p1 = (int) (arr.length * 0.5);
        public int p2 = arr.length - 1;

        public twoStacks() {
            Arrays.fill(arr, -1);
        }

        // Function to push an integer into the stack1.
        void push1(int x) {
            if (arr[p1] == -1) {
                arr[p1] = x;
                p1--;
            }
            if (p1 < 0) {
                return;
            }
        }

        // Function to push an integer into the stack2.
        void push2(int x) {
            if (p2 > arr.length * 0.5) {
                if (arr[p2] == -1) {
                    arr[p2] = x;
                    p2--;
                } else {
                    return;
                }
            }
        }

        // Function to remove an element from top of the stack1.
        int pop1() {
            if (p1 == arr.length * 0.5) {
                return arr[p1];
            }
            int header = p1 + 1;
            int val = arr[header];
            arr[header] = -1;
            p1++;
            return val;
        }

        // Function to remove an element from top of the stack2.
        int pop2() {
            if (p2 == arr.length - 1) {
                return arr[p2];
            }
            int header = p2 + 1;
            int val = arr[header];
            arr[header] = -1;
            p2++;
            return val;
        }
    }
}
