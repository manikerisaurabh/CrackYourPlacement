import java.util.Arrays;

public class Smallest_Positive_missing_number {
    class Solution {
        static int missingNumber(int arr[], int n) {
            // Your code here
            Arrays.sort(arr);
            int ans = 1;
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    if (arr[i] > ans) {
                        return ans;
                    } else if (arr[i] == ans) {
                        ans++;
                    } else if (arr[i] < ans) {
                        continue;
                    }
                }
            }
            return ans;
        }
    }
}
