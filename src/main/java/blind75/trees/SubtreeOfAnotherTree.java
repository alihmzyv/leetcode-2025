package blind75.trees;

import java.util.Stack;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null) {
            return (isSameTree(root, subRoot))
                    || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        } else if (root == null && subRoot == null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            return (node1.val == node2.val) && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
        } else if (node1 == null && node2 == null){
            return true;
        } else {
            return false;
        }
    }
}
