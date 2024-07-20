public class Beautiful_Arrangement {
    class Solution {
        public int countArrangement(int n) {
            int[] arr = new int[n + 1];
            int ans = 0;
            ans = countArrangementHelper(n, arr, ans, 1);
            return ans;
        }

        private int countArrangementHelper(int n, int[] arr, int ans, int currNum) {
            if (currNum == n + 1) {
                ++ans;
                return ans;
            }

            for (int i = 1; i <= n; i++) {
                if (arr[i] == 0 && (currNum % i == 0 || i % currNum == 0)) {
                    arr[i] = currNum;
                    ans = countArrangementHelper(n, arr, ans, currNum + 1);
                    arr[i] = 0;
                }
            }
            return ans;
        }
    }
}
