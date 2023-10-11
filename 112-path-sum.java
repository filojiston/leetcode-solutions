import java.util.Objects;
import java.util.Stack;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(root.val);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            int sum = sums.pop();

            if (isLeafNode(current) && sum == targetSum) {
                return true;
            }

            if (Objects.nonNull(current.right)) {
                stack.push(current.right);
                sums.push(sum + current.right.val);
            }
            if (Objects.nonNull(current.left)) {
                stack.push(current.left);
                sums.push(sum + current.left.val);
            }
        }

        return false;
    }

    public boolean isLeafNode(TreeNode node) {
        return Objects.isNull(node.left) && Objects.isNull(node.right);
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
