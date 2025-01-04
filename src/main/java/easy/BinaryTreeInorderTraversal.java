package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    public class TreeNode {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
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
                    result.add(stack.pop().val);
                } else {
                    result.add(stack.pop().val);
                    stack.push(right);
                }
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverseRecursively(root, result);
        return result;
    }

    private void traverseRecursively(TreeNode root, List<Integer> result) {
        if (root != null) {
            TreeNode left = root.left;
            if (left != null) {
                traverseRecursively(left, result);
            }
            result.add(root.val);
            traverseRecursively(root.right, result);
        }
    }
}
