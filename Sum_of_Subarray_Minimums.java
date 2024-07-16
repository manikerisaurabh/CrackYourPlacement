import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Sum_of_Subarray_Minimums {

    public class Solution {
        public int sumSubarrayMins(int[] arr) {
            int length = arr.length;
            int[] left = new int[length];
            int[] right = new int[length];

            Arrays.fill(left, -1);
            Arrays.fill(right, length);

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < length; ++i) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    right[stack.pop()] = i;
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            int mod = (int) 1e9 + 7;
            long answer = 0;

            for (int i = 0; i < length; ++i) {
                answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
                answer %= mod;
            }

            return (int) answer;
        }

    }
}
