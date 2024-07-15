import java.util.Stack;

public class Simplyfy_Path {
    class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();

            String[] p = path.split("/");

            for (int i = 0; i < p.length; i++) {
                if (p[i].equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!p[i].equals("") && !p[i].equals(".")) {
                    stack.push(p[i]);
                }
            }

            StringBuilder res = new StringBuilder();

            while (!stack.isEmpty()) {
                res.insert(0, stack.pop()).insert(0, "/");
            }

            if (res.length() == 0) {
                return "/";
            } else {
                return res.toString();
            }

        }
    }
}
