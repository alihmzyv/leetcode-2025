package medium;

public class ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long leftBoundary, long rightBoundary) {
        if (node == null) {
            return true;
        }

        if (!(node.val > leftBoundary && node.val < rightBoundary)) {
            return false;
        }

        return isValid(node.left, leftBoundary, node.val)
                && isValid(node.right, node.val, rightBoundary);
    }
}
