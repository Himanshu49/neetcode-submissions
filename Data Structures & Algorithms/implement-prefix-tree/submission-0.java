class PrefixTree {
    class Trie{
        Trie next[] = new Trie[26];
        boolean isWord = false;
    }

    Trie root;
    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.next[ch-'a'] == null){
                curr.next[ch-'a'] = new Trie();
            }
            curr = curr.next[ch-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.next[ch-'a'] == null){
                return false;
            }
            curr = curr.next[ch-'a'];
        }
        return curr.isWord;
    }

    public boolean startsWith(String word) {
        Trie curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.next[ch-'a'] == null){
                return false;
            }
            curr = curr.next[ch-'a'];
        }
        return true;
    }
}
