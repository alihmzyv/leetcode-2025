package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int countOfNodesAtLevel = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int countOfNodesAtNextLevel = 0;
            List<Integer> valsAtLevel = new LinkedList<>();
            for (int i = countOfNodesAtLevel; i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    valsAtLevel.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                        countOfNodesAtNextLevel++;
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        countOfNodesAtNextLevel++;
                    }
                }
            }
            result.add(valsAtLevel);
            countOfNodesAtLevel = countOfNodesAtNextLevel;
        }
        return result;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverseBreadthFirstAndFillRecursively(root, 0, result);
        return result;
    }

    private void traverseBreadthFirstAndFillRecursively(TreeNode node, int level, List<List<Integer>> result) {
        if (node != null) {
            if (level >= result.size()) {
                result.add(level, new ArrayList<>(List.of(node.val)));
            } else {
                List<Integer> valsAtLevel = result.get(level);
                valsAtLevel.add(node.val);
            }
            traverseBreadthFirstAndFillRecursively(node.left, level + 1, result);
            traverseBreadthFirstAndFillRecursively(node.right, level + 1, result);
        }
    }
}
