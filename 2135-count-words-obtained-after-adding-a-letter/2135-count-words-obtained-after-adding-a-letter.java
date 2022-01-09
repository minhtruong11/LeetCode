class Solution {
    
    class TrieNode {
        static final int ALPHABET_SIZE = 26;
        
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
    
    class Trie {
        TrieNode root;
        
        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String key) {
            int length = key.length();
            TrieNode pCrawl = root;

            for (int level = 0; level < length; level++) {
                int index = key.charAt(level) - 'a';
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();

                pCrawl = pCrawl.children[index];
            }

            pCrawl.isEndOfWord = true;
        }

        public boolean search(String key) {
            int length = key.length();
            TrieNode pCrawl = root;

            for (int level = 0; level < length; level++) {
                int index = key.charAt(level) - 'a';

                if (pCrawl.children[index] == null)
                    return false;

                pCrawl = pCrawl.children[index];
            }

            return (pCrawl.isEndOfWord);
        }
    }
    
    public int wordCount(String[] startWords, String[] targetWords) {
        Trie trie = new Trie();
        
        for (String word : startWords) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            trie.insert(new String(arr));
        }
        
        int count = 0;
        
        for (String str : targetWords) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String target = new String(arr);
            for (int i=0; i<target.length(); i++) {
                String token = target.substring(0, i) + target.substring(i+1);
                if (trie.search(token)) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}