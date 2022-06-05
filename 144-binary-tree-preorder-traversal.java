import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> left = preorderTraversal(root.left);
    List<Integer> right = preorderTraversal(root.right);
    return Stream.of(Collections.singletonList(root.val), left, right)
        .flatMap(List::stream)
        .collect(Collectors.toList());
  }
}
