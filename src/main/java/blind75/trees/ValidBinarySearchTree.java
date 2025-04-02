package blind75.trees;

public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //time - O(n), space - O(n)
    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        boolean valIsValid = node.val > min && node.val < max;
        if (valIsValid) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            return (left == null || isValid(left, min, node.val))
                    && (right == null || isValid(right, node.val, max));
        } else {
            return false;
        }
    }
}
