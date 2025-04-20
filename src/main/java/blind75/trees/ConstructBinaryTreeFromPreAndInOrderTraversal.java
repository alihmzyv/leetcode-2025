package blind75.trees;

public class ConstructBinaryTreeFromPreAndInOrderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, preorder.length, 0, preorder.length, preorder, inorder);
    }

    private TreeNode buildTree(int fromP, int toP, int fromI, int toI, int[] preorder, int[] inorder) {
        if (fromP == toP) {
            return null;
        }
        int rootVal = preorder[fromP];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int index = fromI; index < toI; index++) {
            if (inorder[index] == rootVal) {
                rootIndex = index;
                break;
            }
        }
        root.left = buildTree(fromP + 1, (fromP + 1) + rootIndex - fromI, fromI, rootIndex, preorder, inorder);
        root.right = buildTree((fromP + 1) + rootIndex - fromI, toP, rootIndex + 1, toI, preorder, inorder);
        return root;
    }
}
