import java.util.Stack;

public class Maximum_size_rectangle_binary_sub_matrix_with_all_1s {
    class Solution {
        private int[] nextSmaller(int[] arr, int n) {
            Stack<Integer> st = new Stack<>();
            st.add(-1);
            int ans[] = new int[n];

            for (int i = n - 1; i >= 0; i--) {
                int curr = arr[i];

                while (st.peek() != -1 && arr[st.peek()] >= curr) {
                    st.pop();
                }
                ans[i] = st.peek();
                st.add(i);
            }
            return ans;
        }

        private int[] prevSmaller(int arr[], int n) {
            Stack<Integer> st = new Stack<>();
            st.add(-1);
            int ans[] = new int[n];

            for (int i = 0; i < n; i++) {
                int curr = arr[i];

                while (st.peek() != -1 && arr[st.peek()] >= curr) {
                    st.pop();
                }
                ans[i] = st.peek();
                st.add(i);
            }
            return ans;
        }

        public int largestRectangleArea(int[] heights) {
            int n = heights.length;

            int next[] = new int[n];
            next = nextSmaller(heights, n);

            int prev[] = new int[n];
            prev = prevSmaller(heights, n);

            int area = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int l = heights[i];
                if (next[i] == -1) {
                    next[i] = n;
                }
                int b = next[i] - prev[i] - 1;

                int newArea = l * b;
                area = Math.max(area, newArea);
            }
            return area;
        }

        public int maxArea(int M[][], int n, int m) {
            // add code here.
            int area = largestRectangleArea(M[0]);

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (M[i][j] != 0) {
                        M[i][j] = M[i][j] + M[i - 1][j];
                    } else {
                        M[i][j] = 0;
                    }
                }

                area = Math.max(area, largestRectangleArea(M[i]));
            }
            return area;
        }
    }
}
