import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<List<String>>();
            List<String> list = new ArrayList<String>();
            partitions(0, s, res, list);
            return res;
        }

        public void partitions(int index, String str, List<List<String>> res, List<String> list) {
            if (index == str.length()) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < str.length(); i++) {
                // we will try partitioning from all index
                if (isPali(str, index, i)) {
                    // if while partitioning from i it is palindrome
                    list.add(str.substring(index, i + 1));
                    partitions(i + 1, str, res, list);
                    list.remove(list.size() - 1);
                }
            }
        }

        public boolean isPali(String str, int start, int end) {
            int i = start;
            int j = end;
            while (i <= j) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
