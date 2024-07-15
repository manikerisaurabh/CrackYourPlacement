import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
    class Solution {
        public String getSignature(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + i)).append(count[i]);
                }
            }
            return sb.toString();
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            Map<String, List<String>> groups = new HashMap<>();

            for (String s : strs) {
                groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
            }

            result.addAll(groups.values());

            return result;
        }
    }
}
