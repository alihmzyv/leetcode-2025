package medium;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

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
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
            } else {
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    stack.push(left);
                    node.left = null;
                } else if (right == null) {
                    int valTraversed = stack.pop().val;
                    if (--k == 0) {
                        return valTraversed;
                    }
                } else {
                    int valTraversed = stack.pop().val;
                    if (--k == 0) {
                        return valTraversed;
                    }
                    stack.push(right);
                }
            }
        }
        return root.val;
    }

    public int kthSmallestRecursive(TreeNode root, int k) {
        AtomicInteger result = new AtomicInteger();
        traverseRecursively(root, new AtomicInteger(k), result);
        return result.get();
    }

    private void traverseRecursively(TreeNode root, AtomicInteger k, AtomicInteger result) {
        if (root != null) {
            traverseRecursively(root.left, k, result);
            int kDecremented = k.decrementAndGet();
            if (kDecremented == 0) {
                result.set(root.val);
                return;
            }
            if (kDecremented < 0) {
                return;
            }
            traverseRecursively(root.right, k, result);
        }
    }
}
