package blind75.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    private static class CustomTreeNode {
        TreeNode node;
        int depth;

        CustomTreeNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new MaximumDepthOfBinaryTree().maxDepthIterativeDFS(Helper.build(3, 9, 20, null, null, 15, 7)));
    }

    public int maxDepthRecursiveDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepthRecursiveDFS(root.left);
        int rightMaxDepth = maxDepthRecursiveDFS(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public int maxDepthIterativeDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<CustomTreeNode> stack = new Stack<>();
        CustomTreeNode customRoot = new CustomTreeNode(root, 1);
        stack.push(customRoot);

        int maxDepth = 1;
        while (!stack.isEmpty()) {
            CustomTreeNode customNode = stack.pop();
            TreeNode node = customNode.node;
            TreeNode left = node.left;
            TreeNode right = node.right;
            int depth = customNode.depth;

            if (left != null) {
                stack.push(new CustomTreeNode(left, depth + 1));
            }

            if (right != null) {
                stack.push(new CustomTreeNode(right, depth + 1));
            }

            if (left == null && right == null) {
                if (depth > maxDepth) {
                    maxDepth = depth;
                }
            }
        }

        return maxDepth;
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                if (left != null) {
                    queue.offer(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    queue.offer(right);
                }
            }
            level++;
        }

        return level;
    }
}
