import org.w3c.dom.Node;

public class Median_of_BST {

    class Tree {
        public static void countNodes(Node root, int[] len) {
            if (root == null)
                return;

            countNodes(root.left, len);
            len[0] += 1;
            countNodes(root.right, len);
        }

        public static void helper(Node root, int mid, int[] count, int[] prev, int[] first, int[] sec) {
            if (root == null)
                return;

            helper(root.left, mid, count, prev, first, sec);
            count[0] += 1;
            if (mid == count[0]) {
                count[0] = mid + 1;
                first[0] = root.data;
                sec[0] = prev[0];
                return;
            }
            prev[0] = root.data;

            helper(root.right, mid, count, prev, first, sec);
        }

        public static float findMedian(Node root) {
            int[] len = { 0 };
            countNodes(root, len);

            int mid = len[0] / 2 + 1;
            int[] count = { 0 };
            int[] prev = { 0 };
            int[] first = { 0 };
            int[] sec = { 0 };
            helper(root, mid, count, prev, first, sec);

            float res = first[0];
            if (len[0] % 2 == 0) {
                res = (float) (first[0] + sec[0]) / 2;
            }

            return res;
        }
    }
}
