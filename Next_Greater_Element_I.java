public class Next_Greater_Element_I {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] arr = new int[nums2.length];
            arr[nums2.length - 1] = -1;

            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    boolean bool = false;
                    if (nums1[i] == nums2[j]) {
                        for (int k = j + 1; k < arr.length; k++) {
                            bool = true;
                            if (nums2[k] > nums1[i]) {
                                arr[j] = nums2[k];
                                break;
                            }
                            if (k == arr.length - 1)
                                arr[j] = -1;
                        }
                    }
                    if (bool)
                        break;
                }
            }

            for (int i = 0; i < nums1.length; i++)
                for (int j = 0; j < nums2.length; j++)
                    if (nums1[i] == nums2[j]) {
                        nums1[i] = arr[j];
                        break;
                    }

            return nums1;
        }
    }
}
