import java.util.Objects;

class Solution {
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return 1;
        }

        if (Objects.isNull(root.left)) {
            return 1 + minDepth(root.right);
        }

        if (Objects.isNull(root.right)) {
            return 1 + minDepth(root.left);
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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
