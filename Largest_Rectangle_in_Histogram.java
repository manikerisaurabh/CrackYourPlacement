import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int[] left = nextSmallestLeft(heights);
            int[] right = nextSmallestRight(heights);
            int ans = 0;
            for (int i = 0; i < heights.length; i++) {
                int breadth = heights[i];
                int length = right[i] - left[i] + 1;
                int area = length * breadth;
                ans = Math.max(ans, area);
            }
            return ans;
        }

        public static int[] nextSmallestRight(int[] arr) {
            int[] rightIndex = new int[arr.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = arr.length - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    rightIndex[i] = arr.length - 1;
                    stack.push(arr.length - 1);
                } else {
                    int index = stack.peek();
                    int stackElement = arr[index];
                    while (!stack.isEmpty() && stackElement >= arr[i]) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            index = stack.peek();
                            stackElement = arr[index];
                        }
                    }
                    if (!stack.isEmpty()) {
                        rightIndex[i] = stack.peek() - 1;
                        stack.push(i);
                    } else {
                        rightIndex[i] = arr.length - 1;
                        stack.push(i);
                    }
                }
            }
            return rightIndex;
        }

        public static int[] nextSmallestLeft(int[] arr) {
            int[] leftIndex = new int[arr.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(0);
                    leftIndex[i] = 0;
                } else {
                    int index = stack.peek();
                    int stackElement = arr[index];
                    while (!stack.isEmpty() && stackElement >= arr[i]) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            index = stack.peek();
                            stackElement = arr[index];
                        }
                    }
                    if (!stack.isEmpty()) {
                        leftIndex[i] = stack.peek() + 1;
                        stack.push(i);
                    } else {
                        leftIndex[i] = 0;
                        stack.push(i);
                    }
                }
            }
            return leftIndex;
        }
    }
}
