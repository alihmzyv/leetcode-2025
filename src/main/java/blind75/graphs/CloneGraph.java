package blind75.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> nodeToClone = new HashMap<>();
        return dfs(node, nodeToClone);
    }

    private Node dfs(Node node, Map<Integer, Node> nodeToClone) {
        if (node == null) {
            return null;
        }

        Node clone = nodeToClone.get(node.val);
        if (clone != null) {
            return clone;
        }

        Node newClone = new Node(node.val);
        nodeToClone.put(node.val, newClone);
        for (Node neighbor : node.neighbors) {
            newClone.neighbors.add(dfs(neighbor, nodeToClone));
        }
        return newClone;
    }
}
