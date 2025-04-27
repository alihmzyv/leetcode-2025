package blind75.tries;

class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("apple"));
    }

    private final Node root;

    static class Node {
        boolean isEndOfAWord;
        Node[] data = new Node[26];
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        int length = word.length();
        for (int index = 0; index < length; index++) {
            int indexForNode = word.charAt(index) - 'a';
            if (node.data[indexForNode] == null) {
                node.data[indexForNode] = new Node();
            }
            node = node.data[indexForNode];
        }
        node.isEndOfAWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        int length = word.length();
        for (int index = 0; index < length; index++) {
            Node nodeForLetter = node.data[word.charAt(index) - 'a'];
            if (nodeForLetter == null) {
                return false;
            }
            node = nodeForLetter;
        }
        return node.isEndOfAWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        int length = prefix.length();
        for (int index = 0; index < length; index++) {
            Node nodeForLetter = node.data[prefix.charAt(index) - 'a'];
            if (nodeForLetter == null) {
                return false;
            }
            node = nodeForLetter;
        }
        return true;
    }
}
