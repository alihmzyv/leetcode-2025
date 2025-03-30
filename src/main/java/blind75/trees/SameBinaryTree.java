package blind75.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameBinaryTree {
    //time - O(n), space - O(logn)
    public boolean isSameTreeIterativeDFS(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        pStack.push(p);
        Stack<TreeNode> qStack = new Stack<>();
        qStack.push(q);

        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();

            if (((pNode != null && qNode == null) || (qNode != null && pNode == null))) {
                return false;
            }
            if (pNode != null && (pNode.val != qNode.val)) {
                return false;
            }

            if (pNode !=
                    null) { //contrary to common dfs, add null children too, otherwise e.g. 2 <-- 1 and 1 --> 2would be considered same
                pStack.push(pNode.left);
                pStack.push(pNode.right);
                qStack.push(qNode.left);
                qStack.push(qNode.right);
            }
        }

        return pStack.isEmpty() && qStack.isEmpty();
    }

    //time - O(n), space - O(n)
    public boolean isSameTreeRecursiveDFS(TreeNode p, TreeNode q) {
        return (p == null && q == null) ||
                (((p != null && q != null) && p.val == q.val) && isSameTreeRecursiveDFS(p.left, q.left)
                        && isSameTreeRecursiveDFS(p.right, q.right));
    }

    //time - O(n), space - O(n)
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        pQueue.offer(p);
        Queue<TreeNode> qQueue = new LinkedList<>();
        qQueue.offer(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();

            if (((pNode != null && qNode == null) || (qNode != null && pNode == null))) {
                return false;
            }
            if (pNode != null && (pNode.val != qNode.val)) {
                return false;
            }

            if (pNode != null) { //contrary to common dfs, add null children too, otherwise e.g. 2 <-- 1 and 1 --> 2 would be considered same
                pQueue.offer(pNode.left);
                pQueue.offer(pNode.right);
                qQueue.offer(qNode.left);
                qQueue.offer(qNode.right);
            }
        }

        return pQueue.isEmpty() && qQueue.isEmpty();
    }
}
