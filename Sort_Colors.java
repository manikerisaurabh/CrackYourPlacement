public class Sort_Colors {
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length, l = 0, r = n - 1, id = 0;

            while (id <= r) {
                if (nums[id] == 0) {
                    swap(nums, l++, id++);
                } else if (nums[id] == 2) {
                    swap(nums, id, r--);
                } else {
                    id++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
