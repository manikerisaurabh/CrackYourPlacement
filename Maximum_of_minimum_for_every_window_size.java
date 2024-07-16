import java.util.ArrayDeque;
import java.util.Deque;

public class Maximum_of_minimum_for_every_window_size {
    class Solution {

        static int[] maxOfMin(int[] arr, int n) {
            int min = arr[0];

            Deque<Integer> ps = new ArrayDeque<>();
            int[] PS = new int[n];
            for (int i = 0; i < n; i++) {
                while (ps.isEmpty() == false && arr[i] <= arr[ps.peek()]) {
                    ps.pop();
                }
                PS[i] = (ps.isEmpty()) ? -1 : ps.peek();
                ps.push(i);

                min = Math.min(arr[i], min);
            }

            Deque<Integer> ns = new ArrayDeque<>();
            int[] NS = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                while (ns.isEmpty() == false && arr[i] <= arr[ns.peek()]) {
                    ns.pop();
                }
                NS[i] = (ns.isEmpty()) ? n : ns.peek();
                ns.push(i);
            }

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int in = NS[i] - PS[i] - 1;
                if (res[in - 1] < arr[i]) {
                    res[in - 1] = arr[i];//
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (res[i] < min) {
                    res[i] = min;
                } else {
                    min = res[i];
                }
            }

            return res;
        }
    }
}
