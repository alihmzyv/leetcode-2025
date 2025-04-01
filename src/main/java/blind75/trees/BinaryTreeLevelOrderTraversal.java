package blind75.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
}
