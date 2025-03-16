package medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class KthSmallestElementInABST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Set<Integer> nums = new HashSet<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            nums.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        return nums.stream()
                .sorted()
                .skip(k - 1)
                .findAny()
                .get();
    }
}
