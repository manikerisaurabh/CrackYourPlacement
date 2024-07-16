public class The_Celebrity_Problem {
    class Solution {
        // Function to find if there is a celebrity in the party or not.
        int celebrity(int arr[][], int n) {
            // code here
            for (int i = 0; i < n; i++) {
                int j = 0;
                while (j < n && (arr[j][i] == 1 || i == j)) {
                    j++;
                }
                if (j == n) {
                    int k = 0;
                    while (k < n && arr[i][k] == 0) {
                        k++;
                    }
                    if (k == n) {
                        return i;
                    }
                }
            }

            return -1;
        }
    }
}
