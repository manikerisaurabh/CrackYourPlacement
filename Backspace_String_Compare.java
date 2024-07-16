public class Backspace_String_Compare {
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int n1 = s.length(), n2 = t.length();
            int i = n1 - 1, j = n2 - 1;
            while (i >= 0 || j >= 0) {
                int cnt1 = 0, cnt2 = 0;
                while (i >= 0 && (s.charAt(i) == '#' || cnt1 > 0)) {
                    if (s.charAt(i) == '#') {
                        cnt1++;
                        i--;
                    } else {
                        i--;
                        cnt1--;
                    }
                }
                while (j >= 0 && (t.charAt(j) == '#' || cnt2 > 0)) {
                    if (t.charAt(j) == '#') {
                        cnt2++;
                        j--;
                    } else {
                        j--;
                        cnt2--;
                    }
                }
                if (i >= 0 && j >= 0) {
                    char ch1 = s.charAt(i);
                    char ch2 = t.charAt(j);
                    if (ch1 != ch2) {
                        return false;
                    }
                }
                if ((i >= 0) != (j >= 0)) {
                    return false;
                }
                i--;
                j--;
            }
            if (i < 0 && j < 0)
                return true;
            return false;
        }
    }
}
