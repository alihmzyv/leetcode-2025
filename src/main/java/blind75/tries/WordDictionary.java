package blind75.tries;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("day");
        wordDictionary.addWord("bay");
        wordDictionary.addWord("may");
        System.out.println(wordDictionary.search("say"));; // return false
        System.out.println(wordDictionary.search("day"));; // return true
        System.out.println(wordDictionary.search(".ay"));; // return true
        System.out.println(wordDictionary.search("b.."));; // return true
    }

    Trie.Node root;

    public WordDictionary() {
        root = new Trie.Node();
    }

    public void addWord(String word) {
        Trie.Node node = root;
        int length = word.length();
        for (int index = 0; index < length; index++) {
            char letter = word.charAt(index);
            int indexOfNode = letter - 'a';
            if (node.data[indexOfNode] == null) {
                node.data[indexOfNode] = new Trie.Node();
            }
            node = node.data[indexOfNode];
        }
        node.isEndOfAWord = true;
    }

    //time - O(26^n) - n-the length of word being searched
    //space - O(m * 26) - m - number of nodes inserted in total. Stack trace - 26^n in total
    //https://algo.monster/liteproblems/211 - good
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Trie.Node node) {
        if (node == null) {
            return false;
        }

        int length = word.length();
        for (; index < length; index++) {
            char letter = word.charAt(index);
            if (letter == '.') {
                int nextIndex = index + 1;
                for (int i = 0; i < 26; i++) {
                    if (search(word, nextIndex, node.data[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                int indexOfNode = letter - 'a';
                if (node.data[indexOfNode] == null) {
                    return false;
                } else {
                    node = node.data[indexOfNode];
                }
            }
        }
        return node.isEndOfAWord;
    }
}
