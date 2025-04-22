package blind75.trees;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        maxPathSum(root, true, result);
        return result.get();
    }

    private int maxPathSum(TreeNode node, boolean isRoot, AtomicInteger result) {
        if (node == null) {
            return 0;
        }

        int leftSum = maxPathSum(node.left, false, result);
        int rightSum = maxPathSum(node.right, false, result);
        if (node.val > result.get()) {
            result.set(node.val);
        }

        if (leftSum + node.val > result.get()) {
            result.set(leftSum + node.val);
        }

        if (rightSum + node.val > result.get()) {
            result.set(rightSum + node.val);
        }

        if (leftSum + rightSum + node.val > result.get()) {
            result.set(leftSum + rightSum + node.val);
        }
        return Math.max(Math.max(node.val + leftSum, node.val + rightSum), node.val);
    }
}
