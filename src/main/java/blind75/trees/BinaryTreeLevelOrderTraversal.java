package blind75.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    private static class CustomTreeNode {
        TreeNode node;
        int depth;

        CustomTreeNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    //time - O(n), space - O(n)
    //my own solution
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int nextLevel = 0;

        while (!queue.isEmpty()) {
            List<Integer> levelResult = new LinkedList<>();
            while (level > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    levelResult.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                        nextLevel++;
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        nextLevel++;
                    }
                }
                level--;
            }
            if (!levelResult.isEmpty()) {
                result.add(levelResult);
            }
            level = nextLevel;
            nextLevel = 0;
        }

        return result;
    }

    //at each step, the queue size is actually the size of the level, so need to keep size as a variable
    //improved after looking at neetcode solution
    public List<List<Integer>> levelOrderBFSImproved(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> levelResult = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    levelResult.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!levelResult.isEmpty()) {
                result.add(levelResult);
            }
        }

        return result;
    }
}
