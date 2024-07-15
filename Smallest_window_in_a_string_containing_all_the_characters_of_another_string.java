public class Smallest_window_in_a_string_containing_all_the_characters_of_another_string {

    class Solution {
        static boolean checker(int[] arr) {
            for (int k : arr) {
                if (k < 0)
                    return true; // returns true if arr contains no<0
            }
            return false;
        }

        public static String smallestWindow(String s, String p) {
            String ans = s + "hi", temp;
            int i, j = 0;
            int[] arr = new int[26];
            for (char k : p.toCharArray())
                arr[k - 'a']--;
            for (i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;

                if (checker(arr))
                    continue;
                while (arr[s.charAt(j) - 'a'] - 1 >= 0) {
                    arr[s.charAt(j) - 'a']--;
                    j++;
                }
                temp = s.substring(j, i + 1);
                if (temp.length() < ans.length())
                    ans = temp;
                arr[s.charAt(j) - 'a']--;
                j++;
            }
            if (ans.equals(s + "hi"))
                return "-1";
            return ans;
        }
    }
}
