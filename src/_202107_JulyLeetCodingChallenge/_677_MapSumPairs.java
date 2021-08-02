package _202107_JulyLeetCodingChallenge;

public class _677_MapSumPairs {
    class MapSum {

        private TrieNode root;

        private class TrieNode {
            int val;
            TrieNode[] next = new TrieNode[26];
        }

        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode node = root;
            for (char c : key.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new TrieNode();
                }
                node = node.next[i];
            }
            node.val = val;
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    return 0;
                }
                node = node.next[i];
            }
            return dfs(node);
        }

        private int dfs(TrieNode node) {
            int res = node.val;
            for (TrieNode nxt : node.next) {
                if (nxt != null) {
                    res += dfs(nxt);
                }
            }
            return res;
        }

    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
