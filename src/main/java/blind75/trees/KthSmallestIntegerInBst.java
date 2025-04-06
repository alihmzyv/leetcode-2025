package blind75.trees;

import java.util.Stack;

public class KthSmallestIntegerInBst {
    //time - O(n), space - O(logn)
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null) {
                if (--k == 0) {
                    return node.val;
                }
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
            } else {
                stack.push(node.left);
                node.left = null;
            }
        }
        throw new RuntimeException("Something went wrong");
    }

    //time - O(n), space - O(n)
    public int kthSmallestRecursive(TreeNode root, int k) {
        int[] kAndResult = new int[2];
        kAndResult[0] = k;
        kthSmallestRecursiveHelper(root, kAndResult);
        return kAndResult[1];
    }

    private void kthSmallestRecursiveHelper(TreeNode node, int[] kAndResult) {
        if (node == null) {
            return;
        }

        kthSmallestRecursiveHelper(node.left, kAndResult);
        int decrementedK = kAndResult[0]--;
        if (decrementedK == 0) {
            kAndResult[1] = node.val;
        } else if (decrementedK > 0) {
            kthSmallestRecursiveHelper(node.right, kAndResult);
        }
    }
}
