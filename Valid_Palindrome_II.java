public class Valid_Palindrome_II {
    class Solution {
        public boolean validPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    // Try skipping the character on the left
                    if (isPalindrome(s, left + 1, right)) {
                        return true;
                    }
                    // Try skipping the character on the right
                    if (isPalindrome(s, left, right - 1)) {
                        return true;
                    }
                    // If neither case is a palindrome, return false
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
