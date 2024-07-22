import java.util.Deque;
import java.util.LinkedList;

public class Remove_K_Digits {
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> stack = new LinkedList<>();

            for (Character c : num.toCharArray()) {
                while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }

            while (!stack.isEmpty() && stack.peekLast() == '0') {
                stack.pollLast();
            }

            while (!stack.isEmpty() && k > 0) {
                stack.pop();
                k--;
            }

            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pollLast());
            }
            return result.isEmpty() ? "0" : result.toString();
        }
    }
}
