import java.util.Stack;

public class Reverse_Words_in_a_String {
    class Solution {
        public String reverseWords(String s) {
            String[] lineSplit = s.trim().split("\\s+");
            Stack<String> stack = new Stack<>();
            for (String word : lineSplit)
                stack.push(word);
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < lineSplit.length - 1; i++) {
                String word = stack.peek();
                ans.append(word).append(" ");
                stack.pop();
            }
            ans.append(stack.pop());
            return ans.toString();
        }
    }
}
