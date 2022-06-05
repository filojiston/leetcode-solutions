import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> left = postorderTraversal(root.left);
    List<Integer> right = postorderTraversal(root.right);
    return Stream.of(left, right, Collections.singletonList(root.val))
        .flatMap(List::stream)
        .collect(Collectors.toList());
  }
}
