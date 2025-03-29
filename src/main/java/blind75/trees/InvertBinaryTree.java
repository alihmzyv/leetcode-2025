package blind75.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {
    //time - O(n), space - O(n)
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }

        return root;
    }

    //time - O(n), space - O(n)
    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) {
                stack.push(left);
            }
            if (right != null) {
                stack.push(right);
            }
        }

        return root;
    }

    //recursive DFS
    //time - O(n), space - O(n)
    public TreeNode invertTreeRecursively(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeRecursively(root.left);
        invertTreeRecursively(root.right);
        return root;
    }
}
