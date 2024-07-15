public class Valid_Number {
    class Solution {
        public boolean isNumber(String s) {

            boolean e = false;
            boolean dot = false;
            boolean n = false;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i)))
                    n = true;
                else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                    if (e || !n)
                        return false;
                    e = true;
                    n = false;
                } else if (s.charAt(i) == '.') {
                    if (dot || e)
                        return false;
                    dot = true;
                } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                    if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                        return false;
                } else
                    return false;
            }
            return n;
        }
    }
}
