public class Circular_Tour {
    class Solution {
        // Function to find starting point where the truck can start to get through
        // the complete circle without exhausting its petrol in between.
        int tour(int petrol[], int distance[]) {
            // Your code here
            int n = petrol.length;
            int start = 0, sum = 0, diff = 0;
            for (int x = 0; x < n; x++) {
                sum += petrol[x] - distance[x];
                if (sum < 0) {
                    diff += sum;
                    sum = 0;
                    start = x + 1;
                }
            }
            if (sum + diff >= 0)
                return start;
            return -1;
        }
    }
}
