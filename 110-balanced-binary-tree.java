import java.util.Objects;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }

        int lDepth = calculateDepth(root.left);
        int rDepth = calculateDepth(root.right);

        return Math.abs(lDepth - rDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int calculateDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return 1 + Math.max(calculateDepth(root.left), calculateDepth(root.right));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
