package blind75.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Helper {
    public static TreeNode build(Integer... vals) {
        int length = vals.length;
        TreeNode[] nodes = new TreeNode[length];
        for (int index = 0; index < length; index++) {
            Integer val = vals[index];
            if (val != null) {
                nodes[index] = new TreeNode(val);
            }
        }
        for (int index = 0; index <= (length - 3) / 2; index++) {
            nodes[index].left = nodes[index * 2 + 1];
            nodes[index].right = nodes[index * 2 + 2];
        }
        return nodes[0];
    }

    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node);
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result;
    }
}
