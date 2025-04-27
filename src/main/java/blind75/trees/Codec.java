package blind75.trees;

import java.util.concurrent.atomic.AtomicInteger;

public class Codec {
    private static final String NULL = "n";
    private static final String COMMA = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serialize(root, result);
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private void serialize(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append(NULL);
            result.append(COMMA);
            return;
        }

        result.append(node.val);
        result.append(COMMA);
        serialize(node.left, result);
        serialize(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(COMMA);
        return deserialize(values, new AtomicInteger(0));
    }

    private TreeNode deserialize(String[] values, AtomicInteger index) {
        if (values[index.get()].equals(NULL)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index.get()]));
        index.incrementAndGet();
        node.left = deserialize(values, index);
        index.incrementAndGet();
        node.right = deserialize(values, index);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = Helper.build(1, 2, 3, null, null, 4, 5);
        System.out.println(new Codec().serialize(root));
        TreeNode result = new Codec().deserialize(new Codec().serialize(root));
        System.out.println(Helper.traverse(result));
    }
}
