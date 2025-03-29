package blind75.trees;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode result = Helper.build(3, 1, 4, null, 2);
        System.out.println(Helper.traverse(result));
    }

    //time - O(logn) - worst case is that both are leaf nodes, space - O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else { //when either is equal to root, or one is lower and the other is higher
                return root;
            }
        }
    }

    //time - O(logn) - worst case is that both are leaf nodes, space - O(logn)
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
