import java.util.Stack;

public class Basic_Calculator_II {
    class Solution {
        public int calculate(String s) {
            int l = s.length();
            Stack<Integer> intStack = new Stack<>();
            Stack<Character> optStack = new Stack<>();
            for (int i = 0; i < l; i++) {
                char c = s.charAt(i);
                int prev = i;
                if (Character.isDigit(c)) {
                    while (i < l && Character.isDigit(s.charAt(i))) {
                        i++;
                    }
                    int val = Integer.valueOf(s.substring(prev, i));
                    if (!optStack.isEmpty() && optStack.peek() == '-') {
                        val = -val;
                        optStack.pop();
                        optStack.push('+');
                    }
                    intStack.push(val);
                    if (!optStack.isEmpty()) {
                        if (optStack.peek() == '*') {
                            intStack.push(intStack.pop() * intStack.pop());
                            optStack.pop();
                        } else if (optStack.peek() == '/') {
                            int v1 = intStack.pop();
                            int v2 = intStack.pop();
                            intStack.push(v2 / v1);
                            optStack.pop();
                        }
                    }
                    i--;
                } else if (c != ' ') {
                    optStack.push(c);
                }
            }
            while (!optStack.isEmpty()) {
                if (optStack.pop() == '+') {
                    intStack.push(intStack.pop() + intStack.pop());
                }
            }
            return intStack.pop();
        }
    }
}
